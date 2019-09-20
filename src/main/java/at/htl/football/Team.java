package at.htl.football;

public class Team implements Comparable{
    private String name;
    private int points;
    private int wins;
    private int draws;
    private int defeats;
    private int goalsShot;
    private int goalsReceived;

    public Team(String name, int points, int wins, int draws, int defeats, int goalsShot, int goalsReceived) {
        this.name = name;
        this.points = points;
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.goalsShot = goalsShot;
        this.goalsReceived = goalsReceived;
    }

    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }

    public void addMatch(Match match){

        if (match.getGuestName().equals(this.name)) {
            if (match.getGuestGoals() > match.getHomeGoals()){
                points += 3;
                wins++;
                goalsShot += match.getGuestGoals();
                goalsReceived += match.getHomeGoals();
            }else if (match.getGuestGoals() == match.getHomeGoals()){
                points++;
                draws++;
                goalsShot += match.getGuestGoals();
                goalsReceived += match.getHomeGoals();
            }else if (match.getHomeGoals() > match.getGuestGoals()){
                defeats++;
                goalsShot += match.getGuestGoals();
                goalsReceived += match.getHomeGoals();
            }
        }else if(match.getHomeName().equals(this.name)){
            if (match.getGuestGoals() < match.getHomeGoals()){
                points += 3;
                wins += 1;
                goalsShot += match.getHomeGoals();
                goalsReceived += match.getGuestGoals();

            }else if (match.getGuestGoals() == match.getHomeGoals()){
                points++;
                draws++;
                goalsShot += match.getHomeGoals();
                goalsReceived += match.getGuestGoals();
            }else if (match.getHomeGoals() < match.getGuestGoals()){
                defeats++;
                goalsShot += match.getHomeGoals();
                goalsReceived += match.getGuestGoals();
            }
        }
    }

    // region Getter
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    //endregion

    @Override
    public int compareTo(Object o) {
        Team otherTeam = (Team) o;
        return ((Team) o).points - this.points;
    }
}
