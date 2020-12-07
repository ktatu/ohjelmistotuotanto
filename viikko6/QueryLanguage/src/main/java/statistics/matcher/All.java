package statistics.matcher;

import statistics.Player;

/**
 *
 * @author Tatu
 */
public class All implements Matcher {

    @Override
    public boolean matches(Player p) {
        return true;
    }
    
}
