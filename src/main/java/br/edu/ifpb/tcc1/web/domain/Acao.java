package br.edu.ifpb.tcc1.web.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public class Acao implements Serializable {

    private int codigoFuncao;
    private String nomeFuncao;
    private String codigoSubFuncao;
    private String nomeSubFuncao;
    private String codigoPrograma;
    private String nomePrograma;
    @Id
    @Column(unique = true)
    private String codigoAcao;
    private String nomeAcao;

    public Acao() {
    }

    public Acao(int codigoFuncao, String nomeFuncao, String codigoSubFuncao,
            String nomeSubFuncao, String codigoPrograma, String nomePrograma,
            String codigoAcao, String nomeAcao) {
        this.codigoFuncao = codigoFuncao;
        this.nomeFuncao = nomeFuncao;
        this.codigoSubFuncao = codigoSubFuncao;
        this.nomeSubFuncao = nomeSubFuncao;
        this.codigoPrograma = codigoPrograma;
        this.nomePrograma = nomePrograma;
        this.codigoAcao = codigoAcao;
        this.nomeAcao = nomeAcao;
    }

    public int getCodigoFuncao() {
        return codigoFuncao;
    }

    public void setCodigoFuncao(int codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    public String getCodigoSubFuncao() {
        return codigoSubFuncao;
    }

    public void setCodigoSubFuncao(String codigoSubFuncao) {
        this.codigoSubFuncao = codigoSubFuncao;
    }

    public String getNomeSubFuncao() {
        return nomeSubFuncao;
    }

    public void setNomeSubFuncao(String nomeSubFuncao) {
        this.nomeSubFuncao = nomeSubFuncao;
    }

    public String getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(String codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public String getNomePrograma() {
        return nomePrograma;
    }

    public void setNomePrograma(String nomePrograma) {
        this.nomePrograma = nomePrograma;
    }

    public String getCodigoAcao() {
        return codigoAcao;
    }

    public void setCodigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    @Override
    public String toString() {
        return "Acao{" + "codigoFuncao=" + codigoFuncao + ", nomeFuncao="
                + nomeFuncao + ", codigoSubFuncao=" + codigoSubFuncao
                + ", nomeSubFuncao=" + nomeSubFuncao + ", codigoPrograma="
                + codigoPrograma + ", nomePrograma=" + nomePrograma
                + ", codigoAcao=" + codigoAcao + ", nomeAcao=" + nomeAcao + '}';
    }

}
