package com.zanotti.aeroporto;

public class TerminalRegolare extends Terminal {

    private Gate[] listaGate;

    public TerminalRegolare(int numeroGate) {
        super();
        this.listaGate = new Gate[numeroGate];
        for(int i = 0; i < numeroGate; i++){
            listaGate[i] = new Gate(-1);
        }
    }

    public Gate[] getListaGate() {
        return listaGate;
    }

}
