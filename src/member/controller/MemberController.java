package member.controller;

import book.service.BookService;
//<<<<<<< HEAD
import config.AppConfig;
//=======
import member.dto.MemberDto.FindUserEmailBynameAndTelInputDto;
import member.dto.MemberDto.FindUserPasswordByEmailAndNameInputDto;
import member.dto.MemberDto.LoginMemberInputDto;
import member.dto.MemberDto.LoginMemberOutputDto;
import member.dto.MemberDto.RegisterMemberInputDto;
import member.dto.MemberDto.UpdateMemberInfoForMemInputDto;
import member.dto.MemberDto.ViewMemberInfoInputDto;
import member.dto.MemberDto.ViewMemberInfoOutputDto;
import member.service.MemberService;
import session.Session;
import view.EndView;
//>>>>>>> 95586a2b9e4bc747e9d5b51c586d7ece2aca0efd

public class MemberController {
	BookService bookService = AppConfig.getInstance().getBookService();
	static MemberService memberService = AppConfig.getInstance().getMemberService();
	
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
//<<<<<<< HEAD
	public static Session login(String id, String password) {
		
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
		ViewMemberInfoOutputDto op = memberService.viewMemberInfoForMem(new ViewMemberInfoInputDto(userseq));
		System.out.println("회원님의 정보는 다음과 같습니다.");
		System.out.println(op);
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
//=======
	public static void loginMember(LoginMemberInputDto login) {
		LoginMemberOutputDto loginResult = memberService.loginMember(login);
		EndView.printMessage("로그인이 완료되었습니다.");
	}
	
	/**
	 * 회원정보 수정(회원)
	 */
	/*
	public static void updateMemberInfoForMem(UpdateMemberInfoForMemInputDto updatemember) {
		memberService.UpdateMemberInfoForMem(updatemember);
	}*/
	
//>>>>>>> 95586a2b9e4bc747e9d5b51c586d7ece2aca0efd
}
