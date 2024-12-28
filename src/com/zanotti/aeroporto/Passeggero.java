package com.zanotti.aeroporto;

import java.util.ArrayList;

public class Passeggero extends Viaggiatore {

    private ArrayList<Prenotazione> prenotazioni;

    public Passeggero(Viaggiatore profiloViaggiatore) {
        super(profiloViaggiatore.nome, profiloViaggiatore.cognome, profiloViaggiatore.telefono, profiloViaggiatore.numeroPassaporto);
        this.prenotazioni = new ArrayList<>();
    }

    public Viaggiatore getProfiloViaggiatore(){
        return new Viaggiatore(this.nome, this.cognome, this.telefono, this.numeroPassaporto);
    }

    public void addPrenotazione(Prenotazione prenotazione){
        this.prenotazioni.add(prenotazione);
    }

    public void rimuoviPrenotazione(int numeroPrenotazione){
        this.prenotazioni.remove(numeroPrenotazione);
    }

    public int findPrenotazione(String codiceVolo){
        for(int i = 0; i < this.prenotazioni.toArray().length; i++){
            if(this.prenotazioni.get(i).getCodiceVolo().equals(codiceVolo)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Prenotazione> getPrenotazioni(){return this.prenotazioni;}

    public void mostraPrenotazioni() {
        if (this.prenotazioni.toArray().length == 0) {
            System.out.println("Nessuna prenotazione effettuata!");
        }
        else{
            System.out.println("Lista prenotazioni effettuate:");
            for (int i = 0; i < this.prenotazioni.toArray().length; i++) {
                System.out.println("Volo " + i + ": codice -> " + this.prenotazioni.get(i).getCodiceVolo() + ".");
            }
        }
    }
}
