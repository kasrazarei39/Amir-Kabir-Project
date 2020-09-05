#include "structs.h"
#include "pubfuncs.h"
#include <stdbool.h>

Selool * list[2];
bool donafare = false;
Khoone map[1000][1000];
int n;
void print_map();
void boost_energy(int i,int j);
void split_cell (int i, int j);
void move(int x, int y);

void add_end(Selool * new_selool,int team)
{
	new_selool->next = NULL;
	if(list[team] == NULL)
		list[team] = new_selool;
	else
	{
		Selool * current = list[team];
		while(current->next != NULL){
			current = current->next;
		}
		current->next =  new_selool;
	}
}

void place(Selool * s)
{
	int x , y;
	while(1)
	{
		x = rand()%n;
		y = rand()%n;
		if(map[x][y].jens != Block && map[x][y].vaziat == 0)
		{
			map[x][y].vaziat = s->team;
			s->x = x;
			s->y = y;
			break;
		}
	}
}

void chape_seloola(){
	if(!donafare)
	{
		Selool * c = list[0];
		while(c!=NULL)
		{
			printf("(%d,%d) %s (%d) Team: %d\n" ,c->y, c->x,c->name,c->energy ,c->team);
			c = c->next;
		}
	}
	else
	{
		Selool * c = list[0];
		while(c!=NULL)
		{
			if(c->nobateshe)
			{
				printf("(%d,%d) %s (%d) Team: %d\n" ,c->y, c->x,c->name,c->energy ,c->team);
			}
			c = c->next;
		}
		c = list[1];
		while(c!=NULL)
		{
			if(c->nobateshe)
			{
				printf("(%d,%d) %s (%d) Team: %d\n" ,c->y, c->x,c->name,c->energy ,c->team);
			}
			c = c->next;
		}
	}
}

bool check_nobat(int x , int y)
{
	Selool * curr = list[map[x][y].vaziat - 1];
	while((curr->x != x || curr->y != y ) && curr != NULL)
	curr=curr->next;
	return curr->nobateshe;
}

void check_nobatha (int t)
{
	Selool* curr = list[t-1];
	while(curr != NULL)
	{
		if(curr->nobateshe)
		return;
		curr = curr->next;
	}
	curr = list[1 - (t-1)];
	while(curr != NULL)
	{
		curr->nobateshe = true;
		curr = curr->next;
	}
}

void start(){
	
	if(list[1]!=NULL)
		donafare = true;
	else
		donafare = false;
	while(1)
	{
		fflush(stdin);
		print_map();
		printf("1- Move\n2- Boost Energy\n3- Split a cell\n4- Save\n5- Exit\n");
		int inp;
		scanf("%d" , &inp);
		if(inp >= 1 && inp <= 3)
		{
			chape_seloola();
			int a , b;
			printf("Choose your cell: ( , )\b\b\b\b");
			inputgiri:;
			 a = getch();
			if(a > 47 && a < 50+n)
				a -= 48;
			else
				goto inputgiri;
			printf("%d," , a);
			inputgiri2:
			b = getch();
			if(b > 47 && b < 49+n)
			{
				b -= 48;
				printf("%d)\n" , b);
			}
			else if(b == 8)
			{
				printf("\b\b \b");
				goto inputgiri;
			}
			else
				goto inputgiri2;
			if((map[b][a].vaziat != 1 && map[b][a].vaziat !=2) || !check_nobat(b,a))
			{
				printf("Error! Press enter to continue");
				fflush(stdin);
				getchar();
				continue;
			}
			int akharin_team = map[b][a].vaziat;
			if(inp == 1)
			{
				move(b,a);
			}
			if(inp == 2)
			{
				boost_energy(b,a);
			}
			if(inp == 3)
			{
				split_cell(b,a);
			}
			if(donafare)check_nobatha(akharin_team);
		}
		if(inp == 4)
		{
			FILE * file = fopen("save.map","wb");
			fwrite(&n,sizeof(int),1,file);
			for(int i = 0;i < n;i++)
			{
				for(int j = 0;j < n;j++)
				{
					fwrite(&map[i][j],sizeof(Khoone),1,file);
				}
			}
			fclose(file);
			file = fopen("save.cells","wb");
			fwrite(&donafare,sizeof(bool),1,file);
			int count = 0;
			Selool * curr = list[0];
			while(curr != NULL)
			{
				count++;
				curr = curr->next;
			}
			fwrite(&count,sizeof(int),1,file);
			curr = list[0];
			while(curr != NULL)
			{
				fwrite(curr,sizeof(Selool),1,file);
				curr = curr->next;
			}
			
			if(donafare)
			{
				count = 0;
				curr = list[1];
				while(curr != NULL)
				{
					count++;
					curr = curr->next;
				}
				fwrite(&count,sizeof(int),1,file);
				curr = list[1];
				while(curr != NULL)
				{
					fwrite(curr,sizeof(Selool),1,file);
					curr = curr->next;
				}
			}
			fclose(file);
			printf("\nSaved! Press enter to continue.");
			fflush(stdin);
			getchar();
		}
		if(inp == 5)
		{
			int count = 0;
			Selool * curr = list[0];
			while(curr != NULL)
			{
				count += curr->energy;
				curr = curr->next;
			}
			printf("Total Energy of team 1: %d\n" , count);
			if(donafare)
			{
				count = 0;
				curr = list[1];
				while(curr != NULL)
				{
					count += curr->energy;
					curr = curr->next;
				}
				printf("Total Energy of team 2: %d\n" , count);
			}
			printf("Press enter to continue...");
			fflush(stdin);
			getchar();
			return;
		}
	}
}

