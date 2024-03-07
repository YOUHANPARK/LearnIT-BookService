package member.controller;

import book.service.BookService;
import config.AppConfig;
import member.dto.MemberDto.FindUserEmailBynameAndTelInputDto;
import member.dto.MemberDto.FindUserPasswordByEmailAndNameInputDto;
import member.dto.MemberDto.LoginMemberInputDto;
import member.dto.MemberDto.LoginMemberOutputDto;
import member.dto.MemberDto.RegisterMemberInputDto;
import member.dto.MemberDto.UpdateMemberInfoForMemInputDto;
import member.dto.MemberDto.ViewMemberInfoInputDto;
import member.service.MemberService;
import session.Session;

public class MemberController {
	BookService bookService = AppConfig.getInstance().getBookService();
	static MemberService memberService = AppConfig.getInstance().getMemberService();
	
	/**
	 * 로그인
	 */
	public static Session login(String id, int password) {
		
		//LoginMemberInputDto member = memberService.loginMember(id, password);
		LoginMemberOutputDto member = memberService.loginMember(new LoginMemberInputDto(id,password));
		
		Session session = new Session(member.getUserSeq(),member.getAdmin());
		
		return session;
	}
	
	/**
	 * 회원가입
	 */
	public static void registermem(String name, String tel, String addr, String email, String password, String category) {
		memberService.RegisterMember(new RegisterMemberInputDto(name,tel,addr,email,password,category));
	}
	
	/**
	 * 회원정보 조회
	 */
	public static void viewmeminfo(long userseq) {
		memberService.viewMemberInfoForMem(new ViewMemberInfoInputDto(userseq));
	}
	
	/**
	 * 회원정보 수정
	 */
	public static void updatememinfo(String name,String tel,String addr,String email,String password,String category,long userseq) {
		memberService.UpdateMemberInfoForMem(new UpdateMemberInfoForMemInputDto(name,tel,addr,email,password,category,userseq));	
	}
	/**
	 * ID찾기
	 */
	public static void findUserEmail(String name, String tel) {
		memberService.FindUserEmailBynameAndTel(new FindUserEmailBynameAndTelInputDto(name,tel));
	}
	/**
	 * 비밀번호 찾기
	 */
	public static void findPassword(String email, String name) {
		memberService.FindUserPasswordByEmailAndName(new FindUserPasswordByEmailAndNameInputDto(email,name));
	}
}
