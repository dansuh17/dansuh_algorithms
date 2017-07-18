import java.io.*;
import java.util.*;

/**
 * 백준 문제 1005번 'ACM Craft'
 * https://www.acmicpc.net/problem/1005
 */
public class ACMCraft {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine());

    for (int t = 0; t < T; t++) {
      String[] strs = bf.readLine().split(" ");
      int N = Integer.parseInt(strs[0]);
      int K = Integer.parseInt(strs[1]);
      strs = bf.readLine().split(" ");

      List<ArrayList<Integer>> connections = new ArrayList<>();
      int[] times = new int[N];

      for (int n = 0; n < N; n++) {
        times[n] = Integer.parseInt(strs[n]);
        connections.add(new ArrayList<Integer>());
      }

      // requirements for i-th construction
      for (int k = 0; k < K; k++) {
        strs = bf.readLine().split(" ");
        int from = Integer.parseInt(strs[0]) - 1;
        int to = Integer.parseInt(strs[1]) - 1;
        connections.get(to).add(from);
      }

      int W = Integer.parseInt(bf.readLine()) - 1;

      System.out.println(requiredTime(connections, times, W, N));
    }
  }

  public static int requiredTime(List<ArrayList<Integer>> connections, int[] times, int target, int numBuildings) {
    int[] maxTimes = new int[numBuildings];
    Arrays.fill(maxTimes, -1);

    return maxTime(connections, times, maxTimes, target);
  }

  public static int maxTime(List<ArrayList<Integer>> connections, int[] times, int[] maxTimes, int target) {
    if (maxTimes[target] >= 0) {
      return maxTimes[target];
    }

    ArrayList<Integer> required = connections.get(target);
    int maxReqTime = 0;
    for (int i = 0; i < required.size(); i++) {
      int reqBuild = required.get(i);
      int maxTimeReq = maxTime(connections, times, maxTimes, reqBuild);
      maxReqTime = maxReqTime < maxTimeReq ? maxTimeReq : maxReqTime;
    }

    maxTimes[target] = times[target] + maxReqTime;
    return maxTimes[target];
  }
}
