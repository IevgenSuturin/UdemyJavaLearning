import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;
    private ArrayList<T> teams = new ArrayList<>();


    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team){
        if(teams.contains(team)){
            return false;
        } else {
            teams.add(team);
            return true;
        }
    }

    public void printLeagueTable(){
        Collections.sort(teams);
        for(int i=0; i<teams.size(); i++){
            System.out.println((i+1) + " " + teams.get(i));
        }
    }
}
