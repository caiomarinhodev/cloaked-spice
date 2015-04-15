package models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Caio on 15/04/2015.
 */
@Entity
@Table(name = "CUPOM")
public class Cupom {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String texto;
    @Column
    private String descricao;
    @Column
    private String tag;
    @Column
    private int tipo;
    @Column
    private Date dataCriacao;
    @Column
    private Date dataValidade;
    @Column
    private String loja;
    @Column
    private String url_loja;
    @Column
    private Long autorId;

    public Cupom(){

    }

    public Cupom(String texto, String descricao, String tag, int tipo, Date dataCriacao, Date dataValidade, Long autorId,
                 String loja, String url_loja) {
        this.texto = texto;
        this.descricao = descricao;
        this.tag = tag;
        this.tipo = tipo;
        this.dataCriacao = dataCriacao;
        this.dataValidade = dataValidade;
        this.autorId = autorId;
        this.loja = loja;
        this.url_loja = url_loja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getUrl_loja() {
        return url_loja;
    }

    public void setUrl_loja(String url_loja) {
        this.url_loja = url_loja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cupom cupom = (Cupom) o;

        if (tipo != cupom.tipo) return false;
        if (autorId != null ? !autorId.equals(cupom.autorId) : cupom.autorId != null) return false;
        if (loja != null ? !loja.equals(cupom.loja) : cupom.loja != null) return false;
        if (tag != null ? !tag.equals(cupom.tag) : cupom.tag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + tipo;
        result = 31 * result + (autorId != null ? autorId.hashCode() : 0);
        return result;
    }
}
