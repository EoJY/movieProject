package movieproject;

import java.util.Scanner;

public class Movie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mainmenu m = new Mainmenu();
		m.menuOpen();
	}

}
interface Menu
{
	public void menuOpen();
	public void movieView();
	public void Reservation();
	public void reservationCancel();
	public void Seats();
	
}

abstract class AbstractMovie implements Menu
{

	@Override
	public void menuOpen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movieView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Reservation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Seats() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reservationCancel() {
		// TODO Auto-generated method stub
		
	}
	
}


class Mainmenu extends AbstractMovie
{
	Scanner sc = new Scanner(System.in);
	boolean flag = true;
	@Override
	public void menuOpen() {
		// TODO Auto-generated method stub
		
		System.out.println("===========================");
		System.out.println("==========영화예매===========");
		System.out.println("===========================");
		System.out.println("1.영화 확인하기 2. 영화 예매하기 3. 예매 취소하기 4.관리자 메뉴가기 5.종료");
		
		while(flag)
		{
			int input = sc.nextInt();
			switch(input)
			{
			case 1:
				movieView();
				break;
			case 2:
				Reservation();
				break;
			case 3:
				ReservationOut();
				break;
			case 4:
				callAdminMenu();
				break;
			case 5:
				System.out.println("종료 되었습니다.");
				flag=false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다..");
				System.out.println("1.영화 확인하기 2. 영화 예매하기 3. 예매 취소하기 4.관리자 메뉴가기 5.종료");
				break;
			}
		}
		
	}

	@Override//영화 메뉴
	public void movieView() {
		// TODO Auto-generated method stub
		super.movieView();
	}

	@Override
	public void Reservation() {
		// TODO Auto-generated method stub
		super.Reservation();
		Seats();
	}

	
	@Override
	public void Seats() {
		// TODO Auto-generated method stub
		
	}

	public void ReservationOut() {
		// TODO Auto-generated method stub
		
	}
	
	public void callAdminMenu()
	{
		Adminmenu a = new Adminmenu();
		a.menuOpen();
	}
	
}

class Adminmenu extends AbstractMovie
{

	@Override
	public void menuOpen() {
		// TODO Auto-generated method stub
		super.menuOpen();
	}

	@Override
	public void movieView() {
		// TODO Auto-generated method stub
		super.movieView();
	}

	public void movieSet()
	{
		
	}
	
	public void movieDelete()
	{
		
	}
	
}