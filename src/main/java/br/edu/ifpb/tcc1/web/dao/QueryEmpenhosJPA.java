package br.edu.ifpb.tcc1.web.dao;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class QueryEmpenhosJPA {

    private EntityManager em;

    public QueryEmpenhosJPA() {
        em = Persistence
                .createEntityManagerFactory("Tcc1-web")
                .createEntityManager();
    }
    
    public BigDecimal buscaPorAno(int ano1, int ano2){
        
        return em.createQuery("SELECT SUM(e.valor) FROM Empenho e"
                + " JOIN e.data d"
                + " WHERE d.ano BETWEEN :ano1 AND :ano2",BigDecimal.class)
                .setParameter("ano1", ano1)
                .setParameter("ano2", ano2)
                .getSingleResult();
    }
    
    
    public BigDecimal buscaPorSemestre(int semestre){
        
        return em.createQuery("SELECT SUM(e.valor) FROM Empenho e"
                + " JOIN e.data d "
                + "WHERE d.semestre = :semestre", BigDecimal.class)
                .setParameter("semestre", semestre)
                .getSingleResult();
    }
    
    public BigDecimal buscaPorMes(int mes1, int mes2){
        
        return em.createQuery("SELECT SUM(e.valor) FROM Empenho e"
                + " JOIN e.data d "
                + "WHERE d.codigo BETWEEN :mes1 AND :mes2",BigDecimal.class)
                .setParameter("mes1", mes1)
                .setParameter("mes2", mes2)
                .getSingleResult();
                
    }
}
