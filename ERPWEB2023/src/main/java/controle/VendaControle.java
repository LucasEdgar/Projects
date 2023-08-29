/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import converter.ConverterGenerico;
import entidades.ItensVenda;
import entidades.Pessoa;
import entidades.Produto;
import entidades.Venda;
import facade.PessoaFacade;
import facade.ProdutoFacade;
import facade.VendaFacade;
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
public class VendaControle implements Serializable {

    private Venda venda = new Venda();
    private ItensVenda itensVenda = new ItensVenda();
    @EJB
    private VendaFacade vendaFacade;
    @EJB
    private PessoaFacade pessoaFacade;
    @EJB
    private ProdutoFacade produtoFacade;
    private ConverterGenerico produtoConverter;
    private ConverterGenerico pessoaConverter;

    public ItensVenda getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ItensVenda itensVenda) {
        this.itensVenda = itensVenda;
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

    public ConverterGenerico getPessoaConverter() {
        if (pessoaConverter == null) {
            pessoaConverter = new ConverterGenerico(pessoaFacade);
        }
        return pessoaConverter;
    }

    public List<Produto> getListaFiltrandoProduto(String filtro) {
        return produtoFacade.listaFiltrando(filtro, "nome");
    }

    public List<Pessoa> getListaFiltrandoPessoa(String filtro) {
        return pessoaFacade.listaFiltrando(filtro, "nome", "cpfCnpj");
    }

    public void setPessoaConverter(ConverterGenerico pessoaConverter) {
        this.pessoaConverter = pessoaConverter;
    }

    public void salvar() {
//        venda.setDataVenda(new Date());
        vendaFacade.salvar(venda);
        venda = new Venda();
    }

    public void addItem() {
        ItensVenda itemTemp = null;
        Double estoque = itensVenda.getProduto().getEstoque();
        for (ItensVenda it : venda.getItensVendas()) {
            if (itensVenda.getProduto().getId().equals(it.getProduto().getId())) {
                estoque = estoque - it.getQuantidade();
                itemTemp = it;
            }
        }
        if (itensVenda.getQuantidade() > estoque) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Estoque insuficiente!", "Restam apenas " + estoque + " unidade!"));
        } else {
            if (itemTemp == null) {
                itensVenda.setVenda(venda);
                venda.getItensVendas().add(itensVenda);
            } else {
                itemTemp.setQuantidade(itemTemp.getQuantidade() + itensVenda.getQuantidade());
            }

            itensVenda = new ItensVenda();
        }
    }

    public void atualizaPreco() {
        itensVenda.setPreco(itensVenda.getProduto().getPreco());
    }

    public void remover(Venda ve) {
        vendaFacade.remover(ve);
    }

    public void editar(Venda ve) {
        venda = ve;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Venda> getListaVendas() {
        return vendaFacade.listaTodos();
    }

}
