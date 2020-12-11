package ohtu.kivipaperisakset;

public class Paaohjelma {

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetetaan");

            String syote = IO.syote("valikko");
            
            if (syote.equals("x")) {
                return;
            }
            
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            
            String peliTyyppi = peliTyyppi(syote);
            KiviPaperiSakset peli = PeliTehdas.luoPeli(peliTyyppi);
            peli.pelaa();
        }

    }
    
        private static String peliTyyppi(String kayttajaSyote) {
            if (kayttajaSyote.equals("a")) {
                return "kaksinpeli";
            } else if (kayttajaSyote.equals("b")) {
                return "yksinpeli";
            }
            return "pahaYksinpeli";
        }
}
