package view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import book.controller.BookController;
import book.dto.BookDto;
import book.dto.BookDto.AddFavoriteBookInputDto;
import book.dto.BookDto.CheckBookAvailabilityBySeqInputDto;
import book.dto.BookDto.DeleteFavoriteBookInputDto;
import book.dto.BookDto.RateBookInputDto;
import book.dto.BookDto.RecommendBookInputDto;
import book.dto.BookDto.RegisterBookUnrequestedInputDto;
import book.dto.BookDto.RequestBookInputDto;
import book.dto.BookDto.ReturnBookBySeqInputDto;
import book.dto.BookDto.SearchBookByCategoryInputDto;
import book.dto.BookDto.SearchBookByTitleInputDto;
import book.dto.BookDto.ViewFavoriteBookInputDto;
import book.dto.BookDto.ViewLoanHistoryInputDto;
import member.controller.MemberController;
import session.Session;
import session.SessionSet;


public class MenuView {
	static BookController bookController;
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			
			MenuView.printMenu();
			
			System.out.print("메뉴 번호를 선택해주세요 : ");

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.searchBookMenu(); // 검색
				
				break;
			case 2:
				MenuView.login(); // 로그인
				
				break;

			case 3:
				MenuView.register();// 회원가입
				break;

			case 4:
				System.out.println("시스템이 종료되었습니다.");
				System.exit(0);
			}
			sc.nextLine();
		}

	}

	public static void printMenu() {
		System.out.println(
				"============================================================================================");					
		System.out.println("=====================================LearnIT 도서대여서비스=====================================");
		System.out.println(
				"============================================================================================");
		System.out.println(
				"                      " + "1. 검색   |   2. 로그인   |  3. 회원가입   |   4. 종료" + "                   ");
		System.out.println(
				"============================================================================================");
	}
	
	/**
	 * 도서 검색 메뉴
	 */
	public static void searchBookMenu() {
		while (true) {
			System.out.println(
					"                      " + "1. 도서 검색   |   2. 도서 상세 검색   |  3. 뒤로 가기" + "                   ");

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.searchBookBylistMenu();
				// 도서 검색
				break;
				
			case 2:
				// 도서 상세 검색
				System.out.print("책 번호를 입력해주세요: ");
				long bookseq = sc.nextLong();
				
				
				BookDto.SearchBookBySeqInputDto ip = new BookDto.SearchBookBySeqInputDto(bookseq);
				ip.setBookseq(bookseq);
				BookController.SearchBookBySeq(ip);
				
				return;
				
			case 3:
				MenuView.menu();// 뒤로가기
				break;
			}
			sc.nextLine();
		}
	}
	
	/**
	 * 도서 (리스트) 검색 메뉴
	 */
	public static void searchBookBylistMenu() {
		while (true) {
			System.out.println(
					"                              " + "1. 제목 검색   |   2. 뒤로 가기" + "                           "); // 카테고리 검색 제외
			
			/*System.out.println(
					"                      " + "1. 제목 검색   |   2. 카테고리 검색   |  3. 뒤로 가기" + "                   ");*/
			
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				
				System.out.println("책 제목을 입력해주세요.");
				System.out.println();
				String title = sc.nextLine();
				
                System.out.println("페이지를 입력해주세요.");
                System.out.println();
                int titlepage = sc.nextInt();
                
                SearchBookByTitleInputDto ip = new SearchBookByTitleInputDto(title,titlepage);
				BookController.SearchBookByTitle(ip); // 도서 제목 검색
				break;

			/*case 2:
				// 도서 카테고리 검색
				
				System.out.println("카테고리를 입력해주세요.");
				System.out.println();
				String category = sc.nextLine();
				
                System.out.println("페이지를 입력해주세요.");
                System.out.println();
                int cartpage = sc.nextInt();
                
                SearchBookByCategoryInputDto input = new SearchBookByCategoryInputDto(category,cartpage);
				BookController.SearchBookByCategory(input);
				break;
				
			case 3:
				MenuView.searchBookMenu(); // 뒤로가기
				break;*/ // 카테고리 검색 제외
				
			case 2:
				MenuView.searchBookMenu(); // 뒤로가기
				break;
			}
			sc.nextLine();
			
		}
	}
	
	/**
	 * 로그인 메뉴
	 * */
	public static void login() {
		 
		
         System.out.print("아이디(이메일) : ");
		 String id = sc.nextLine();
		 
		 System.out.print("비밀번호 : ");
		 String password = sc.nextLine();
		 
		 SessionSet ss = SessionSet.getInstance();
		 Session session = MemberController.login(id, password);
		 ss.add(session);
		 
		 MenuView.checkManager(session);
		 
		 
	}
	
	/**
	 * 회원가입 메뉴
	 */
	public static void register() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("전화번호 : ");
		String tel = sc.nextLine();
		
		System.out.print("주소: ");
		String addr = sc.nextLine();
		
		System.out.print("아이디로 사용될 이메일: ");
		String email = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		
		System.out.print("선호 카테고리 : ");
		String category = sc.nextLine();
		
		MemberController.registermem(name, tel, addr, email, password, category);
	}
	/**
	 * 회원/관리자 여부
	 * */
	public static void checkManager(Session session) /*throws ParseException*/ {

		if (session.getAdmin()==1) {
			MenuView.printAdminMenu(session);
		}
		else MenuView.printUserMenu(session);
	}
	
	
	
	/**
	 * 회원 메뉴
	 */
	public static void printUserMenu(Session session) {
		while (true) {
			
			MenuView.recommendBook(session);
			
			System.out.println(
					"==========================================회원 로그인==========================================");
			System.out.println("                   1. 대여   |   2. 반납   |  3. 회원정보 조회   |   4. 로그아웃");
			//System.out.println("1. 대여   |   2. 반납   |  3. 연장   |   4. 도서요청   |   5. 관심도서   |   6. 회원정보 조회   |   7. 로그아웃");
			
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.checkBookMenu(session); // 대여
				break;

			case 2:
				MenuView.returnBook(session);// 반납
				break;
			/*case 3:
				// 연장
				break;
			case 4:
				MenuView.requestBookMenu(session);// 도서요청
				break;
			case 5:
				MenuView.addFavorBookMenu(session);// 관심도서
				break;

			case 6:
				MenuView.userInfoMenu(session);//회원정보 조회(관리)메뉴
				break;
				
			case 7:
				MenuView.logout(session);//로그아웃
				MenuView.menu();
				break;*/
				
			case 3:
				MenuView.userInfoMenu(session);//회원정보 조회(관리)메뉴
				break;
				
			case 4:
				MenuView.logout(session);//로그아웃
				MenuView.menu();
				break;
			}
			sc.nextLine();
		}
		
	}
	/**
	 * 도서 반납
	 */
	public static void returnBook(Session session) {
		System.out.print("반납할 책 번호: ");
		long bookseq = sc.nextLong();
		BookController.returnBook(new ReturnBookBySeqInputDto(bookseq,session.getUser_seq()));
		sc.nextLine();
		System.out.print("별점을 남겨주세요: ");
		int rate = Integer.parseInt(sc.nextLine());
		BookController.rateBook(new RateBookInputDto(rate,bookseq,session.getUser_seq()));
	}
	/**
	 * 도서 추천
	 */
	public static void recommendBook(Session session) {
		BookController.recommendBook(new RecommendBookInputDto(session.getUser_seq()));
	}
	/**
	 * 로그 아웃
	 */
	public static void logout(Session session) {
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
		
		//MenuView.printMenu();
	}

	/**
	 * 대여 관리 메뉴
	 */
	public static void checkBookMenu(Session session) {
		while (true) {
			System.out.println(
					"                      " + "1. 도서대여   |   2. 도서대여 내역조회   |  3. 뒤로 가기" + "                   ");

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.loanBook(session);// 도서 대여
				break;

			case 2:
				MenuView.viewloan(session);// 도서대여내역 조회
				break;
				
			case 3:
				MenuView.printUserMenu(session);// 뒤로가기
				break;
			}
			sc.nextLine();
		}
	}
	/**
	 * 도서 대여
	 */
	public static void loanBook(Session session) {
		System.out.println("책 번호를 입력하세요: ");
		long bookseq = sc.nextLong();
		long userseq = session.getUser_seq();
		//System.out.println(userseq);
		BookController.loanBook(new CheckBookAvailabilityBySeqInputDto(bookseq,userseq));
	}
	/**
	 * 도서 대여 내역 조회
	 */
	public static void viewloan(Session session) {
		BookController.viewLoanHistory(new ViewLoanHistoryInputDto(session.getUser_seq()));
	}
	
	/**
	 * 도서요청 관리 메뉴
	 */
	public static void requestBookMenu(Session session) {
		while (true) {
			System.out.println(
					"                      " + "1. 도서요청   |   2. 도서요청 내역확인   |  3. 뒤로 가기" + "                   ");

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.requestBook(session.getUser_seq());//도서 요청
				break;

			case 2:
				MenuView.viewrequestbook(session.getUser_seq());// 도서요청 내역확인
				break;
				
			case 3:
				MenuView.printUserMenu(session);// 뒤로가기
				break;
			}
			sc.nextLine();
		}
	}
	
	/**
	 * 도서 요청
	 */
	public static void requestBook(long userseq) {
		System.out.print("책 제목을 입력해주세요: ");
		String title = sc.nextLine();
		System.out.print("출판사를 입력해주세요: ");
		String publisher = sc.nextLine();
		System.out.print("저자를 입력해주세요: ");
		String author = sc.nextLine();
		RequestBookInputDto ip = new RequestBookInputDto(title,publisher,author,userseq);
		BookController.RequestBook(ip);
	}
	/**
	 * 도서 요청 내역 확인
	 */
	public static void viewrequestbook(long userseq) {
		
	}
	
	/**
	 * 관심도서 관리 메뉴
	 */
	public static void addFavorBookMenu(Session session) {
		while (true) {
			System.out.println(
					"     " + "1. 관심도서 추가   |   2. 관심도서 리스트 조희   |  3. 관심도서 삭제   |   4. 뒤로 가기" + "     ");

			System.out.print("메뉴를 선택해주세요: ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.insertFavorBook(session.getUser_seq());// 관심도서 추가
				break;

			case 2:
				MenuView.viewFavorBook(session.getUser_seq());//관심도서 리스트 조회
				break;
			
			case 3:
				MenuView.delFavorBook(session.getUser_seq());//관심도서 삭제
				break;
				
			case 4:
				MenuView.printUserMenu(session);
				break;
			}
			sc.nextLine();
		}
	}
	

	/**
	 *  관심도서 추가
	 */
	public static void insertFavorBook(long userseq) {
		 
		System.out.print("책 번호를 입력해주세요.");
		long bookseq = sc.nextLong();
        
		BookController.AddFavoriteBook(new AddFavoriteBookInputDto(userseq,bookseq));

	}
	/**
	 * 관심도서 조회
	 */
	public static void viewFavorBook(long userseq) {
		BookController.ViewFavoriteBook(new ViewFavoriteBookInputDto(userseq));
	
	}
	/**
	 * 관심도서 삭제
	 */
	public static void delFavorBook(long userseq) {
		System.out.print("책 제목을 입력해주세요.:");
		String booktitle = sc.nextLine();
		BookController.DeleteFavoriteBook(new DeleteFavoriteBookInputDto(booktitle,userseq));
	}
	
	/**
	 * 회원정보 조회(회원) 관리 메뉴
	 */
	public static void userInfoMenu(Session session) {
		while (true) {
			System.out.println(" " + "1. 회원정보 조회   |   2. 회원정보 수정   |  3. ID 찾기   |   4. PASSWORD 찾기   |   5. 뒤로 가기");

			System.out.print("메뉴를 선택해주세요: ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MemberController.viewmeminfo(session.getUser_seq());// 회원정보 조회
				break;

			case 2:
				MenuView.updatememinfo(session);// 회원정보 수정
				break;
			
			case 3:
				MenuView.findEmail();// ID 찾기
				break;
			
			case 4:
				MenuView.findPassword();//비밀번호 찾기
				break;
				
			case 5:
				MenuView.printUserMenu(session);// 뒤로가기
				break;
			}
			sc.nextLine();
		}
	}
	/**
	 * 회원정보 수정
	 */
	public static void updatememinfo(Session session) {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("전화번호 : ");
		String tel = sc.nextLine();
		
		System.out.print("주소: ");
		String addr = sc.nextLine();
		
		System.out.print("아이디로 사용될 이메일: ");
		String email = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		
		System.out.print("선호 카테고리 : ");
		String category = sc.nextLine();
		
		MemberController.updatememinfo(name,tel,addr,email,password,category,session.getUser_seq());
	}
	
	/**
	 * ID찾기
	 */
	public static void findEmail() {
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("전화번호: ");
		String tel = sc.nextLine();
		
		MemberController.findUserEmail(name,tel);
	}
	/**
	 * 비밀번호 찾기
	 */
	public static void findPassword() {
		System.out.println("이메일: ");
		String email = sc.nextLine();
		System.out.println("이름: ");
		String name = sc.nextLine();
		MemberController.findPassword(email, name);
		
	}
	
	/**
	 * 관리자 메뉴
	 */
	public static void printAdminMenu(Session session) /*throws ParseException*/{
		while (true) {
			System.out	  
			.println("==========================================관리자 로그인==========================================");
			System.out.println("1. 대여   |   2. 반납   |  3. 연장   |   4. 도서관리   |   5. 관심도서   |   6. 연체자 관리   |   7. 회원정보 조회   |   8. 로그아웃");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.loanBook(session);// 대여
				break;

			case 2:
				// 반납
				break;
			case 3:
				// 연장
				break;
			case 4:
				MenuView.registerBookMenu(session);// 도서관리
				break;
			case 5:
				MenuView.addFavorBookMenu(session);// 관심도서
				break;

			case 6:
				// 연체자 관리
				break;
				
			case 7:
				MenuView.adminInfoMenu();// 관리자의 회원정보 조회
				break;
			
			case 8:
				break;
			}
			sc.nextLine();
		}
	}

	
	/**
	 * 도서 관리 메뉴
	 */
	public static void registerBookMenu(Session session) /*throws ParseException*/ {
		while (true) {
			System.out.println(" " + "1. 도서 추가   |   2. 요청 도서 추가   |  3. 도서 수정   |   4. 도서 삭제   |   5. 뒤로 가기");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				//MenuView.registerUnrBook(session);// 도서 추가
				break;

			case 2:
				// 요청 도서 추가
				break;
			
			case 3:
				// 도서 수정
				break;
				
			case 4:
				// 도서 삭제
				break;
				
			case 5:
				// 뒤로가기
				break;
			}
			sc.nextLine();
		}
	}
	/**
	 * 도서 추가
	 */
	public static void registerUnrBook(Session session) throws ParseException{
		System.out.print("책 제목: ");
		String title = sc.nextLine();
		System.out.print("청구 기호: ");
		String callnum = sc.nextLine();
		System.out.print("출판사: ");
		String publisher = sc.nextLine();
		System.out.print("책 소개: ");
		String intro = sc.nextLine();
		System.out.print("저자: ");
		String author = sc.nextLine();
		
		System.out.print("출판연도: ");
		String pubyear = sc.nextLine();
		SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");             
		Date dpubyear = formatter.parse(pubyear);
		 
		System.out.println("도서 대여가능 여부: ");
		int loanposb = Integer.parseInt(sc.nextLine());
		
		System.out.println("카테고리 이름: ");
		String category = sc.nextLine();
		 
		
		BookController.registerBook(new RegisterBookUnrequestedInputDto(title, callnum, publisher, intro,
				author, dpubyear, loanposb, session.getUser_seq(), category));
	}
	/**
	 * 도서 수정
	 */
	public static void updateBook(Session session) {
		
	}
	
	
	/**
	 * 회원정보 조회(관리자) 관리 메뉴
	 */
	public static void adminInfoMenu() {
		while (true) {
			System.out.println("1. 개인 회원정보 조회   |   2. 개인 회원정보 수정   |  3. 모든 회원정보 조회   |   4. ID 찾기   |   5. PASSWORD 찾기   |   6. 뒤로 가기");

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 회원정보 조회
				break;

			case 2:
				// 회원정보 수정
				break;
			
			case 3:
				//모든 회원 정보 조회
				break;
			
			case 4:
				// ID 찾기
				break;
				
			case 5:
				//비밀번호 찾기
				break;
			
			case 6:
				// 뒤로가기
				break;
			}
			sc.nextLine();
		}
	}

	/**
	 * 프로그램 시작
	 */

	public static void main(String[] args) {
		
		MenuView.menu();

	}

}
