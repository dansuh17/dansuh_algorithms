function poj() {
  g++-6 -Wall -std=c++98 -pedantic-errors $1;
  cat input.txt | ./a.out
}
