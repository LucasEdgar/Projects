/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Estado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author jaimedias
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {

    @PersistenceContext(unitName = "ERPWEB2023PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }

    public List<Estado> buscarEstadosEmOrdemAlfabetica() {
        TypedQuery<Estado> query = em.createQuery("SELECT e FROM Estado e ORDER BY e.nome", Estado.class);
        return query.getResultList();
    }

    public boolean existeEstado(Estado estado) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(e) FROM Estado e WHERE e.uf = :uf", Long.class);
        query.setParameter("uf", estado.getUf());
        long count = query.getSingleResult();
        return count > 0;
    }

}
