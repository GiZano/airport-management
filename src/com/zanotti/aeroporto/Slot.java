package com.zanotti.aeroporto;

public class Slot extends Gate{

    private String nomeCompagnia;

    public Slot() {
        super(0);
        this.nomeCompagnia = "";
    }

    public String getNomeCompagnia() {return nomeCompagnia;}

    public void setNomeCompagnia(String nomeCompagnia) {this.nomeCompagnia = nomeCompagnia;}
}
