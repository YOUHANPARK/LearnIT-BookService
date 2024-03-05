import java.util.Scanner;

public class MenuView {

	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {

			MenuView.printMenu();

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				
				
				// 검색
				break;
			case 2:

				// 로그인

				break;

			case 3:
				// 회원가입
				break;

			case 4:
				System.exit(0);
			}
		}

	}

	public static void printMenu() {
		System.out.println(
				"********************************************************************************************");
		System.out.println("*************************************LeanIT 도서대여서비스*************************************");
		System.out.println(
				"********************************************************************************************");
		System.out.println(
				"                      " + "1. 검색   |   2. 로그인   |  3. 회원가입   |   4. 종료" + "                   ");
		System.out.println(
				"********************************************************************************************");
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
				// 도서 검색
				break;

			case 2:
				// 도서 상세 검색
				break;
				
			case 3:
				// 뒤로가기
				break;
			}
		}
	}
	
	
	/**
	 * 로그인 메뉴
	 * */
	public static void login() {
		 System.out.print("아이디 : ");
		 String id = sc.nextLine();
		 
		 System.out.print("비번 : ");
		 String password = sc.nextLine();
		 
		//.login(id, password); 
	}
	
	/**
	 * 
	 */
	
	/**
	 * 회원 메뉴
	 */
	public static void printUserMenu() {
		while (true) {

			System.out.println(
					"******************************************회원 로그인******************************************");
			System.out.println("1. 대여   |   2. 반납   |  3. 연장   |   4. 도서요청   |   5. 관심도서   |   6. 회원정보 조회   |   7. 로그아웃");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.checkBookMenu(); // 대여
				break;

			case 2:
				// 반납
				break;
			case 3:
				// 연장
				break;
			case 4:
				MenuView.requestBookMenu();// 도서요청
				break;
			case 5:
				MenuView.addFavorBookMenu();// 관심도서
				break;

			case 6:
				// 회원정보 조회
				break;
				
			case 7:
				break;
			}
		}
	}

	/**
	 * 대여 관리 메뉴
	 */
	public static void checkBookMenu() {
		while (true) {
			System.out.println(
					"                      " + "1. 도서대여   |   2. 도서대여 내역조회   |  3. 뒤로 가기" + "                   ");

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 도서 대여
				break;

			case 2:
				// 도서대여내역 조회
				break;
				
			case 3:
				// 뒤로가기
				break;
			}
		}
	}
	
	/**
	 * 도서요청 관리 메뉴
	 */
	public static void requestBookMenu() {
		while (true) {
			System.out.println(
					"                      " + "1. 도서요청   |   2. 도서요청 내역확인   |  3. 뒤로 가기" + "                   ");

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 도서 요청
				break;

			case 2:
				// 도서요청 내역확인
				break;
				
			case 3:
				// 뒤로가기
				break;
			}
		}
	}
	
	/**
	 * 관심도서 관리 메뉴
	 */
	public static void addFavorBookMenu() {
		while (true) {
			System.out.println(
					"     " + "1. 관심도서 추가   |   2. 관심도서 리스트 조희   |  3. 관심도서 삭제   |   4. 뒤로 가기" + "     ");

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 관심도서 추가
				break;

			case 2:
				// 관심도서 리스트 조회
				break;
			
			case 3:
				// 관심도서 삭제
				break;
				
			case 4:
				// 뒤로가기
				break;
			}
		}
	}
	
	/**
	 * 회원정보 조회(회원) 관리 메뉴
	 */
	public static void userInfoMenu() {
		while (true) {
			System.out.println(" " + "1. 회원정보 조회   |   2. 회원정보 수정   |  3. ID 찾기   |   4. PASSWORD 찾기   |   5. 뒤로 가기");

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 회원정보 조회
				break;

			case 2:
				// 회원정보 수정
				break;
			
			case 3:
				// ID 찾기
				break;
			
			case 4:
				//비밀번호 찾기
				break;
				
			case 5:
				// 뒤로가기
				break;
			}
		}
	}
	
	/**
	 * 관리자 메뉴
	 */
	public static void printAdminMenu() {
		while (true) {
			System.out
			.println("******************************************관리자 로그인******************************************");
			System.out.println("1. 대여   |   2. 반납   |  3. 연장   |   4. 도서관리   |   5. 관심도서   |   6. 연체자 관리   |   7. 회원정보 조회   |   8. 로그아웃");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.checkBookMenu(); // 대여
				break;

			case 2:
				// 반납
				break;
			case 3:
				// 연장
				break;
			case 4:
				MenuView.registerBookMenu();// 도서관리
				break;
			case 5:
				MenuView.addFavorBookMenu(); // 관심도서
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
		}
	}

	
	/**
	 * 도서 관리 메뉴
	 */
	public static void registerBookMenu() {
		while (true) {
			System.out.println(" " + "1. 도서 추가   |   2. 요청 도서 추가   |  3. 도서 수정   |   4. 도서 삭제   |   5. 뒤로 가기");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 도서 추가
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
		}
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
		}
	}

	/**
	 * 프로그램 시작
	 */

	public static void main(String[] args) {
		MenuView.menu();

	}

}
