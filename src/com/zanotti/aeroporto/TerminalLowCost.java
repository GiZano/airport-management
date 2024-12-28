package com.zanotti.aeroporto;

public class TerminalLowCost extends Terminal {

    private Slot[] slot;

    public TerminalLowCost(int numeroSlot) {
        this.slot = new Slot[numeroSlot];
        for(int i = 0; i < this.slot.length; i++){
            this.slot[i] = new Slot();
        }
    }

    public void assegnaSlot(Volo volo, int numeroSlot, CompagniaAerea compagnia){
        this.slot[numeroSlot].setStato("Occupato");
        this.slot[numeroSlot].setCodiceVolo(volo.getCodice());
        this.slot[numeroSlot].setNomeCompagnia(compagnia.getNome());

    }

    public void liberaSlot(int numeroSlot){
        this.slot[numeroSlot].setStato("Libero");
        this.slot[numeroSlot].setCodiceVolo("");
        this.slot[numeroSlot].setNomeCompagnia("");
    }



    public Slot[] getSlot() {return this.slot;}
}
