/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import entidades.Estado;
import facade.EstadoFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author jaimedias
 */
public class EstadoConverter implements Converter {

    private final EstadoFacade estadoFacade;

    public EstadoConverter(EstadoFacade estadoFacade) {
        this.estadoFacade = estadoFacade;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {        
        return estadoFacade.buscar(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
        return ((Estado) value).getId().toString();

    }
}
