package game;

public class Main {

    //public static void main(String args[]) {
    public static void main(String[] args) {
        int roundnum = 9;

        Team teamA = new Team();
        Team teamB = new Team();
        teamA.setName("ソフトバンク");
        teamB.setName("楽天");
        Player p = new Player();
        Player h = new Player();


        System.out.println("---野球ゲームプログラム開始---");//最大回数の名前分かりやすくするように
        for (int round = 0; round < roundnum; round++) {
            System.out.println("★★★★第" + (round + 1) + "回合★★★★");
            if(round >= 8 && teamA.getSumScore() == teamB.getSumScore()) {
                roundnum += 1; //roundnum++;
            }
            for(int ch = 0; ch <2; ch++) {
                p = new Player(); 
                if (ch == 0) {
                    System.out.println("★★★★第" + (round + 1) + "回合の上回合★★★★");
                    System.out.println("攻撃チーム:" + teamA.name
                            + "\n防御チーム:" + teamB.name);
                    p.playStart(teamA, round);
                }else {
                    System.out.println("★★★★第" + (round + 1) + "回合の下回合★★★★");
                    System.out.println("攻撃チーム:" + teamB.name
                            + "\n防御チーム:" + teamA.name);
                    p.playStart(teamB, round);
                }
            }
        }
        String result = (teamA.getSumScore() > teamB.getSumScore())
                ? teamA.name:teamB.name;
        System.out.println("----野球ゲームプログラム終了----");
        System.out.println("\n ★★★★★★★★★★★★★★★★★★★★★★★");
        System.out.println(result + "チームはwin！　おめでとうございます!");
        System.out.println(teamA.name + "の総得点：" + teamA.getSumScore());
        System.out.println(teamB.name + "の総得点：" + teamB.getSumScore());
        System.out.println("\n ★★★★★★★★★★★★★★★★★★★★★★★");
    }
}