void move(int i,int j){
    int inp,temp;
    printf("\n[1] North\n[2] South\n[3] Northeast\n[4] Northwest\n[5] Southeast\n[6] Southwest\n");
    scanf("%d",&inp);
    Selool *curr=list[map[i][j].vaziat-1];
    while(curr !=NULL)
    {
    	if(curr->x == i && curr->y == j)
    	{
    		break;
		}
		curr= curr->next;
		
	}
	if(curr == NULL)
	{
		printf("You can't'");
		return;
	}
    switch (inp)
    {
        case 1:
            if (i!=n-1)
            {
                if (map[i+1][j].vaziat==0 && map[i-1][j].jens!=3)
                {
                    temp=map[i][j].vaziat;
                    map[i][j].vaziat=0;
                    map[i+1][j].vaziat=temp;
                    while (1)
                    {
                        if (curr->x==i && curr->y==j)
                        {
                            curr->x++;
                            if(donafare) curr->nobateshe = false;
                            break;
                        }
                        curr=curr->next;
                    }
                }
            }else printf("YOU CAN'T");
            break;
        case 2:
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
                            if(donafare) curr->nobateshe = false;
                            break;
                        }
                        curr=curr->next;
                    }
                }
            }else printf("YOU CAN'T");
            break;
        case 3:
            if (j==n-1 ||(j%2==0 && i==n-1))
                printf("YOU CAN'T");
            else
            {
                if (j%2==0)
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
                                    curr->x++;
                                    curr->y++;
                                    if(donafare) curr->nobateshe = false;
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
                                if(donafare) curr->nobateshe = false;
                                break;
                            }
                        }
                    }
                }
            }
            break;
        case 4:
            if (j==0 ||(j%2==0 && i==n-1))
                printf("YOU CAN'T");
            else
            {
                if (j%2==0)
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
                                    curr->x++;
                                    curr->y--;
                                    if(donafare) curr->nobateshe = false;
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
                                if(donafare) curr->nobateshe = false;
                                break;
                            }
                            curr=curr->next;
                        }
                    }else printf("YOU CAN'T");
                }
            }
            break;
        case 5:
            if (j==n-1 ||(j%2==1 && i==0))
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
                                    if(donafare) curr->nobateshe = false;
                                    break;
                                }
                                curr=curr->next;
                            }
                        }
                        else printf("YOU CAN'T");
                }
                else
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
                                curr->y++;
                                curr->x--;
                                if(donafare) curr->nobateshe = false;
                                break;
                            }
                            curr=curr->next;
                        }
                    }
                }
            }
            break;
        case 6:
            if (j==0 ||(j%2==0 && i==n-1))
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
                                    if(donafare) curr->nobateshe = false;
                                    break;
                                }
                                curr=curr->next;
                            }
                        }
                        else printf("YOU CAN'T");
                }
                else
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
                                curr->y--;
                                if(donafare) curr->nobateshe = false;
                                curr->x--;
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


