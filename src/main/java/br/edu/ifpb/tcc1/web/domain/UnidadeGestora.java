package br.edu.ifpb.tcc1.web.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnidadeGestora implements Serializable {

    @Id
    private int codigoUnidadeGestora;
    private String nomeUnidadeGestora;
    private int codigoOrgaoSuperior;
    private String nomeOrgaoSuperior;
    private int codigoOrgao;
    private String nomeOrgao;

    public UnidadeGestora(int codigoUnidadeGestora, String nomeUnidadeGestora,
            int codigoOrgaoSuperior, String nomeOrgaoSuperior, int codigoOrgao,
            String nomeOrgao, int codigo) {
        this.codigoUnidadeGestora = codigoUnidadeGestora;
        this.nomeUnidadeGestora = nomeUnidadeGestora;
        this.codigoOrgaoSuperior = codigoOrgaoSuperior;
        this.nomeOrgaoSuperior = nomeOrgaoSuperior;
        this.codigoOrgao = codigoOrgao;
        this.nomeOrgao = nomeOrgao;

    }

    public UnidadeGestora() {
    }

    public int getCodigoUnidadeGestora() {
        return codigoUnidadeGestora;
    }

    public void setCodigoUnidadeGestora(int codigoUnidadeGestora) {
        this.codigoUnidadeGestora = codigoUnidadeGestora;
    }

    public String getNomeUnidadeGestora() {
        return nomeUnidadeGestora;
    }

    public void setNomeUnidadeGestora(String nomeUnidadeGestora) {
        this.nomeUnidadeGestora = nomeUnidadeGestora;
    }

    public int getCodigoOrgaoSuperior() {
        return codigoOrgaoSuperior;
    }

    public void setCodigoOrgaoSuperior(int codigoOrgaoSuperior) {
        this.codigoOrgaoSuperior = codigoOrgaoSuperior;
    }

    public String getNomeOrgaoSuperior() {
        return nomeOrgaoSuperior;
    }

    public void setNomeOrgaoSuperior(String nomeOrgaoSuperior) {
        this.nomeOrgaoSuperior = nomeOrgaoSuperior;
    }

    public int getCodigoOrgao() {
        return codigoOrgao;
    }

    public void setCodigoOrgao(int codigoOrgao) {
        this.codigoOrgao = codigoOrgao;
    }

    public String getNomeOrgao() {
        return nomeOrgao;
    }

    public void setNomeOrgao(String nomeOrgao) {
        this.nomeOrgao = nomeOrgao;
    }

    @Override
    public String toString() {
        return "UnidadeGestora{" + "codigoUnidadeGestora=" + codigoUnidadeGestora
                + ", nomeUnidadeGestora=" + nomeUnidadeGestora
                + ", codigoOrgaoSuperior=" + codigoOrgaoSuperior
                + ", nomeOrgaoSuperior=" + nomeOrgaoSuperior
                + ", codigoOrgao=" + codigoOrgao + ", nomeOrgao=" + nomeOrgao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.codigoUnidadeGestora;
        hash = 71 * hash + Objects.hashCode(this.nomeUnidadeGestora);
        hash = 71 * hash + this.codigoOrgaoSuperior;
        hash = 71 * hash + Objects.hashCode(this.nomeOrgaoSuperior);
        hash = 71 * hash + this.codigoOrgao;
        hash = 71 * hash + Objects.hashCode(this.nomeOrgao);

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
        final UnidadeGestora other = (UnidadeGestora) obj;
        if (this.codigoUnidadeGestora != other.codigoUnidadeGestora) {
            return false;
        }
        if (this.codigoOrgaoSuperior != other.codigoOrgaoSuperior) {
            return false;
        }
        if (this.codigoOrgao != other.codigoOrgao) {
            return false;
        }
        if (!Objects.equals(this.nomeUnidadeGestora, other.nomeUnidadeGestora)) {
            return false;
        }
        if (!Objects.equals(this.nomeOrgaoSuperior, other.nomeOrgaoSuperior)) {
            return false;
        }
        if (!Objects.equals(this.nomeOrgao, other.nomeOrgao)) {
            return false;
        }

        return true;
    }

}
