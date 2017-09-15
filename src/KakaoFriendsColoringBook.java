import java.util.*;

/**
 * 카카오 프렌즈 컬러링북
 * https://www.welcomekakao.com/learn/challenges/591
 *
 * 출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다.
 * 여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면
 * 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다.
 * (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)
 * 그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.
 *
 * [입력 형식]
 * 입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.
 * 1 <= m, n <= 100
 * picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
 * picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
 *
 *
 * [출력 형식]
 * 리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.
 */
class KakaoFriendsColoringBook {
  public int[] solution(int m, int n, int[][] picture) {
    int maxSizeOfOneArea = 0;
    boolean[][] visited = new boolean[m][n];
    int[][] offsets = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int areaId = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j]) {
          continue;
        }

        // do nothing for uncolored blocks
        int thisColor = picture[i][j];
        if (thisColor == 0) {
          visited[i][j] = true;
          continue;
        }

        // conduct a bfs
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(i, j, thisColor)); // root
        visited[i][j] = true;
        int thisAreaSize = 0;
        areaId++;

        while (!queue.isEmpty()) {
          Node currNode = queue.poll();
          thisAreaSize++;

          // add adjacent blocks
          for (int[] offset : offsets) {
            int sideX = currNode.x + offset[0];
            int sideY = currNode.y + offset[1];
            if (sideX >= 0 && sideY >= 0 && sideX < m && sideY < n) {
              int thatColor = picture[sideX][sideY];
              if (!visited[sideX][sideY] && thatColor == thisColor) {
                queue.add(new Node(sideX, sideY, thatColor));
                visited[sideX][sideY] = true;
              }
            }
          }
        }

        // update max area size
        if (maxSizeOfOneArea < thisAreaSize) {
          maxSizeOfOneArea = thisAreaSize;
        }
      }
    }

    // compose the answer
    int[] answer = new int[2];
    answer[0] = areaId;
    answer[1] = maxSizeOfOneArea;
    return answer;
  }

  class Node {
    int x;
    int y;
    int color;
    Node(int x, int y, int color) {
      this.x = x;
      this.y = y;
      this.color = color;
    }
  }
}