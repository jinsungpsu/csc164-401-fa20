public class Driver {
    public static void main(String[] args) {
        /*
        https://www.basketball-reference.com/playoffs/NBA_2020.html

        Game 1	Sun, August 30	Boston Celtics	112	@ Toronto Raptors	94
        Game 2	Tue, September 1	Boston Celtics	102	@ Toronto Raptors	99
        Game 3	Thu, September 3	Toronto Raptors	104	@ Boston Celtics	103
        Game 4	Sat, September 5	Toronto Raptors	100	@ Boston Celtics	93
        Game 5	Mon, September 7	Boston Celtics	111	@ Toronto Raptors	89
        Game 6	Wed, September 9	Toronto Raptors	125	@ Boston Celtics	122
        Game 7	Fri, September 11	Boston Celtics	92	@ Toronto Raptors	87

        How should we store these?

        Data manipulation:
        - average points scored by either team
        - average points scored PER team
        - max score by either team
        - max score by both teams
        - standard deviation for each team
        - average difference per game

        Refactoring:
        - how can we improve our code?
        -- NOT just how do we get it to work, but how can we get our code more: readable, reusable, maintainable

        */

        Team boston = new Team();
        Team toronto = new Team();

        boston.name = "Celtics";
        toronto.name = "Raptors";

        Game ecfGm1 = new Game();
        Game ecfGm2 = new Game();
        Game ecfGm3 = new Game();
        Game ecfGm4 = new Game();
        Game ecfGm5 = new Game();
        Game ecfGm6 = new Game();
        Game ecfGm7 = new Game();

        PlayoffSeries ecf = new PlayoffSeries();

        Game[] games = {ecfGm1, ecfGm2, ecfGm3, ecfGm4, ecfGm5, ecfGm6, ecfGm7};
        ecf.games = games;

        ecfGm1.date = "August 30";
        ecfGm1.loc = "Orlando, FL";
        ecfGm1.homeTeam = toronto;
        ecfGm1.awayTeam = boston;
        ecfGm1.homeScore = 94;
        ecfGm1.awayScore = 112;

        double avgPoints = ecf.getAveragePoints();
        System.out.println("Average number of points scored by both teams is: " + avgPoints);

        // who won game 1???
        System.out.println("Game 1 winner was: " + ecfGm1.winner());

        // who won the series???
        System.out.println("The series was won by: " + ecf.winner());


    }
}

class Team {
    String name;
}

class PlayoffSeries {
    int numGames = 1; // potentially use this to keep track of how many games in this series (not necessarily 7)
    Game[] games = new Game[numGames];

    double getAveragePoints() {
        int sum = 0;
        for (int i = 0; i < numGames; i++) {
            sum += games[i].homeScore + games[i].awayScore;
        }
        return sum/(numGames*2);
    }

    String winner() {
        // the logic in this method is broken, because home/away teams change per game
        // sorry!
        
        String winner;

        int homeWins = 0;
        int awayWins = 0;

        for (int i = 0; i < numGames; i++) {
            if (games[i].homeScore > games[i].awayScore) {
                homeWins++;
            } else {
                awayWins++;
            }
        }

        if (homeWins > awayWins) {
            return games[0].homeTeam.name;
        } else {
            return games[0].awayTeam.name;
        }
    }
}

class Game {
    String date;
    String loc;

    Team homeTeam;
    Team awayTeam;

    int homeScore;
    int awayScore;

    String winner() {
        String winner;

        if (homeScore > awayScore) {
            return homeTeam.name;
        } else {
            return awayTeam.name;
        }
    }


}
