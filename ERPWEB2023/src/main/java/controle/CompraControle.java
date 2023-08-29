/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import converter.ConverterGenerico;
import entidades.ItensCompra;
import entidades.Fornecedor;
import entidades.Produto;
import entidades.Compra;
import facade.FornecedorFacade;
import facade.ProdutoFacade;
import facade.CompraFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Micro
 */
@ManagedBean
@SessionScoped
public class CompraControle implements Serializable {

    private Compra compra = new Compra();
    private ItensCompra itensCompra = new ItensCompra();
    @EJB
    private CompraFacade compraFacade;
    @EJB
    private FornecedorFacade fornecedorFacade;
    @EJB
    private ProdutoFacade produtoFacade;
    private ConverterGenerico produtoConverter;
    private ConverterGenerico fornecedorConverter;

    public ItensCompra getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(ItensCompra itensCompra) {
        this.itensCompra = itensCompra;
    }

    public ConverterGenerico getProdutoConverter() {
        if (produtoConverter == null) {
            produtoConverter = new ConverterGenerico(produtoFacade);
        }
        return produtoConverter;
    }

    public void setProdutoConverter(ConverterGenerico produtoConverter) {
        this.produtoConverter = produtoConverter;
    }

    public ConverterGenerico getFornecedorConverter() {
        if (fornecedorConverter == null) {
            fornecedorConverter = new ConverterGenerico(fornecedorFacade);
        }
        return fornecedorConverter;
    }

    public List<Produto> getListaFiltrandoProduto(String filtro) {
        return produtoFacade.listaFiltrando(filtro, "nome");
    }

    public List<Fornecedor> getListaFiltrandoFornecedor(String filtro) {
        return fornecedorFacade.listaFiltrando(filtro, "nome", "cnpj");
    }

    public void setFornecedorConverter(ConverterGenerico fornecedorConverter) {
        this.fornecedorConverter = fornecedorConverter;
    }

    public void salvar() {
//        compra.setDataCompra(new Date());
        compraFacade.salvar(compra);
        compra = new Compra();
    }

    public void addItem() {
        ItensCompra itemTemp = null;
        Double estoque = itensCompra.getProduto().getEstoque();
        for (ItensCompra it : compra.getItensCompras()) {
            if (itensCompra.getProduto().getId().equals(it.getProduto().getId())) {
                estoque = estoque - it.getQuantidade();
                itemTemp = it;
            }
        }
        if (itensCompra.getQuantidade() > estoque) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Estoque insuficiente!", "Restam apenas " + estoque + " unidade!"));
        } else {
            if (itemTemp == null) {
                itensCompra.setCompra(compra);
                compra.getItensCompras().add(itensCompra);
            } else {
                itemTemp.setQuantidade(itemTemp.getQuantidade() + itensCompra.getQuantidade());
            }

            itensCompra = new ItensCompra();
        }
    }

    public void atualizaPreco() {
        itensCompra.setPreco(itensCompra.getProduto().getPreco());
    }

    public void remover(Compra ve) {
        compraFacade.remover(ve);
    }

    public void editar(Compra ve) {
        compra = ve;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public List<Compra> getListaCompras() {
        return compraFacade.listaTodos();
    }

}
