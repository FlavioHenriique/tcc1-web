package br.edu.ifpb.tcc1.web.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Data implements Serializable {

    @Id
    private int codigo;
    //@Temporal(TemporalType.DATE)
    //private Date data;
    private int ano;
    private int numero_mes;
    private String nome_mes;
    private int semestre;

    public Data() {
    }

    public Data(int codigo, int ano, int numero_mes,
            String nome_mes, int semestre) {
        this.codigo = codigo;
        //this.data = data;
        this.ano = ano;
        this.numero_mes = numero_mes;
        this.nome_mes = nome_mes;
        this.semestre = semestre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumero_mes() {
        return numero_mes;
    }

    public void setNumero_mes(int numero_mes) {
        this.numero_mes = numero_mes;
    }

    public String getNome_mes() {
        return nome_mes;
    }

    public void setNome_mes(String nome_mes) {
        this.nome_mes = nome_mes;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Data{" + "codigo=" + codigo + ", "
                + ", ano=" + ano + ", numero_mes=" + numero_mes + ","
                + " nome_mes=" + nome_mes + ", semestre=" + semestre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.codigo;
        hash = 47 * hash + this.ano;
        hash = 47 * hash + this.numero_mes;
        hash = 47 * hash + Objects.hashCode(this.nome_mes);
        hash = 47 * hash + this.semestre;
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
        final Data other = (Data) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (this.numero_mes != other.numero_mes) {
            return false;
        }
        if (this.semestre != other.semestre) {
            return false;
        }
        if (!Objects.equals(this.nome_mes, other.nome_mes)) {
            return false;
        }
        return true;
    }

}
