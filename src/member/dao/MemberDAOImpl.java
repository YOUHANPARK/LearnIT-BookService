package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import member.dto.MemberDto.ViewAllMembersInfoOutputDto;
import member.dto.MemberDto.ViewMemberInfoInputDto;
import member.dto.MemberDto.ViewMemberInfoOutputDto;
import member.dto.MemberDto.ViewOverdueMembersInputDto;
import member.dto.MemberDto.ViewOverdueMembersOutputDto;

public class MemberDAOImpl implements MemberDAO {
	public static void main(String[] args) {
		MemberDAOImpl memberDAO = new MemberDAOImpl();

//		  //회원 정보 수정 예시
//		    UpdateMemberInfoForMemInputDto updateInfo = new UpdateMemberInfoForMemInputDto();
//		    updateInfo.setUser_seq(22L); // 가정: user_seq가 1인 회원
//		    updateInfo.setName("Updated Name");
//		    updateInfo.setTel("010-9999-8888");
//		    updateInfo.setAddr("Updated Address");
//		    updateInfo.setEmail("updated@example.com");
//		    updateInfo.setPassword(123456);
//		    updateInfo.setCategory(null);
//		    memberDAO.updateMemberInfo(updateInfo);
//		    System.out.println("회원 정보 수정이 완료되었습니다.");

//		// 특정 회원 정보 조회 예시
//		long userSeqToFind = 22L; // 조회하고자 하는 회원의 고유 번호(userSeq)
//		ViewMemberInfoOutputDto memberInfo = memberDAO.viewMemberInfo(userSeqToFind);
//
//		if (memberInfo != null) {
//			System.out.println("회원 정보 조회 결과:");
//			System.out.println("이름: " + memberInfo.getName());
//			System.out.println("전화번호: " + memberInfo.getTel());
//			System.out.println("주소: " + memberInfo.getAddr());
//			System.out.println("이메일: " + memberInfo.getEmail());
//			System.out.println("카테고리: " + memberInfo.getCategory());
//		} else {
//			System.out.println("회원 정보를 찾을 수 없습니다.");
//		}

//		List<ViewAllMembersInfoOutputDto> allMembers = memberDAO.viewAllMembersInfo();
//	    
//	    if (!allMembers.isEmpty()) {
//	        System.out.println("모든 회원 정보 조회 결과:");
//	        for (ViewAllMembersInfoOutputDto memberInfo : allMembers) {
//	            System.out.println("회원 고유 번호: " + memberInfo.getUserSeq());
//	            System.out.println("이름: " + memberInfo.getName());
//	            System.out.println("전화번호: " + memberInfo.getTel());
//	            System.out.println("주소: " + memberInfo.getAddr());
//	            System.out.println("이메일: " + memberInfo.getEmail());
//	            System.out.println("카테고리: " + memberInfo.getCategory());
//	            System.out.println("-----------------------------------");
//	        }
//	    } else {
//	        System.out.println("등록된 회원 정보가 없습니다.");
//	    }

//		// 연체자 조회 기능 확인(잘 안 됨)
//		List<ViewOverdueMembersOutputDto> overdueMembers = memberDAO
//				.viewOverdueMembers(new ViewOverdueMembersInputDto());
		
		
}

		
	// 회원 가입
	@Override
	public void registerMember(RegisterMemberInputDto member) {
		String sql = "INSERT INTO 회원 (NAME, TEL, ADDR, EMAIL, PASSWORD, JOIN_DATE, STATE, CATEGORY) "
				+ "VALUES (?, ?, ?, ?, ?, SYSDATE, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getTel());
			pstmt.setString(3, member.getAddr());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPassword());
			pstmt.setString(6, "ACTIVE");
			pstmt.setString(7, member.getCategory());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원 정보 수정
	@Override
	public void updateMemberInfo(UpdateMemberInfoForMemInputDto member) {
		String sql = "UPDATE 회원 SET NAME=?, TEL=?, ADDR=?, EMAIL=?, PASSWORD=?, CATEGORY=? WHERE USER_SEQ=?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getTel());
			pstmt.setString(3, member.getAddr());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPassword());
			pstmt.setString(6, member.getCategory());
			pstmt.setLong(7, member.getUser_seq());
			int affectedRows = pstmt.executeUpdate();
			System.out.println("Updated rows: " + affectedRows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	};

