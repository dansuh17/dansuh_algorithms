import java.io.*;
import java.util.*;

/**
 * 최적의 행렬 곱셈 - from kakao practice
 * https://www.welcomekakao.com/learn/challenge_codes/76
 *
 * 크기가 X*Y 인 행렬 A와 Y*Z인 행렬 B가 있을 때, 두 행렬을 곱하기 위해 총 X*Y*Z 번의 곱셈을 해야 합니다.
 * 하지만 곱셈 순서를 바꾸면 곱셈을 더 적게 할 수 있습니다. 예를 들어, 5*3 행렬 A, 3*2 행렬 B, 2*6인 행렬 C가 있다면
 * A와 B를 먼저 곱하고 C를 곱하는 것이, B와 C를 곱한 다음 A를 곱하는 것보다 곱셈을 더 적게 할 수 있습니다.
 * 행렬의 곱셈을 수행하면서 필요한 최소한의 곱셈 횟수를 알려주는 matrix 함수를 만들어 보세요.
 */
class MatrixMultOpt {
  public int matrix(int[][] list) {
    List<ArrayList<Integer>> costs = new ArrayList<>();
    int len = list.length;
    for (int i = 0; i < len; i++) {
      costs.add(new ArrayList<>());
      for (int j = 0; j < len; j++) {
        if (i == j) {
          costs.get(i).add(0);  // 0 cost for itself
        } else {
          costs.get(i).add(-1);
        }
      }
    }

    return subCost(0, len - 1, costs, list);
  }

  // calculate the sub-cost for multiplying from START to END of matrix list.
  // the recursive formula : subCost(start, end) = min( subCost(start, mid) + subCost(mid + 1, end) + multiplyingCost );
  // where multiplyingCost = left dimension * right dimension * middle dimension (where two matrix's dimension match).
  public int subCost(int start, int end, List<ArrayList<Integer>> costs, int[][] matrixList) {
    if (start > end) {
      return -1;
    }

    if (costs.get(start).get(end) != -1) {
      return costs.get(start).get(end);
    }

    int minCost = Integer.MAX_VALUE;
    int leftDim = matrixList[start][0];
    int rightDim = matrixList[end][1];

    // find the minimum value among all intermediate combinations
    for (int k = start; k < end; k++) {
      int middleDim = matrixList[k][1];
      int partialCost = subCost(start, k, costs, matrixList) + subCost(k + 1, end, costs, matrixList)
          + (leftDim * rightDim * middleDim);

      if (partialCost < minCost) {
        minCost = partialCost;
      }
    }

    costs.get(start).set(end, minCost);
    return minCost;
  }

  // 실행을 위한 테스트코드입니다.
  public static void main(String[] args) {
    MatrixMultOpt matrix = new MatrixMultOpt();
    int[][] list = { { 5, 3 }, { 3, 2 }, { 2, 6 } };
    if (matrix.matrix(list) == 90) {
      System.out.println("{{5,3},{3,2},{2,6}}인 경우에 정상동작합니다. 제출을 눌러서 다른 경우에도 정답인지 확인해 보세요.");
    } else {
      System.out.println("{{5,3},{3,2},{2,6}}인 경우에 정상동작하지 않습니다.");
    }
  }
}