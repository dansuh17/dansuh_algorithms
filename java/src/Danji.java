import java.io.*;
import java.util.*;

/**
 * 백준 문제 2667번 '단지번호붙이기'
 * https://www.acmicpc.net/problem/2667
 */
public class Danji {
  /**
   * Indicate whether the coordinate is within the map
   * @param x x coordinate
   * @param y y coordinate
   * @param N the dimension
   * @return the coord is in the map if true
   */
  private static boolean inMap(int x, int y, int N) {
    return x >= 0 && x < N && y >= 0 && y < N;
  }

  /**
   * Find different complexes in the map.
   *
   * @param map the map
   * @param N the dimension of the map
   * @return a list of size of complexes
   */
  private static List<Integer> findDanji(List<ArrayList<House>> map, int N) {
    int[][] offsets = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int danjiIdx = 1;
    List<Integer> danjiCounts = new ArrayList<>();

    // 맵을 돌면서 집이 있는 곳을 찾고, 아직 방문하지 않은 집이 있으면 거기서부터 DFS를 돌린다.
    for (int n = 0; n < N; n++) {
      ArrayList<House> houseRow = map.get(n);

      for (int m = 0; m < N; m++) {
        House house = houseRow.get(m);
        if (!house.visited && house.isHouse) {  // 집 하나 찾음
          // run DFS
          Stack<House> stack = new Stack<>();
          stack.push(house);
          int danjiCount = 0;

          while (!stack.isEmpty()) {
            House danjiHouse = stack.pop();
            // if already visited, discard the house
            if (danjiHouse.visited) continue;

            danjiCount++;  // update count
            danjiHouse.danji = danjiIdx;
            danjiHouse.visited = true;

            // find for adjacent houses - up down left right
            for (int[] offset : offsets) {
              int adjN = danjiHouse.x + offset[0];
              int adjM = danjiHouse.y + offset[1];

              // if there is a house nearby...
              if (inMap(adjN, adjM, N)) {
                House adjHouse = map.get(adjN).get(adjM);
                // search on from there
                if (!adjHouse.visited && adjHouse.isHouse) {
                  stack.push(adjHouse);
                }
              }
            }
          }
          danjiIdx++;

          // acknowledge there is another Danji cluster
          if (danjiCount != 0) {
            danjiCounts.add(danjiCount);
          }
        }
      }
    }
    return danjiCounts;
  }

  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine().trim());
    List<ArrayList<House>> map = new ArrayList<>();

    // first draw the map
    for (int n = 0; n < N; n++) {
      String houseRow = bf.readLine().trim();
      ArrayList<House> houseRowList = new ArrayList<>();
      map.add(houseRowList);

      for (int m = 0; m < N; m++) {
        boolean isHouse = (houseRow.charAt(m) - '0') == 1;  // 1 if house, 0 otherwise
        houseRowList.add(new House(isHouse, n, m));
      }
    }

    // 단지를 찾는다
    List<Integer> danjis = findDanji(map, N);
    System.out.println(danjis.size());
    Collections.sort(danjis);
    for (Integer danji : danjis) {
      System.out.println(danji);
    }
  }
}

class House {
  boolean visited;
  boolean isHouse;
  int danji;
  int x;
  int y;

  House(boolean isHouse, int x, int y) {
    this.isHouse = isHouse;
    this.visited = false;
    this.x = x;
    this.y = y;
  }
}
