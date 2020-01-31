package no.hvl.dat109;

/**
 * Ein observatør som startar spelet.
 * @author Stian Grønås
 */
public class Observator {

    private static final int SPELARAR = 4;

    public static void main(String[] args) {
        
        SpelUI ui = new SpelUI();
        ui.start(SPELARAR);
    }
}