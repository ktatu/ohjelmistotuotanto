package ohtu.kivipaperisakset;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Tatu
 */
public class IO {
    
    private static final Scanner SCANNER = new Scanner(System.in);
    
    private static final Set VALIKKO = new HashSet<String>(Set.of("a", "b", "c"));
    private static final Set SIIRTO = new HashSet<String>(Set.of("k", "p", "s"));
    
    private static final String VIRHEELLINEN = "x";
    
    public static String syote(String konteksti) {
        String syote = SCANNER.nextLine();
        return onValidi(syote, konteksti) ? syote : VIRHEELLINEN;
    }
    
    private static boolean onValidi(String syote, String konteksti) {
        if (konteksti.equals("valikko")) {
            return VALIKKO.contains(syote);
        }
        return SIIRTO.contains(syote);
    }
}
