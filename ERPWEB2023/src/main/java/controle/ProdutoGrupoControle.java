package controle;

import entidades.ProdutoGrupo;
import facade.ProdutoGrupoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProdutoGrupoControle implements Serializable {

    private ProdutoGrupo produtoGrupo = new ProdutoGrupo();
    @EJB
    private ProdutoGrupoFacade produtoGrupoFacade;

    public void salvar() {
        if (!produtoGrupoFacade.existeProdutoGrupo(produtoGrupo)) {
            produtoGrupoFacade.salvar(produtoGrupo);
            produtoGrupo = new ProdutoGrupo();
        } else {
            // ProdutoGrupo já existe, exibir mensagem ou realizar ação apropriada
        }
    }

    public void remover(ProdutoGrupo prodGrup) {
        produtoGrupoFacade.remover(prodGrup);
    }

    public void editar(ProdutoGrupo prodGrup) {
        produtoGrupo = prodGrup;
    }

    public ProdutoGrupo getProdutoGrupo() {
        return produtoGrupo;
    }

    public void setProdutoGrupo(ProdutoGrupo produtoGrupo) {
        this.produtoGrupo = produtoGrupo;
    }

    public List<ProdutoGrupo> getListaProdutoGrupos() {
        return produtoGrupoFacade.listaTodos();
       
    }
    
    public void limparProdutoGrupo() {
        produtoGrupo = new ProdutoGrupo();
    }
}
