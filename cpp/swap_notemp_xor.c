#include <stdio.h>

int main(void) {
  int x = 18;
  int y = 3;
  // using XOR operation
  x = x ^ y;
  y = x ^ y;
  x = x ^ y;
  return 0;
}

// this actually works for pointers (addresses) as well.
void swap(int *xptr, int *yptr) {
  *xptr = *xptr ^ *yptr;
  *yptr = *xptr ^ *yptr;
  *xptr = *xptr ^ *yptr;
}
