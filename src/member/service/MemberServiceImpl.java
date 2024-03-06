package member.service;

import member.dto.MemberDto.FindUserEmailBynameAndTelInputDto;
import member.dto.MemberDto.FindUserEmailBynameAndTelOutputDto;
import member.dto.MemberDto.FindUserPasswordByEmailAndNameInputDto;
import member.dto.MemberDto.FindUserPasswordByEmailAndNameOutputDto;
import member.dto.MemberDto.LoginMemberInputDto;
import member.dto.MemberDto.LoginMemberOutputDto;
import member.dto.MemberDto.RegisterMemberInputDto;
import member.dto.MemberDto.RestrictBookLoanInputDto;
import member.dto.MemberDto.RestrictBookLoanOutputDto;
import member.dto.MemberDto.UpdateMemberInfoForMemInputDto;
import member.dto.MemberDto.ViewAllMembersInfoInputDto;
import member.dto.MemberDto.ViewAllMembersInfoOutputDto;
import member.dto.MemberDto.ViewMemberInfoInputDto;
import member.dto.MemberDto.ViewMemberInfoOutputDto;
import member.dto.MemberDto.ViewOverdueMembersInputDto;
import member.dto.MemberDto.ViewOverdueMembersOutputDto;

public class MemberServiceImpl implements MemberService {
	
	
	public void RegisterMember(RegisterMemberInputDto registermember) {
		
	};

	public void UpdateMemberInfoForMem(UpdateMemberInfoForMemInputDto updatemember ) {};
	
	
	public ViewMemberInfoOutputDto viewMemberInfoForMem(ViewMemberInfoInputDto viewmember) {
		return null;};
	
	
	public ViewAllMembersInfoOutputDto viewAllMembersInfoByName(ViewAllMembersInfoInputDto viewallmember) {
		return null;};
	
	
	public ViewOverdueMembersOutputDto viewOverdueMembers(ViewOverdueMembersInputDto viewovermember) {
		return null;};
	
	
	public RestrictBookLoanOutputDto restrictBook(RestrictBookLoanInputDto restirct) {
		return null;};
	
	
	public LoginMemberOutputDto loginMember(LoginMemberInputDto login) {
		return null;};
	
	
	public void Logout() {};
	
	
	public FindUserEmailBynameAndTelOutputDto FindUserEmailBynameAndTel(FindUserEmailBynameAndTelInputDto userid) {
		return null;};
	
	
	public FindUserPasswordByEmailAndNameOutputDto FindUserPasswordByEmailAndName(FindUserPasswordByEmailAndNameInputDto userpassword) {
		return null;};

}
