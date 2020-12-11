package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tatu
 */
public class PeliTehdas {
    
    private static final HashMap<String, KiviPaperiSakset> PELIT = new HashMap<>(Map.of(
            "kaksinpeli", new KPSPelaajaVsPelaaja(),
            "yksinpeli", new KPSTekoaly(),
            "pahaYksinpeli", new KPSParempiTekoaly()));
    
    public static KiviPaperiSakset luoPeli(String tyyppi) {
        return PELIT.get(tyyppi);
    }
}
