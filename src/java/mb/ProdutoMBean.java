/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejbs.dao.ProdutoFacade;
import entidades.Categoria;
import entidades.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

/**
 *
 * @author informatica
 */
@Named(value = "produtoMBean")
@SessionScoped
public class ProdutoMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    Produto produto;
    @Inject
    ProdutoFacade produtoFacade;
    @Inject
    Categoria categoria;

    private List<Produto> produtos;
    private List<Produto> produtosCategorias;

    @PostConstruct
    public void init() {
        produtos = new ArrayList<>();
        produtosCategorias = new ArrayList<>();
        produtos = produtoFacade.findAll();
    }

    public ProdutoMBean() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void carregarProdutosDaCategoria() {

        produtosCategorias = produtoFacade.findProdutoByCategoria(categoria);

    }

    /*
    public void carregaMunicipiosDaProvincia() {
        System.out.println("Provncia >>>>>" + provincia);
        municipios = municipioDAO.findByIdProvincia2(provincia);
    }
    
     */
    /**
     * public void carregarProdutosDaCategoria(ValueChangeEvent event) {
     * Categoria cat = (Categoria)event.getNewValue();
     * System.out.print("Sigla>>>>>>" + event.getNewValue().toString());
     * produtosCategorias = produtoFacade.findProdutoByCategoria(cat);
     *
     * }
     */

    public List<Produto> getProdutosCategorias() {
        return produtosCategorias;
    }

    public void setProdutosCategorias(List<Produto> produtosCategorias) {
        this.produtosCategorias = produtosCategorias;
    }

}
