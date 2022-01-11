package ss8_clean_code_refactoring.bai_tap.Refactoring;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String score;
        int tempScore;
        if (m_score1 == m_score2) {
            switch (m_score1) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            StringBuilder scoreBuilder = new StringBuilder();
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = m_score1;
                else {
                    scoreBuilder.append("-");
                    tempScore = m_score2;
                }
                switch (tempScore) {
                    case 0:
                        scoreBuilder.append("Love");
                        break;
                    case 1:
                        scoreBuilder.append("Fifteen");
                        break;
                    case 2:
                        scoreBuilder.append("Thirty");
                        break;
                    case 3:
                        scoreBuilder.append("Forty");
                        break;
                }
            }
            score = scoreBuilder.toString();
        }
        return score;
    }
}
