package member.controller;

import book.service.BookService;
import member.dto.MemberDto.*;
import member.service.MemberService;
import view.EndView;

public class MemberController {
	static BookService bookService;
	static MemberService memberService;
	
	/**
	 * 회원가입
	 */
	public static void registerMember(RegisterMemberInputDto registermember) {
		memberService.RegisterMember(registermember);
		EndView.printMessage("회원가입이 완료되었습니다.");
	}
	
	/**
	 * 로그인
	 */
	public static void loginMember(LoginMemberInputDto login) {
		LoginMemberOutputDto loginResult = memberService.loginMember(login);
		EndView.printMessage("로그인이 완료되었습니다.");
	}
	
	/**
	 * 회원정보 수정(회원)
	 */
	public static void updateMemberInfoForMem(UpdateMemberInfoForMemInputDto updatemember) {
		memberService.UpdateMemberInfoForMem(updatemember);
	}
	
}
