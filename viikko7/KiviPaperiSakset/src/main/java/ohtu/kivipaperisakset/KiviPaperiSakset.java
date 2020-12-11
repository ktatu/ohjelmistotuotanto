package ohtu.kivipaperisakset;

public abstract class KiviPaperiSakset {
    
    protected String ekanSiirto;
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.println("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = ensimmaisenSiirto();
        System.out.println("Toisen pelaajan siirto: ");
        String tokanSiirto = toisenSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = ensimmaisenSiirto();
            
            System.out.println("Toisen pelaajan siirto: ");
            tokanSiirto = toisenSiirto();
        }
        peliPaattyy(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        String siirto = IO.syote("siirto");
        ekanSiirto = siirto;
        return siirto;
    }

    // t�m� on abstrakti metodi sill� sen toteutus vaihtelee eri pelityypeiss�
    abstract protected String toisenSiirto();
    
    // Tietokoneen siirto ei voi olla virheellinen, tarkistetaan vain kertooko IO virhesy�tteest�
    protected static boolean onkoOkSiirto(String siirto) {
        return !siirto.equals("x");
    }
    
    private void peliPaattyy(Tuomari tuomari) {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}