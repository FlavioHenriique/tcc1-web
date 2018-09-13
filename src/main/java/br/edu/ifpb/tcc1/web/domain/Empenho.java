package br.edu.ifpb.tcc1.web.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Empenho")
public class Empenho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codAcao")
    private Acao acao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codFavorecido")
    private Favorecido favorecido;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codUnidadeGestora")
    private UnidadeGestora unidadeGestora;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codData")
    private Data data;

    private BigDecimal valor;

    public Empenho() {
    }

    public Empenho(Acao acao, Favorecido favorecido,
            UnidadeGestora unidadeGestora, Data data) {
        this.acao = acao;
        this.favorecido = favorecido;
        this.unidadeGestora = unidadeGestora;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Favorecido getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(Favorecido favorecido) {
        this.favorecido = favorecido;
    }

    public UnidadeGestora getUnidadeGestora() {
        return unidadeGestora;
    }

    public void setUnidadeGestora(UnidadeGestora unidadeGestora) {
        this.unidadeGestora = unidadeGestora;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.acao);
        hash = 67 * hash + Objects.hashCode(this.favorecido);
        hash = 67 * hash + Objects.hashCode(this.unidadeGestora);
        hash = 67 * hash + Objects.hashCode(this.data);
        hash = 67 * hash + Objects.hashCode(this.valor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empenho other = (Empenho) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.acao, other.acao)) {
            return false;
        }
        if (!Objects.equals(this.favorecido, other.favorecido)) {
            return false;
        }
        if (!Objects.equals(this.unidadeGestora, other.unidadeGestora)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmpenhoTemporario{" + "id=" + id + ", acao=" + acao
                + ", favorecido=" + favorecido + ", unidadeGestora="
                + unidadeGestora + ", data=" + data + ", valor=" + valor + '}';
    }

}
