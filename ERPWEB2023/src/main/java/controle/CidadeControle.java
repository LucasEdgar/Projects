package controle;

import converter.ConverterGenerico;
import entidades.Cidade;
import entidades.Estado;
import facade.CidadeFacade;
import facade.EstadoFacade;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CidadeControle implements Serializable {

    private Cidade cidade = new Cidade();
    @EJB
    private CidadeFacade cidadeFacade;
    @EJB
    private EstadoFacade estadoFacade;
    private ConverterGenerico estadoConverter;

    public ConverterGenerico getEstadoConverter() {
        if (estadoConverter == null) {
            estadoConverter = new ConverterGenerico(estadoFacade);
        }
        return estadoConverter;
    }

    public void editar(Cidade cid) {
        cidade = cid;
    }

    public void setEstadoConverter(ConverterGenerico estadoConverter) {
        this.estadoConverter = estadoConverter;
    }

    public List<Estado> listaEstadosFiltrando(String filtro) {
        return estadoFacade.listaFiltrando(filtro, "nome", "uf");
    }

    public void salvar() {
        cidadeFacade.salvar(cidade);
        cidade = new Cidade();
    }

    public void remover(Cidade obj) {
        cidadeFacade.remover(obj);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getListaCidades() {
        List<Cidade> listaCidades = cidadeFacade.listaTodos();
        Collections.sort(listaCidades, new Comparator<Cidade>() {
            @Override
            public int compare(Cidade cidade1, Cidade cidade2) {
                return cidade1.getNome().compareTo(cidade2.getNome());
            }
        });
        return listaCidades;
    }

}
