import java.util.*;

/**
 * 2017 카카오 1차 코딩테스트 #3
 * 카카오 다트 게임
 *
 * 어떤 규칙을 가지고 '8T*1D2S#'와 같이 표현된 다트 점수 코드로부터
 * 최종 다트 점수를 계산하는 문제.
 */
class KakaoDartGame {
  public int solution(String dartResult) {
    int len = dartResult.length();
    int[] scores = new int[len];

    int scoreIdx = -1;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      char c = dartResult.charAt(i);

      if (c != 'T' && c != 'D' && c != 'S' && c != '*' && c != '#') {
        sb.append(c);
        continue;
      }

      if (sb.length() != 0) {
        scoreIdx++;
        scores[scoreIdx] = Integer.parseInt(sb.toString());
        sb = new StringBuilder();  // reset stringbuilder -> integer
      }

      int currScore = scores[scoreIdx];

      switch (c) {
        case 'T':
          scores[scoreIdx] = currScore * currScore * currScore;
          break;
        case 'D':
          scores[scoreIdx] = currScore * currScore;
          break;
        case 'S':
          break;
        case '*':
          scores[scoreIdx] = currScore * 2;
          if (scoreIdx > 0) {
            scores[scoreIdx - 1] = scores[scoreIdx - 1] * 2;
          }
          break;
        case '#':
          scores[scoreIdx] = currScore * -1;
          break;
      }
    }

    // calculate the sum
    int answer = 0;
    for (int j = 0; j <= scoreIdx; j++) {
      System.out.println(scores[j]);
      answer += scores[j];
    }

    return answer;
  }

  public static void main(String[] args) {
    KakaoDartGame kaka = new KakaoDartGame();
    kaka.solution("1S2D*3T");
  }
}