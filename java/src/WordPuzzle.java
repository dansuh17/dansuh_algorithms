import java.util.*;

/**
 * 2017 KAKAO 모의고사 #7
 *
 * 단어 퍼즐은 주어진 단어 조각들을 이용해서 주어진 문장을 완성하는 퍼즐입니다.
 * 이때, 주어진 각 단어 조각들은 각각 무한개씩 있다고 가정합니다.
 * 예를 들어 주어진 단어 조각이 [“ba”, “na”, “n”, “a”]인 경우 "ba", "na", "n", "a" 단어 조각이 각각 무한개씩 있습니다.
 * 이때, 만들어야 하는 문장이 “banana”라면 “ba”, “na”, “n”, “a”의 4개를 사용하여 문장을 완성할 수 있지만,
 * “ba”, “na”, “na”의 3개만을 사용해도 “banana”를 완성할 수 있습니다.
 *
 * 사용 가능한 단어 조각들을 담고 있는 배열 strs와 완성해야 하는 문자열 t가 매개변수로 주어질 때,
 * 주어진 문장을 완성하기 위해 사용해야 하는 단어조각 개수의 최솟값을 return 하도록 solution 함수를 완성해 주세요.
 * 만약 주어진 문장을 완성하는 것이 불가능하면 -1을 return 하세요.
 *
 *
 * 제한사항
 *
 * strs는 사용 가능한 단어 조각들이 들어있는 배열로, 길이는 1 이상 100 이하입니다.
 * strs의 각 원소는 사용 가능한 단어조각들이 중복 없이 들어있습니다.
 * 사용 가능한 단어 조각들은 문자열 형태이며, 모든 단어 조각의 길이는 1 이상 5 이하입니다.
 * t는 완성해야 하는 문자열이며 길이는 1 이상 20,000 이하입니다.
 * 모든 문자열은 알파벳 소문자로만 이루어져 있습니다.
 *
 * 입출력 예
 * strs 	t 	result
 * ["ba","na","n","a"] 	"banana" 	3
 * ["app","ap","p","l","e","ple","pp"] 	"apple" 	2
 * ["ba","an","nan","ban","n"] 	"banana" 	-1
 */
class WordPuzzle {
  public int solution(String[] strs, String t) {
    int strLen = t.length();

    List<ArrayList<String>> stringParts = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      stringParts.add(new ArrayList<>());
    }

    // collect string parts by length
    for (String part : strs) {
      stringParts.get(part.length()).add(part);
    }

    int[] useParts = new int[strLen];  // minimum number of parts to build substrings
    for (int i = 0; i < strLen; i++) {
      int minUse = -1;

      for (int j = 0; j < 5; j++) {  // max len of part = 5
        int startIdx = i - j;
        int numUseAtStart;

        // handle special cases where start index goes behind
        if (startIdx <= 0) {
          startIdx = 0;
          numUseAtStart = 0;
        } else {
          numUseAtStart = useParts[startIdx - 1];
          if (numUseAtStart == -1) {
            // it would be nonsense if we cannot build the string at the first place
            continue;
          }
        }

        // find the substring
        String subStr = t.substring(startIdx, i + 1) ;  // secnod argument exclusive

        // check for all parts that we can use that matches the length
        for (String partStr : stringParts.get(subStr.length())) {
          if (subStr.equals(partStr)) {
            int use = numUseAtStart + 1;

            // update minimum usage
            if (minUse > use || minUse == -1) {
              minUse = use;
            }
            break;  // break once we see that it can be achieved
          }
        }
      }

      useParts[i] = minUse;
    }

    return useParts[strLen - 1];
  }
}


/**
 * 같은 문제를 HashSet을 사용해서 조금 더 보기 편하게 풀어낸 방법.
 * 출처: http://stack07142.tistory.com/274 [Hello World]
 */
class Solution {
  static HashSet<String> set = new HashSet<>();
  static int[] dp = new int[20001];

  static final int INF = 1000000000;

  static {
    Arrays.fill(dp, -1);
  }

  public static int solution(String[] strs, String t) {
    for (String s : strs) {
      set.add(s);
    }

    solveRecursive(t, 0);
    return dp[0] == INF ? -1 : dp[0];
  }

  public static int solveRecursive(String t, int idx) {
    // 기저 조건
    if (idx == t.length()) return 0;

    // memoization
    if (dp[idx] != -1) return dp[idx];

    dp[idx] = INF;

    // 탐색
    for (int i = idx; i < Math.min(idx + 5, t.length()); i++) {
      String s = t.substring(idx, i + 1);
      if (set.contains(s)) {
        dp[idx] = Math.min(dp[idx], solveRecursive(t, idx + s.length()) + 1);
      }
    }

    return dp[idx];
  }
}



