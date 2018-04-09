#include <iostream>

using namespace std;

int hack(int d, string p) {
  // find the furthermost 'cs' pattern and swap
  size_t size = p.size();
  long damages[size];
  long total_damage = 0;
  int charged = 1;
  for (uint i = 0; i < size; i++) {
    bool is_shoot = p[i] == 'S';
    if (is_shoot) {
      total_damage += charged;
      damages[i] = charged;
    } else {
      charged <<= 1;  // *2
      damages[i] = -1;  // indicate charge
    }
  }

  if (total_damage <= d) {
    return 0;  // no need to swap
  }

  bool can_continue = true;
  int num_swaps = 0;
  long prev_damage;
  while (can_continue) {
    prev_damage = damages[size - 1];
    for (uint i = size - 1; i-- > 0; ) {
      if (damages[i] < 0 && prev_damage > 0) {  // a 'cs' pattern
        num_swaps++;
        damages[i] = prev_damage >> 1;  // div 2
        damages[i + 1] = -1;
        total_damage -= damages[i];
        if (total_damage <= d) {
          return num_swaps;
        }
        prev_damage = damages[i];
        break;
      }
      prev_damage = damages[i];
      if (i == 0) {
        can_continue = false;  // we're finished
      }
    }
  }
  return -1;
}

int main() {
  int t;
  int d;
  int res;
  string p;
  cin >> t;  // num_tests
  for (int i = 1; i <= t; i++) {
    cin >> d >> p;
    res = hack(d, p);
    if (res >= 0) {
      cout << "Case #" << i << ": " << res << endl;
    } else {
      cout << "Case #" << i << ": " << "IMPOSSIBLE" << endl;
    }
  }
  return 0;
}
