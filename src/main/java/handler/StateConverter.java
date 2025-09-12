/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handler;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.util.List;
import model.codelist.CLState;

@FacesConverter("stateConverter")
public class StateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        // Logic to find the State object based on the string value (e.g., 'CZE')
        // This often involves iterating through the original list of states
        // or querying a database.
        // Example:
            List<CLState> states = (List<CLState>) component.getAttributes().get("states");
            for (CLState state : states) {
                if (state.getCode().equals(value)) {
                    return state;
                }
            }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        // Cast the object to your custom type and return the string representation
        if (value instanceof CLState) {
            return ((CLState) value).getCode();
        }
        return "";
    }
}
