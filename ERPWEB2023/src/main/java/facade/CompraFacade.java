/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import entidades.ItensCompra;
import entidades.Produto;
import entidades.Compra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Micro
 */
@Stateless
public class CompraFacade extends AbstractFacade<Compra> {

    @PersistenceContext(unitName = "ERPWEB2023PU")
    private EntityManager em;

    @Override
    public void salvar(Compra Comp) {
        Produto p = null;
        for (ItensCompra it : Comp.getItensCompras()) {
            p = it.getProduto();
                p.setEstoque(p.getEstoque() + it.getQuantidade()); // Sinal !!!
                em.merge(p);
        }
        super.salvar(Comp);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompraFacade() {
        super(Compra.class);
    }

}
