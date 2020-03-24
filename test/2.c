#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>


struct random
{
    int i;
    int j;
};
struct khune
{
        int jens; //energy = 1, mitosis = 2, forbidden = 3, normal = 4
        int energy;
        //char name[4];
        int vaziat;
};
struct khune map[1000][1000];

struct selool
{
    int energy;
    char name[4];
    struct selool *next;
    int x;
    int y;
};

struct selool*list_x=NULL;
struct selool*list_y=NULL;

struct selool *new_khune(int energy, char name[])
{
    struct selool *new_node=(struct selool *)malloc(sizeof(struct selool));
    new_node->energy=energy;
    strcpy((new_node->name),name);
    new_node->next=NULL;
    return new_node;
};

void add_end(struct selool *list,int energy, char name[])
{
    struct selool *curr=list;
    for ( ; curr->next!=NULL; curr=curr->next);
    curr->next=new_khune(energy,name);
}


struct random rand_set()
{
    int i,j;
    struct random loc;
    srand(time(NULL));
    while (1)
    {
        i=rand()%tool;
        j=rand()%tool;
        if (map[i][j].vaziat==0 && map[i][j].jens==4)
        {
            loc.i=i;
            loc.j=j;
            return loc;
        }
    }
};

