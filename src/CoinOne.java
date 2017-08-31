import java.io.*;
import java.util.*;

/**
 * 백준 문제 2293번 '동전 1'
 * https://www.acmicpc.net/problem/2293
 */
public class CoinOne {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] strOpts = bf.readLine().trim().split(" ");
    int N = Integer.parseInt(strOpts[0]);
    int K = Integer.parseInt(strOpts[1]);

    int[] coinValues = new int[N];

    // retrieve the values
    for (int n = 0; n < N; n++) {
      coinValues[n] = Integer.parseInt(bf.readLine());
    }

    // find all combinations that make this value
    bw.write(findCombinations(K, N, coinValues) + "\n");
    bw.close();
  }

  public static long findCombinations(int K, int N, int[] coinValues) {
    // the table represents number of combinations using coins up to n that make up value k.
    // for example, numCombinations[i][k] means the number of ways to make value k
    // using coins only UP TO i-th coin.
    long[][] numCombinations = new long[N][K + 1];

    // fill in 1 for the coin values
    for (int i = 0; i < N; i++) {
      int val = coinValues[i];
      if (val <= K) {
        numCombinations[i][val] = 1;
      }
    }

    // iterate through all target values starting from 0
    for (int k = 0; k < K + 1; k++) {
      for (int j = 0; j < N; j++) {  // for all coin values
        int fromCoinVal = coinValues[j];

        if (k - fromCoinVal >= 0) {
          // for all previous coins...
          for (int i = 0; i <= j; i++) {
            // add up all combinations that now starts using fromCoinVal
            numCombinations[j][k] += numCombinations[i][k - fromCoinVal];
          }
        }
      }
    }

    long totalComb = 0;
    for (int i = 0; i < N; i++) {
      totalComb += numCombinations[i][K];
    }

    return totalComb;
  }
}

