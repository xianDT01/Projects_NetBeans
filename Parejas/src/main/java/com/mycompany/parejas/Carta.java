
package com.mycompany.parejas;

public class Carta {
    private int id;
    private  String imagen;
    private boolean  eliminada;
    
    public Carta(int identificador, String ruta){
        id=identificador;
        imagen=ruta;
        eliminada=false;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isEliminada() {
        return eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }


}
