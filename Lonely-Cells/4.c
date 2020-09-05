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

int tool;
void read_binary();
void move(int i,int j,struct selool *list)
{
    int n,temp;
    printf("[1] North\n[2] South\n[3] Northeast\n[4]\nNorthwest\n[5] Southeast\n[6]Southwest\n");
    scanf("%d",&n);
    struct selool *curr=list;
    switch (n)
    {
        case 1:
            if (i!=0)
            {
                if (map[i-1][j].vaziat==0 && map[i-1][j].jens!=3)
                {
                    temp=map[i][j].vaziat;
                    map[i][j].vaziat=0;
                    map[i-1][j].vaziat=temp;
                    while (1)
                    {
                        if (curr->x==i && curr->y==j)
                        {
                            curr->x--;
                            break;
                        }
                        curr=curr->next;
                    }
                }
            }else printf("YOU CAN'T");
            break;
        case 2:
            if (i!=tool)
            {
                if (map[i+1][j].vaziat==0 && map[i+1][j].jens!=3)
                {
                    temp=map[i][j].vaziat;
                    map[i][j].vaziat=0;
                    map[i+1][j].vaziat=temp;
                    while (1)
                    {
                        if (curr->x==i && curr->y==j)
                        {
                            curr->x++;
                            break;
                        }
                        curr=curr->next;
                    }
                }
            }else printf("YOU CAN'T");
            break;
        case 3:
            if (j==tool ||(j%2==0 && i==0))
                printf("YOU CAN'T");
            else
            {
                if (j%2==0)
                {
                       if (map[i-1][j+1].vaziat==0 && map[i-1][j+1].jens!=3)
                        {
                            temp=map[i][j].vaziat;
                            map[i][j].vaziat=0;
                            map[i-1][j+1].vaziat=temp;
                            while (1)
                            {
                                if (curr->x==i && curr->y==j)
                                {
                                    curr->x--;
                                    curr->y++;
                                    break;
                                }
                            }
                        }
                        else printf("YOU CAN'T");
                }
                else
                {
                    if (map[i][j+1].vaziat==0 && map[i][j+1].jens!=3)
                    {
                        temp=map[i][j].vaziat;
                        map[i][j].vaziat=0;
                        map[i][j+1].vaziat=temp;
                        while (1)
                        {
                            if (curr->x==i && curr->y==j)
                            {
                                curr->y++;
                                break;
                            }
                        }
                    }
                }
            }
            break;
        case 4:
            if (j==0 ||(j%2==0 && i==0))
                printf("YOU CAN'T");
            else
            {
                if (j%2==0)
                {
                       if (map[i-1][j-1].vaziat==0 && map[i-1][j-1].jens!=3)
                        {
                            temp=map[i][j].vaziat;
                            map[i][j].vaziat=0;
                            map[i-1][j-1].vaziat=temp;
                            while (1)
                            {
                                if (curr->x==i && curr->y==j)
                                {
                                    curr->x--;
                                    curr->y--;
                                    break;
                                }
                                curr=curr->next;
                            }
                        }
                        else printf("YOU CAN'T");
                }
                else
                {
                    if (map[i][j-1].vaziat==0 && map[i][j-1].jens!=3)
                    {
                        temp=map[i][j].vaziat;
                        map[i][j].vaziat=0;
                        map[i][j-1].vaziat=temp;
                        while (1)
                        {
                            if (curr->x==i && curr->y==j)
                            {
                                curr->y--;
                                break;
                            }
                            curr=curr->next;
                        }
                    }else printf("YOU CAN'T");
                }
            }
            break;
        case 5:
            if (j==tool ||(j%2==1 && i==tool))
                printf("YOU CAN'T");
            else
            {
                if (j%2==0)
                {
                       if (map[i][j+1].vaziat==0 && map[i][j+1].jens!=3)
                        {
                            temp=map[i][j].vaziat;
                            map[i][j].vaziat=0;
                            map[i][j+1].vaziat=temp;
                            while (1)
                            {
                                if (curr->x==i && curr->y==j)
                                {
                                    curr->y++;
                                    break;
                                }
                                curr=curr->next;
                            }
                        }
                        else printf("YOU CAN'T");
                }
                else
                {
                    if (map[i+1][j+1].vaziat==0 && map[i+1][j+1].jens!=3)
                    {
                        temp=map[i][j].vaziat;
                        map[i][j].vaziat=0;
                        map[i+1][j+1].vaziat=temp;
                        curr
                        while (1)
                        {
                            if (curr->x==i && curr->y==j)
                            {
                                curr->y++;
                                curr->x++;
                                break;
                            }
                            curr=curr->next;
                        }
                    }
                }
            }
            break;
        case 6:
            if (j==0 ||(j%2==0 && i==0))
                printf("YOU CAN'T");
            else
            {
                if (j%2==0)
                {
                       if (map[i][j-1].vaziat==0 && map[i][j-1].jens!=3)
                        {
                            temp=map[i][j].vaziat;
                            map[i][j].vaziat=0;
                            map[i][j-1].vaziat=temp;
                            while (1)
                            {
                                if (curr->x==i && curr->y==j)
                                {
                                    curr->y--;
                                    break;
                                }
                                curr=curr->next;
                            }
                        }
                        else printf("YOU CAN'T");
                }
                else
                {
                    if (map[i+1][j-1].vaziat==0 && map[i+1][j-1].jens!=3)
                    {
                        temp=map[i][j].vaziat;
                        map[i][j].vaziat=0;
                        map[i+1][j-1].vaziat=temp;
                        while (1)
                        {
                            if (curr->x==i && curr->y==j)
                            {
                                curr->y--;
                                curr->x++;
                                break;
                            }
                            curr=curr->next;
                        }
                    }else printf("YOU CAN'T");
                }
            }
            break;




    }

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
void boost_energy(int i,int j,struct selool*list)
{
    struct selool *curr = list;
    while (1)
    {
        if (curr -> x == i && curr -> y == j)
        {
            break;
        }
        curr = curr -> next;
    }
    if (map[i][j].energy == 0 || curr -> energy == 100)
    {
        printf("YOU CAN'T");
        return;
    }
    int cnt = 0;
    while (cnt <= 15)
    {
        cnt++;
        if (map[i][j].energy - cnt < 0 || curr -> energy + cnt > 100)
            break;
    }
    cnt--;
    curr -> energy += cnt;
    map[i][j].energy -= cnt;
}


