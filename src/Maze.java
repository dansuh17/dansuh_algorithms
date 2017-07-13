import java.io.*;
import java.util.*;

/**
 * 백준 문제 2178번 '미로'
 * https://www.acmicpc.net/problem/2178
 */
public class Maze {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] strs = bf.readLine().split(" ");
    int R = Integer.parseInt(strs[0]);
    int C = Integer.parseInt(strs[1]);

    // create the maze
    List<ArrayList<Path>> maze = new ArrayList<>();
    for (int r = 0; r < R; r++) {
      String col = bf.readLine().split(" ")[0];
      ArrayList<Path> thisRow = new ArrayList<Path>();
      maze.add(thisRow);

      for (int c = 0; c < C; c++) {
        int isWayInt = col.charAt(c) - '0';
        boolean isWay = isWayInt == 1;
        thisRow.add(new Path(isWay, r, c));
      }
    }

    System.out.println(getOutOfMaze(maze, R, C));
  }

  public static boolean isInMaze(int r, int c, int R, int C) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }

  public static int getOutOfMaze(List<ArrayList<Path>> maze, int R, int C) {
    Queue<Path> q = new LinkedList<Path>();
    int[][] offsets = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // '항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다'
    // starting point
    Path start = maze.get(0).get(0);
    start.visited = true;
    start.shortest = 1;
    q.add(start);

    // do BFS
    while (!q.isEmpty()) {
      Path thispath = q.poll();
      int baseR = thispath.r;
      int baseC = thispath.c;

      for (int[] offset : offsets) {
        int nextR = baseR + offset[0];
        int nextC = baseC + offset[1];

        if (isInMaze(nextR, nextC, R, C)) {  // should be part of the maze
          Path nextPath = maze.get(nextR).get(nextC);

          // should be unvisited, available path
          if (nextPath.isPath && !nextPath.visited) {
            nextPath.visited = true;
            nextPath.shortest = (nextPath.shortest == -1 || nextPath.shortest > thispath.shortest + 1)
                ? thispath.shortest + 1 : nextPath.shortest;
            q.add(nextPath);  // add next path to the queue
          }
        }
      }
    }

    return maze.get(R - 1).get(C -1).shortest;
  }
}


class Path {
  boolean visited;
  boolean isPath;
  int shortest;
  int r;
  int c;

  Path(boolean isPath, int r, int c) {
    this.isPath = isPath;
    this.visited = false;
    this.shortest = -1;  // infinite distance
    this.r = r;
    this.c = c;
  }
}
