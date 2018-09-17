import java.util.*;

/**
 * 2017 KAKAO 모의고사 #4
 *
 * 1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
 * 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요.
 * (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)
 *
 * 예를 들어
 * 0   1   1   1
 * 1   1   1   1
 * 1   1   1   1
 * 0   0   1   0
 *
 * 가 있다면 가장 큰 정사각형은
 * -   1   1   1
 * -   1   1   1
 * -   1   1   1
 * -   -   -   -
 *
 * 가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.
 *
 *
 * 제한사항
 *
 * 표(board)는 2차원 배열로 주어집니다.
 * 표(board)의 행(row)의 크기 : 1000 이하의 자연수
 * 표(board)의 열(column)의 크기 : 1000 이하의 자연수
 * 표(board)의 값은 1또는 0으로만 이루어져 있습니다.
 *
 *
 * 내가 쓴 코드랑 똑같은데 이상하게 안돌아가서 남의 코드 갖고옴.....
 * 출처 : http://stack07142.tistory.com/274
 */
class LargestSquare {
  public int solution(int[][] board) {
    int answer = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {

        if (board[i][j] == 0) continue;

        if ((i - 1 >= 0 && board[i - 1][j] > 0)
            && (j - 1 >= 0 && board[i][j - 1] > 0)
            && (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] > 0)) {
          board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
        }

        answer = answer < board[i][j] ? board[i][j] : answer;
      }
    }
    return answer * answer;
  }
}