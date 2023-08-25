/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jaimedias
 */

//Classe entidade é toda classe que será persistida no banco de dados.
//annotation que cria uma tabela no banco de dados
@Entity
public class Estado {
//diz que o ID será uma chave primário da tabela
    @Id
//O dia será autoincremente, será gerado um numero sequencial automaticamente.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//indica que o atributo nome será uma coluna da tabela, com tamanho de 100 caracteres, não pode ser nulo, e os valores deve ser unicos.
    @Column(length = 100, nullable = false, unique = true)
    private String nome;
    @Column(length = 2, nullable = false)
    private String sigla;

//gets e sets - métodos acessores.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
