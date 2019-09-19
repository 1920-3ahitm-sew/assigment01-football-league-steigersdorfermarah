package at.htl.football;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        League league = new League();

        try(Scanner scanner = new Scanner(new FileReader("bundesliga-1819.csv"))) {
            scanner.nextLine();
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] elements = line.split(";");
                String date = elements[0];
                String homeTeam = elements[1];
                String guestTeam = elements[2];
                int homeGoals = Integer.parseInt(elements[3]);
                int guestGoals = Integer.parseInt(elements[4]);

                Match match = new Match(homeTeam, guestTeam,homeGoals,guestGoals);
                league.addMatchResults(match);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        league.getTable();


        }


    }


