/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Pessoa;
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
public class PessoaFacade extends AbstractFacade<Pessoa> {

    @PersistenceContext(unitName = "ERPWEB2023PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PessoaFacade() {
        super(Pessoa.class);
    }

    public List<Pessoa> buscarPessoasEmOrdemAlfabetica() {
        TypedQuery<Pessoa> query = em.createQuery("SELECT e FROM Pessoa e ORDER BY e.nome", Pessoa.class);
        return query.getResultList();
    }

    public boolean existePessoa(Pessoa pessoa) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(e) FROM Pessoa e WHERE e.cpfCnpj = :cpfCnpj", Long.class);
        query.setParameter("cpfCnpj", pessoa.getCpfCnpj());
        long count = query.getSingleResult();
        return count > 0;
    }

}