int main(){
	srand(time(NULL));
	while(1)
	{
		system("cls");
		srand(time(NULL));
		list[0] = NULL;
		list[1] = NULL;
	    printf("[1]Load\n[2]New single player game\n[3]New Multiplayer game\n[4]Map Editor\n[5]Exit\n");    
	    int input = 0;
	    scanf("%d" , &input);
	    if(input == 2)
	    {
		    char file_adress[100];
		    printf("Addresee file map ra vared konid: ");
		    fflush(stdin);
		    scanf("%s" , file_adress);
		    FILE * file = fopen(file_adress,"rb");
		    if(file == NULL)
		    {
		    	printf("Error");
		    	continue;
			}
		    fread(&n,sizeof(int),1,file);
		    for(int i = 0; i < n;i ++)
		    for(int j = 0 ; j < n; j++)
		    	map[i][j].vaziat = 0;
		    	
		    for(int i = 0;i < n;i++)
	    	for(int j = 0;j < n;j++)
	    	{
	    		map[i][j].energy = 100;
	    		unsigned char tmp;
	    		fread(&tmp,sizeof(unsigned char),1,file);
	    		map[i][j].jens = tmp - '0';
	    		map[i][j].vaziat = 0;
			}
			int tedade_selool;
			printf("Tedade selool ha ra vared konid: ");
			scanf("%d" , &tedade_selool);
			while(tedade_selool--)
			{
				Selool * new_selool = (Selool*) malloc (sizeof(Selool));
				add_end(new_selool,0);
				new_selool->team = 1;
				new_selool->energy = 40;
				place(new_selool);
				fflush(stdin);
				printf("Esme Selool ra vared konid: ");
				scanf("%s" , &new_selool->name);
			}
			start(n,map);
		}
		else if(input == 3)
		{
			char file_adress[100];
			printf("Addresee file map ra vared konid: ");
		    fflush(stdin);
		    scanf("%s" , file_adress);
		    FILE * file = fopen(file_adress,"rb");
		    if(file == NULL)
		    {
		    	printf("Error");
		    	continue;
			}
		    fread(&n,sizeof(int),1,file);
		    for(int i = 0; i < n;i ++)
		    for(int j = 0 ; j < n; j++)
		    	map[i][j].vaziat = 0;
		    	
		    for(int i = 0;i < n;i++)
	    	for(int j = 0;j < n;j++)
	    	{
	    		map[i][j].energy = 100;
	    		unsigned char tmp;
	    		fread(&tmp,sizeof(unsigned char),1,file);
	    		map[i][j].jens = tmp - '0';
	    		map[i][j].vaziat = 0;
			}
			int tedade_selool;
			printf("Tedade seloole team 1 ra vared konid: ");
		    fflush(stdin);
			scanf("%d" , &tedade_selool);
			for(int i = 1;i <= tedade_selool;i++)
			{
				Selool * new_selool = (Selool*) malloc (sizeof(Selool));
				add_end(new_selool,0);
				new_selool->team = 1;
				new_selool->energy = 40;
				new_selool->nobateshe = true;
				place(new_selool);
				fflush(stdin);
				printf("Esme Selool shomare %d ra vared konid: " , i);
				scanf("%s" , &new_selool->name);
			}
			printf("Tedade seloole team 2 ra vared konid: ");
			fflush(stdin);
			scanf("%d" , &tedade_selool);
			for(int i = 1;i <= tedade_selool;i++)
			{
				Selool * new_selool = (Selool*) malloc (sizeof(Selool));
				add_end(new_selool,1);
				new_selool->team = 2;
				new_selool->energy = 40;
				new_selool->nobateshe = false;
				place(new_selool);
				fflush(stdin);
				printf("Esme Selool shomare %d ra vared konid: " , i);
				scanf("%s" , &new_selool->name);
			}
			start(n,map);
		}
		else if(input == 1)
		{
			FILE * file = fopen("save.map","rb");
			fread(&n,sizeof(int),1,file);
			for(int i = 0;i < n;i++)
			{
				for(int j = 0;j < n;j++)
				{
					fread(&map[i][j],sizeof(Block),1,file);
				}
			}
			fclose(file);
			file = fopen("save.cells","rb");
			fread(&donafare,sizeof(bool),1,file);
			int count;
			fread(&count,sizeof(int),1,file);
			while(count--)
			{
				Selool * nc = (Selool*) malloc(sizeof(Selool));
				fread(nc,sizeof(Selool),1,file);
				add_end(nc,0);
			}
			if(donafare)
			{
				fread(&count,sizeof(int),1,file);
				while(count--)
				{
					Selool * nc = (Selool*) malloc(sizeof(Selool));
					fread(nc,sizeof(Selool),1,file);
					add_end(nc,1);
					
				}
			}
			start(n,map);
		}
		else if(input == 4)
		{
			system("cls");
			int N;
			printf("Be Map Editor khosh oomadid.\nDoost darid mapeton chand dar chand bashe?\nN ra vared konid:");
			scanf("%d" , &N);
			printf("Khoobe mapeton %d x %d e\nHala az bala samte chap be tartib doost darid che khone haye too mapeton bashe?\n%d ta character az 1 ta 4 vared konid:\n1= Khooneye energy\n2= Khooneye taghsim\n3= Khooneye mamnooe\n4= Khooneye Addi\n" ,N, N,N*N);
			unsigned char khooneha[N*N];
			for(int i = 0;i<N*N;i++)
			{
				char tmp = getchar();
				while(tmp != '1' && tmp != '2' &&tmp != '3' &&tmp != '4')
				tmp = getchar();
				khooneha[i] = tmp;
			}
			char name_map[100];
			printf("Esme mapetono vared konid: ");
			fflush(stdin);
			scanf("%s" , name_map);
			FILE * file = fopen(name_map,"wb");
			fwrite(&N,sizeof(int),1,file);
			for(int i = 0;i<N*N;i++)
			{
				fwrite(&khooneha[i],sizeof(unsigned char),1,file);
			}
			fclose(file);
			continue;
		}
		else if(input == 5)return 0;
	}
	

    return 0;
}

