package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KiviPaperiSakset {

    private final TekoalyParannettu tekoaly;
    
    public KPSParempiTekoaly() {
        tekoaly = new TekoalyParannettu(512);
    }

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}
