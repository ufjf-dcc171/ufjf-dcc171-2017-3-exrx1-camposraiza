package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;

public class TipoRaio {
    private String nome;
    private List<Raio> raios;

    public TipoRaio() {
        this(null);
    }

    public TipoRaio(String nome) {
        this.raios = new ArrayList<>();
        this.nome = nome;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Raio> getRaios() {
        return raios;
    }

    public void setRaios(List<Raio> raios) {
        this.raios = raios;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
}
