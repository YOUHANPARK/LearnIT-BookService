package book.service;

import  book.dto.BookDto;
import book.dto.BookDto.SearchBookByTitleInput;
import book.dto.BookDto.SearchBookByTitleOutput;

public interface BookService {
	
	SearchBookByTitleOutput searchBookByTitle(SearchBookByTitleInput er);
	
}
