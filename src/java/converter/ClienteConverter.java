/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import ejbs.dao.CategoriaFacade;
import ejbs.dao.ClienteFacade;
import entidades.Cliente;
import javax.enterprise.context.spi.Context;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * @author informatica
 */
@FacesConverter(value = "clienteConverter")
public class ClienteConverter implements javax.faces.convert.Converter {

   ClienteFacade clienteFacade = lookupClienteFacade();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
     
        Cliente cliente;
        if (value != null) {
            cliente = (Cliente)clienteFacade.find(Integer.parseInt(value));
            return cliente;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Cliente cli = (Cliente)value;
            return  String.valueOf(cli.getIdCliente());
         
        }
        return null;
    }

    
  
    private ClienteFacade lookupClienteFacade() {
        javax.naming.Context context;
        try {
            context = new InitialContext();
            return (ClienteFacade) context.lookup("java:global/CarrinhoCompras09042018_3/ClienteFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }

    }
}
