package at.htl.football;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class League {
    private List<Team> teams = new ArrayList<>();
    Team team = new Team();

    public void addMatchResults(Match match){

        Team homeTeam = findOrCreateTeam(match.getHomeName());
        homeTeam.addMatch(match);
        Team guestTeam = findOrCreateTeam(match.getGuestName());
        guestTeam.addMatch(match);

    }

    private Team findOrCreateTeam(String team){

        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().compareTo(team) == 0) {
                return teams.get(i);
            }
        }

        Team team1 = new Team(team);
        teams.add(team1);
        return teams.get(teams.size()-1);
    }

    public List<Team> getTable(){
        Collections.sort(teams);

        String.format("Team             Pts     W       D       L       GF      GA      GD");
        System.out.println("");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println(teams.get(i).getName() + " " + teams.get(i).getPoints() + " " + teams.get(i).getDraws()+ " " + teams.get(i).getDefeats() + " " + teams.get(i).getGoalsShot()+ " " + teams.get(i).getGoalsReceived());
            System.out.println();
        }

        return null;
    }


   /* @Override
    public String toString() {
        return String.format("%s                %d   %d   %d   %d   %d   %d   %d", team.getName(), team.getPoints(), team.getWins(),team.getDraws(), team.getDefeats(),team.getGoalsShot(),team.getGoalsReceived());
    }*/
}
