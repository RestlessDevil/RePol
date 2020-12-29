/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package policygenerator.forms.element;

/**
 *
 * @author vasilije
 */
public class BooleanCheckbox extends FormElement {

    private boolean value;

    public BooleanCheckbox(Panel panel, String id, boolean mandatory, String label, String conditionId) {
        super(panel, Type.BOOLEAN, id, mandatory, label, conditionId);
        this.value = false;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public void setDefaultValue(String defaultValue) {
        this.value = "true".equalsIgnoreCase(defaultValue);
        touch();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setValidationRegex(String validationRegex) {
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void setByTrigger(String value) {
        this.value = "true".equalsIgnoreCase(value);
        push();
    }

    @Override
    public boolean match(String value) {
        return (this.value == "true".equalsIgnoreCase(value));
    }

    @Override
    public void clear() {
        this.value = false;
    }

    @Override
    public void remove(String value) {
    }

    @Override
    public void sync(FormElement element) {
        switch (element.getType()) {
            case BOOLEAN:
                this.value = ((BooleanCheckbox) element).isValue();
                break;
            case ONELINE:
                this.value = "true".equalsIgnoreCase(((OneLine) element).getValue());
                break;
            case TEXT:
                this.value = "true".equalsIgnoreCase(((Text) element).getValue());
                break;
        }
    }

    @Override
    public String getXml() {
        return "<field type=\"boolean\" id=\"" + getId() + "\"><value>" + value + "</value></field>";
    }

}