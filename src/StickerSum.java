/**
 * 2017 KAKAO 모의고사 #6
 *
 * 원형으로 연결된 스티커에서 몇 장의 스티커를 뜯어내어 뜯어낸 스티커에 적힌 숫자의 합이 최대가 되도록 하고 싶습니다.
 * 단 스티커 한 장을 뜯어내면 양쪽으로 인접해있는 스티커는 찢어져서 사용할 수 없게 됩니다.
 *
 * 예를 들어 위 그림에서 14가 적힌 스티커를 뜯으면 인접해있는 10, 6이 적힌 스티커는 사용할 수 없습니다.
 * 스티커에 적힌 숫자가 배열 형태로 주어질 때, 스티커를 뜯어내어 얻을 수 있는 숫자의 합의 최댓값을 return 하는 solution 함수를 완성해 주세요. 원형의 스티커 모양을 위해 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어 있다고 간주합니다.
 *
 *
 * 제한 사항
 *
 * sticker는 원형으로 연결된 스티커의 각 칸에 적힌 숫자가 순서대로 들어있는 배열로, 길이(N)는 1 이상 100,000 이하입니다.
 * sticker의 각 원소는 스티커의 각 칸에 적힌 숫자이며, 각 칸에 적힌 숫자는 1 이상 100 이하의 자연수입니다.
 * 원형의 스티커 모양을 위해 sticker 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어있다고 간주합니다.
 *
 *
 * 입출력 예
 * sticker 	answer
 * [14, 6, 5, 11, 3, 9, 2, 10] 	36
 * [1, 3, 2, 5, 4] 	8
 */
class StickerSum {
  public int solution(int sticker[]) {
    int stickerLen = sticker.length;

    // length less than four can be calculated too easily
    if (stickerLen < 4) {
      int max = -1;
      for (int i = 0; i < stickerLen; i++) {
        if (max < sticker[i]) {
          max = sticker[i];
        }
      }
      return max;
    }

    int[] newSticker = new int[stickerLen - 2];
    for (int i = 0; i < stickerLen - 2; i++) {
      newSticker[i] = sticker[i + 1];
    }

    // the total max score is max of sticker L and L', where L' = L[1:-1]
    // L' represents the case of SELECTING the first sticker, and thereby cannot use the LAST sticker as well
    int maxScoreNoFirst = score(sticker, stickerLen);
    int maxScoreUseFirst = score(newSticker, newSticker.length) + sticker[0];

    return maxScoreNoFirst > maxScoreUseFirst ? maxScoreNoFirst : maxScoreUseFirst;
  }

  public int score(int sticker[], int len) {
    int[] scores = new int[len];
    scores[0] = 0;

    for (int i = 1; i < len; i++) {
      if (i == 1) {
        scores[i] = sticker[i];
        continue;
      }

      int scoreJustBefore = scores[i - 1];
      int scoreTwoBefore = scores[i - 2] + sticker[i];
      scores[i] = scoreJustBefore > scoreTwoBefore ? scoreJustBefore : scoreTwoBefore;
    }

    return scores[len - 1];
  }
}