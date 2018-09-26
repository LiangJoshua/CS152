#include <stdio.h>

#define PI 3.14159265359

#define SWAP(a,b) { int tmp=a; a=b; b=tmp; }

void swap(int a, int b) {
  int tmp=a; a=b; b=tmp;
}

// Using pointers, C can make the swap function work,
// but what if your language did not have pointers?
void swapByRef(int* a, int* b) {
  int tmp=*a; *a=*b; *b=tmp;
}

void badHygieneExample() {
  int a = 5;
  int tmp = 0;
  printf("a=%d, tmp=%d\n", a, tmp);
  SWAP(a,tmp);
  printf("a=%d, tmp=%d\n", a, tmp);
}

int main(int argc, const char* argv[]) {
  int x = 4, y = 5;
  printf("x=%d, y=%d\n", x, y);
  swap(x,y);
  //swapByRef(&x,&y);
  printf("x=%d, y=%d\n", x, y);

  printf("pi=%f\n", PI);

  SWAP(x,y);
  printf("x=%d, y=%d\n", x, y);

  badHygieneExample();
}
