import java.io.*;
import java.util.*;

/**
 * 2017 카카오 1차 코딩테스트 #5
 * 프렌즈 4 블록
 *
 * board 에서 2 x 2 블록이 같으면 사라지고 (터지고) 위에 있는 블록들이 아래로 내려와 공백을 채운다.
 * 그렇게 반복해서 전체 지워지는 빈칸의 개수를 구하는 문제.
 */
public class Friends4Block {
  public int solution(int m, int n, String[] board) {
    char[][] cBoard = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        cBoard[i][j] = board[j].charAt(i);
      }
    }

    do {
      char[][] tempBoard = copyArray(cBoard, n, m);

      for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
          char thisChar = cBoard[i][j];

          if (thisChar == '/') continue;

          if (thisChar == cBoard[i][j - 1]
              && thisChar == cBoard[i - 1][j]
              && thisChar == cBoard[i - 1][j - 1]) {
            tempBoard[i][j] = '/';
            tempBoard[i - 1][j] = '/';
            tempBoard[i][j - 1] = '/';
            tempBoard[i - 1][j - 1] = '/';
          } else {
            tempBoard[i][j] = thisChar;
          }
        }
      }

      cBoard = tempBoard;
    } while (pushDown(cBoard, n, m));

    return countBlanks(cBoard, n, m);
  }

  public char[][] copyArray(char[][] original, int n, int m) {
    char[][] copy = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        copy[i][j] = original[i][j];
      }
    }

    return copy;
  }

  public int countBlanks(char[][] board, int n, int m) {
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == '/') count++;
      }
    }

    return count;
  }

  public boolean pushDown(char[][] board, int n, int m) {
    boolean didPush = false;
    for (int i = 0; i < n; i++) {
      char[] thisRow = board[i];
      int blankStart = 0;
      int blankLast = m;

      boolean searchingStart = true;
      // find the start and end where the blanks start
      for (int j = 0; j < m; j++) {
        if (thisRow[j] == '/' && searchingStart) {
          blankStart = j;
          searchingStart = false;
        } else if (thisRow[j] != '/' && !searchingStart) {
          blankLast = j;
          break;
        }
      }

      // push downwards
      int dist = blankLast - blankStart;
      for (int k = 0; k < blankStart; k++) {
        thisRow[k + dist] = thisRow[k];
        thisRow[k] = '/';
        didPush = true;  // the 'push' happened
      }
    }

    return didPush;
  }

  public static void main(String[] args) {
    Friends4Block nc = new Friends4Block();
    int numBlank = nc.solution(4, 5,  	new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    System.out.println(numBlank);
  }

  public void printBoard(char[][] board, int n, int m) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(board[i][j]);
        sb.append(' ');
      }
      System.out.println(sb.toString());
      sb = new StringBuilder();
    }
  }
}