package member.dto;

import java.util.Date;

public class MemberDto {
	
	/**
	 * 회원가입 Input
	 */
	public static class RegisterMemberInputDto{
		String name;
		String tel;
		String addr;
		String email;
		int password;
		String category;	
	}
	
	
	
	/**
	 * 회원정보수정(회원, 관리자) Input
	 */
	public static class UpdateMemberInfoForMemInputDto{	
		String name;
		String tel;
		String addr;
		String email;
		int password;
		String category;
		long user_seq;	
	}
	
	
	
	
	/**
	 * 회원정보조회(회원, 관리자) Input
	 */
	public static class ViewMemberInfoForMemInputDto{
		long userSeq;	
	}
	/**
	 * 회원정보조회(회원, 관리자) output
	 */
	public static class ViewMemberInfoForMemOutputDto{
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
	public static class ViewAllMembersInfoByNameInputDto{
		long userSeq;
	}
	/**
	 * 회원정보모두조회(관리자) output
	 */
	public static class ViewAllMembersInfoByNameOutputDto{
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
	public static class ViewOverdueMembersInputDto{
		long userSeq;
	}
	/**
	 * 연체자조회 Output
	 */
	public static class ViewOverdueMembersOutputDto{
		String name;
		String tel;
		String addr;
		String email;
	}
	
	
	/**
	 * 도서제한 Input
	 */
	public static class RestrictBookInputDto{
		long userSeq;
	}
	/**
	 * 도서제한 Output
	 */
	public static class RestrictBookOutputDto{
		int restrictDate;
	}
	
	
	/**
	 * 로그인 Input
	 */
	public static class LoginMemberInputDto{
		String id;
		int password;
	}
	/**
	 * 로그인 Output
	 */
	public static class LoginMemberOutputDto{
		long userSeq;
		boolean isAdmin;		
	}

	
	
	/**
	 * ID찾기 Input
	 */
	public static class FidnUserEmailBynameAndTelInputDto{
		String name;
		String tel;
	}
	/**
	 * ID찾기 Output
	 */
	public static class FidnUserEmailBynameAndTelOutputDto{
		String email;
	}
	
	
	
	/**
	 * Password찾기 Input
	 */
	public static class FindUserPasswordByEmailAndNameInputDto{
		String email;
		String name;
	}
	/**
	 * Password찾기 Output
	 */
	public static class FindUserPasswordByEmailAndNameOutputDto{
		int password;
	}
}
