package controle;

import entidades.Estado;
import facade.EstadoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EstadoControle implements Serializable {

    private Estado estado = new Estado();

    @EJB
    private EstadoFacade estadoFacade;

    public void salvar() {
        if (!estadoFacade.existeEstado(estado)) {
            estadoFacade.salvar(estado);
            estado = new Estado();
        } else {
            // Estado já existe, exibir mensagem ou realizar ação apropriada
        }
    }

    public void remover(Estado est) {
        estadoFacade.remover(est);
    }

    public void editar(Estado est) {
        estado = est;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getListaEstados() {
        return estadoFacade.buscarEstadosEmOrdemAlfabetica();
    }
    
    public void limparEstado() {
        estado = new Estado();
    }
}
