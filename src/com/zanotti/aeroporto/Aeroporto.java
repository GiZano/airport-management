package com.zanotti.aeroporto;
import java.util.ArrayList;

public class Aeroporto {

    private ArrayList<TerminalRegolare> terminalRegolari;

    private ArrayList<TerminalLowCost> terminalLowCost;

    private ArrayList<Viaggiatore> profiliUtente;

    private ArrayList<Passeggero> passeggeri;

    public Aeroporto() {
        this.terminalRegolari = new ArrayList<>();
        this.terminalLowCost = new ArrayList<>();
        this.profiliUtente = new ArrayList<>();
        this.passeggeri = new ArrayList<>();
    }


    public void aggiungiTerminal(TerminalRegolare terminal){
        this.terminalRegolari.add(terminal);
    }


    public void aggiungiTerminal(TerminalLowCost terminal){
        this.terminalLowCost.add(terminal);
    }

    public void rimuoviTerminalRegolare(int numeroTerminal){
        this.terminalRegolari.remove(numeroTerminal);
    }

    public void rimuoviTerminalLowC(int numeroTerminal){
        this.terminalLowCost.remove(numeroTerminal);
    }

    public void aggiungiUtente(Viaggiatore viaggiatore){
       this.profiliUtente.add(viaggiatore);
    }

    public int findUtente(String codicePassaporto){
        for(int i = 0; i < this.profiliUtente.toArray().length; i++){
            if(this.profiliUtente.get(i).numeroPassaporto.equals(codicePassaporto)){
                return i;
            }
        }
        return -1;
    }

    public int findPasseggero(String codicePassaporto){
            for (int i = 0; i < this.passeggeri.toArray().length; i++) {
                if (this.passeggeri.get(i).numeroPassaporto.equals(codicePassaporto)) {
                    return i;
                }
            }
        return -1;
    }

    public void aggiungiPasseggero(Passeggero passeggero){
        this.passeggeri.add(passeggero);
    }

    public ArrayList<TerminalRegolare> getTerminalRegolari() {
        return terminalRegolari;
    }

    public ArrayList<TerminalLowCost> getTerminalLowCost() {
        return terminalLowCost;
    }

    public ArrayList<Viaggiatore> getProfiliUtente() {
        return profiliUtente;
    }

    public ArrayList<Passeggero> getPasseggeri() {return passeggeri;}
}