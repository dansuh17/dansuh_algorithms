#include <stdio.h>
#include <cmath>

#define PI 3.1415926535

/**
 * POJ problem 1799 YeeHaa!
 * Finding the radius of a bullet that fits into a revolver.
 */

float calc_radius(float R, int n) { return R / (1 + (1 / sin(PI / n))); }

int main(void) {
  int num_of_scenarios, i, n;
  float R;
  scanf("%d", &num_of_scenarios);
  for (i = 0; i < num_of_scenarios; i++) {
    scanf("%f %d", &R, &n);
    printf("Scenario #%d:\n%.3f\n\n", i + 1, calc_radius(R, n));
  }
  return 0;
}

