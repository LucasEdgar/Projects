/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.ProdutoGrupo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Micro
 */
@Stateless
public class ProdutoGrupoFacade extends AbstractFacade<ProdutoGrupo> {

    @PersistenceContext(unitName = "ERPWEB2023PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoGrupoFacade() {
        super(ProdutoGrupo.class);
    }

    public List<ProdutoGrupo> buscarProdutoGruposEmOrdemAlfabetica() {
        TypedQuery<ProdutoGrupo> query = em.createQuery("SELECT e FROM ProdutoGrupo e ORDER BY e.nome", ProdutoGrupo.class);
        return query.getResultList();
    }

    public boolean existeProdutoGrupo(ProdutoGrupo produtoGrupo) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(e) FROM ProdutoGrupo e WHERE e.nome = :nome", Long.class);
        query.setParameter("nome", produtoGrupo.getNome());
        long count = query.getSingleResult();
        return count > 0;
    }

}
