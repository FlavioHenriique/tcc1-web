package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.query.QueryValores;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ValoresController {

    @Inject
    private QueryValores query;

    public List<String> areas() {
        return query.todasAsAreas();
    }

    public List<String> anos() {
        return query.todosOsAnos();
    }
    
    public List<String> meses() {
        return query.todosOsMeses();
    }
}
