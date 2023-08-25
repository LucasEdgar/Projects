package controle;

import entidades.Pessoa;
import facade.PessoaFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PessoaControle implements Serializable {

    private Pessoa pessoa = new Pessoa();

    @EJB
    private PessoaFacade pessoaFacade;

    public void salvar() {
        if (!pessoaFacade.existePessoa(pessoa)) {
            pessoaFacade.salvar(pessoa);
            pessoa = new Pessoa();
        } else {
            // Pessoa já existe, exibir mensagem ou realizar ação apropriada
        }
    }

    public void remover(Pessoa cli) {
        pessoaFacade.remover(cli);
    }

    public void editar(Pessoa cli) {
        pessoa = cli;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getListaPessoas() {
        return pessoaFacade.buscarPessoasEmOrdemAlfabetica();
    }
    
    public void limparPessoa() {
        pessoa = new Pessoa();
    }
}
