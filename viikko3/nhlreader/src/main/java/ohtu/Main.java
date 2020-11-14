package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        System.out.println("Oliot:");
        printByNationality(players, "FIN");
    }
  
    
    public static void printByNationality(Player[] players, String nat) {
        System.out.println("\nPlayers from " + nat + "\n");
        
        Arrays.sort(players);
        
        for (Player player: players) {
            if (player.getNationality().equals(nat)) {
                System.out.println(player.getName() + " " + player.goalsAndAssists());
            }
        }
    }
}
