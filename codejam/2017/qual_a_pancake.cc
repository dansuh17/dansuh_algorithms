#include <iostream>
#include <string>

using namespace std;

// used for debugging
void dump_bits(bool* bool_arr, size_t size) {
  cout << "Hahah :";
  for (uint i = 0; i < size; i++) {
    if (bool_arr[i]) {
      cout << '+';
    } else {
      cout << '-';
    }
  }
  cout << endl;
}

int compute(string s, int n) {
  size_t size = s.size();

  // create a bit array
  bool bitarr[size];
  for (string::size_type i = 0; i < size; i++) {
    char c = s[i];
    if (c == '+') {
      bitarr[i] = true;
    } else {
      bitarr[i] = false;
    }
  }

  int count = 0;
  uint i = 0;
  while (i <= (size - n)) {
    if (bitarr[i]) {
      i++;
      continue;
    }

    // flip the bits
    count++;
    for (int j = 0; j < n; j++) {
      bitarr[i + j] = !bitarr[i + j];
    }
    i++;
  }

  for (int j = 0; j < n; j++) {
    if (!bitarr[size - 1 - j]) {
      return -1;
    }
  }
  return count;
}

int main(void) {
  int t, n, res;
  string s;
  cin >> t;
  for (int i = 1; i <= t; i++) {
    cin >> s >> n;
    res = compute(s, n);
    cout << "Case #" << i << ": ";
    if (res == -1) {
      cout << "IMPOSSIBLE";
    } else {
      cout << res;
    }
    cout << endl;
  }
  return 0;
}
