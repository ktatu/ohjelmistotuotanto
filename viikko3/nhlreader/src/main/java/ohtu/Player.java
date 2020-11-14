
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String team;
    private int goals;
    private int assists;
    
    private String nationality;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public String goalsAndAssists() {
        return goals + " + " + assists + " = " + Integer.sum(goals, assists); 
    }

    @Override
    public int compareTo(Player o) {
        return Integer.sum(o.goals, o.assists)- Integer.sum(this.goals, this.assists);
    }
      
}
