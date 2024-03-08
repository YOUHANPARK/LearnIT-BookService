package member.dao;

import java.sql.SQLException;
import java.util.List;
import member.dto.MemberDto.*;
import java.util.List;

public interface MemberDAO {

	// 회원 가입
	void registerMember(RegisterMemberInputDto member);

	// 회원 정보 수정
	void updateMemberInfo(UpdateMemberInfoForMemInputDto member);

	// 특정 회원 정보 조회
	ViewMemberInfoOutputDto viewMemberInfo(ViewMemberInfoInputDto ip);

	// 모든 회원 정보 조회 (관리자용)
	List<ViewAllMembersInfoOutputDto> viewAllMembersInfo();
	
	//관리자 여부 확인
	boolean isAdmin(long userSeq);
	
	// 연체자 조회
	public List<ViewOverdueMembersOutputDto> viewOverdueMembers(ViewOverdueMembersInputDto viewovermember);

	// 도서 연체 제한 설정
	void restrictBook(RestrictBookLoanInputDto restriction);

	// 로그인
	LoginMemberOutputDto login(LoginMemberInputDto loginInfo);

	// ID 찾기
	FindUserEmailBynameAndTelInputDto findUserEmailByNameAndTel(FindUserEmailBynameAndTelInputDto userInfo);

	// 비밀번호 찾기
	FindUserPasswordByEmailAndNameOutputDto findUserPasswordByEmailAndName(FindUserPasswordByEmailAndNameInputDto userInfo);
}
