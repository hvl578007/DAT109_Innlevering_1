package no.hvl.dat109;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Program for å teste logikk i stigespelet
 */
public class StigespelTest {

    private static Brett brett = new Brett();
    private static Rute[] ruter = brett.getRuter();
    
    /**
     * Tester at ein står på ruta ein er på om ein går forbi mål
     */
    @Test
    public void testerGaarForbiMaal() {
        Rute rute99 = ruter[99-1];
        assertEquals(brett.finnNyRute(rute99, 2), rute99);
        assertEquals(brett.finnNyRute(rute99, 3), rute99);
        assertEquals(brett.finnNyRute(rute99, 4), rute99);
        Rute rute97 = ruter[97-1];
        assertEquals(brett.finnNyRute(rute97, 6), rute97);
    }

    /**
     * Tester at ein treff mål... dette tester generelt om du kjem på ruta ein skal 
     */
    @Test
    public void testerTreffRuta() {
        Rute rute99 = ruter[99-1];
        assertEquals(brett.finnNyRute(rute99, 1), ruter[99]);
        Rute rute94 = ruter[94-1];
        assertEquals(brett.finnNyRute(rute94, 6), ruter[99]);
    }

    /** 
     * Tester om du blir sendt til start-ruta om ein gir med ein stor negativ verdi (som spelaren skal sende ved 3*6 kast)
     * Burde eigentleg teste om det vil skje at spelaren kan få 3*6 då...
     */
    @Test
    public void testerGaaTilStart() {
        Rute rute99 = ruter[99-1];
        assertEquals(brett.finnNyRute(rute99, Integer.MIN_VALUE), ruter[0]);
    }

    //TODO ?? teste terningen? Teste spelaren? Noko anna... Burde men idk
}
