package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {

    private final Tekoaly tekoaly;
    
    public KPSTekoaly() {
        this.tekoaly = new Tekoaly();
    }

    @Override
    protected String toisenSiirto() {
        return tekoaly.annaSiirto();
    }
}