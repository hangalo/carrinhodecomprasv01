/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejbs.dao.ClienteFacade;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author informatica
 */
@Named(value = "clienteMBean")
@RequestScoped
public class ClienteMBean {
private static final long serialVersionUID = 1L;
    @EJB
    private ClienteFacade clienteFacade;

   
    private Cliente cliente;
    private List<Cliente> clientes;
    
    public ClienteMBean() {
    }
    
    @PostConstruct
    public void init(){
    cliente = new Cliente();
    clientes = new ArrayList<>();
    clientes = clienteFacade.findAll();
    
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
    
    
}
