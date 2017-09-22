package br.ufjf.dcc171;

import java.util.Date;

public class Raio {
    private String latitude;
    private String longitude;
    private String descricao;
    private Date data;
    

    public Raio() {
        
    }  
    
    public Raio(String latitude, String longitude, String descricao) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
        this.data = new Date();
        
    }
    
        public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    

    @Override
    public String toString() {
        return latitude + ": " + longitude + ": " + descricao + ":" + data;
    }
    
}
