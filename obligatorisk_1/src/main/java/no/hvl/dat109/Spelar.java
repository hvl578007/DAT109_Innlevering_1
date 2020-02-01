package no.hvl.dat109;

/**
 * Klasse som definerar ein spelar
 * @author Stian Grønås
 */
public class Spelar {

    private static final int MAKS_KAST_MED_SEKSER = 3;
    //felles terning?
    //private Terning terning;
    private String namn;
    private Brikke brikke;

    private boolean kanFlytte;

    /**
     * Opprettar ein spelar med det namnet og brikka
     * @param namn
     * @param brikke
     */
    public Spelar(String namn, Brikke brikke) {
        this.namn = namn;
        this.brikke = brikke;
        //this.terning = terning;
        this.kanFlytte = true;
    }

    /**
     * Spelaren utførar eit trekk i spelet
     */
    public void gjerTrekk(Terning terning) {

        //Rute forrigeRute = brikke.getRute();

        int verdi = 0;

        //iterasjon 3 - terningsreglane. Kunne godt implementert ein annan plass, og burde kanskje gjort det..
        
        //gammal versjon der ein trilla opp til 3 gonger og så flytta
        /*
        do {
            terning.trill();
            verdi += terning.getVerdi();
            if (terning.getVerdi() == 6 && kanFlytte == false) {
                this.setKanFlytte(true);
            }
        } while (terning.getVerdi() == 6 && verdi < 6 * MAKS_KAST_MED_SEKSER);
        
        if (verdi >= 6 * MAKS_KAST_MED_SEKSER) {
            this.setKanFlytte(false);
            brikke.flytt(Integer.MIN_VALUE);
        }
        
        if (isKanFlytte()) {
            //evt la spelaren flytte brikka?
            brikke.flytt(verdi);
        }
        */

        //spelar flyttar etter eit kast og så kastar på nytt...

        int antKast = 0;

        do {
            terning.trill();
            verdi = terning.getVerdi();

            antKast++;

            if (verdi == 6 && !isKanFlytte()) {
                this.setKanFlytte(true);
            }

            if (antKast == 3 && verdi == 6) {
                this.setKanFlytte(false);
                brikke.flytt(Integer.MIN_VALUE);
                //burde ha eigen melding, flytte til start
                SpelUI.skrivUtTrekk(this, brikke.getRute(), Integer.MIN_VALUE);
            }

            if (isKanFlytte()) {
                brikke.flytt(verdi);
                SpelUI.skrivUtTrekk(this, brikke.getRute(), verdi);
            }

        } while (verdi == 6 && antKast < 3);

        //TODO spelaren seier trekket sitt til UI? Litt usikkert... Berre ny rute? Eller ta med at ein gjekk frå rute nr x til rute nr y?

        //skriv ut her for å få rett verdi...
        //SpelUI.skrivUtTrekk(this, brikke.getRute(), verdi);
        //treng vel ikkje sende med ruta...
    }

    /**
     * Spelaren sjekkar brikka si om den ligg på rute 100
     * @return true om den er på rute 100, false ellers
     */
    public boolean harVunne() {
        return this.brikke.getRute().getNummer() >= 100;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public boolean isKanFlytte() {
        return kanFlytte;
    }

    public void setKanFlytte(boolean kanFlytte) {
        this.kanFlytte = kanFlytte;
    }

    
}