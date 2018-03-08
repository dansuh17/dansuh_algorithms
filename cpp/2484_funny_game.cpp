#include <cstdio>
#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main(void) {
  string str;
  int val, ret;

  while (true) {
    stringstream ss;
    getline(cin, str);
    ss << str;
    ss >> val;

    if (val == 0) break;

    // calculate XOR of all
    if (val >= 3) printf("Bob\n");
    else printf("Alice\n");
  }

  return 0;
}
