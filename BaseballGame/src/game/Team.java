package game;

public class Team {
    String name;
    int[] scores = new int[12];
    int outcnt;

    public void setScore(int round, int score) {
        scores[round] += score;
        System.out.println("点数" + scores[round]);
    }
    public int[] getScores() {
        return scores;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public int getSumScore(){
        int sum = 0;
        for (int score: scores){
            sum += score;
        }
        return sum;
    }
}
