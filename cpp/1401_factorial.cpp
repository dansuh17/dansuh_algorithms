#include <stdio.h>

/**
 * POJ problem 1401 Factorial
 * Finding the number of trailing 0's in a factorial number.
 */

int calc(int n) {
  int divisor = 5;
  int ret = 0;
  while (divisor <= n) {
    ret += n / divisor;
    divisor *= 5;
  }
  return ret;
}

int main(void) {
  int num_of_scenarios, n, i;
  scanf("%d", &num_of_scenarios);
  for (i = 0; i < num_of_scenarios; i++) {
    scanf("%d", &n);
    printf("%d\n", calc(n));
  }
  return 0;
}
