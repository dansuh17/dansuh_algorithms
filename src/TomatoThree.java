import java.util.*;
import java.io.*;

/**
 * 백준 문제 7569번 '토마토'
 * https://www.acmicpc.net/problem/7569
 *
 * '토마토'문제의 3D버전
 *
 * Sample Input:
 5 3 1
 0 -1 0 0 0
 -1 -1 0 1 1
 0 0 0 1 1

 * Sample Output:
 -1

 * Sample Input 2:
 6 4 1
 0 0 0 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 1

 * Sample Output2:
 8

 */
public class TomatoThree {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] params = bf.readLine().trim().split(" ");
    int C = Integer.parseInt(params[0]);  // box width
    int R = Integer.parseInt(params[1]);  // box length
    int H = Integer.parseInt(params[2]);  // box height

    // 3D tomato Box
    List<ArrayList<ArrayList<Tomato3d>>> tomatoBox = new ArrayList<>();
    Queue<Tomato3d> queue = new LinkedList<>();  // BFS 는 큐다
    int totalCount = 0;  // 전체 토마토 개수 - 비어있는 칸이 있을 수 있기 때문에
    int ripeCount = 0;  // ripe 한 토마토 개수

    // fill in the tomato
    for (int h = 0; h < H; h++) {
      // 판
      ArrayList<ArrayList<Tomato3d>> thisPlane = new ArrayList<>();
      tomatoBox.add(thisPlane);

      for (int r = 0; r < R; r++) {
        // 줄
        String[] thisRow = bf.readLine().split(" ");
        ArrayList<Tomato3d> thisTomatoRow = new ArrayList<>();
        thisPlane.add(thisTomatoRow);

        for (int c = 0; c < C; c++) {
          int ripe = Integer.parseInt(thisRow[c]);

          // update count
          if (ripe != -1) {
            totalCount++;  // 토마토가 있긴 있다
            if (ripe == 1) {
              ripeCount++;  // 익은 토마토가 있다
              queue.add(new Tomato3d(0, ripe, h, r, c));
            }
          }

          thisTomatoRow.add(new Tomato3d(0, ripe, h, r, c));
        }
      }
    }

    // output
    System.out.println(startRipe(tomatoBox, queue, totalCount, ripeCount));
  }

  /**
   * 토마토가 박스 안에 존재해야한다.
   * @param tom 기준토마토
   * @param comb 조합 - offset을 specify한다. [height offset, row offset, column offset] 형태
   * @param dim 토마토박스의 크기
   * @return 박스 안에 있으면 true, 없으면 false
   */
  public static boolean available(Tomato3d tom, int[] comb, int[] dim) {
    int h = tom.h + comb[0];
    int r = tom.r + comb[1];
    int c = tom.c + comb[2];

    return h >= 0 && h < dim[0] && r >= 0 && r < dim[1] && c >= 0 && c < dim[2];
  }

  public static int startRipe(List<ArrayList<ArrayList<Tomato3d>>> tomatoBox,
                              Queue<Tomato3d> q, int totalCount, int ripeCount) {
    int maxDays = -1;
    // 토마토 박스 크기
    int[] dimension = {tomatoBox.size(), tomatoBox.get(0).size(), tomatoBox.get(0).get(0).size()};
    // 앞 뒤 좌 우 위 아래 오프셋 조합
    int[][] nearby = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    // Queue에 더이상 토마토가 추가되지 않을 때까지 계속한다. BFS.
    while (!q.isEmpty() && totalCount != ripeCount) {
      Tomato3d tom = q.poll();
      int nextDay = tom.days + 1;

      for (int i = 0; i < nearby.length; i++) {
        int[] com = nearby[i];
        if (available(tom, com, dimension)) {  // test for 1. is it within the box, 2. is it not ripe
          Tomato3d nextTomato = tomatoBox.get(tom.h + com[0]).get(tom.r + com[1]).get(tom.c + com[2]);
          if (nextTomato.ripe == 0) {  // if this exists and is not ripe
            nextTomato.days = nextDay;
            nextTomato.ripe = 1;
            ripeCount++;
            q.add(nextTomato);
          }
        }
      }

      if (nextDay > maxDays) {
        maxDays = nextDay;
      }
    }

    // -1 은 전체 토마토가 다 익을 수 없는 경우를 의미한다.
    return totalCount == ripeCount ? maxDays : -1;
  }
}

class Tomato3d {
  int days;
  int ripe;
  int h;
  int r;
  int c;

  Tomato3d(int days, int ripe, int h, int r, int c) {
    this.ripe = ripe;
    this.days = days;
    this.h = h;
    this.r = r;
    this.c = c;
  }
}