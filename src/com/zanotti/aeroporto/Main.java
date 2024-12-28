package com.zanotti.aeroporto;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static int scelta(Scanner sc, int numeroScelte){
        int scelta;
        try {
            do {
                System.out.print("Inserire scelta:");
                scelta = sc.nextInt();
                sc.nextLine();
            } while (scelta < 0 || scelta > numeroScelte);
        }catch(InputMismatchException e){
            System.out.println("Inserire valore numerico!");
            sc.next();
            scelta = scelta(sc, numeroScelte);
        }
        return scelta;
    }

    public static int inputCheck(Scanner sc, int scelta){
        scelta = -1;
        try{
            System.out.print("Inserire valore:");
            scelta = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Inserire valore numerico!");
            sc.next();
            scelta = inputCheck(sc, scelta);
        }
        if(scelta <= 0){
            System.out.println("Inserire valore positivo!");
            scelta = inputCheck(sc, scelta);
        }
        return scelta;
    }

    public static String inputCheck(Scanner sc, String input){
        do{
            input = sc.nextLine();
        }while(Objects.equals(input, ""));
        return input;
    }

    public static int selezioneCompagniaRegular(Scanner sc, int numeroTerminal, Aeroporto aeroporto){
        System.out.println("Selezionare compagnia aerea: (selezione 0 - " + (aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().toArray().length - 1) + " disponibili).");
        System.out.println("Lista compagnie:");
        aeroporto.getTerminalRegolari().get(numeroTerminal).mostraListaCompagnie();
        return scelta(sc, aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().toArray().length - 1);
    }

    public static int selezioneCompagniaLowCost(Scanner sc, int numeroTerminal, Aeroporto aeroporto){
        System.out.println("Selezionare compagnia aerea: (selezione 0 - " + (aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().toArray().length - 1) + " disponibili).");
        System.out.println("Lista compagnie:");
        aeroporto.getTerminalLowCost().get(numeroTerminal).mostraListaCompagnie();
        return scelta(sc, aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().toArray().length - 1);
    }

    public static int selezioneVoloRegular(Scanner sc, int numeroTerminal, int compagniaScelta, Aeroporto aeroporto){
        System.out.println("Selezionare volo da assegnare: (selezione 0 - " + (aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().toArray().length - 1) + " disponibili).");
        System.out.println("Lista voli:");
        aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).mostraListaVoli();
        return scelta(sc, aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().toArray().length - 1);
    }

    public static int selezioneVoloLowCost(Scanner sc, int numeroTerminal, int compagniaScelta, Aeroporto aeroporto){
        System.out.println("Selezionare volo da assegnare: (selezione 0 - " + (aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().toArray().length - 1) + " disponibili).");
        System.out.println("Lista voli:");
        aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).mostraListaVoli();
        return scelta(sc, aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().toArray().length- 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scelta;

        System.out.println("Benvenuto nel programma di gestione di un aeroporto!");
        Aeroporto aeroporto = new Aeroporto();

        while (true) {

            System.out.println("""
                    ------Menu------ 0
                    1) Gestione Terminal
                    2) Gestione Passeggeri/Viaggiatori
                    0) Esci
                    """);
            scelta = scelta(sc, 2);

            switch (scelta) {
                case 0:
                    return;

                case 1:
                    // gestione terminal
                    System.out.println("""
                            ------Menu------ 0.1
                            1) Gestione Terminal Regolare
                            2) Gestione Terminal Low Cost
                            0) Indietro""");
                    scelta = scelta(sc, 2);

                    switch (scelta) {
                        case 0:
                            break;

                        case 1:
                            // gestione terminal regolare
                            System.out.println("""
                                    ------Menu------ 0.1.1
                                    1) Crea nuovo Terminal
                                    2) Gestione terminal esistente
                                    0) Indietro""");
                            scelta = scelta(sc, 3);

                            switch (scelta) {
                                case 0:
                                    break;
                                case 1:
                                    // crea terminal
                                    System.out.println("Creazione di nuovo terminal regolare!");
                                    System.out.println("Quanti gate gestisce?");
                                    int numeroGate = -1;
                                    numeroGate = inputCheck(sc, numeroGate);
                                    TerminalRegolare nuovoTerminal = new TerminalRegolare(numeroGate);
                                    aeroporto.aggiungiTerminal(nuovoTerminal);
                                    System.out.println("\nTerminal creato! \n");
                                    break;
                                case 2:
                                    // gestione terminal
                                    if(aeroporto.getTerminalRegolari().toArray().length == 0){
                                        System.out.println("Nessun terminal regolare esistente!");
                                    }
                                    else {
                                        System.out.println("Selezionare numero terminal (0 - " + (aeroporto.getTerminalRegolari().toArray().length - 1) + " disponibili).");
                                        int numeroTerminal = scelta(sc, aeroporto.getTerminalRegolari().toArray().length-1);

                                        System.out.println("""
                                                ------Menu------ 0.1.1.2
                                                1) Gestione Gate
                                                2) Aggiungi compagnia aerea
                                                3) Rimuovi compagnia aerea
                                                4) Gestione compagnia aerea
                                                5) Mostra passeggeri
                                                6) Elimina Terminal
                                                0) Indietro""");
                                        scelta = scelta(sc, 6);

                                        switch (scelta) {
                                            case 0:
                                                break;
                                            case 1:
                                                // gestione gate
                                                if(aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().toArray().length == 0){
                                                    System.out.println("Nessuna compagnia da assegnare!");
                                                    break;
                                                }
                                                System.out.println("Selezionare numero gate (0 -" + (aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate().length - 1) +" disponibili).");
                                                int gateSelezionato = scelta(sc, aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate().length);
                                                System.out.println("""
                                                        ------Menu------ 0.1.1.2.1
                                                        1) Assegna
                                                        2) Libera
                                                        3) Visualizza
                                                        0) Indietro""");
                                                scelta = scelta(sc, 3);

                                                switch (scelta) {
                                                    case 0:
                                                        break;
                                                    case 1:
                                                        // assegna gate
                                                        if(Objects.equals(aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].getStato(), "Occupato")){
                                                            System.out.println("Gate gia' assegnato!");
                                                            break;
                                                        }
                                                        else{
                                                            int compagniaScelta = selezioneCompagniaRegular(sc, numeroTerminal, aeroporto);

                                                            if(aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().toArray().length == 0){
                                                                System.out.println("Nessun volo esitente!");
                                                            }
                                                            else{
                                                                int voloScelto = selezioneVoloRegular(sc, numeroTerminal, compagniaScelta, aeroporto);
                                                                aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].setCodiceVolo(aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().get(voloScelto).getCodice());
                                                                aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].setStato("Occupato");
                                                                aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].setNumeroCompagnia(compagniaScelta);
                                                                aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().get(voloScelto).setStato("Occupato");
                                                            }

                                                        }
                                                        break;
                                                    case 2:
                                                        // libera gate
                                                        if(Objects.equals(aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].getStato(), "Libero")){
                                                            System.out.println("Gate gia' Libero!");
                                                            break;
                                                        }
                                                        else{
                                                            aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].getNumeroCompagnia()).getListaVoli().get(aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].getNumeroCompagnia()).findVolo(aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].getCodiceVolo())).setStato("Libero");
                                                            aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].setStato("Libero");
                                                            aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].setStato("");
                                                        }
                                                        break;
                                                    case 3:
                                                        // visualizza gate
                                                        System.out.println("Stato del gate: " + aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].getStato());
                                                        System.out.println("Codice volo del gate: " + aeroporto.getTerminalRegolari().get(numeroTerminal).getListaGate()[gateSelezionato].getCodiceVolo() + "\n");
                                                        break;
                                                }
                                                break;
                                            case 2:
                                                // aggiungi compagnia

                                                System.out.println("Inserire nome compagnia:");
                                                String nomeCompagnia = "";
                                                nomeCompagnia = inputCheck(sc, nomeCompagnia);
                                                CompagniaAerea nuovaCompagnia = new CompagniaAerea(nomeCompagnia);
                                                aeroporto.getTerminalRegolari().get(numeroTerminal).addCompagnia(nuovaCompagnia);

                                                break;
                                            case 3:
                                                // rimuovi compagnia aerea
                                                if(aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().toArray().length == 0){
                                                    System.out.println("Nessuna compagnia esistente!");
                                                    break;
                                                }
                                                else{
                                                    int compagniaScelta = selezioneCompagniaRegular(sc, numeroTerminal, aeroporto);
                                                    aeroporto.getTerminalRegolari().get(numeroTerminal).rimuoviCompagnia(compagniaScelta);
                                                }
                                                break;
                                            case 4:
                                                // gestione compagnia aerea
                                                int compagniaScelta;
                                                if(aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().toArray().length == 0){
                                                    System.out.println("Nessuna compagnia esistente!");
                                                    break;
                                                }
                                                else{
                                                    compagniaScelta = selezioneCompagniaRegular(sc, numeroTerminal, aeroporto);
                                                }

                                                System.out.println("""
                                                        ------Menu------ 0.1.1.2.3
                                                        1) Aggiungi volo
                                                        2) Rimuovi volo
                                                        3) Mostra voli
                                                        0) Indietro""");
                                                scelta = scelta(sc, 3);

                                                switch (scelta) {
                                                    case 0:
                                                        break;
                                                    case 1:
                                                        // aggiungi volo
                                                        System.out.println("Inserire codice volo.");
                                                        String codiceVolo = "";
                                                        codiceVolo = inputCheck(sc, codiceVolo);
                                                        System.out.println("Inserire tipologia volo.");
                                                        System.out.println("""
                                                                   0) Standard
                                                                   1) Business
                                                                   """);
                                                        int tipoVolo;
                                                        String tipologiaVolo = "";
                                                        tipoVolo = scelta(sc, 1);
                                                        switch(tipoVolo){
                                                                case 0:
                                                                tipologiaVolo = "Standard";
                                                                    break;
                                                                case 1: tipologiaVolo = "Business";
                                                                    break;
                                                            }
                                                            System.out.println("Inserire numero massimo di passeggeri.");
                                                        int maxPasseggeri = -1;
                                                        maxPasseggeri = inputCheck(sc, maxPasseggeri);
                                                        Volo nuovoVolo = new Volo(codiceVolo, tipologiaVolo, maxPasseggeri);
                                                        aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).aggiungiVolo(nuovoVolo);

                                                        break;
                                                    case 2:
                                                        // rimuovi volo
                                                        if(aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().toArray().length == 0){
                                                            System.out.println("Nessun volo esistente!\n");
                                                            break;
                                                        }
                                                        else{
                                                            System.out.println("Selezionare volo (0-" + (aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().toArray().length - 1) + " disponibili).");
                                                            aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).mostraListaVoli();
                                                            int voloScelto;
                                                            voloScelto = selezioneVoloRegular(sc, numeroTerminal, compagniaScelta, aeroporto);
                                                            if(Objects.equals(aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().get(voloScelto).getStato(), "Occupato")){
                                                                System.out.println("Volo occupato in un gate!");
                                                            }
                                                            else{
                                                                aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).rimuoviVolo(voloScelto);
                                                            }
                                                        }
                                                        break;
                                                    case 3:
                                                        // mostra voli
                                                        aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).mostraListaVoli();
                                                        break;
                                                }
                                                break;
                                            case 5:
                                                // mostra passeggeri
                                                ArrayList<Passeggero> passeggeri = aeroporto.getTerminalRegolari().get(numeroTerminal).getPasseggeri();
                                                for(int i = 0; i < passeggeri.toArray().length; i++){
                                                    System.out.println("Passeggero " + i + ": " + passeggeri.get(i).getNome() + passeggeri.get(i).getCognome());
                                                }
                                                break;
                                            case 6:
                                                // elimina terminal
                                                aeroporto.rimuoviTerminalRegolare(numeroTerminal);
                                                System.out.println("Terminal eliminato con successo!");
                                                break;

                                        }
                                    }
                                    break;
                            }

                            break;

                        case 2:
                            // gestione terminal low cost
                            System.out.println("""
                                    ------Menu------ 0.1.2
                                    1) Crea nuovo Terminal
                                    2) Gestione terminal esistente
                                    0) Indietro
                                    """);
                            scelta = scelta(sc, 2);
                            switch (scelta) {
                                case 0:
                                    break;
                                case 1:
                                    // crea nuovo terminal
                                    System.out.println("Creazione di nuovo terminal Low-Cost!");

                                    System.out.println("Quanti slot gestisce?");
                                    int numeroSlot = -1;
                                    numeroSlot = inputCheck(sc, numeroSlot);
                                    TerminalLowCost nuovoTerminal = new TerminalLowCost(numeroSlot);
                                    aeroporto.aggiungiTerminal(nuovoTerminal);
                                    System.out.println("Terminal creato con successo!\n");
                                    break;
                                case 2:
                                    // gestisci terminal esistente
                                    if(aeroporto.getTerminalLowCost().toArray().length == 0){
                                        System.out.println("Nessun terminal low-cost esistente!");
                                    }
                                    else {
                                        System.out.println("Selezionare numero terminal (0 - " + (aeroporto.getTerminalLowCost().toArray().length - 1) + " disponibili).");
                                        int numeroTerminal = scelta(sc, aeroporto.getTerminalLowCost().toArray().length - 1);

                                        System.out.println("""
                                                ------Menu------ 0.1.2.2
                                                1) Gestione Slot
                                                2) Aggiungi compagnia aerea
                                                3) Rimuovi compagnia aerea
                                                4) Elimina Terminal
                                                0) Indietro
                                                """);

                                        scelta = scelta(sc, 5);
                                        switch (scelta) {
                                            case 0:
                                                break;
                                            case 1:
                                                // gestione slot
                                                if(aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().toArray().length == 0){
                                                    System.out.println("Nessuna compagnia esistente!");
                                                    break;
                                                }
                                                else {
                                                    System.out.println("""
                                                            ------Menu------ 0.1.2.2.1
                                                            1) Assegna slot
                                                            2) Libera slot
                                                            3) Visualizza Slot
                                                            0) Indietro
                                                            """);

                                                    scelta = scelta(sc, 3);
                                                    int slotSelezionato;
                                                    switch (scelta) {
                                                        case 0:
                                                            break;
                                                        case 1:
                                                            // assegna slot
                                                            System.out.println("Seleziona slot (0-" + aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot().length + ")");
                                                            slotSelezionato = scelta(sc, aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot().length);
                                                            if (aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot()[slotSelezionato].getStato().equals("Occupato")) {
                                                                System.out.println("Slot gia' assegnato!");
                                                                break;
                                                            } else {
                                                                System.out.println("Selezionare compagnia aerea.");
                                                                System.out.println("Lista compagnie aeree:");
                                                                aeroporto.getTerminalLowCost().get(numeroTerminal).mostraListaCompagnie();
                                                                int compagniaScelta = scelta(sc, aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().toArray().length);
                                                                System.out.println("Inserire codice volo.");
                                                                String codiceVolo = "";
                                                                codiceVolo = inputCheck(sc, codiceVolo);
                                                                System.out.println("Inserire numero massimo di passeggeri.");
                                                                int maxPasseggeri = -1;
                                                                maxPasseggeri = inputCheck(sc, maxPasseggeri);
                                                                Volo nuovoVolo = new Volo(codiceVolo, "Low-Cost", maxPasseggeri);
                                                                nuovoVolo.setStato("Occupato");
                                                                aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta).aggiungiVolo(nuovoVolo);
                                                                aeroporto.getTerminalLowCost().get(numeroTerminal).assegnaSlot(nuovoVolo, slotSelezionato, aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().get(compagniaScelta));
                                                            }

                                                            break;
                                                        case 2:
                                                            // libera slot
                                                            System.out.println("Seleziona slot (0-" + aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot().length);
                                                            slotSelezionato = scelta(sc, aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot().length);
                                                            if (aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot()[slotSelezionato].getStato().equals("Libero")) {
                                                                System.out.println("Slot gia' libero!");
                                                                break;
                                                            } else {
                                                                String nomeCompagnia = aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot()[slotSelezionato].getNomeCompagnia();
                                                                int numeroCompagnia = aeroporto.getTerminalLowCost().get(numeroTerminal).findCompagnia(nomeCompagnia);
                                                                String codiceVolo = aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot()[slotSelezionato].getCodiceVolo();
                                                                int numeroVolo = aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().get(numeroCompagnia).findVolo(codiceVolo);
                                                                aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().get(numeroCompagnia).rimuoviVolo(numeroVolo);

                                                                aeroporto.getTerminalLowCost().get(numeroTerminal).liberaSlot(slotSelezionato);
                                                            }
                                                            break;
                                                        case 3:
                                                            // visualizza slot
                                                            System.out.println("Seleziona slot (0-" + aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot().length);
                                                            slotSelezionato = scelta(sc, aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot().length);

                                                            System.out.println("Slot " + slotSelezionato + ":\n stato: " + aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot()[slotSelezionato].getStato() + "\n compagnia: "  + aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot()[slotSelezionato].getNomeCompagnia() + "\n codice volo: " + aeroporto.getTerminalLowCost().get(numeroTerminal).getSlot()[slotSelezionato].getCodiceVolo());
                                                            break;
                                                    }

                                                    break;
                                                }
                                            case 2:
                                                // aggiungi compagnia
                                                System.out.println("Inserire nome compagnia:");
                                                String nomeCompagnia = "";
                                                nomeCompagnia = inputCheck(sc, nomeCompagnia);
                                                CompagniaAerea nuovaCompagnia = new CompagniaAerea(nomeCompagnia);
                                                aeroporto.getTerminalLowCost().get(numeroTerminal).addCompagnia(nuovaCompagnia);

                                                break;
                                            case 3:
                                                // rimuovi compagnia
                                                if(aeroporto.getTerminalLowCost().get(numeroTerminal).getCompagnieAssegnate().toArray().length == 0){
                                                    System.out.println("Nessuna compagnia esistente!");
                                                    break;
                                                }
                                                else{
                                                    int compagniaScelta = selezioneCompagniaLowCost(sc, numeroTerminal, aeroporto);
                                                    aeroporto.getTerminalLowCost().get(numeroTerminal).rimuoviCompagnia(compagniaScelta);
                                                }
                                                break;
                                            case 4:
                                                // elimina terminal
                                                aeroporto.rimuoviTerminalLowC(numeroTerminal);
                                                System.out.println("Terminal eliminato con successo!");
                                                break;
                                        }
                                    }
                                    break;
                            }
                            break;
                    }

                    break;

                case 2:
                    // gestione passeggeri
                    System.out.println("""
                            ------Menu------ 0.2
                            1) Crea profilo Viaggiatore
                            2) Mostra profilo Viaggiatore
                            3) Modifica profilo Viaggiatore
                            4) Aggiungi prenotazione
                            5) Rimuovi prenotazione
                            0) Indietro""");
                    scelta = scelta(sc, 5);

                    switch (scelta) {
                        case 0:
                            break;
                        case 1:
                            // Crea profilo viaggiatore
                            System.out.println("Inserire nome viaggiatore:");
                            String nome = "";
                            nome = inputCheck(sc, nome);
                            System.out.println("Inserire cognome viaggiatore:");
                            String cognome = "";
                            cognome = inputCheck(sc, cognome);
                            System.out.println("Inserire telefono viaggiatore:");
                            String telefono = "";
                            telefono = inputCheck(sc, telefono);
                            System.out.println("Inserire numero del passaporto viaggiatore:");
                            String passaporto = "";
                            passaporto = inputCheck(sc, passaporto);

                            Viaggiatore nuovoUtente = new Viaggiatore(nome, cognome, telefono, passaporto);
                            aeroporto.aggiungiUtente(nuovoUtente);

                            break;
                        case 2:
                            // mostra profilo viaggiatore
                            if(aeroporto.getProfiliUtente().toArray().length == 0){
                                System.out.println("Nessun profilo utente esistente!");
                            }
                            else{
                                System.out.println("Inserire codice passaporto");
                                String codicePassaporto = "";
                                codicePassaporto = inputCheck(sc, codicePassaporto);

                                int numeroViaggiatore = aeroporto.findUtente(codicePassaporto);
                                if(numeroViaggiatore == -1){
                                    System.out.println("Viaggiatore non trovato!");
                                    break;
                                }
                                else{
                                    System.out.println("Dati viaggiatore:");
                                    aeroporto.getProfiliUtente().get(numeroViaggiatore).mostraViaggiatore();
                                }
                            }

                            break;
                        case 3:
                            // modifica profilo
                            if(aeroporto.getProfiliUtente().toArray().length == 0){
                                System.out.println("Nessun profilo utente esistente!");
                            }
                            else{
                                System.out.println("Inserire codice passaporto:");
                                String codicePassaporto = "";
                                codicePassaporto = inputCheck(sc, codicePassaporto);
                                int numeroProfilo = aeroporto.findUtente(codicePassaporto);
                                if(numeroProfilo == -1){
                                    System.out.println("Profilo non trovato!");
                                }
                                else{
                                    System.out.println("Inserire nuovo nome:");
                                    String nomeProfilo = "";
                                    nomeProfilo = inputCheck(sc, nomeProfilo);
                                    System.out.println("Inserire nuovo cognome:");
                                    String cognomeProfilo = "";
                                    cognomeProfilo = inputCheck(sc, cognomeProfilo);
                                    System.out.println("Inserire nuovo numero di telefono:");
                                    String telefonoProfilo = "";
                                    System.out.println(inputCheck(sc, telefonoProfilo));
                                    System.out.println("Inserire nuovo codice passaporto:");
                                    String passaportoProfilo = "";
                                    System.out.println(inputCheck(sc, passaportoProfilo));

                                    if(aeroporto.findUtente(codicePassaporto) == -1){
                                        aeroporto.getProfiliUtente().get(numeroProfilo).setNome(nomeProfilo);
                                        aeroporto.getProfiliUtente().get(numeroProfilo).setCognome(cognomeProfilo);
                                        aeroporto.getProfiliUtente().get(numeroProfilo).setTelefono(telefonoProfilo);
                                    }
                                    else{
                                        System.out.println("Passaporto esistente!");
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            // aggiungi prenotazione
                            int numeroPasseggero;
                            Passeggero nuovoPasseggero;
                            if(aeroporto.getProfiliUtente().toArray().length == 0){
                                System.out.println("Nessun profilo utente esistente!");
                            }
                            else{
                                System.out.println("Inserire codice passaporto");
                                String codicePassaporto = "";
                                codicePassaporto = inputCheck(sc, codicePassaporto);

                                int numeroViaggiatore = aeroporto.findUtente(codicePassaporto);
                                if(numeroViaggiatore == -1){
                                    System.out.println("Viaggiatore non trovato!");
                                    break;
                                }
                                else{

                                    numeroPasseggero = aeroporto.findPasseggero(codicePassaporto);

                                    if(numeroPasseggero == -1){
                                        nuovoPasseggero = new Passeggero(aeroporto.getProfiliUtente().get(numeroViaggiatore));
                                        aeroporto.aggiungiPasseggero(nuovoPasseggero);
                                        numeroPasseggero = aeroporto.getPasseggeri().toArray().length-1;
                                    }

                                    System.out.println("Si desidera prenotare in un terminal regolare o low cost?");
                                    System.out.println("""
                                            1) Regolare
                                            2) Low-Cost
                                            0) Indietro
                                            """);
                                    scelta = scelta(sc, 2);

                                    int terminalPrenotazione, compagniaScelta, voloSelezionato;
                                    switch (scelta) {
                                        case 0: break;
                                        case 1:
                                            // prenotazione regular
                                            System.out.println("Inserire numero terminal (0-" + (aeroporto.getTerminalRegolari().toArray().length-1) + ")");
                                            terminalPrenotazione = scelta(sc, aeroporto.getTerminalRegolari().toArray().length-1);
                                            System.out.println("Selezionare compagnia");
                                            compagniaScelta = selezioneCompagniaRegular(sc, terminalPrenotazione, aeroporto);
                                            System.out.println("Selezionare volo");
                                            voloSelezionato = selezioneVoloRegular(sc, terminalPrenotazione, compagniaScelta, aeroporto);

                                            Prenotazione nuovaPrenotazione = new Prenotazione(terminalPrenotazione, "Regular", aeroporto.getTerminalRegolari().get(terminalPrenotazione).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().get(voloSelezionato).getCodice(), aeroporto.getTerminalRegolari().get(terminalPrenotazione).getCompagnieAssegnate().get(compagniaScelta).getNome());
                                            aeroporto.getPasseggeri().get(numeroPasseggero).addPrenotazione(nuovaPrenotazione);
                                            aeroporto.getTerminalRegolari().get(terminalPrenotazione).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().get(voloSelezionato).addPasseggero(aeroporto.getPasseggeri().get(numeroPasseggero));

                                            aeroporto.getProfiliUtente().get(numeroViaggiatore).aggiornaStorico(aeroporto.getTerminalRegolari().get(terminalPrenotazione).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().get(voloSelezionato));


                                            break;
                                        case 2:
                                            // prenotazione low cost

                                            numeroPasseggero = aeroporto.findPasseggero(codicePassaporto);

                                            if(numeroPasseggero == -1){
                                                nuovoPasseggero = new Passeggero(aeroporto.getProfiliUtente().get(numeroViaggiatore));
                                                aeroporto.aggiungiPasseggero(nuovoPasseggero);
                                                numeroPasseggero = aeroporto.getPasseggeri().toArray().length-1;
                                            }

                                            System.out.println("Inserire numero terminal (0-" + (aeroporto.getTerminalLowCost().toArray().length-1) + ")");
                                            terminalPrenotazione = scelta(sc, aeroporto.getTerminalLowCost().toArray().length-1);
                                            System.out.println("Selezionare compagnia");
                                            compagniaScelta = selezioneCompagniaLowCost(sc, terminalPrenotazione, aeroporto);
                                            System.out.println("Selezionare volo");
                                            voloSelezionato = selezioneVoloLowCost(sc, terminalPrenotazione, compagniaScelta, aeroporto);

                                            Prenotazione prenotazione = new Prenotazione(terminalPrenotazione, "Low-Cost", aeroporto.getTerminalLowCost().get(terminalPrenotazione).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().get(voloSelezionato).getCodice(), aeroporto.getTerminalLowCost().get(terminalPrenotazione).getCompagnieAssegnate().get(compagniaScelta).getNome());

                                            aeroporto.getPasseggeri().get(numeroPasseggero).addPrenotazione(prenotazione);
                                            aeroporto.getTerminalLowCost().get(terminalPrenotazione).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().get(voloSelezionato).addPasseggero(aeroporto.getPasseggeri().get(numeroPasseggero));

                                            aeroporto.getProfiliUtente().get(numeroViaggiatore).aggiornaStorico(aeroporto.getTerminalRegolari().get(terminalPrenotazione).getCompagnieAssegnate().get(compagniaScelta).getListaVoli().get(voloSelezionato));

                                            break;
                                    }

                                }
                            }
                            break;
                        case 5:
                            // rimuovi prenotazione
                            if(aeroporto.getProfiliUtente().toArray().length == 0){
                                System.out.println("Nessun profilo utente esistente!");
                            }
                            else{
                                System.out.println("Inserire codice passaporto");
                                String codicePassaporto = "";
                                codicePassaporto = inputCheck(sc, codicePassaporto);

                                numeroPasseggero = aeroporto.findPasseggero(codicePassaporto);
                                if(numeroPasseggero == -1){
                                    System.out.println("Passeggero non trovato!");
                                    break;
                                }
                                else{
                                    System.out.println("Selezionare prenotazione");
                                    aeroporto.getPasseggeri().get(numeroPasseggero).mostraPrenotazioni();
                                    int prenotazioneScelta = scelta(sc, aeroporto.getPasseggeri().get(numeroPasseggero).getPrenotazioni().toArray().length-1);

                                    if(Objects.equals(aeroporto.getPasseggeri().get(numeroPasseggero).getPrenotazioni().get(prenotazioneScelta).getTipoTerminal(), "Regular")){

                                        passaporto = aeroporto.getPasseggeri().get(numeroPasseggero).getNumeroPassaporto();
                                        int numeroTerminal = aeroporto.getPasseggeri().get(numeroPasseggero).getPrenotazioni().get(prenotazioneScelta).getNumeroTerminal();
                                        String nomeCompagnia = aeroporto.getPasseggeri().get(numeroPasseggero).getPrenotazioni().get(prenotazioneScelta).getNomeCompagnia();
                                        String codiceVolo = aeroporto.getPasseggeri().get(numeroPasseggero).getPrenotazioni().get(prenotazioneScelta).getCodiceVolo();
                                        int numeroCompagnia = aeroporto.getTerminalRegolari().get(numeroTerminal).findCompagnia(nomeCompagnia);
                                        int numeroVolo = aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(numeroCompagnia).findVolo(codiceVolo);

                                        aeroporto.getTerminalRegolari().get(numeroTerminal).getCompagnieAssegnate().get(numeroCompagnia).getListaVoli().get(numeroVolo).rimuoviPasseggero(passaporto);


                                    }
                                    aeroporto.getPasseggeri().get(numeroPasseggero).rimuoviPrenotazione(prenotazioneScelta);
                                }
                            }
                            break;
                    }
                    break;
            }

        }
    }
}
