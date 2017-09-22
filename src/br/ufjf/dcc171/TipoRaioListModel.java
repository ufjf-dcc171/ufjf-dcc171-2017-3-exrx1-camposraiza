package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class TipoRaioListModel implements ListModel<TipoRaio> {

    private final List<TipoRaio> nome;
    private final List<ListDataListener> dataListeners;

    public TipoRaioListModel(List<TipoRaio> nome) {
        this.nome = nome;
        this.dataListeners =  new ArrayList<>();
    }

    @Override
    public int getSize() {
        return nome.size();
    }

    @Override
    public TipoRaio getElementAt(int index) {
        return nome.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
}
