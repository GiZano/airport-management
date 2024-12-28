package com.zanotti.aeroporto;

import java.util.ArrayList;
import java.util.Arrays;

public class Viaggiatore {
    protected String nome;
    protected String cognome;
    protected String telefono;
    protected String numeroPassaporto;
    protected ArrayList<Volo> storico;

    public Viaggiatore(String nome, String cognome, String telefono, String numeroPassaporto) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.numeroPassaporto = numeroPassaporto;
        this.storico = new ArrayList<>();
    }

    public void aggiornaStorico(Volo volo){
        this.storico.add(volo);
    }

    public String getNome() {return nome;}
    public String getCognome() {return cognome;}
    public String getTelefono() {return telefono;}
    public String getNumeroPassaporto() {return numeroPassaporto;}
    public void setNome(String nome) {this.nome = nome;}
    public void setCognome(String cognome) {this.cognome = cognome;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setNumeroPassaporto(String numeroPassaporto) {this.numeroPassaporto = numeroPassaporto;}

    @Override
    public String toString() {
        return "Viaggiatore{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", telefono='" + telefono + '\'' +
                ", numeroPassaporto='" + numeroPassaporto + '\'' +
                ", numeroVoli=" + storico.toArray().length +
                ", storico=" + Arrays.toString(storico.toArray()) +
                '}';
    }

    public void mostraViaggiatore(){
        System.out.println("Dati Viaggiatore " + this.numeroPassaporto);
        System.out.println("Nome: " + this.nome);
        System.out.println("Cognome: " + this.cognome);
        System.out.println("Telefono: " + this.telefono);
        System.out.println("Passaporto: " + this.numeroPassaporto);
        System.out.println("Storico: ");
        if(this.storico.toArray().length == 0){
            System.out.println("Nessun volo affrontato!!");
        }
        else{
            for(int i = 0; i < this.storico.toArray().length; i++){
                System.out.println("Volo " + i + ": codice: " + this.storico.get(i).getCodice() + ", tipo: " + this.storico.get(i).getTipo());
            }
        }
    }

}
