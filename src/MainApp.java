import book.dto.BookDto.SearchBookByTitleInputDto;
import book.service.BookService;
import config.AppConfig;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
		
	}

	private static void run() {
		AppConfig ac = new AppConfig();
		
		BookService bs =  ac.getBookService();
		System.out.println("tlfgod");
		//System.out.println(bs.findAllBook(null).toArray()[0].toString());
		bs.SearchBookByTitle(new SearchBookByTitleInputDto());
	}
}
