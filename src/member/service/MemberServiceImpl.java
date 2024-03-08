package member.service;

import java.util.List;

import member.dao.MemberDAO;
import member.dto.MemberDto.*;
import view.EndView;

public class MemberServiceImpl implements MemberService {

	private final MemberDAO MemberDAO;

	public MemberServiceImpl(MemberDAO MemberDAO) {
		this.MemberDAO = MemberDAO;
	}

	// 회원가입
	public void RegisterMember(RegisterMemberInputDto registermember) {
		MemberDAO.registerMember(registermember);
	};

	// 로그인
	public LoginMemberOutputDto loginMember(LoginMemberInputDto loginmember) {
		LoginMemberOutputDto loginResult = MemberDAO.login(loginmember);
		
		return loginResult;
	};

	// 회원정보수정
	public void UpdateMemberInfoForMem(UpdateMemberInfoForMemInputDto updatemember) {
		MemberDAO.updateMemberInfo(updatemember);
		
	};

	// 회원정보조회
	public ViewMemberInfoOutputDto viewMemberInfoForMem(ViewMemberInfoInputDto viewmember) {
		return MemberDAO.viewMemberInfo(viewmember);
	};

	// 모든회원정보조회
	public ViewAllMembersInfoOutputDto viewAllMembersInfoByName(ViewAllMembersInfoInputDto viewallmember) {
		return null;
	};

	// 연체자조회
	public List<ViewOverdueMembersOutputDto> viewOverdueMembers(ViewOverdueMembersInputDto viewovermember) {
		return null;
	};

	public RestrictBookLoanOutputDto restrictBook(RestrictBookLoanInputDto restirct) {
		return null;
	};

	public void Logout() {
	};

	public FindUserEmailBynameAndTelOutputDto FindUserEmailBynameAndTel(FindUserEmailBynameAndTelInputDto userid) {
		return null;
	};

	public FindUserPasswordByEmailAndNameOutputDto FindUserPasswordByEmailAndName(
			FindUserPasswordByEmailAndNameInputDto userpassword) {
		return null;
	};

}
