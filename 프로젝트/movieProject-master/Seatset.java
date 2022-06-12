package orn;

import java.util.*;

public class Seatset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Commands c = new Commands();
		c.prints();
		c.Init_seat();
		c.Print_seat();
		c.print();
		
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			input.toUpperCase();
			try {
				c.option(input);
			}catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("");
				System.out.println("잘못 입력하셨습니다. 좌석예약은 '대문자' , '숫자' 만 가능합니다 다시 입력하세요.");
				System.out.println("");
				c.print();
			}
		}
	}
}
class Commands
{
	final int SIZE =10;
	char[][] seat = new char[SIZE][SIZE];
	
	protected void print()
	{
		System.out.print("입력>>");
	}
	protected void prints()
	{
		System.out.println("예약 하실 좌석을 선택하세요");
		System.out.println("");
		System.out.println("좌석은 A1~I9까지 가능합니다 ");
		System.out.println("좌석 예약을 원하실 경우 예시 '+A1'");
		System.out.println("좌석 취소를 원하실 경우 예시 '-A1'");
		System.out.println("예약 조회를 원하실 경우 P 를 입력하세요");
		System.out.println("예약 종료를 원하실 경우 E 를 입력하세요");
		System.out.println("");
	}
	
	void Init_seat()
	{
		char col='A';
		char row='1';
		
		for(int i=1;i<SIZE;i++)
		{
			for(int j=0;j<SIZE;j++)
			{
				seat[i][j] = 'O';
			}
		}
		for(int i=1;i<SIZE;i++)
		{
			seat[i][0]=col++;
		}
		for(int j=1;j<SIZE;j++)
		{
			seat[0][j]=row++;
		}
	}
	void Print_seat()
	{
		for(char [] index : seat)
		{
			for(char temp : index)
			{
				System.out.printf("%c \t",temp);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	void option(String input) 
	{
		char[] ip=input.toCharArray();
		char op =ip[0];
		int col=0,row=0;
		if (ip.length >3)
		{
			System.out.println("");
			System.out.println("잘못 입력하셨습니다. 좌석예약은 '대문자' , '숫자' 만 가능합니다 다시 입력하세요.");
			System.out.println("");
			print();
				return;
		}
		if(op=='+'||op=='-')
		{
			col=(int)ip[1]-64;
			row=(int)ip[2]-48;
			
		}
		
		switch (op)
		{
		
		case'+':
			if(seat[col][row] !='X')
			{
				seat[col][row]='X';
				System.out.println("");
				System.out.printf("%c%c좌석을 예매했습니다. %n%n", ip[1], ip[2]);
			}
			else
			{
				System.out.println("");
				 System.out.printf("이미 예약이 되어있는 자리 입니다.%n%n");
			}
			print();
				break;
			
		case'-':
			if(seat[col][row] !='O')
			{
				seat[col][row]='O';
				System.out.println("");
				System.out.printf("%c%c좌석을 취소했습니다. %n%n", ip[1], ip[2]);
			}
			else
			{
				System.out.println("");
				System.out.printf("예약 하지않은 자리 입니다.%n%n");
			}
			print();
				break;
			
		case 'P':
		case 'p':
			if(ip.length >=2)
			{
				System.out.println();
				System.out.printf("잘못 입력하셨습니다. 다시 입력하세요. %n%n");
				print();
					return;
			}
			Print_seat();
			System.out.println("조회를 완료하였습니다.");
			System.out.println("");
			prints();
			print();
				break;
				
		case 'E':
		case 'e':
			if(ip.length >=2)
			{
				System.out.println();
				System.out.printf("잘못 입력하셨습니다. 다시 입력하세요. %n%n");
				print();
					return;
			}
			System.out.println("");
			System.out.print("프로그램을 종료합니다.");
			System.exit(0);
				break;
		
		default:
			System.out.println("");
			System.out.printf("잘못 입력하셨습니다. 다시 입력하세요. %n%n");
			print();
				break;
		}
	}
}
