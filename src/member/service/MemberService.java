package member.service;

import member.dto.MemberDto.FidnUserEmailBynameAndTelInputDto;
import member.dto.MemberDto.FidnUserEmailBynameAndTelOutputDto;
import member.dto.MemberDto.FindUserPasswordByEmailAndNameInputDto;
import member.dto.MemberDto.FindUserPasswordByEmailAndNameOutputDto;
import member.dto.MemberDto.LoginMemberInputDto;
import member.dto.MemberDto.LoginMemberOutputDto;
import member.dto.MemberDto.RegisterMemberInputDto;
import member.dto.MemberDto.RestrictBookInputDto;
import member.dto.MemberDto.RestrictBookOutputDto;
import member.dto.MemberDto.UpdateMemberInfoForMemInputDto;
import member.dto.MemberDto.ViewAllMembersInfoByNameInputDto;
import member.dto.MemberDto.ViewAllMembersInfoByNameOutputDto;
import member.dto.MemberDto.ViewMemberInfoForMemInputDto;
import member.dto.MemberDto.ViewMemberInfoForMemOutputDto;
import member.dto.MemberDto.ViewOverdueMembersInputDto;
import member.dto.MemberDto.ViewOverdueMembersOutputDto;

public interface MemberService {
	
	void RegisterMember(RegisterMemberInputDto registermember );
	
	
	void UpdateMemberInfoForMem(UpdateMemberInfoForMemInputDto updatemember );
	
	
	ViewMemberInfoForMemOutputDto viewMemberInfoForMem(ViewMemberInfoForMemInputDto viewmember);
	
	
	ViewAllMembersInfoByNameOutputDto viewAllMembersInfoByName(ViewAllMembersInfoByNameInputDto viewallmember);
	
	
	ViewOverdueMembersOutputDto viewOverdueMembers(ViewOverdueMembersInputDto viewovermember);
	
	
	RestrictBookOutputDto restrictBook(RestrictBookInputDto restirct);
	
	
	LoginMemberOutputDto loginMember(LoginMemberInputDto login);
	
	
	void Logout();
	
	
	FidnUserEmailBynameAndTelOutputDto FidnUserEmailBynameAndTel(FidnUserEmailBynameAndTelInputDto userid);
	
	
	FindUserPasswordByEmailAndNameOutputDto FindUserPasswordByEmailAndName(FindUserPasswordByEmailAndNameInputDto userpassword);
		
	
}
