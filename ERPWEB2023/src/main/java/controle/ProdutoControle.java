package controle;

import converter.ConverterGenerico;
import entidades.Produto;
import entidades.ProdutoGrupo;
import facade.ProdutoFacade;
import facade.ProdutoGrupoFacade;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProdutoControle implements Serializable{
    
    private Produto produto = new Produto();
    @EJB
    private ProdutoFacade produtoFacade;
    @EJB
    private ProdutoGrupoFacade produtoGrupoFacade;
    
    private ConverterGenerico produtoGrupoConverter;

    public ConverterGenerico getProdutoGrupoConverter(){
         if(produtoGrupoConverter == null){
            produtoGrupoConverter = new ConverterGenerico(produtoGrupoFacade);
        
        }
           return produtoGrupoConverter;
    }
    
    public void editar(Produto prod){
        produto = prod;
    
    }
    
    public void setprodutoGrupoConverter(ConverterGenerico produtoGrupoConverter){
            this.produtoGrupoConverter = produtoGrupoConverter;
    }
    
    
    public List<ProdutoGrupo> listaGrupoFiltrando(String filtro){
        return produtoGrupoFacade.listaFiltrando(filtro, "nome");
    
    }
    public void salvar(){
        produtoFacade.salvar(produto);
        produto = new Produto();
    
    }
    
    public void remover(Produto prod){
        produtoFacade.remover(prod);
    
    }
    
    public List<Produto> getListaProdutos(){
        return produtoFacade.listaTodos();
    
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}
