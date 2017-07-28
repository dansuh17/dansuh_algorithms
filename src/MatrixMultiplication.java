import java.io.*;
import java.util.*;

/**
 * 백준 문제 2740번 '행렬 곱셈'
 * https://www.acmicpc.net/problem/2740
 */
public class MatrixMultiplication {
  public static void main(String[] args) throws java.io.IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    String[] dimA = bf.readLine().split(" ");

    int N = Integer.parseInt(dimA[0]);
    int M = Integer.parseInt(dimA[1]);

    // create matrix A
    int[][] A = new int[N][M];

    for (int n = 0; n < N; n++) {
      String[] rowString = bf.readLine().split(" ");
      for (int m = 0; m < M; m++) {
        A[n][m] = Integer.parseInt(rowString[m]);
      }
    }

    String[] dimB = bf.readLine().split(" ");

    int bM = Integer.parseInt(dimB[0]);
    int K = Integer.parseInt(dimB[1]);

    // create matrix B
    int[][] B = new int[M][K];

    if (bM != M) System.out.println("Wrong dimension!");

    for (int m = 0; m < M; m++) {
      String[] rowString = bf.readLine().split(" ");
      for (int k = 0; k < K; k++) {
        B[m][k] = Integer.parseInt(rowString[k]);
      }
    }

    int[][] result = matmul(A, B);

    // print out the results
    for (int n = 0; n < N; n++) {
      for (int k = 0; k < K; k++) {
        System.out.print(result[n][k] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] matmul(int[][] A, int[][] B) {
    int N = A.length;
    int M = A[0].length;
    int K = B[0].length;

    int[][] result = new int[N][K];

    // element by element
    for (int n = 0; n < N; n++) {
      for (int k = 0; k < K; k++) {
        int elem = 0;
        for (int m = 0; m < M; m++) {
          elem += (A[n][m] * B[m][k]);
        }
        result[n][k] = elem;
      }
    }

    return result;
  }
}
