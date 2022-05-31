package movieproject;

import java.io.*;

public class TrainTiketTest {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
		String destination[] = {"서울","대전","대구","부산"};
		Tiket x = new Tiket();
		x.display();
		int start, end, number;
		
		while(true){
			System.out.println("승차지점 선택해주세요\n1.서울,2.대전,3.대구");
			start = Integer.parseInt(stdin.readLine());
		
			System.out.println("하차지점 선택해주세요\n1.대전,2.대구,3.부산");
			end = Integer.parseInt(stdin.readLine());
		
			System.out.println("구매할 표 매수를 적어주세요(1~5)");
			number = Integer.parseInt(stdin.readLine());
		
			System.out.println("("+destination[start-1]+")에서 ("+destination[end]+")까지 "+ number+"매를 선택하셨습니다..");
			
			int card[] = {start,end,number};
			
			int cnt=-1;
			boolean bb= false;
			while(!bb)
			{
				cnt++;
				bb = x.search(card,cnt);
			}
			if(bb) x.set(start, end, number, cnt);
			x.display();
			
		}
	}
}
class Tiket{
	boolean a[][]=new boolean[3][40];
	
	boolean search(int[] card,int cnt){
		int i=0,j=0;
		for(i=card[0]-1 ; i<card[1] ; i++)
		{
			for(j=cnt ; j<card[2]+cnt ; j++)
			{
				if(a[i][j]==true){ return false; }
			}
		}
		return true;
	}
	void set(int x, int y, int z, int cnt){
		
		for(int i1=x-1;i1<y;i1++)
		{
			for(int j1=cnt;j1<z+cnt;j1++)
			{
				a[i1][j1]=true;
			}
		}
		System.out.print("★★★좌석번호는");
		for(int j1=cnt;j1<z+cnt;j1++)
		{
			System.out.print((j1+1)+" ");
		}
		System.out.println("번 입니다.★★★\n");
	}
	
	void display(){
		System.out.print("       ");
		for(int j=1;j<=a[0].length;j++)
			System.out.printf(" %2d",j);
		System.out.println();
		int cnt=0;
		for(int i=0;i<a.length;i++)
		{
			switch(cnt)
			{
			case 0 : System.out.print("서울~대전");break;
			case 1 : System.out.print("대전~대구");break;
			case 2 : System.out.print("대구~부산");break;
			}cnt++;
			
			for(int j=0;j<a[i].length;j++)
				if(a[i][j]==true)System.out.print("■");
				else System.out.print("□");
			System.out.println("");
		}
	}
}
