import java.util.*;
import java.io.*;


public class BuNyeoHweJang {
  public static void main(String[] args) throws IOException {
    // List<Integer> list = new ArrayList<>();  // Integer의 리스트
    List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(14);
    for (int i = 0; i < 15; i++) {
      list.add(new ArrayList<Integer>(15));

      if (i == 0) {
        for (int z = 0; z < 14; z++) {
          list.get(0).add(z + 1);
        }
      } else {
        for (int j = 0; j < 14; j++) {
          if (j == 0) {
            list.get(i).add(1);
          } else {
            list.get(i).add(list.get(i - 1).get(j) + list.get(i).get(j - 1));
          }
        }
      }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    for (int i = 0; i < testCase; i++) {
      int floor = Integer.parseInt(br.readLine());
      int room = Integer.parseInt(br.readLine()) - 1;

      int result = getTotalPeople(list, floor, room);
      System.out.println(result);
    }
  }

  public static int getTotalPeople(List<ArrayList<Integer>> list, int floor, int room) {
    return list.get(floor).get(room);
  }
}
