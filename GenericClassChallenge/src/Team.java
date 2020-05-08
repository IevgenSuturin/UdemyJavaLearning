import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    private int played;
    private int won;
    private int lost;
    private int tied;
    private ArrayList<Player> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T newPlayer){
        if(members.contains(newPlayer)){
            System.out.println(newPlayer.getName() + " is already in this team!");
            return false;
        } else {
            members.add(newPlayer);
            System.out.println(newPlayer.getName()+" was added to "+this.name);
            return true;
        }
    }

    public int getNumPlayers(){
        return members.size();
    }

    public void matchResults(Team<T> team, int outScore, int theirScore){
        played++;
        if(outScore > theirScore){
            won++;
        } else if (outScore < theirScore){
            lost++;
        } else {
            tied++;
        }

        if(team != null) {
            team.matchResults(null, theirScore, outScore);
        }
    }

    public int getRank(){
        return won*2 + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.getRank() > team.getRank()){
            return -1;
        } else if (this.getRank() < team.getRank()){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString(){
        return getName() +" "+ getRank() + " w:" + won + " t:" + tied + " l:" + lost;
    }
}
