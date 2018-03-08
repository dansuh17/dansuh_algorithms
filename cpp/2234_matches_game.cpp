#include <cstdio>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

int main(void) {
  string str;
  vector<int> v;
  int val, ret, i;

  while (true) {
    stringstream ss;
    getline(cin, str);
    if (str.empty()) break;
    ss << str;
    while (!ss.eof()) {
      ss >> val;
      v.push_back(val);
    }

    // calculate XOR of all
    ret = v[1];
    for (i = 2; i < v[0] + 1; i++) {
      ret ^= v[i];
    }
    if (ret) printf("Yes\n");
    else printf("No\n");
    v.clear();
  }

  return 0;
}
