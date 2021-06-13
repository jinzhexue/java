package game;

public class Player {
    String name;
    int htk;
    int ptk;
    int basecnt; //進塁人数
    int ballchance; //攻撃チャンス　3回
    int outcnt;  //アウト人数、　アウト3人チェンジ//管理
    int basechance; //ボールによる進塁チャンス　　4
    int ball;


    Player() {
        this.basecnt = 0;
        this.ballchance = 3;
        this.outcnt = 0;
        this.basechance = 0;
    }
    public void playStart(Team team,  int round) {
        int i = 1;
        while (true) {
            System.out.println(team.name + "チームの攻撃は"+"第"+(round+1)+"回の" + i + "攻撃");
            //ピッチ
            int ball = pitch();
            hit(team,ball,round);
            if (outcnt >= 3) {
                break;
            }
            System.out.println("-----------------------------------");
            System.out.println(team.name + "の得点:" + team.getScores()[round]);
            System.out.println("-----------------------------------");
            i++;
        }
    }
    public int pitch() {
        if (ptk>90) {
            ball = new java.util.Random().nextInt(95) + 1;
        }
        else
            ball = new java.util.Random().nextInt(100) + 1;

        return ball;
    }


    public void hit(Team team, int ball , int round) {
        //int hittype = new java.util.Random().nextInt(2) + 1;
        if (ball < 45) {//ボール
            if(htk<ptk) {
                delChance();
                System.out.println("ボールです。" + team.name + ": ボール打ちました。" );
            } else {
                addBasechace(team, round);
                System.out.println("ボールです。" + team.name + "はボール打ってないです。1/4　進塁です。");
            }
        } else if (ball >95) {//デットボール
            addBase(team, round);
            System.out.println("デットボールです。" + "デットボールなので" + team.name + "進塁しました。");
        } else {//ストライク
            if(hittype == 1) {
                int striketype = new java.util.Random().nextInt(10) + 1;
                strikeBall(team, round, striketype);
            }else {
                delChance();
                System.out.println("ストライクボールです。"+team.name + ": ボール打ってないです。");
            }
        }
    }

    public void strikeBall(Team team, int round, int striketype) {
        if(striketype == 1 ) {
            team.setScore(round, basecnt + 1);
            System.out.println("ストライクボールです。、" + team.name + "はホームランを打ちました。得点："+ (basecnt + 1));
            basecnt=0;
        }
        else if(striketype >= 2 && striketype <= 4) {
            addBase(team, round);
            System.out.println("ストライクボールです。"  + team.name + "は安打を打ちました。" );
        }
        else if(striketype == 5) {
            addOut(this.basecnt + 1);
            System.out.println("ストライクボールです。"  + team.name + "はフォース アウトしました。");
        }
        else {
            delChance();
            System.out.println("ストライクボールです。"  + team.name + "打たれてない、線外を打ちました。");
        }

    }

    public void addBase(Team team, int round){
        this.basecnt += 1;
        if(this.basecnt == 4) {
            team.setScore(round, 1);
            this.basecnt = 3;
        }
        System.out.println("進塁　人数:" + this.basecnt);
    }

    public void addOut(int outcnt) {
        this.outcnt += outcnt;
        System.out.println("アウト人数:" + this.outcnt );
    }

    public void delChance() {
        ballchance -= 1;
        if(ballchance == 0) {
            addOut(1);
            if(outcnt != 3) ballchance = 3;
        }
        System.out.println("残りballchance:" + ballchance );
    }
    public void addBasechace(Team team, int round) {
        basechance += 1;
        if(basechance % 4 == 0) {
            addBase(team, round);
            basechance = 0;
        }
        System.out.println("1/4進塁の個数" + basechance);
    }
}
