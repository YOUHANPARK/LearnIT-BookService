package member.dto;

import java.util.Date;

public class MemberDto {
	
	/**
	 * 회원가입 Input
	 */
	public static class RegisterMemberInput{
		String name;
		String tel;
		String addr;
		String email;
		int password;
		String category;	
	}
	/**
	 * 회원가입 output
	 */
	public static class RegisterMemberOutput{
		
	}
	
	
	
	/**
	 * 회원정보수정(회원, 관리자) Input
	 */
	public static class UpdateMemberInfoForMemInput{	
		String name;
		String tel;
		String addr;
		String email;
		int password;
		String category;
		long user_seq;	
	}
	/**
	 * 회원정보수정(회원, 관리자) output
	 */
	public static class UpdateMemberInfoForMemOutput{		
		
	}
	
	
	
	/**
	 * 회원정보조회(회원, 관리자) Input
	 */
	public static class ViewMemberInfoForMemInput{
		long userSeq;	
	}
	/**
	 * 회원정보조회(회원, 관리자) output
	 */
	public static class ViewMemberInfoForMemOutput{
		String name;
		String tel;
		String addr;
		String email;
		int password;
		String category;	
	}
	
	
	/**
	 * 회원정보모두조회(관리자) input
	 */
	public static class ViewAllMembersInfoByNameInput{
		long userSeq;
	}
	/**
	 * 회원정보모두조회(관리자) output
	 */
	public static class ViewAllMembersInfoByNameOutput{
		String name;
		String tel;
		String addr;
		String email;
		Date registerDate;
		long userSeq;
	}
	
	
	/**
	 * 연체자조회 Input
	 */
	public static class ViewOverdueMembersInput{
		long userSeq;
	}
	/**
	 * 연체자조회 Output
	 */
	public static class ViewOverdueMembersOutput{
		String name;
		String tel;
		String addr;
		String email;
	}
	
	
	/**
	 * 도서제한 Input
	 */
	public static class RestrictBookInput{
		long userSeq;
	}
	/**
	 * 도서제한 Output
	 */
	public static class RestrictBookOutput{
		int restrictDate;
	}
	
	
	/**
	 * 로그인 Input
	 */
	public static class LoginMemberInput{
		String id;
		int password;
	}
	/**
	 * 로그인 Output
	 */
	public static class LoginMemberOutput{
		long userSeq;
		boolean isAdmin;		
	}
	
	
	/**
	 * 로그아웃 Input
	 */
	public static class LogoutInput{
		
	}
	/**
	 * 로그아웃 Output
	 */
	public static class LogoutOutput{
		
	}
	
	
	/**
	 * ID찾기 Input
	 */
	public static class FidnUserEmailBynameAndTelInput{
		String name;
		String tel;
	}
	/**
	 * ID찾기 Output
	 */
	public static class FidnUserEmailBynameAndTelOutput{
		String email;
	}
	
	
	
	/**
	 * Password찾기 Input
	 */
	public static class FindUserPasswordByEmailAndNameInput{
		String email;
		String name;
	}
	/**
	 * Password찾기 Output
	 */
	public static class FindUserPasswordByEmailAndNameOutput{
		int password;
	}
}
