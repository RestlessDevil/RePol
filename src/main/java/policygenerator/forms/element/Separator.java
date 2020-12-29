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
public class Separator extends FormElement {

    public Separator() {
        super(null, Type.SEPARATOR, null, false, null, null);
    }

    @Override
    public void setDefaultValue(String defaultValue) { // No effect
    }

    @Override
    public boolean isEmpty() { // Always empty
        return true;
    }

    @Override
    public void setValidationRegex(String validationRegex) {
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void setByTrigger(String value) { // Not supposed to have a value
    }

    @Override
    public boolean match(String value) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public void remove(String value) {
    }

    @Override
    public void sync(FormElement element) {
        //DO NOTHING
    }

    @Override
    public String getXml() {
        return "";
    }

}