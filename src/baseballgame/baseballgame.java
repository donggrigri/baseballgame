package baseballgame;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class baseballgame {
		public static void main(String[] args) {
			while(true)
			{
			Start start=new Start();
			start.gameinit();
	
			while(true)
			{
				start.input();
				start.strikeandball();
				start.nothing();
				if(start.strike()>=Start.three) 
					break;
			}
				System.out.println("�����մϴ�");
				System.out.println("���ΰ����� �����մϴ�");
            }	
}	
}


class Start{
		static final int three=3;
		
		 int[] game=new int[three];
	     int[]insert=new int[three];
			void gameinit()
			{
				for(int i=0;i<game.length;i++)
				{
					game[i]=(int)(Math.random()*9+1);
				}
				while(game[0]==game[1])
				{
					game[1]=(int)(Math.random()*9+1);
				}
				while(game[0]==game[2] || game[1]==game[2])
				{
					game[2]=(int)(Math.random()*9+1);
				}
			}
			//���� �Է��ϱ�
			
			void input()
			{
				int receiveNumber;
				Scanner sc= new Scanner(System.in);
				System.out.println("����3���� �Է��ϼ���");
				receiveNumber=sc.nextInt();
				insert[0]=receiveNumber/100;
				insert[1]=(receiveNumber-insert[0]*100)/10;
				insert[2]=receiveNumber-insert[0]*100-insert[1]*10;
			}
			
			
			  //��Ʈ����ũ
			int strike() 
			{
				int s=0;
				for(int i=0;i<game.length;i++)
				{
				   	if(game[i]==insert[i])
				       s++;
				}
				return s;
			}
			//��
			int ball()
			{
				int b=0;
				for(int i=0,j=0;i<game.length;)
				{
					
					if(game[i]==insert[j] && i!=j)
					{
						b++;
					}
					if(j<2)
					{
						j++;
					}
					else
					{
						i++;j=0;
					}
				}
				
				return b;
			}
			
			//����
			void nothing()
		   {
				int out=0;
				
				for(int i=0,j=0;i<game.length;)
				{
					
					if(game[i]!=insert[j])
						out++;
					if(j<2)
					{
						j++;
					}
					else
					{
						i++;j=0;
					}
				}
	
				if(out==9)
				{
					System.out.println("����");		
				}
			}
			
			
			void strikeandball()
			{
				if(strike()>0 && ball()>0)
				{
					System.out.println("��Ʈ����ũ:"+strike()+"��:"+ball());
				}
				else if(strike()>0)
				{
						System.out.println("��Ʈ����ũ:"+strike());
			    }
				else if(ball()>0)
				{
						System.out.println("��:"+ball());
				}
			}
			
			
			
			
}


