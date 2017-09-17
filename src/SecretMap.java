import java.util.*;

/**
 * 2017 카카오 1차 코딩테스트 #1
 *
 * 단순한 2진수 변환 문제.
 */
class SecretMap {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    int[] totalMap = new int[n];
    String[] answer = new String[n];

    for (int i = 0; i < n; i++) {
      totalMap[i] = arr1[i] | arr2[i];
      answer[i] = toBinarySharp(totalMap[i], n);
    }

    return answer;
  }

  public String toBinarySharp(int val, int len) {
    char[] chars = new char[len];

    for (int i = 0; i < len; i++) {
      char c = (val % 2) == 1 ? '#' : ' ';
      val /= 2;
      chars[len - 1 - i] = c;
    }

    return new String(chars);
  }
}