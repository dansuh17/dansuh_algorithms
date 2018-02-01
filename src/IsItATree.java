import java.io.*;
import java.util.*;

/**
 * POJ problem 1308 : Is it a tree?
 * http://poj.org/problem?id=1308
 *
 * Example input :
 6 8  5 3  5 2  6 4
 5 6  0 0

 8 1  7 3  6 2  8 9  7 5
 7 4  7 8  7 6  0 0

 0 0

 1 1 0 0

 3 8  6 8  6 4
 5 3  5 6  5 2  0 0
 -1 -1
 */
public class IsItATree {
  public static void main(String[] args) throws IOException {
    Reader sc = new Reader(System.in);
    boolean flag1 = true;
    int x, y, casenum = 1;
    do {
        x = sc.nextInt();
        y = sc.nextInt();

        if (x < 0 && y < 0) {
            break;
        }
        HashSet<Integer> toSet = new HashSet<Integer>();
        HashSet<Integer> fromSet = new HashSet<Integer>();
        while (x != 0 && y != 0) {
            if (flag1) {
                fromSet.add(x);
                if (toSet.contains(y)) {
                    // check if destination has multiple departures
                    // if it does, it is not a tree
                    flag1 = false;
                }
                toSet.add(y);  // gyup no
            }
            x = sc.nextInt();
            y = sc.nextInt();
        }

        // find uniqure root
        int notincount = 0;
        for (int from : fromSet) {
          if (!toSet.contains(from))
            if (notincount == 1) {
              flag1 = false;
              break;
            } else {
              notincount++;
            }
        }

        // unique root
        if (!fromSet.isEmpty() && notincount != 1) {
            flag1 = false;
        }

        if (!flag1) {
          System.out.print("Case ");
          System.out.print(casenum++);
          System.out.println(" is not a tree.");
        } else {
          System.out.print("Case ");
          System.out.print(casenum++);
          System.out.println(" is a tree.");
        }

        flag1 = true;
    } while (x != -1 && y != -1);
  }

  static class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    Reader(String input) throws FileNotFoundException {
      reader = new BufferedReader(new FileReader(input));
      tokenizer = new StringTokenizer("");
    }

    Reader(InputStream input) {
      reader = new BufferedReader(new InputStreamReader(input));
      tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
      while (!tokenizer.hasMoreTokens())
        tokenizer = new StringTokenizer(reader.readLine());
      return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
      return Double.parseDouble(next());
    }
  }
}

