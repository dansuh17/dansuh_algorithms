#include <cstdio>

int main() {
  int n, x;
  scanf("%d %d", &n, &x);
  int in;
  while (n--) {
    scanf("%d", &in);
    if (in < x) {
      printf("%d ", in);
    }
  }
  return 0;
}
