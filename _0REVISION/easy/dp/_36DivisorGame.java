package _0REVISION.easy.dp;

//  https://leetcode.com/problems/divisor-game/
public class _36DivisorGame {

    enum Players {
        ALICE,
        BOB
    }

    enum GameStatus {
        SUCCESS,
        FAIL
    }

    private static int maxRange = 0;

    public static boolean divisorGame(int n) {
        Players currPlayer = Players.ALICE;
        GameStatus status;
        maxRange = n;
        do {
            status = makeAMove();
            currPlayer = currPlayer == Players.ALICE ? Players.BOB : Players.ALICE;
        } while (status == GameStatus.SUCCESS);
        return currPlayer == Players.ALICE;
    }

    private static GameStatus makeAMove() {
        for (int i = 1; i < maxRange; i++) {
            if (maxRange % i == 0) {
                maxRange -= i;
                return GameStatus.SUCCESS;
            }
        }
        return GameStatus.FAIL;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + divisorGame(2));   //  true
        System.out.println("yup: " + divisorGame(3));   //  false
        System.out.println("yup: " + divisorGame(4));   //  true
    }
}
