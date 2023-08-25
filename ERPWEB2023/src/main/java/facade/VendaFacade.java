/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import entidades.ItensVenda;
import entidades.Produto;
import entidades.Venda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Micro
 */
@Stateless
public class VendaFacade extends AbstractFacade<Venda> {

    @PersistenceContext(unitName = "ERPWEB2023PU")
    private EntityManager em;

    @Override
    public void salvar(Venda ve) {
        Produto p = null;
        for (ItensVenda it : ve.getItensVendas()) {
            p = it.getProduto();
                p.setEstoque(p.getEstoque() - it.getQuantidade());
                em.merge(p);
        }
        super.salvar(ve);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendaFacade() {
        super(Venda.class);
    }

}
