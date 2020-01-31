package no.hvl.dat109;

/**
 * Klasse som definerar eit stigespel
 * @author Stian Grønås
 */
public class Stigespel {

    private int rundeNr;
    private Terning terning;
    private Brett brett;
    private Brikke[] brikker;
    private Spelar[] spelarar;
    private boolean ferdig;

    //kopling tilbake til UI-objektet... gjer ikkje noko med dette ennå
    private SpelUI spelUI;

    /**
     * Opprettar eit nytt stigespel
     * @param spelUI
     */
    public Stigespel(SpelUI spelUI, int talPaaSpelarar) {
        this.terning = new Terning();

        this.brett = new Brett();

        this.brikker = new Brikke[talPaaSpelarar];
        this.spelarar = new Spelar[talPaaSpelarar];

        for (int i = 0; i < talPaaSpelarar; i++) {

            //sendar ein med brettet kan brikka sjølv setje seg på rute 1.
            brikker[i] = new Brikke(i, brett, brett.hentForsteRute());

            //berre brukar ui sin metode
            String namn = spelUI.lesInnNamnPaaSpelar(i+1);
            spelarar[i] = new Spelar(namn, brikker[i]);
        }

        this.rundeNr = 1; //begynner på runde 1

        this.spelUI = spelUI;
    }

    
    //flytta dette til konstruktøren heller så ein ikkje kan opprette ugyldige spel
    /*
    public void initialiser(int talPaaSpelarar) {
        this.terning = new Terning();

        this.brett = new Brett();

        this.brikker = new Brikke[talPaaSpelarar];
        this.spelarar = new Spelar[talPaaSpelarar];

        for (int i = 0; i < talPaaSpelarar; i++) {

            //sendar ein med brettet kan brikka sjølv setje seg på rute 1.
            brikker[i] = new Brikke(i, brett, brett.hentForsteRute());

            //berre brukar ui sin metode
            String namn = spelUI.lesInnNamnPaaSpelar(i+1);
            spelarar[i] = new Spelar(namn, brikker[i]);
        }

        this.rundeNr = 1; //begynner på runde 1
    }
    */


    /**
     * Startar spelet
     */
    public void startSpel() {


        while(!ferdig) {

            utforRunde();
        }

    }
    
    /**
     * Utførar ein runde
     */
    private void utforRunde() {

        spelUI.skrivUtRunde(this.rundeNr);

        for (Spelar spelar : spelarar) {

            spelar.gjerTrekk(this.terning);
            //TODO spelet skriv ut trekket!?
            //spelUI.skrivUtTrekk(spelar, spelar.getBrikke().getRute(), this.terning.getVerdi());

            boolean vunne = spelar.harVunne();

            if(vunne) {
                spelUI.skrivUtVinnar(spelar);
                this.ferdig = true;
                break;
            }
        }

        this.rundeNr++;

    }

    public int getRunde() {
        return rundeNr;
    }

    public void setRunde(int runde) {
        this.rundeNr = runde;
    }

	

    
}