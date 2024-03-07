import book.dto.BookDto.SearchBookByTitleInputDto;
import book.service.BookService;
import config.AppConfig;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
		
	}

	private static void run() {
		AppConfig ac = AppConfig.getInstance();
		
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
		for(int i=0; i<=9; i++) {
			System.out.println(bs.SearchBookByTitle(new SearchBookByTitleInputDto("스마트",1)).toArray()[i].toString());
		}*/
	}
}
