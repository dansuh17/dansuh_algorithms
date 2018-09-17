import java.io.*;
import java.util.*;


/**
 * https://www.acmicpc.net/problem/15953
 */
public class PrizeHunter {
  public static int calculatePrize(int a, int b) {
    int aPrize = 0;
    int bPrize = 0;

    List<Integer> ranklist = new ArrayList<Integer>(Arrays.asList(1, 3, 6, 10, 15, 21));
    List<Integer> prizelist = new ArrayList<Integer>(Arrays.asList(500, 300, 200, 50, 30, 10));
    if (a <= 21 && a > 0) {
      for (int i = 0; i < ranklist.size(); i++) {
        if (ranklist.get(i) >= a) {
          aPrize = prizelist.get(i);
          break;
        }
      }
    }

    ranklist = new ArrayList<Integer>(Arrays.asList(1, 3, 7, 15, 31));
    prizelist = new ArrayList<Integer>(Arrays.asList(512, 256, 128, 64, 32));
    if (b <= 31 && b > 0) {
      for (int i = 0; i < ranklist.size(); i++) {
        if (ranklist.get(i) >= b) {
          bPrize = prizelist.get(i);
          break;
        }
      }
    }
    return (aPrize + bPrize) * 10000;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(bf.readLine());

    for (int i = 0; i < T; i++) {
      String[] intlist = bf.readLine().split(" ");
      int a = Integer.parseInt(intlist[0]);
      int b = Integer.parseInt(intlist[1]);
      int result = calculatePrize(a, b);

      System.out.println(result);
    }
  }
}
