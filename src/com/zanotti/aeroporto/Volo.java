package com.zanotti.aeroporto;

public class Volo {

    private String codice;
    private String tipo; // Standard, Business, Low-Cost
    private String stato; // Occupato, Libero
    private int passeggeriAttuali;
    private Passeggero[] passeggeri;

    public Volo(String codice, String tipo, int MAXPASSEGGERI) {
        this.codice = codice;
        this.tipo = tipo;
        this.passeggeriAttuali = 0;
        this.passeggeri = new Passeggero[MAXPASSEGGERI];
        this.stato = "Libero";
    }

    public void addPasseggero(Passeggero passeggero){
        try {
            this.passeggeri[this.passeggeriAttuali] = passeggero;
            passeggeriAttuali++;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Volo pieno!");
        }
    }

    public void rimuoviPasseggero(String passaporto){
        int index = -1;
        for(int i = 0; i < this.passeggeriAttuali; i++){
            if(this.passeggeri[i].getNumeroPassaporto().equals(passaporto)){
                index = i;
            }
        }
        if(index == -1){
            System.out.println("Prenotazione inesistente!");
        }
        else{
            for(int i = index; i < passeggeriAttuali; i++){
                this.passeggeri[i] = this.passeggeri[i+1];
                this.passeggeri[i] = this.passeggeri[i+1];

            }
            this.passeggeriAttuali--;
        }
    }

    public String getCodice() {return codice;}
    public String getTipo() {return tipo;}
    public String getStato() {return stato;}
    public int getPasseggeriAttuali() {return passeggeriAttuali;}
    public Passeggero[] getPasseggeri() {return passeggeri;}

    public void setStato(String stato) {this.stato = stato;}
}
