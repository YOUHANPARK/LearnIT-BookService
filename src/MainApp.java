import book.dto.BookDto.SearchBookByTitleInputDto;
import book.service.BookService;
import config.AppConfig;
import member.dto.MemberDto.LoginMemberInputDto;
import member.dto.MemberDto.LoginMemberOutputDto;
import member.dto.MemberDto.RegisterMemberInputDto;
import member.service.MemberService;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();

	}

	private static void run() {
		AppConfig ac = new AppConfig();
		
		MemberService ms = ac.getMemberService();
		BookService bs =  ac.getBookService();
		System.out.println("tlfgod");
		//System.out.println(bs.findAllBook(null).toArray()[0].toString());
		//bs.SearchBookByTitle(new SearchBookByTitleInputDto());
		//System.out.println(bs.SearchBookBySeq(new SearchBookBySeqInputDto(105280932)).toString());
		//bs.AddFavoriteBook(new AddFavoriteBookInputDto(21,105280932));
		//System.out.println(bs.ViewFavoriteBook(new ViewFavoriteBookInputDto(21)).toArray()[0].toString());
		
		//bs.DeleteFavoriteBook(new DeleteFavoriteBookInputDto("마인크래프트 크리에이티브 핸드북",21));
		//System.out.println(bs.ViewFavoriteBook(new ViewFavoriteBookInputDto(21)).toArray()[0].toString());
		
		//bs.RegisterBookUnrequested(new RegisterBookUnrequestedInputDto("테스트용","","테스트","테스트","테스트",Date.valueOf("2024-03-06"),1,21,"게임"));
		//System.out.println(bs.SearchBookByTitle(new SearchBookByTitleInputDto("테스트용")).toArray()[0].toString());
		
		//bs.UpdateBookBySeq(new UpdateBookBySeqInputDto("테스트용", "", "출판사", "저자", Date.valueOf("2024-03-06"),42));
		//System.out.println(bs.SearchBookByTitle(new SearchBookByTitleInputDto("테스트용")).toArray()[0].toString());
	
		//bs.DeleteBook(new DeleteBookInputDto(42));
		//System.out.println(bs.SearchBookByTitle(new SearchBookByTitleInputDto("테스트용")).toArray()[0].toString());
		
		//bs.RateBook(new RateBookInputDto(5,43,21));
		
		//bs.CheckBookAvailabilityBySeq(new CheckBookAvailabilityBySeqInputDto());
		
		//System.out.println(bs.ViewLoanHistory(new ViewLoanHistoryInputDto(21)).toArray()[0].toString());
		
		/*
		for(int i=1; i<=5; i++) {
			System.out.println(bs.SearchBookByTitle(new SearchBookByTitleInputDto("스마트",1)).toArray()[i].toString());
		}*/
		
		
		
////		//회원 가입 예시
//		RegisterMemberInputDto newMember 
//		= new RegisterMemberInputDto("gg","010-1234-5678","Seoul, Korea","gg@example.com","1234",null);
//		
//		try {
//			ms.RegisterMember(newMember);
//			System.out.println("회원가입이 완료되었습니다.");
//			} catch (Exception e) {
//				System.out.println("회원가입에 실패했습니다. 다시 시도해주세요.");
//			}
		
		
		
		//로그인 기능 예시
				LoginMemberInputDto loginInfo = new LoginMemberInputDto("johndoe@example.com","password123");
				
				LoginMemberOutputDto loginMember = ms.loginMember(loginInfo);
				if (loginMember != null) {
					System.out.println("로그인 성공: " + loginMember.getName() + "님 환영합니다.");
					System.out.println("관리자여부: " + loginMember.isAdmin());
				} else {
					System.out.println("로그인 실패: 이메일 또는 비밀번호가 틀렸습니다.");
				}
		
		
		
	}
}
