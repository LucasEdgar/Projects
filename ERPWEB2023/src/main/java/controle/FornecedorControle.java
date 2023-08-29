package controle;

import entidades.Fornecedor;
import facade.FornecedorFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FornecedorControle implements Serializable {

    private Fornecedor fornecedor = new Fornecedor();

    @EJB
    private FornecedorFacade fornecedorFacade;

    public void salvar() {
        if (!fornecedorFacade.existeFornecedor(fornecedor)) {
            fornecedorFacade.salvar(fornecedor);
            fornecedor = new Fornecedor();
        } else {
            // Fornecedor já existe, exibir mensagem ou realizar ação apropriada
        }
    }

    public void remover(Fornecedor forn) {
        fornecedorFacade.remover(forn);
    }

    public void editar(Fornecedor forn) {
        fornecedor = forn;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getListaFornecedor() {
        return fornecedorFacade.buscarFornecedorEmOrdemAlfabetica();
    }
    
    public void limparFornecedor() {
        fornecedor = new Fornecedor();
    }
}
