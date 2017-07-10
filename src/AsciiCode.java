import java.util.*;

/**
 * String manipulation example - printing the position of ascii code in a given string.
 */
class AsciiCode {
  public static void main(String[] arg) {
    Scanner reader = new Scanner(System.in);
    List<Integer> indices = new ArrayList<Integer>();
    for (int i = 0; i < 'z' - 'a' + 1; i++) {
      indices.add(-1);
    }
    String line = reader.next().trim();
    for (int i = 0; i < line.length(); i++) {
      int asciiCode = (int)line.charAt(i) - 'a';
      if (indices.get(asciiCode) == -1) {
        indices.set(asciiCode, i);
      }
    }

    for (Integer indice : indices) {
      System.out.print(indice + " ");
    }
  }
}
