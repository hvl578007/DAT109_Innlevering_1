package no.hvl.dat109;

import javax.swing.JOptionPane;

/**
 * Klasse for UI-element og metodar (utskrift/innlesing) til spelet
 * @author Stian Grønås
 */
public class SpelUI {

    private Stigespel spel;

    //TODO burde vel hatt ein kontroller mellom UI og spelet.. Nå er vel heller Stigespelet kontrolleren...

    /**
     * Startar spelet med så mange spelarar
     * @param talPaaSpelarar
     */
    public void start(int talPaaSpelarar) {

        if (talPaaSpelarar < 2 || talPaaSpelarar > 4) {
            System.out.println("Feil tal på spelararar");

        } else {
            System.out.println("----- Initialiserer stige og slangespel -----");
            this.spel = new Stigespel(this, talPaaSpelarar);
            
            //spel.initialiser(talPaaSpelarar);

            System.out.println("----- Startar stige og slangespel -----");
            spel.startSpel();

        }

        System.out.println("----- Avsluttar spelet -----");
        
    }


    /**
     * Skriv ut rundenr
     * @param rundeNr
     */
    public void skrivUtRunde(int rundeNr) {
        System.out.println("\n----- Runde nr " + rundeNr + " -----");
    }

    //kunne ha kutta nyRute variabelen...
    /**
     * Skriv ut eit trekk som ein spelar har gjort.
     * Namn, kva spelaren trilla og ruta brikka står på no.
     * (berre kor spelaren flytta til, også om brikka står i ro, ingen anna informasjon)
     * @param spelar
     * @param nyRute
     * @param verdi
     */
    public static void skrivUtTrekk(Spelar spelar, Rute nyRute, int verdi) {
        System.out.println(spelar.getNamn() + " trilla " + verdi + ", og flytta til rute nr. " + nyRute.getNummer());
    }

    /**
     * Skriv ut namnet på spelaren som har vunne
     * @param spelar
     */
    public void skrivUtVinnar(Spelar spelar) {
        System.out.println("##### " + spelar.getNamn() + " har vunne spelet! #####");
    }

    /**
     * Les inn eit namn til ein spelar
     * @param nr
     * @return namnet som blei skreve inn
     */
    public String lesInnNamnPaaSpelar(int nr) {
        //TODO burde hatt sjekk på kva som blei skreve inn (tom/ingen streng)
        return JOptionPane.showInputDialog("Skriv inn namn på spelar " + nr + ":");
    }
}