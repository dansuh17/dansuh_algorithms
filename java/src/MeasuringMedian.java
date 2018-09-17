import java.io.*;
import java.util.*;

/**
 * 백준 문제 9426번 '중앙값 측정'
 * https://www.acmicpc.net/problem/9426
 *
 * Used continuous sorted insertions.
 * O(N^2) algorithm.
 */
public class MeasuringMedian {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] optStrs = bf.readLine().split(" ");
    int N = Integer.parseInt(optStrs[0]);
    int K = Integer.parseInt(optStrs[1]);

    Queue<Integer> lastTemps = new LinkedList<>();
    int[] sortedTemps = new int[K + 1];
    Stack<Integer> medians = new Stack<>();
    int sortedTempsSize = 0;

    for (int n = 0; n < N; n++) {
      int newRecord = Integer.parseInt(bf.readLine());

      lastTemps.add(newRecord);
      if (lastTemps.size() == K + 1) {
        int removedRec = lastTemps.poll();
        // removes single instance
        removeTemp(sortedTemps, removedRec, sortedTempsSize);
        sortedTempsSize--;
      }

      // perform insertion sort
      // insert the new one into sorted temperature list
      sortedTemps[sortedTempsSize] = newRecord;
      sortedTempsSize++;
      int insertIndex = sortedTempsSize - 1;

      while (insertIndex > 0) {
        insertIndex--;
        int comparedTemp = sortedTemps[insertIndex];

        // swap
        if (comparedTemp > newRecord) {
          sortedTemps[insertIndex] = newRecord;
          sortedTemps[insertIndex + 1] = comparedTemp;
        } else {
          // found the right place
          break;
        }
      }

      // if the sorted temps contains enough data, retrieve the median
      if (sortedTempsSize == K) {
        medians.push(getMedian(sortedTemps, sortedTempsSize));
      }
    }


    // print out the sum of medians
    long medianSum = sumMedians(medians);
    bw.write(medianSum + "");
    bw.close();
  }

  public static void removeTemp(int[] temps, int toRemove, int size) {
    for (int i = 0; i < size; i++) {
      if (toRemove == temps[i]) {
        for (int j = i; j < size - 1; j++) {
          temps[j] = temps[j + 1];
        }
      }
    }
  }

  public static int getMedian(int[] sortedTemps, int size) {
    return sortedTemps[(size - 1) / 2];
  }

  public static long sumMedians(Stack<Integer> stack) {
    long sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }

    return sum;
  }
}