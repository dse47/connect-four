import java.util.Scanner;
public class FinalProject
{
    public static void main(String args[])
    throws java.lang.InterruptedException
    {
        Scanner input = new Scanner(System.in);
        int i,z=1,j,k,l,m,n,o,p=0,hc=0,hc2=0,vc=0,vc2=0,column=0,rand=0,c2=0;
        boolean game=true;
        char board[][]= new char[6][7];
        for(i=0;i<=5;i++)
        {
            for(j=0;j<=6;j++)
            {
                board[i][j]='*';
            }
        } 
        String title=("         Connect Four!  ");
        System.out.print("         ");       
        for(i=9;i<=23;i++)
        {
            System.out.print(title.substring(i,i+1));
            Thread.sleep(25);
            
        }
        System.out.println();
        
        while(game==true)
        {
            printSlow(board);
            board=input1(board);
            System.out.println("\f         Connect Four!");
            printNormal(board);
            
            hc=hcheck(board,'X');
            hc2=hcheck(board,'O');
            vc=vcheck(board,'X');
            vc2=vcheck(board,'O');
            game=winlose(hc,hc2,vc,vc2,board,game);
            
            board=input2(board);
            System.out.println("\f         Connect Four!");
            printNormal(board);
            System.out.println("\f         Connect Four!");
            hc=hcheck(board,'X');
            hc2=hcheck(board,'O');
            vc=vcheck(board,'X');
            vc2=vcheck(board,'O');
            game=winlose(hc,hc2,vc,vc2,board,game);
            
        }
    }
    public static void printSlow(char board[][])
    throws java.lang.InterruptedException
    {
        int i,j;
        for(i=0;i<=5;i++)
        {
            for(j=0;j<=6;j++)
            {
                System.out.print(board[i][j]+"    ");
                Thread.sleep(35);
            }
            System.out.println();
            System.out.println();
        }
    }
    public static void printNormal(char board[][])
    {
        int i,j;
        for(i=0;i<=5;i++)
        {
            for(j=0;j<=6;j++)
            {
                System.out.print(board[i][j]+"    ");
            }
            System.out.println();
            System.out.println();
        }
    }
    public static char[][] input1(char board[][])
    { 
        Scanner input = new Scanner(System.in);
        int i;
        for(;;)
        {
            System.out.println("PLAYER 1: Enter a column number (1-7)");
            int column=input.nextInt()-1;
            if(column<0||column>6)
                System.out.print("ERROR: Number must be from 1-7. ");
            else if(board[0][column]=='X'||board[0][column]=='O')
                System.out.print("That column is filled up. ");
            else
            {
                for(i=5;i>=0;i--)
                {
                    if(board[i][column]=='*')
                    {
                        board[i][column]='X';
                        break;
                    }
                }
                break;
            }
        }
        return board;
    }
    public static char[][] input2(char board[][])
    { 
        Scanner input = new Scanner(System.in);
        int i;
        for(;;)
        {
            System.out.println("PLAYER 2: Enter a column number (1-7)");
            int column=input.nextInt()-1;
            if(column<0||column>6)
                System.out.print("ERROR: Number must be from 1-7. ");
            else if(board[0][column]=='X'||board[0][column]=='O')
                System.out.print("That column is filled up. ");
            else
            {
                for(i=5;i>=0;i--)
                {
                    if(board[i][column]=='*')
                    {
                        board[i][column]='O';
                        break;
                    }
                }
                break;
            }
        }
        return board;
    }
    public static int hcheck(char board[][],char a)
    {
        int n,o,hc=0;
        for(n=0;n<=5;n++)
        {
            for(o=0;o<=6;o++)
            {
                if(board[n][o]==a)
                    hc++;
                if(board[n][o]!=a)
                    hc=0;
                if(hc==4)
                    break;
                }
            if(hc==4)
                break;
            else
                hc=0;
        }
        return hc;
    }
    public static int vcheck(char board[][],char a)
    {
        int n,o,vc=0;
        for(n=0;n<=6;n++)
            {
                for(o=0;o<=5;o++)
                {
                    if(board[o][n]=='X')
                        vc++;
                    if(board[o][n]!='X')
                        vc=0;    
                    if(vc==4)
                        break;
                }
                if(vc==4)
                    break;
                else
                    vc=0;
            }
        return vc;
    }
    public static boolean winlose(int hc,int hc2,int vc,int vc2,char board[][],boolean game)
    {
        Scanner input=new Scanner(System.in);
        int i,j,p,c=0,c2=0;
        if((hc==4&&hc2==4)||(hc==4&&vc2==4)||(vc==4&&hc2==4)||(vc==4&&vc2==4))
            {
                printNormal(board);
                System.out.println("Tie!");
                for(;;)
                {
                    System.out.println("Enter 1 to play again or 2 to quit");
                    p=input.nextInt();
                    if(p<1||p>2)
                    {
                        System.out.println("ERROR: Enter 1 to play again or 2 to quit");
                        p=input.nextInt();
                    }
                    else
                        break;
                }
                if(p==2)
                    game=false;
                else
                    for(i=0;i<=5;i++)
                    {
                        for(j=0;j<=6;j++)
                        {
                            board[i][j]='*';
                        }
                        System.out.println("\f         Connect Four!");
                    } 
            }
            else if(hc==4||vc==4)
            {          
                for(i=0;i<=5;i++)
                {
                    for(j=0;j<=6;j++)
                    {
                        System.out.print(board[i][j]+"    ");
             
                    }
                    System.out.println();
                    System.out.println();
                }
                System.out.println("Player 1 wins!");
                for(;;)
                {
                    System.out.println("Enter 1 to play again or 2 to quit");
                    p=input.nextInt();
                    if(p<1||p>2)
                    {
                        System.out.println("ERROR: Number must be 1 or 2");
                    }
                    else
                        break;
                }
                if(p==2)
                    game=false;
                else
                    for(i=0;i<=5;i++)
                    {
                        for(j=0;j<=6;j++)
                        {
                            board[i][j]='*';
                        }
                        System.out.println("\f         Connect Four!");
                    }     
                 
            }
            else if(hc2==4||vc2==4)
            {
                for(i=0;i<=5;i++)
                {
                    for(j=0;j<=6;j++)
                    {
                        System.out.print(board[i][j]+"    ");
             
                    }
                    System.out.println();
                    System.out.println();
                }
                System.out.println("Player 2 wins");
                for(;;)
                {
                    System.out.println("Enter 1 to play again or 2 to quit");
                    p=input.nextInt();
                    if(p<1||p>2)
                    {
                        System.out.println("ERROR: Enter 1 to play again or 2 to quit");
                        p=input.nextInt();
                    }
                    else
                        break;
                }
                if(p==2)
                    game=false;
                else
                    for(i=0;i<=5;i++)
                    {
                        for(j=0;j<=6;j++)
                        {
                            board[i][j]='*';
                        }
                        System.out.println("\f         Connect Four!");
                    } 
            }            
            else if(c2==0)
            {
                for(i=0;i<=5;i++)
                {
                    for(j=0;j<=6;j++)
                    {
                        System.out.print(board[i][j]+"    ");
             
                    }
                    System.out.println();
                    System.out.println();
                }
                System.out.println("Tie!");
                for(;;)
                {
                    System.out.println("Enter 1 to play again or 2 to quit");
                    p=input.nextInt();
                    if(p<1||p>2)
                    {
                        System.out.println("ERROR: Enter 1 to play again or 2 to quit");
                        p=input.nextInt();
                    }
                    else
                        break;
                }
                if(p==2)
                    game=false;
                else
                    for(i=0;i<=5;i++)
                    {
                        for(j=0;j<=6;j++)
                        {
                            board[i][j]='*';
                        }
                        System.out.println("\f         Connect Four!");
                    } 
            }
        return game;
    }
}