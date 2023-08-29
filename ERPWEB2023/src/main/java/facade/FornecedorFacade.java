/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Fornecedor;
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
public class FornecedorFacade extends AbstractFacade<Fornecedor> {

    @PersistenceContext(unitName = "ERPWEB2023PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FornecedorFacade() {
        super(Fornecedor.class);
    }

    public List<Fornecedor> buscarFornecedorEmOrdemAlfabetica() {
        TypedQuery<Fornecedor> query = em.createQuery("SELECT e FROM Fornecedor e ORDER BY e.nome", Fornecedor.class);
        return query.getResultList();
    }

    public boolean existeFornecedor(Fornecedor fornecedor) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(e) FROM Fornecedor e WHERE e.cnpj = :cnpj", Long.class);
        query.setParameter("cnpj", fornecedor.getCnpj());
        long count = query.getSingleResult();
        return count > 0;
    }

}
