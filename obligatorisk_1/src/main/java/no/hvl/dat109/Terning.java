package no.hvl.dat109;

import java.util.Random;

/**
 * Definerar ein terning
 * @author Stian Grønås
 */
public class Terning {

    private int verdi;

    /**
     * Opprettar ein ny terning
     */
    public Terning() {
        this.verdi = 0;
    }

    /**
     * Trill terningen
     */
    public void trill() {

        //logikk for tilfeldig tal:
        Random random = new Random();
        this.verdi = random.nextInt(6) + 1;

        //TODO teste trillelogikken?
    }

    public int getVerdi() {
        return verdi;
    }
    
    //setVerdi() ikkje aktuelt?!

}