	// 특정 회원 정보 조회
	@Override
	public ViewMemberInfoOutputDto viewMemberInfo(ViewMemberInfoInputDto ip) {
		String sql = "SELECT NAME, TEL, ADDR, EMAIL, PASSWORD, CATEGORY FROM 회원 WHERE USER_SEQ = ?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setLong(1, ip.getUserSeq());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ViewMemberInfoOutputDto memberInfo = new ViewMemberInfoOutputDto();
					memberInfo.setName(rs.getString("NAME"));
					memberInfo.setTel(rs.getString("TEL"));
					memberInfo.setAddr(rs.getString("ADDR"));
					memberInfo.setEmail(rs.getString("EMAIL"));
					// 비밀번호는 일반적으로 조회 결과로 반환하지 않으므로 생략
					memberInfo.setCategory(rs.getString("CATEGORY"));
					return memberInfo;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	};

	// 모든 회원 정보 조회 (관리자용)
	@Override
	public List<ViewAllMembersInfoOutputDto> viewAllMembersInfo() {
		List<ViewAllMembersInfoOutputDto> membersList = new ArrayList<>();
		String sql = "SELECT USER_SEQ, NAME, TEL, ADDR, EMAIL, CATEGORY FROM 회원";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				ViewAllMembersInfoOutputDto memberInfo = new ViewAllMembersInfoOutputDto();
				memberInfo.setUserSeq(rs.getLong("USER_SEQ"));
				memberInfo.setName(rs.getString("NAME"));
				memberInfo.setTel(rs.getString("TEL"));
				memberInfo.setAddr(rs.getString("ADDR"));
				memberInfo.setEmail(rs.getString("EMAIL"));
				memberInfo.setCategory(rs.getString("CATEGORY"));
				membersList.add(memberInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return membersList;
	};

	// 관리자 여부 확인
	@Override
	public boolean isAdmin(long userSeq) {
		return false;
	};

	// 연체자 조회
	@Override
	public List<ViewOverdueMembersOutputDto> viewOverdueMembers(ViewOverdueMembersInputDto viewOvermember) {
		List<ViewOverdueMembersOutputDto> overdueMembersList = new ArrayList<>();

		String sql = "SELECT ds.expectedreturn_date , d.user_seq , u.name , b.book_title\r\n"
				+ "FROM 대여상세 ds , 대여 d , 회원 u , 책 b\r\n"
				+ "WHERE (((ds.expectedreturn_date <= TO_DATE('2024.03.06','YYYY.MM.DD')\r\n"
				+ "AND d.borrow_seq = ds.borrow_seq) AND d.user_seq = u.user_seq)\r\n"
				+ "AND b.book_seq = ds.book_seq)\r\n" + "AND b.loan_possible = 0";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				ViewOverdueMembersOutputDto overdueMemberInfo = new ViewOverdueMembersOutputDto();
				overdueMemberInfo.setUserSeq(rs.getLong("USER_SEQ"));

				overdueMembersList.add(overdueMemberInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return overdueMembersList;
	};

	// 도서 연체 제한 설정
	@Override
	public void restrictBook(RestrictBookLoanInputDto restriction) {
	};

	// 로그인
	@Override
	public LoginMemberOutputDto login(LoginMemberInputDto loginInfo) {
		try {
			String sql = "SELECT USER_SEQ, NAME,IS_ADMIN FROM 회원 WHERE EMAIL = ? AND PASSWORD = ?";
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginInfo.getEmail());
			pstmt.setString(2, loginInfo.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				LoginMemberOutputDto member = new LoginMemberOutputDto();
				member.setUserSeq(rs.getLong("USER_SEQ"));
				member.setName(rs.getString("NAME"));
				member.setAdmin(rs.getInt("IS_ADMIN"));
				
				return member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	};

	// ID 찾기
	@Override
	public FindUserEmailBynameAndTelInputDto findUserEmailByNameAndTel(FindUserEmailBynameAndTelInputDto userInfo) {
		return userInfo;
	};

	// 비밀번호 찾기
	@Override
	public FindUserPasswordByEmailAndNameOutputDto findUserPasswordByEmailAndName(
			FindUserPasswordByEmailAndNameInputDto userInfo) {
		return null;
	};

}
