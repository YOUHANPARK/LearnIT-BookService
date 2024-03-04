package member.service;

import member.dto.MemberDto.FidnUserEmailBynameAndTelInput;
import member.dto.MemberDto.FidnUserEmailBynameAndTelOutput;
import member.dto.MemberDto.FindUserPasswordByEmailAndNameInput;
import member.dto.MemberDto.FindUserPasswordByEmailAndNameOutput;
import member.dto.MemberDto.LoginMemberInput;
import member.dto.MemberDto.LoginMemberOutput;
import member.dto.MemberDto.LogoutInput;
import member.dto.MemberDto.LogoutOutput;
import member.dto.MemberDto.RegisterMemberInput;
import member.dto.MemberDto.RegisterMemberOutput;
import member.dto.MemberDto.RestrictBookInput;
import member.dto.MemberDto.RestrictBookOutput;
import member.dto.MemberDto.UpdateMemberInfoForMemInput;
import member.dto.MemberDto.UpdateMemberInfoForMemOutput;
import member.dto.MemberDto.ViewAllMembersInfoByNameInput;
import member.dto.MemberDto.ViewAllMembersInfoByNameOutput;
import member.dto.MemberDto.ViewMemberInfoForMemInput;
import member.dto.MemberDto.ViewMemberInfoForMemOutput;
import member.dto.MemberDto.ViewOverdueMembersInput;
import member.dto.MemberDto.ViewOverdueMembersOutput;

public interface MemberService {
	
	RegisterMemberOutput register(RegisterMemberInput registermember );
	
	
	UpdateMemberInfoForMemOutput updateMemInfo(UpdateMemberInfoForMemInput updatemember );
	
	
	ViewMemberInfoForMemOutput viewMemInfo(ViewMemberInfoForMemInput viewmember);
	
	
	ViewAllMembersInfoByNameOutput viewAllMem(ViewAllMembersInfoByNameInput viewallmember);
	
	
	ViewOverdueMembersOutput viewOverMem(ViewOverdueMembersInput viewovermember);
	
	
	RestrictBookOutput restirctBook(RestrictBookInput restirct);
	
	
	LoginMemberOutput loginMem(LoginMemberInput login);
	
	
	LogoutOutput logoutMem(LogoutInput logout);
	
	
	FidnUserEmailBynameAndTelOutput findUserID(FidnUserEmailBynameAndTelInput userid);
	
	
	FindUserPasswordByEmailAndNameOutput findUserPassword(FindUserPasswordByEmailAndNameInput userpassword);
	
	
	
	
}
