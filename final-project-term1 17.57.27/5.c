#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <conio.h>
#include <windows.h>
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

void split_cell (int i, int j, struct selool *list)
{
    if (map[i][j].jens != 2)
    {
        printf("YOU CAN'T");
        return;
    }
    struct selool *curr = list;
    while (1)
    {
        if (curr -> x == i && curr -> y == j)
            break;
        curr = curr -> next;
    }
    if (curr -> energy < 80)
    {
        printf("YOU CAN'T");
        return;
    }
    int n,temp;
    printf("[1] North\n[2] South\n[3] Northeast\n[4]\nNorthwest\n[5] Southeast\n[6]Southwest\n");
    scanf("%d",&n);
    switch (n)
    {
        case 1:
            if (i!=0)
            {
                if (map[i-1][j].vaziat==0 && map[i-1][j].jens!=3)
                {
                    //temp=map[i][j].vaziat;
                    //map[i][j].vaziat=0;
                    map[i-1][j].vaziat=map[i][j].vaziat;
                    /*while (1)
                    {
                        if (curr->x==i && curr->y==j)
                        {
                            curr->x--;
                            break;
                        }
                        curr=curr->next;
                    }*/
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


void print_map(int n,struct khune map[n][n]){
	int x = 0;
	int y = 0;
	system("cls");
	for(int i = n-1;i >= 0;i--)
	{
		y = (n - i - 1) * 6;
		for(int j = 0;j < n;j+=2)
		{
			x = j * 7;
			gotoxy(x,y);
			printf("_______");
		}
		y = ((n - i - 1) * 6) + 2;
		for(int j = 1;j < n;j += 2)
		{
			x = j * 7;
			gotoxy(x,y);
			printf("_______");
		}


		y = (n - i - 1) * 6;
		y++;
		for(int j = 0;j < n;j+=2)
		{
			x = j * 7;
			gotoxy(x,y);
			printf("%s" , map[i][j].jens == 1?"Energy " : map[i][j].jens == 2 ? "Mitosis" : map[i][j].jens == 3 ? " Block " : "Normal ");
			if(map[i][j].jens == 1)
			{
				gotoxy(x,y+1);
				printf("  %d" , map[i][j].energy);
			}
			gotoxy(x,y+4);
			printf(" (%d,%d)" , j,i);
		}
		y = ((n - i - 1) * 6) + 2;
		y++;
		for(int j = 1;j < n;j += 2)
		{
			x = j * 7;
			gotoxy(x,y);
			printf("%s" , map[i][j].jens == 1?"Energy " : map[i][j].jens == 2 ? "Mitosis" : map[i][j].jens == 3 ? " Block " : "Normal ");
			if(map[i][j].jens == 1)
			{
				gotoxy(x,y+1);
			}
			gotoxy(x,y+4);
			printf(" (%d,%d)" , j,i);
		}


	}
	//khataye akhar:
	y = (n) * 6;
	for(int j = 0;j < n;j+=2)
	{
		x = j * 7;
		gotoxy(x,y);
		printf("_______");
	}
	y = ((n) * 6) + 2;
	for(int j = 1;j < n;j += 2)
	{
		x = j * 7;
		gotoxy(x,y);
		printf("_______");
	}
}

int main()
{
    printf("[1]Load\n[2]New single player game\n[3]New Multiplayer game\n[4]Exit\n");
    int n;
    char file_adress[100];
  //  scanf("%s" , file_adress);
    FILE * file = fopen("map.bin","rb");
    printf("1");
    fread(&n,sizeof(int),1,file);
    printf("2\n");

    print_map(n,map);
    struct khune map[n][n];
    for(int i = n-1;i > 0;i--)
    	for(int j = 0;j < n;j++)
    	{
    		map[i][j].energy = 100;
    		unsigned char tmp;
    		fread(&tmp,sizeof(unsigned char),1,file);
    		map[i][j].jens = tmp - '0';
    		map[i][j].vaziat = 0;
		}

	print_map(n,map);
}
