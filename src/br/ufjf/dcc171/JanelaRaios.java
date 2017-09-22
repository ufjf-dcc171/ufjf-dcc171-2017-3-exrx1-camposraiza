package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaRaios extends JFrame {

    private final List<TipoRaio> raios;
    private final List<Raio> novoRaio;
    private final List<TipoRaio> nome;
    private final JList<TipoRaio> lstNome = new JList<>(new DefaultListModel<>());
    private final JList<Raio> lstRaios = new JList<>(new DefaultListModel<>());

    private final JButton criaNome = new JButton("Add Nome");
    private final JButton excluiNome = new JButton("Exclui Nome");
    private final JButton criaRaio = new JButton("Add Raio");
    private final JButton excluiRaio = new JButton("Exclui Raio");

    public JanelaRaios(List<TipoRaio> sampleData) throws ParseException {
        super("Raios");
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = fmt.parse("17/12/2007 19:30:20");
        String str = fmt.format(data);

        this.raios = sampleData;
         this.novoRaio = null;
        setMaximumSize(new Dimension(500, 300));
        this.nome = sampleData;
        lstNome.setModel(new TipoRaioListModel(nome));
        add(new JScrollPane(lstNome), BorderLayout.WEST);
        add(new JScrollPane(lstRaios), BorderLayout.CENTER);
        //Box botoes = Box.createHorizontalBox();
        JPanel botoes = new JPanel(new GridLayout(1, 4));
        add(botoes, BorderLayout.SOUTH);
        botoes.add(criaNome);
        botoes.add(excluiNome);
        botoes.add(criaRaio);
        botoes.add(excluiRaio);

        lstNome.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstNome.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                TipoRaio selecionada = lstNome.getSelectedValue();
                if (selecionada != null) {
                    System.out.println(selecionada);
                    lstRaios.setModel(new RaioListModel(selecionada.getRaios()));
                } else {
                    lstRaios.setModel(new DefaultListModel<>());
                }
            }
        });

        criaNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome raio");
                if (nome != null && !nome.isEmpty()) {
                    TipoRaio t = new TipoRaio("Raio1");
                    raios.add(t);

                    lstNome.updateUI();
                }
            }
        });
        excluiNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (lstNome.isSelectionEmpty()) {
                    return;
                }
                nome.remove(lstNome.getSelectedValue());
                lstNome.clearSelection();
                lstNome.updateUI();;
            }

        });
        criaRaio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String raio = JOptionPane.showInputDialog("Dados Raio");
                if (raio != null && !raio.isEmpty()) {
                    Raio t = new Raio();
                    novoRaio.add(t);

                    lstNome.updateUI();
                }
            }
        });

        excluiRaio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (lstRaios.isSelectionEmpty()) {
                    return;
                }
                novoRaio.remove(lstRaios.getSelectedValue());
                lstRaios.clearSelection();
                lstRaios.updateUI();;
            }

        });
    }
}