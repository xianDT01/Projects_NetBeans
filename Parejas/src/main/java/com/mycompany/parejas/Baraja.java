
package com.mycompany.parejas;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    
    private Carta[] cartas;
    private int seleccionada;
    
    public Baraja(int longitud) {
        cartas = new Carta[longitud + 1];
        seleccionada = 0;
        cartas[0] = new Carta(0, "/img/dorso.jpg");
        int numeroParejas = longitud / 2;
        ArrayList<Integer> arrayPosiciones = new ArrayList<>();
        for (int i = 1; i <= numeroParejas * 2; i++) {
            arrayPosiciones.add(i);
        }
        Collections.shuffle(arrayPosiciones);

        for (int k = 1; k <= numeroParejas; k++) {
            int indice1 = k - 1;
            int indice2 = indice1 + numeroParejas;
            cartas[arrayPosiciones.get(indice1)] = new Carta(arrayPosiciones.get(indice1), "/img/carta" + k + ".jpg");
            cartas[arrayPosiciones.get(indice2)] = new Carta(arrayPosiciones.get(indice2), "/img/carta" + k + ".jpg");
        }
    }
    
    public boolean compararPareja(int a, int b){
       
     return (cartas[a].getImagen().equals(cartas[b].getImagen()));
        }
    public String getRutaImagen(int posicion){
        return cartas[posicion].getImagen();
        
    }
    
    public int getSeleccionada(){
        return  seleccionada;
    }
    public void setSeleccionada(int pos){
        seleccionada=pos;
    }
    
    public void eliminarPareja(int a, int b){
        cartas[a].setEliminada(true);
        cartas[b].setEliminada(true);
    }
    
}
