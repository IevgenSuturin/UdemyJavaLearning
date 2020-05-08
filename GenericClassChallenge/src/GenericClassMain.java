// Create a generic class to implement a league table for a sport.
// The class should allow teams to be added to the list, and store
// a list of teams that belong to the league.
//
// Your class should have a method to print out the teams in order,
// with the team at the top of the league printed first.
//
// Only teams of the same type should be added to any particular
// instance of the league class - the program should fail to compile
// if an attempt is made to add an incompatible team.

public class GenericClassMain {
    public static void main(String[] args) {
        Team<SoccerPlayer> dnipro = new Team<>("Dnipro");
        Team<SoccerPlayer> dynamo = new Team<>("Dynamo");
        Team<SoccerPlayer> shakhtar = new Team<>("Shakhtar");

        dnipro.matchResults(dynamo, 3, 4);
        dynamo.matchResults(shakhtar, 0, 2);
        dnipro.matchResults(shakhtar, 0, 0);

        League<Team<SoccerPlayer>> soccerLeague = new League<>("Soccer League");
        soccerLeague.addTeam(dnipro);
        soccerLeague.addTeam(shakhtar);
        soccerLeague.addTeam(dynamo);

        soccerLeague.printLeagueTable();
    }
}
