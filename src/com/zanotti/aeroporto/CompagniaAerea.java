package com.zanotti.aeroporto;

import java.util.ArrayList;
import java.util.Arrays;

public class CompagniaAerea {

    private String nome;
    private ArrayList<Volo> listaVoli;

    public CompagniaAerea(String nome) {
        this.nome = nome;
        this.listaVoli = new ArrayList<>();
    }

    public void aggiungiVolo(Volo volo){
        this.listaVoli.add(volo);
    }

    public void rimuoviVolo(int numeroVolo){
        this.listaVoli.remove(numeroVolo);
    }

    public String getNome() {return nome;}

    public ArrayList<Volo> getListaVoli(){return listaVoli;}


    public void mostraListaVoli(){
        for(int i = 0; i < this.listaVoli.toArray().length; i++){
            System.out.println("Volo " + i + ": \n codice:" + this.listaVoli.get(i).getCodice() + "\n tipo: " + this.listaVoli.get(i).getTipo() + "\n passeggeri max: " + this.listaVoli.get(i).getPasseggeri().length + "\n passeggeri attuali: " + this.listaVoli.get(i).getPasseggeriAttuali());
        }
    }

    public int findVolo(String codiceVolo){
        int numeroVolo = -1;
        for(int i = 0; i < this.listaVoli.toArray().length; i++){
            if(this.listaVoli.get(i).getCodice().equals(codiceVolo)){
                numeroVolo = i;
            }
        }
        return numeroVolo;
    }

}
