package camp.model;

public class Score {
    private String scoreId;
    private int scoreNum;
    private String scoreRank;

    public Score(String seq) {
        this.scoreId = seq;

    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }


}
