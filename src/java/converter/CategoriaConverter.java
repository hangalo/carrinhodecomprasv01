/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import ejbs.dao.CategoriaFacade;
import entidades.Categoria;
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
@FacesConverter(value = "categoriaConverter")
public class CategoriaConverter implements javax.faces.convert.Converter {

   CategoriaFacade categoriaFacade = lookupCategoriaFacade();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
     
        Categoria categoria;
        if (value != null) {
            categoria = (Categoria)categoriaFacade.find(Integer.parseInt(value));
            return categoria;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Categoria cat = (Categoria)value;
            return  String.valueOf(cat.getIdCategoria());
          // return ((Categoria) value).getIdCategoria().toString();
        }
        return null;
    }

    
    /*
    
    
       if (value != null) {
            Aluno aluno =(Aluno)value;
            return String.valueOf(aluno.getIdAluno());
        }
        return null;
    
    
    */
    private CategoriaFacade lookupCategoriaFacade() {
        javax.naming.Context context;
        try {
            context = new InitialContext();
            return (CategoriaFacade) context.lookup("java:global/CarrinhoComprasV01/CategoriaFacade");
        } catch (NamingException ne) {
            System.out.println("Erro" + ne.getMessage());
            return null;
        }

    }
}
