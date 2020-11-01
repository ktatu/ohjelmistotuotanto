package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tatu
 */
public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka k‰ytt‰‰ "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void searchReturnsAPlayer() {
        Player testSearch = stats.search("Kurri");
        
        assertEquals("Kurri", testSearch.getName());
        assertEquals("EDM", testSearch.getTeam());
        assertEquals(37, testSearch.getGoals());
        assertEquals(53, testSearch.getAssists());
    }
    
    @Test
    public void searchForNonExistentPlayerReturnsNull() {
        assertNull(stats.search("imaginaryPlayer"));
    }
    
    @Test
    public void aListOfTeamIsReturned() {
        List<Player> expectedTeam = new ArrayList<>();
        
        expectedTeam.add(stats.search("Semenko"));
        expectedTeam.add(stats.search("Kurri"));
        expectedTeam.add(stats.search("Gretzky"));
        
        List<Player> retrievedList = stats.team("EDM");
        
        for (Player player : expectedTeam) {
            assertTrue(retrievedList.contains(player));
        }
        
        assertEquals(expectedTeam.size(), retrievedList.size());
    }
    
    @Test
    public void topScorersAreReturned() {
        List<Player> top3Scorers = stats.topScorers(3);
        
        assertEquals(3, top3Scorers.size());
        
        assertEquals("Gretzky", top3Scorers.get(0).getName());
        assertEquals("Lemieux", top3Scorers.get(1).getName());
        assertEquals("Yzerman", top3Scorers.get(2).getName());
    }
}
