package member.service;

import member.dto.MemberDto.*;

public interface MemberService {
	/**
	 * 회원가입
	 * 회원의 정보를 받아 db에 저장하는 api
	 * @param registermember
	 */
	void RegisterMember(RegisterMemberInputDto registermember );
	
	/**
	 * 회원정보 수정(회원)
	 * 로그인한 회원이 자신의 회원정보(이름 / 전화번호 / 주소 / 이메일 / 비밀번호)를 수정하는 api
	 * @param updatemember
	 */
	void UpdateMemberInfoForMem(UpdateMemberInfoForMemInputDto updatemember );
	
	/**
	 * 회원정보 조회
	 * user_seq으로 db에 저장된 회원정보를 출력하는 api
	 * @param viewmember
	 * @return
	 */
	ViewMemberInfoOutputDto viewMemberInfoForMem(ViewMemberInfoInputDto viewmember);
	
	/**
	 * 회원정보 모두 조회(관리자)
	 * 모든 회원의 회원정보를 출력하는 api
	 * @param viewallmember
	 * @return
	 */
	ViewAllMembersInfoOutputDto viewAllMembersInfoByName(ViewAllMembersInfoInputDto viewallmember);
	
	/**
	 * 연체자 조회
	 * 관리자가 연체자 목록을 조회하는 api
	 * @param viewovermember
	 * @return
	 */
	ViewOverdueMembersOutputDto viewOverdueMembers(ViewOverdueMembersInputDto viewovermember);
	
	/**
	 * 도서 연체 제한 
	 * 저장된 연체자 정보를 받아 도서 대여를 연체일*2만큼 제한을 두는 api
	 * @param restirct
	 * @return
	 */
	RestrictBookLoanOutputDto restrictBook(RestrictBookLoanInputDto restirct);
	
	/**
	 * 로그인
	 * 아이디/비밀번호가 회원db의 정보와 일치하면 로그인하는 api
	 * @param login
	 * @return
	 */
	LoginMemberOutputDto loginMember(LoginMemberInputDto login);
	
	/**
	 * 로그아웃
	 * 로그아웃을 선언하는 api
	 */
	void Logout();
	
	/**
	 * id찾기
	 * 등록한 email을 반환하는 api
	 * @param userid
	 * @return
	 */
	FindUserEmailBynameAndTelOutputDto FindUserEmailBynameAndTel(FindUserEmailBynameAndTelInputDto userid);
	
	/**
	 * password찾기
	 * email과 이름으로 password를 찾는 api
	 * @param userpassword
	 * @return
	 */
	FindUserPasswordByEmailAndNameOutputDto FindUserPasswordByEmailAndName(FindUserPasswordByEmailAndNameInputDto userpassword);
		
	

	}
