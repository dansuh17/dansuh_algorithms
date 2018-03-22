import java.util.*;
import java.io.*;

public class JavaFileReadTemplate {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    FastReader sc = new FastReader();
    int N = sc.nextInt();

    // reading file
    File file = new File("example.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    while ((st = br.readLine()) != null) {
      System.out.println();
    }
    br.close();

    // writing file
    BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
    bw.write("some string");
    bw.close();
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException  e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    String nextToken() {
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
