import java.io.*;
import java.util.*;

/**
 * Hanoi Tower problem (from Kakao coding practice page)
 * https://www.welcomekakao.com/learn/challenge_codes/157
 *
 * Must print all paths in form of [startpole, endpole].
 * N is the number of plates in pole 1.
 *
 * There are total 2^N movements required to build a hanoi tower.
 */
public class HanoiTower {
  static int[][] hanoi(int n) {
    // 2차원 배열을 완성해 주세요.
    Stack<Integer> pole1 = new Stack<>();
    Stack<Integer> pole2 = new Stack<>();
    Stack<Integer> pole3 = new Stack<>();

    // add plates to pole1
    for (int i = 0; i < n; i++) {
      pole1.push(n - i);
    }

    // define poles
    List<Stack<Integer>> poles = new ArrayList<>();
    poles.add(pole1);
    poles.add(pole2);
    poles.add(pole3);

    List<int[]> answerList = hanoi(n, 1, 2, 3, poles);

    int[][] answer = new int[answerList.size()][2];
    for (int i = 0; i < answerList.size(); i++) {
      answer[i] = answerList.get(i);
    }
    return answer;
  }

  static List<int[]> hanoi(int n, int startPole, int endPole,
                                  int otherPole, List<Stack<Integer>> poles) {
    if (n == 1) {
      // degenerate case
      List<int[]> result = new ArrayList<>();
      result.add(new int[] {startPole, endPole});

      // simply move the 1 plate from start pole to end pole
      int onePlate = poles.get(startPole - 1).pop();
      poles.get(endPole - 1).push(onePlate);
      return result;
    }

    // first, lift all plates on top of N_th large plate to otherPole
    List<int[]> result = hanoi(n - 1, startPole, otherPole, endPole, poles);

    // move the bottom-most plate
    result.add(new int[] {startPole, endPole});
    int lowerPlate = poles.get(startPole - 1).pop();
    poles.get(endPole - 1).push(lowerPlate);

    // then rebuild the n-1 tower over the endPole
    List<int[]> endSteps = hanoi(n - 1, otherPole, endPole, startPole, poles);
    result.addAll(endSteps);  // add the paths

    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] resultSteps = hanoi(4);
    bw.write(Arrays.deepToString(resultSteps));
    bw.close();
  }
}

