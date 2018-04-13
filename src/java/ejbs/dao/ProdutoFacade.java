/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs.dao;

import entidades.Categoria;
import entidades.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author informatica
 */
@Stateless
public class ProdutoFacade extends AbstractFacade<Produto> {

    private final String findProdutoByCategoria = "SELECT NEW org.ofmcap.facade.utiljpql.FrateDati(f.idFrate, f.nomeReligioso, f.nomeCivile, f.cognome, f.nomeCompleto, f.dataNascita, f.luogoNascita, f.nativoONo, f.diocesi, f.nomePadre, f.nomeMadre, f.vestizione, f.professioneTemporanea, f.professionePerpetua, f.ordinazioneDiaconale, f.ordinazioneSacerdotale,f.ordinazioneEpiscopale, f.siglaArchivio, f.numeroRegistro, f.noteAggiuntive, f.osservazione, c.nomeItalianoCircoscrizione, f.idCircoscrizione, n.nomeItalianoNazione, o.opzioneFrate, f.fotoFrate, f.fileUrl, us.dataUscita, us.idMotivoUscita, us.osservazione, mr.dataMorte, mr.luogoMorte, mr.luogoSepoltura, mr.dataSepoltura, mr.idCausaMorte, mr.idNazione,dm.missione, dm.dataInizioObbedienza, dm.dataFineObbedienza, dm.osservazione, fr.descrizioneFormazione, fr.dataFine, fr.idSpecialita) FROM Frate as f LEFT JOIN f.idCircoscrizione as c LEFT JOIN f.idNazione as n LEFT JOIN f.idOpzioneFrate as o LEFT JOIN f.morteCollection as mr LEFT JOIN f.uscitaCollection as us LEFT JOIN f.formazioneCollection as fr LEFT JOIN f.domicilioCollection dm WHERE f.idCircoscrizione =:circoscrizione ORDER BY f.nomeCivile";
    @PersistenceContext(unitName = "CarrinhoCompras09042018_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoFacade() {
        super(Produto.class);
    }
    
     public List<Produto> findProdutoByCategoria(Categoria categoria){
     Query query;
        query = em.createQuery("SELECT p FROM Produto p WHERE p.categoria =:categoria ORDER BY p.nomeProduto");
        query.setParameter("categoria", categoria);
       return query.getResultList();
    
    }
    
}
