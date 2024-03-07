package member.controller;

import book.service.BookService;
import member.dto.MemberDto;
import member.dto.MemberDto.LoginMemberInputDto;
import member.dto.MemberDto.LoginMemberOutputDto;
import member.service.MemberService;

public class MemberController {
	static BookService bookService;
	static MemberService memberService;
	
	/**
	 * 로그인
	 */
	public static void login(String id, int password) {
		
		LoginMemberInputDto member = memberService.loginMember(id, password);
	}

}
