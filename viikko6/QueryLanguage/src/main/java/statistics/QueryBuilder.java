package statistics;

import java.util.ArrayList;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author Tatu
 */
public class QueryBuilder {
    
    private Matcher m;
    
    public QueryBuilder() {
        this.m = new All();
    }
    
    public Matcher build() {
        Matcher toReturn = m;
        m = new All();
        return toReturn;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.m = new Or(m1, m2);
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.m = new And(m, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.m = new And(m, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.m = new And(m, new HasFewerThan(value, category));
        return this;
    }

}
