/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import entidades.ClassePai;
import facade.AbstractFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author jaimedias
 */
public class ConverterGenerico implements Converter {

    private final AbstractFacade abstractFacade;

    public ConverterGenerico(AbstractFacade abstractFacade){
        this.abstractFacade = abstractFacade;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {        
        return abstractFacade.buscar(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
        return ((ClassePai) value).getId().toString();
    }
}
