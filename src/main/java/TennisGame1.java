import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

	private Player playerFirst;
	private Player playerSecond;

	private Map<Integer, String> sameScore = new HashMap();
	private Map<Integer, String> moreScore = new HashMap();
	private Map<Integer,String> sameDefaultScore = new HashMap<Integer, String>(); 
	
	private void putDefaultScore(){
		sameDefaultScore.put(0, "Love-All");
		sameDefaultScore.put(1, "Fifteen");
		sameDefaultScore.put(2, "Thirty");
		sameDefaultScore.put(3, "Forty");
	}

	private void putSameScore() {
		sameScore.put(0, "Love-All");
		sameScore.put(1, "Fifteen-All");
		sameScore.put(2, "Thirty-All");
		sameScore.put(-1, "Deuce");
	}

	private void putMoreThanfourScore() {
		moreScore.put(1, "Advantage player1");
		moreScore.put(-1, "Advantage player2");
		moreScore.put(2, "Win for player1");
		moreScore.put(-2, "Win for player2");
	}

	public TennisGame1(String player1Name, String player2Name) {
		this.playerFirst = new Player(player1Name);
		this.playerSecond = new Player(player2Name);
		putSameScore();
		putMoreThanfourScore();
		putDefaultScore();
	}

	public void wonPoint(String playerName) {
		if (playerName == "player1") {
			int score = playerFirst.getScore();
			playerFirst.setScore(playerFirst.getScore() + 1);
		} else {
			playerSecond.setScore(playerSecond.getScore() + 1);
		}

	}

	public String getScore() {
		String score = "";
		int scoreOfFirst = playerFirst.getScore();
		int scoreOfSecond = playerSecond.getScore();
		if (scoreOfFirst == scoreOfSecond) {
			score = getSameScore(scoreOfFirst);
		} else if (scoreOfFirst >= 4 || scoreOfSecond >= 4) {
			int minusResult = scoreOfFirst - scoreOfSecond;
			score = getScoreMoreThanFour(minusResult);
		} else {
			score = getDefalutScore(scoreOfFirst, scoreOfSecond);
		}
		return score;
	}

	
	private String getDefalutScore(int scoreOfFirst, int scoreOfSecond) {
		String score = sameDefaultScore.get(scoreOfFirst) +"-"+sameDefaultScore.get(scoreOfSecond);
		return score;
	}

	private String getScoreMoreThanFour(int minusResult) {
		String score = moreScore.get(Math.min(minusResult, 2));

		if (score == null) {
			score = moreScore.get(-2);
		}
		return score;

	}

	// 요구사항이 변경됐을 때 자료구조의 영향을 받는지 안 받는지.
	private String getSameScore(int scoreOfFirst) {
		String score = sameScore.get(scoreOfFirst);

		if (score == null) {
			score = sameScore.get(-1);
		}
		return score;

	}

}