void boost_energy(int i,int j){
    Selool *curr = list[map[i][j].vaziat-1];
    if(map[i][j].jens != Energy){
    	printf("Wrong input!");
    	return;
	}
    while (1)
    {
    	if(curr == NULL)
    	{
    		printf("Wrong input!");
    		return;
		}
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
    if(donafare) curr->nobateshe = false;
}

void split_cell (int i, int j){
	
    if (map[i][j].jens != 2)
    {
        printf("YOU CAN'T");
        return;
    }
    Selool *curr = list[map[i][j].vaziat-1];
    while (curr != NULL)
    {
        if (curr -> x == i && curr -> y == j)
            break;
        curr = curr -> next;
    }
    if(curr == NULL)
    {
    	printf("YOU CAN'T'");
    	return;
	}
    if (curr -> energy < 80)
    {
        printf("YOU CAN'T");
        return;
    }
	if(curr == list[map[i][j].vaziat-1])
	{
		list[map[i][j].vaziat-1] = NULL;
	}
	else
	{
		Selool * current = list[map[i][j].vaziat-1];
		while(current->next != curr)
		{
			current = current->next;
		}
		Selool* rm = current->next;
		current->next = current->next->next;
		free(rm);
	}
    int n,temp;
    Selool * new_selool = (Selool*) malloc (sizeof(Selool));
	add_end(new_selool,curr->team-1);
	new_selool->team = curr->team;
	new_selool->x = i;
	new_selool->y = j;
	new_selool->energy = 40;
	map[i][j].vaziat = new_selool->team;
	fflush(stdin);
	printf("Esme Selool aval ra vared konid: ");
	scanf("%s" , &new_selool->name);
	if(list[map[i][j].vaziat-1] == NULL)
	{
		list[map[i][j].vaziat-1] = new_selool;
	}
	while(new_selool->x == i && new_selool->y == j)
	{
		printf("Koja bere?");
		move(new_selool->x,new_selool->y);
	}
	
	new_selool = (Selool*) malloc (sizeof(Selool));
	add_end(new_selool,curr->team-1);
	new_selool->team = curr->team;
	new_selool->energy = 40;
	new_selool->x = i;
	new_selool->y = j;
	map[i][j].vaziat = new_selool->team;
	fflush(stdin);
	printf("Esme Selool Dovom ra vared konid: ");
	scanf("%s" , &new_selool->name);
	
    
}


void print_map(){
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
			if(map[i][j].jens == Energy)
			{
				gotoxy(x,y+1);
				printf("  %d" , map[i][j].energy);
			}
			gotoxy(x,y+3);
			printf("  %d   " , map[i][j].vaziat);
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
			if(map[i][j].jens == Energy)
			{
				gotoxy(x,y+1);
					printf("  %d" , map[i][j].energy);
			}
			gotoxy(x,y+3);
			printf("  %d   " , map[i][j].vaziat);
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
	gotoxy(0 , n*6 + 4);
}
