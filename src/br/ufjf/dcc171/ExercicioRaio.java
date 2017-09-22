package br.ufjf.dcc171;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class ExercicioRaio {

    public static void main(String[] args) throws ParseException {
        
        JanelaRaios janela = new JanelaRaios(getSampleData());
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
    }

    private static List<TipoRaio> getSampleData() {
        Raio r1 = new Raio("17", "25", " RAIO NÍVEL HARD");
        Raio r2 = new Raio("27", "30", "RAIO NÍVEL LIGTH");
        
        
        TipoRaio t1 = new TipoRaio("RAIO s2");
        TipoRaio t2 = new TipoRaio("RAIO s3");
        
        t1.getRaios().add(r1);
   
        t2.getRaios().add(r1);
        t2.getRaios().add(r2);
    
        List<TipoRaio> nome = new ArrayList<>();
        nome.add(t1);
        nome.add(t2);
        return nome;
    }
    
}
