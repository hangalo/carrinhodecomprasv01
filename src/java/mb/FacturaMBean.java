/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejbs.dao.FacturaFacade;
import entidades.Factura;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import util.DateUtil;

/**
 *
 * @author informatica
 */
@Named(value = "facturaMBean")
//@RequestScoped
@SessionScoped
public class FacturaMBean implements Serializable{
private static final long serialVersionUID = 1L;
    @EJB
    private FacturaFacade facturaFacade;

    private Factura factura;

    public FacturaMBean() {
    }

    @PostConstruct
    public void init() {
        factura = new Factura();
        factura.setDataFactura(DateUtil.getDataActual());
    }

    public void registarFactura() {
        System.out.println("Factura"+factura.getIdCliente());
        facturaFacade.create(factura);

    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void definirValorTotal(Double valor) {
        factura.setValorTotal(valor);
    }

    public void helloWOlrd() {

        System.out.println(" Hello WOrld");
    }

}
