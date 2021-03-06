package policygenerator.form.condition;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import policygenerator.form.Form;
import policygenerator.form.element.input.FormElement;
import policygenerator.form.element.exceptions.ElementNotFoundException;

public class Empty extends Condition {

    private final FormElement element;

    public Empty(Form myForm, Node node) throws ElementNotFoundException {
        super(myForm, null, node);

        String elementId;
        try {
            elementId = node.getAttributes().getNamedItem("id").getTextContent();
        } catch (DOMException ex) {
            throw new ElementNotFoundException("FormElement ID not specified!");
        }
        this.element = myForm.getElement(elementId);
    }

    @Override
    public boolean evaluate() {
        boolean value = element.isEmpty();
        if (!inverted) {
            return value;
        } else {
            return !value;
        }
    }

    @Override
    public String toString() {
        return (inverted ? "NOT " : "") + "EMPTY(" + element.getId() + ")";
    }

}
