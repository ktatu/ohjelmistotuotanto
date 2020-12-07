package statistics.matcher;

import statistics.Player;

/**
 *
 * @author Tatu
 */
public class Not implements Matcher {

    private Matcher m;
    
    public Not(Matcher m) {
        this.m = m;
    }
    
    @Override
    public boolean matches(Player p) {
        if (m.matches(p)) {
            return false;
        }
        return true;
    }
    
}
