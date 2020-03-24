#include <stdbool.h>
#ifndef STRUCTS_H_INCLUDED
#define STRUCTS_H_INCLUDED

typedef struct Selool{
	int x , y , energy;
	int team;
	char name[50];
	struct Selool * next;
	bool nobateshe;
}Selool;

typedef struct Khoone{
    int jens;
    int energy;
    int vaziat;
}Khoone;

enum{
	Energy = 1,
	Mitosis,
	Block,
	Normal
};

#endif
