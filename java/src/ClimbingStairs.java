import java.io.*;
import java.util.*;

/**
 * 백준 문제 2579번 '계단 오르기'
 * https://www.acmicpc.net/problem/2579
 */
public class ClimbingStairs {
  public static int maxScore(int[] stairs) {
    List<ArrayList<Integer>> scoreBoard = new ArrayList<>();
    int stairLength = stairs.length;

    for (int s = 0; s < stairLength; s++) {
      ArrayList<Integer> thisStepScore = new ArrayList<Integer>();
      scoreBoard.add(thisStepScore);
      int thisScore = stairs[s];

      if (s == 0) {
        thisStepScore.add(thisScore);
        thisStepScore.add(thisScore);
      } else if (s == 1) {
        thisStepScore.add(thisScore + scoreBoard.get(s - 1).get(0));  // one-step
        thisStepScore.add(thisScore);  // from two-steps
      } else {
        ArrayList<Integer> twoStepBehind = scoreBoard.get(s - 2);
        int maxTwoStepBehind = Collections.max(twoStepBehind);
        thisStepScore.add(thisScore + scoreBoard.get(s - 1).get(1));   // one-step
        thisStepScore.add(thisScore + maxTwoStepBehind);  // two-step
      }
    }

    return Collections.max(scoreBoard.get(stairLength - 1));
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int[] stairs = new int[N];

    // save stair values
    for (int n = 0; n < N; n++) {
      stairs[n] = Integer.parseInt(bf.readLine());
    }

    System.out.println(maxScore(stairs));
  }
}
