#include <iostream>
#include <vector>
#include <fstream>

using namespace std;

int main() {
  // reading file
  ifstream myfile;
  string line;
  myfile.open("example.txt");
  if (myfile.is_open()) {
    while (getline(myfile, line)) {
      cout << line << '\n';
    }
    myfile.close();
  }

  // writing file
  ofstream write_file;
  write_file.open("output.txt");
  if (write_file.is_open()) {
    write_file << "Hello World!\n";
    write_file << "Write like this\n";
    write_file.close();
  }

  /** C-style file IO **/
  FILE *cfile;
  cfile = fopen("example.txt", "r");
  int c;
  if (cfile) {
    while ((c = getc(cfile)) != EOF) {
      // do something with c
    }
    fclose(cfile);
  }

  return 0;
}
