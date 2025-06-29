package _8InterviewBit.medium;

//  https://www.youtube.com/watch?v=kPE-9D05UCg&t=1s&ab_channel=TECHTANGLE
public class _1TotalMovesOfBishop {

    //  current r - row, c - col pos - let us assume curr pos r = 3, c = 5
    private static int solve(int A, int B) {
        int totMoves = Math.min(Math.abs(8 - A), Math.abs(1 - B))    //  move top left side
                + Math.min(Math.abs(8 - A), Math.abs(8 - B))    //  move top right side
                + Math.min(Math.abs(1 - A), Math.abs(1 - B)) //  move bottom left side
                + Math.min(Math.abs(1 - A), Math.abs(8 - B));    //  move bottom right side
        return totMoves;
    }

    public static void main(String[] args) {
        System.out.println("yup: totMoves: " + solve(3, 5));
    }
}
