void swap(int arr[], int i, int j) {
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = arr[i];
}

void quicksort(int arr[], int left, int right) {
  if (left >= right) {
    return;
  }

  // PREVENTING INTEGER OVERFLOW!!
  int mid = left + (right - left) / 2;
  swap(arr, left, mid);  // move mid point to leftmost position
  int i;
  int pivot = left;
  for (i = left + 1; i <= right; i++) {
    if (arr[i] < arr[left]) {
      swap(arr, ++pivot, i);
    }
  }
  swap(arr, pivot, left);
  quicksort(arr, left, pivot - 1);
  quicksort(arr, pivot + 1, right);
}
