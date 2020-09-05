#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <conio.h>
#include <windows.h>
#ifndef PUBFUNCS_H_INCLUDED
#define PUBFUNCS_H_INCLUDED

void gotoxy(int eex, int eey)
{
  COORD coord;
  coord.X = eex;
  coord.Y = eey;
  SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}




#endif
