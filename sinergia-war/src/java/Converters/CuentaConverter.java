/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converters;

import ManagedBeans.ManagedBeanCuentaContable;
import be.Cuenta;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author argos
 */
@FacesConverter(value = "cuentaConverter")
public class CuentaConverter implements Converter{

     @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (context == null) {
            throw new NullPointerException("context");
        }
        if (component == null) {
            throw new NullPointerException("component");
        }
        FacesContext ctx = FacesContext.getCurrentInstance();
        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{managedBeanCuentaContable}", ManagedBeanCuentaContable.class);
        ManagedBeanCuentaContable bean = (ManagedBeanCuentaContable) vex.getValue(ctx.getELContext());
        Cuenta objeto;
        try {
           objeto = bean.getObjeto(new Integer(value));
        } catch (NumberFormatException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "CONVERTER ERROR", "NÚMERO ID INVALIDO");
            throw new ConverterException(message);
        }
        if (objeto == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "CONVERTER ERROR", "OBJETO DESCONOCIDO");
            throw new ConverterException(message);
        }
        return objeto;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {


        if (context == null) {
            throw new NullPointerException("context");
        }
        if (component == null) {
            throw new NullPointerException("component");
        }


        if (((Cuenta) value).getPkId() == null) {
                   return "";
        } else {
            return ((Cuenta) value).getPkId().toString();
        }
    }
    
}
