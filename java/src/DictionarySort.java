import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Oncoder 테스트시험 7번 "정렬하기"
 * https://www.oncoder.com
 *
 * 문제:
 * 양의 정수가 담긴 int[] arr가 주어집니다.
 * int[] arr의 각 요소를 문자열이라 가정했을때의 "사전순" 기준 오름차순으로 정렬하여 리턴하세요.
 *
 * ※ [15, 143, 167]을 "사전순" 기준 오름차순 정렬하면, [143, 15, 167] 입니다.
 */
public class DictionarySort {
  Comparator<Integer> myComp;

  public static void printArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println('\n');
  }

  public static void main(String[] args) {
    DictionarySort sol = new DictionarySort();
    printArr(sol.solution(new int[]{1, 9, 2, 0, 65, 6, 1, 2, 58, 1, 3, 2}));
    printArr(sol.solution(new int[]{5, 5, 5, 5, 5, 5, 5}));
    printArr(sol.solution(new int[]{15,143,167}));
  }

  public int[] solution(int[] arr) {
    myComp = new MyComparator();
    List<Integer> arr2 = new LinkedList<Integer>();
    for (int i = 0; i < arr.length; i++) {
      arr2.add(arr[i]);
    }

    quickSort(arr2, 0, arr2.size() - 1);

    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr2.get(i);
    }
    return arr;
  }

  public void quickSort(List<Integer> arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int div = partition(arr, left, right);
    quickSort(arr, left, div - 1);
    quickSort(arr, div + 1, right);
  }

  public int partition(final List<Integer> arr, int l, int r) {
    final int pIdx = (l + r) / 2;
    final int pVal = arr.get(pIdx);
    final int originalLeft = l;
    swap(arr, l, pIdx);  // swap pivot with the leftmost element

    // System.out.println("PIdx : " + pIdx + " Left : " + l + " Right : " + r);

    while (l <= r) {
      while (l <= r && myComp.compare(arr.get(l), pVal) <= 0) {
        l++;
      }

      while (l <= r && myComp.compare(arr.get(r), pVal) > 0) {
        r--;
      }

      if (l <= r) {
        swap(arr, l, r);
      }
    }

    swap(arr, originalLeft, r);
    return r;
  }

  public void swap(final List<Integer> arr, final int i, final int j) {
    int tmp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, tmp);
  }

  class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
      String s1 = Integer.toString(o1);
      String s2 = Integer.toString(o2);
      return s1.compareTo(s2);
    }
  }
}
