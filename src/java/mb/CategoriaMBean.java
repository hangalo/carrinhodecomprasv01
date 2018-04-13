/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejbs.dao.CategoriaFacade;
import entidades.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author informatica
 */
@Named(value = "categoriaMBean")
@RequestScoped
public class CategoriaMBean implements Serializable{

    private static final long serialVersionUID = 1L;
    @EJB
    private CategoriaFacade categoriaFacade;

    private List<Categoria> categorias;
    
    
    public CategoriaMBean() {
    }
    
    
    @PostConstruct
    public void init(){
    categorias = categoriaFacade.findAll();
    
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    
    
    
    
}
