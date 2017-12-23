#include <cstdio>

int main() {
  int a, b, c;
  int ans;
  scanf("%d %d %d", &a, &b, &c);
  if (a > b) {
    if (c > a) {
      ans = a;
    } else if (c > b) {
      ans = c;
    } else {
      ans = b;
    }
  } else {
    if (c > b) {
      ans = b;
    } else if (c > a) {
      ans = c;
    } else {
      ans = a;
    }
  }
  printf("%d\n", ans);
  return 0;
}
