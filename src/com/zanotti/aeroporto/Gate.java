package com.zanotti.aeroporto;

public class Gate {

    private String stato; // libero o occupato;
    private String codiceVolo; // nessuno o codice del volo assegnato
    private int numeroCompagnia;

    Gate(int numeroCompagnia) {
        this.stato = "Libero";
        this.codiceVolo = "";
        this.numeroCompagnia = numeroCompagnia;
    }

    public void setStato(String stato) {this.stato = stato;}
    public void setCodiceVolo(String codiceVolo) {this.codiceVolo = codiceVolo;}
    public void setNumeroCompagnia(int numeroCompagnia) {this.numeroCompagnia = numeroCompagnia;}

    public String getStato() {return this.stato;}
    public String getCodiceVolo() {return this.codiceVolo;}
    public int getNumeroCompagnia() {return this.numeroCompagnia;}
}
