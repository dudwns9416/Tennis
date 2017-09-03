
public class TennisGame2 implements TennisGame {
    public int player1Score = 0;
    public int player2Score = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (player1Score == player2Score && player1Score < 4) {
            if (player1Score == 0)
                score = "Love";
            if (player1Score == 1)
                score = "Fifteen";
            if (player1Score == 2)
                score = "Thirty";
            score += "-All";
        }
        if (player1Score == player2Score && player1Score >= 3)
            score = "Deuce";

        if (player1Score > 0 && player2Score == 0) {
            if (player1Score == 1)
                P1res = "Fifteen";
            if (player1Score == 2)
                P1res = "Thirty";
            if (player1Score == 3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (player2Score > 0 && player1Score == 0) {
            if (player2Score == 1)
                P2res = "Fifteen";
            if (player2Score == 2)
                P2res = "Thirty";
            if (player2Score == 3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (player1Score > player2Score && player1Score < 4) {
            if (player1Score == 2)
                P1res = "Thirty";
            if (player1Score == 3)
                P1res = "Forty";
            if (player2Score == 1)
                P2res = "Fifteen";
            if (player2Score == 2)
                P2res = "Thirty";
            score = P1res + "-" + P2res;
        }
        if (player2Score > player1Score && player2Score < 4) {
            if (player2Score == 2)
                P2res = "Thirty";
            if (player2Score == 3)
                P2res = "Forty";
            if (player1Score == 1)
                P1res = "Fifteen";
            if (player1Score == 2)
                P1res = "Thirty";
            score = P1res + "-" + P2res;
        }

        if (player1Score > player2Score && player2Score >= 3) {
            score = "Advantage player1";
        }

        if (player2Score > player1Score && player1Score >= 3) {
            score = "Advantage player2";
        }

        if (player1Score >= 4 && player2Score >= 0 && (player1Score - player2Score) >= 2) {
            score = "Win for player1";
        }
        if (player2Score >= 4 && player1Score >= 0 && (player2Score - player1Score) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        player1Score++;
    }

    public void P2Score() {
        player2Score++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}