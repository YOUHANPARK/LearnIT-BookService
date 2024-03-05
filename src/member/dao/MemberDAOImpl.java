package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import config.AppConfig.DBUtil;
import member.dto.MemberDto.FindUserEmailBynameAndTelInputDto;
import member.dto.MemberDto.FindUserPasswordByEmailAndNameInputDto;
import member.dto.MemberDto.FindUserPasswordByEmailAndNameOutputDto;
import member.dto.MemberDto.LoginMemberInputDto;
import member.dto.MemberDto.LoginMemberOutputDto;
import member.dto.MemberDto.RegisterMemberInputDto;
import member.dto.MemberDto.RestrictBookLoanInputDto;
import member.dto.MemberDto.UpdateMemberInfoForMemInputDto;
import member.dto.MemberDto.ViewAllMembersInfoInputDto;
import member.dto.MemberDto.ViewMemberInfoOutputDto;
import member.dto.MemberDto.ViewOverdueMembersOutputDto;

public class MemberDAOImpl implements MemberDAO {
	public static void main(String[] args) {
		 MemberDAOImpl memberDAO = new MemberDAOImpl();
		    
		    RegisterMemberInputDto newMember = new RegisterMemberInputDto();
		    newMember.setName("bear");
		    newMember.setTel("010-1234-5678"); 
		    newMember.setAddr("Seoul, Korea");
		    newMember.setEmail("bear@example.com");
		    newMember.setPassword("bear");
		    
		    memberDAO.registerMember(newMember);
		    
		    System.out.println("회원가입이 완료되었습니다.");
	}
	// 회원 가입
	@Override
	public void registerMember(RegisterMemberInputDto member) {
		String sql = "INSERT INTO 회원 (NAME, TEL, ADDR, EMAIL, PASSWORD, JOIN_DATE, STATE) "
	               + "VALUES (?, ?, ?, ?, ?, SYSDATE, ?)";
	    
	    try (Connection conn = DBUtil.getConnection(); 
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, member.getName());
	        pstmt.setString(2, member.getTel()); 
	        pstmt.setString(3, member.getAddr());
	        pstmt.setString(4, member.getEmail());
	        pstmt.setString(5, member.getPassword());
	        pstmt.setString(6, "ACTIVE"); // STATE, 예를 들어 'ACTIVE'로 설정

	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// 회원 정보 수정
	@Override
	public void updateMemberInfo(UpdateMemberInfoForMemInputDto member) {

	};

	// 특정 회원 정보 조회
	@Override
	public ViewMemberInfoOutputDto viewMemberInfo(long userSeq) {
		return null;
	};

	// 모든 회원 정보 조회 (관리자용)
	@Override
	public List<ViewAllMembersInfoInputDto> viewAllMembersInfo(){
		return null;};

	// 연체자 조회
	@Override
	public List<ViewOverdueMembersOutputDto> viewOverdueMembers() {
		return null;
	};

	// 도서 연체 제한 설정
	@Override
	public void restrictBook(RestrictBookLoanInputDto restriction) {
	};

	// 로그인
	@Override
	public LoginMemberOutputDto login(LoginMemberInputDto loginInfo) {
		return null;
	};

	// ID 찾기
	@Override
	public FindUserEmailBynameAndTelInputDto findUserEmailByNameAndTel(FindUserEmailBynameAndTelInputDto userInfo){
		return userInfo;};

	// 비밀번호 찾기
	@Override
	public FindUserPasswordByEmailAndNameOutputDto findUserPasswordByEmailAndName(FindUserPasswordByEmailAndNameInputDto userInfo) {
		return null;
	};

}
