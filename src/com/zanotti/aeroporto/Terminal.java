package com.zanotti.aeroporto;
import java.util.ArrayList;

public abstract class Terminal {

    protected ArrayList<CompagniaAerea> compagnieAssegnate;

    public Terminal() {
        this.compagnieAssegnate = new ArrayList<>();
    }

    public void addCompagnia(CompagniaAerea compagnia) {
        this.compagnieAssegnate.add(compagnia);
    }

    public void rimuoviCompagnia(int numeroCompagnia){
        this.compagnieAssegnate.remove(numeroCompagnia);
    }

    public ArrayList<CompagniaAerea> getCompagnieAssegnate() {return compagnieAssegnate;}

    public ArrayList<Passeggero> getPasseggeri(){
        ArrayList<Passeggero> passeggeri = new ArrayList<>();
        for(int i = 0; i < this.compagnieAssegnate.toArray().length; i++){
            for(int j = 0; j < this.compagnieAssegnate.get(i).getListaVoli().toArray().length; j++){
                for(int k = 0; k < this.compagnieAssegnate.get(i).getListaVoli().get(j).getPasseggeriAttuali(); k++){
                    passeggeri.add(this.compagnieAssegnate.get(i).getListaVoli().get(j).getPasseggeri()[k]);
                }
            }
        }
        return passeggeri;
    }

    public void mostraListaCompagnie(){
        for(int i = 0; i < this.compagnieAssegnate.toArray().length; i++){
            System.out.println("Compagnia " + i + ": " + this.compagnieAssegnate.get(i).getNome());
        }
    }

    public int findCompagnia(String nomeCompagnia){
        for(int i = 0; i < this.compagnieAssegnate.toArray().length; i++){
            if(this.compagnieAssegnate.get(i).getNome().equals(nomeCompagnia)){
                return i;
            }
        }
        return -1;
    }
}
