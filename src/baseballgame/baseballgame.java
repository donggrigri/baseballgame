package baseballgame;

import java.util.Scanner;

public class baseballgame {
		public static void main(String[] args) {
			Start start=new Start();
			start.gameinit();
			while(true) {
			start.input();
			start.nothing();
			if(start.strike()>=3) {
				break;
			}
			}
			System.out.println("축하합니다");
}	
}


class Start{
	
		 int[] game=new int[3];
	       int[]insert=new int[3];
			void gameinit() {
			
			
			for(int i=0;i<game.length;i++) {
				game[i]=(int)(Math.random()*9+1);
			}
			while(game[0]==game[1]) {
				game[1]=(int)(Math.random()*9+1);
			}
			while(game[0]==game[2] || game[1]==game[2]) {
				game[2]=(int)(Math.random()*9+1);
			}
			
			}
			//숫자 입력하기
			
			void input() {
				while(true) {
			Scanner sc= new Scanner(System.in);
			for(int i=0;i<insert.length;i++) {
				System.out.println((i+1)+"번쨰 수");
				insert[i]=sc.nextInt();
			}
			
			if(insert[0]!=insert[1] && insert[0]!=insert[2] && insert[1]!=insert[2]) {
				break;
			}
			System.out.println("서로다른값을 입력하세요");
		    sc.close();
			}
			}
			
			  //스트라이크
			int strike() {
			int s=0;
			for(int i=0;i<game.length;i++) {
				
			    	if(game[i]==insert[i]) {
					s++;
				}
			}
			return s;
			
			}
			//볼
			int ball() {
			int b=0;
			for(int i=0;i<game.length;i++) {
				for(int j=0; j<game.length;j++) {
					if(game[i]==insert[j] && i!=j) {
						b++;
					}
				}
			}
			return b;
			}
			
			//낫싱
			void nothing() {
			int out=0;
			for(int i=0;i<game.length;i++) {
				
				for(int j=0; j<game.length;j++) {
					if(game[i]!=insert[j]) {
						out++;
					}
				}
				}
			if(out==9) {
				System.out.println("낫싱");		
			}
			else {
				System.out.println("스트라이크:"+strike()+"볼:"+ball());
			}
			}
			
	
}
