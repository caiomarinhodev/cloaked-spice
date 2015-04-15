package models;

import javax.persistence.*;

/**
 * Created by caio on 15/04/15.
 */
@Entity
@Table(name = "LOJA")
public class Loja {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String url_foto;
    @Column
    private String url_link_loja;

    public Loja(){

    }

    public Loja(String nome, String url_foto, String url_link_loja) {
        this.nome = nome;
        this.url_foto = url_foto;
        this.url_link_loja = url_link_loja;
    }

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

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public String getUrl_link_loja() {
        return url_link_loja;
    }

    public void setUrl_link_loja(String url_link_loja) {
        this.url_link_loja = url_link_loja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loja loja = (Loja) o;

        if (nome != null ? !nome.equals(loja.nome) : loja.nome != null) return false;
        if (url_foto != null ? !url_foto.equals(loja.url_foto) : loja.url_foto != null) return false;
        if (url_link_loja != null ? !url_link_loja.equals(loja.url_link_loja) : loja.url_link_loja != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (url_foto != null ? url_foto.hashCode() : 0);
        result = 31 * result + (url_link_loja != null ? url_link_loja.hashCode() : 0);
        return result;
    }
}
