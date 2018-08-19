#include <cstdio>

using namespace std;

int main(void) {
  int n;
  scanf("%d", &n);
  int i;
  for (i = 0; i < n; i++) {
    int n1, n2;
    scanf("%d %d", &n1, &n2);
    printf("%d\n", n1 + n2);
  }
  return 0;
}
