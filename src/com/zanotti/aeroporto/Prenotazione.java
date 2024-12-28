package com.zanotti.aeroporto;

public class Prenotazione {

    private int numeroTerminal;
    private String tipoTerminal;
    private String codiceVolo;
    private String nomeCompagnia;

    public Prenotazione(int numeroTerminal, String tipoTerminal, String codiceVolo, String nomeCompagnia) {
        this.numeroTerminal = numeroTerminal;
        this.tipoTerminal = tipoTerminal;
        this.codiceVolo = codiceVolo;
        this.nomeCompagnia = nomeCompagnia;
    }

    public int getNumeroTerminal() {
        return numeroTerminal;
    }

    public String getTipoTerminal() {
        return tipoTerminal;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public String getNomeCompagnia() {
        return nomeCompagnia;
    }
}
