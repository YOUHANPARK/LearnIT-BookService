package book.service;

import  book.dto.BookDto;

public interface BookService {
	
	BookDto.searchBookByTitleOutput searchBookByTitle(BookDto.searchBookByTitleInput) ;
	
}
