package movieproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Movie {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Mainmenu m = new Mainmenu();
		m.menuOpen();
	}

}
interface Menu
{
	public void menuOpen() throws IOException;
	public void movieView() throws IOException;
	public void Reservation();
	public void reservationCancel();
	public void Seats();
	
}

abstract class AbstractMovie implements Menu
{
	File file = new File("../movie.txt");
	Scanner sc = new Scanner(System.in);
	boolean flag1=true;
	
	@Override
	public void menuOpen() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movieView() throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str=null;
		Adminmenu admin = new Adminmenu();
		while((str=br.readLine())!=null)
		{
			System.out.println(str);
			
		}
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
	
	public void movieSet() throws IOException
	{
		if(!file.exists())
		{
			System.out.println("영화 목록을 만듭니다.");
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		System.out.println("영화의 제목과 장르를 입력해 주세요.");
		
		int plugin = 1;
		while(plugin==1)
		{
			Long time = System.currentTimeMillis();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("영화 이름을 입력해 주세요.");
			String moviename = sc.nextLine();
			System.out.println("영화 장르를 입력해 주세요.");
			String movietype = sc.nextLine();
			
			String str = time+","+moviename+","+movietype;
			bw.write(str+'\n');
			System.out.println("영화 등록이 마무리 되었습니다.");
			
			System.out.println("계속 등록하고 싶으시면 1, 종료하고 싶으시면 0을 눌러주세요.");
			plugin=sc.nextInt();
			if(plugin>1)
			{
				System.out.println("잘못된 숫자 입니다.");
			}
			
			
		}
		bw.close();
		
		
		FileReader  fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String read=null;
		while((read=br.readLine())!=null)
		{
			System.out.println(read);
		}
	}
}


class Mainmenu extends AbstractMovie
{
	Scanner sc = new Scanner(System.in);
	static boolean flag = true;
	Adminmenu admin = new Adminmenu();
	@Override
	public void menuOpen() throws IOException {
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
				super.movieView();
				System.out.println("1.영화 확인하기 2. 영화 예매하기 3. 예매 취소하기 4.관리자 메뉴가기 5.종료");
				break;
			case 2:
				Reservation();
				System.out.println("1.영화 확인하기 2. 영화 예매하기 3. 예매 취소하기 4.관리자 메뉴가기 5.종료");
				break;
			case 3:
				ReservationOut();
				System.out.println("1.영화 확인하기 2. 영화 예매하기 3. 예매 취소하기 4.관리자 메뉴가기 5.종료");
				break;
			case 4:
				admin.menuOpen();
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
	public void movieView() throws IOException {
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
	
	public void callAdminMenu() throws IOException
	{
		Adminmenu a = new Adminmenu();
		a.menuOpen();
	}
	
}

class Adminmenu extends AbstractMovie
{
	
	File file = new File("../movie.txt");
	Scanner sc = new Scanner(System.in);
	boolean flag1=true;
	
	@Override
	public void menuOpen() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("===========================");
		System.out.println("==========관리자매뉴==========");
		System.out.println("===========================");
		System.out.println("1.영화 확인하기 2. 영화 등록하기 3. 영화 삭제하기 4.종료");
		
		while(flag1)
		{
			int input = sc.nextInt();
			switch(input)
			{
			case 1:
				movieView();
				System.out.println("1.영화 확인하기 2. 영화 등록하기 3. 영화 삭제하기 4.종료");
				break;
			case 2:
				movieSet();
				System.out.println("1.영화 확인하기 2. 영화 등록하기 3. 영화 삭제하기 4.종료");
				break;
			case 3:
				movieDelete();
				break;
			case 4:
				System.out.println("종료 되었습니다.");
				flag1=false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다..");
				System.out.println("1.영화 확인하기 2. 영화 등록하기 3. 영화 삭제하기 4.종료");
				break;
			}
		}
	}

	@Override
	public void movieView() throws IOException {
		// TODO Auto-generated method stub
		super.movieView();
	}

	public void movieSet() throws IOException
	{
		super.movieSet();
		
	}
	
	public void movieDelete()
	{
		
	}
	
}