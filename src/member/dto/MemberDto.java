package member.dto;

import java.util.Date;

public class MemberDto {

	/**
	 * 회원가입을 위한 데이터
	 */
	public static class RegisterMemberInputDto {
		private String name;
		private String tel;
		private String addr;
		private String email;
		private String password;
		private String category;

		// Getters

		public String getName() {
			return name;
		}

		public String getTel() {
			return tel;
		}

		public String getAddr() {
			return addr;
		}

		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}

		public String getCategory() {
			return category;
		}

		// Setters

		public void setName(String name) {
			this.name = name;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public RegisterMemberInputDto() {
			super();
		}

		public RegisterMemberInputDto(String name, String tel, String addr, String email,
				String password, String category) {
			super();
			this.name = name;
			this.tel = tel;
			this.addr = addr;
			this.email = email;
			this.password = password;
			this.category = category;
		}
		
		

	}

	/**
	 * 회원 정보 수정을 위한 데이터(회원, 관리자)
	 */
	public static class UpdateMemberInfoForMemInputDto {
		private String name;
		private String tel;
		private String addr;
		private String email;
		private String password;
		private String category;
		private long user_seq;

		// Getters
		public String getName() {
			return name;
		}

		public String getTel() {
			return tel;
		}

		public String getAddr() {
			return addr;
		}

		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}

		public String getCategory() {
			return category;
		}

		public long getUser_seq() {
			return user_seq;
		}

		// Setters
		public void setName(String name) {
			this.name = name;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public void setUser_seq(long user_seq) {
			this.user_seq = user_seq;
		}

		public UpdateMemberInfoForMemInputDto() {
			super();
		}

		public UpdateMemberInfoForMemInputDto(String name, String tel, String addr, String email, String password,
				String category, long user_seq) {
			super();
			this.name = name;
			this.tel = tel;
			this.addr = addr;
			this.email = email;
			this.password = password;
			this.category = category;
			this.user_seq = user_seq;
		}
		
		
	}

	/**
	 * 해당 user_seq을 가진 회원 정보 조회를 위한 데이터(for 회원, 관리자)
	 */
	public static class ViewMemberInfoInputDto {
		private long userSeq;

		// Getter
		public long getUserSeq() {
			return userSeq;
		}

		// Setter
		public void setUserSeq(long userSeq) {
			this.userSeq = userSeq;
		}

		public ViewMemberInfoInputDto() {
			super();
		}

		public ViewMemberInfoInputDto(long userSeq) {
			super();
			this.userSeq = userSeq;
		}
		
		
	}

	public static class ViewMemberInfoOutputDto {
		private String name;
		private String tel;
		private String addr;
		private String email;
		private int password;
		private String category;

		// Getters
		public String getName() {
			return name;
		}

		public String getTel() {
			return tel;
		}

		public String getAddr() {
			return addr;
		}

		public String getEmail() {
			return email;
		}

		public int getPassword() {
			return password;
		}

		public String getCategory() {
			return category;
		}

		// Setters
		public void setName(String name) {
			this.name = name;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(int password) {
			this.password = password;
		}

		public void setCategory(String category) {
			this.category = category;
		}

	}

	/**
	 * 회원 정보를 전부 조회하기 위한 데이터(관리자)
	 */
	public static class ViewAllMembersInfoInputDto {
		private long userSeq;

		// Getter
		public long getUserSeq() {
			return userSeq;
		}

		// Setter
		public void setUserSeq(long userSeq) {
			this.userSeq = userSeq;
		}
	}

	public static class ViewAllMembersInfoOutputDto {
		private long userSeq;
		private String name;
		private String tel;
		private String addr;
		private String email;
		private int password;
		private String category;

		// Getters
		public long getUserSeq() {
			return userSeq;
		}

		public String getName() {
			return name;
		}

		public String getTel() {
			return tel;
		}

		public String getAddr() {
			return addr;
		}

		public String getEmail() {
			return email;
		}

		public int getPassword() {
			return password;
		}

		public String getCategory() {
			return category;
		}

		// Setters
		public void setName(String name) {
			this.name = name;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(int password) {
			this.password = password;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public void setUserSeq(long userSeq) {
			this.userSeq = userSeq;
		}

	}

	public static class ViewOverdueMembersInputDto {
		private long userSeq;
		
		// Getter

		public long getUserSeq() {
			return userSeq;
		}

		// Setter
		public void setUserSeq(long userSeq) {
			this.userSeq = userSeq;
		}
	}

	public static class ViewOverdueMembersOutputDto {
		private long userSeq;
		private String name;
		private String tel;
		private String addr;
		private String email;

		// Getters
		public long getUserSeq() {
			return userSeq;
		}

		public String getName() {
			return name;
		}

		public String getTel() {
			return tel;
		}

		public String getAddr() {
			return addr;
		}

		public String getEmail() {
			return email;
		}

		// Setters
		public void setUserSeq(long userSeq) {
			this.userSeq = userSeq;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	}

	public static class RestrictBookLoanInputDto {
		private long userSeq;

		// Getter
		public long getUserSeq() {
			return userSeq;
		}

		// Setter
		public void setUserSeq(long userSeq) {
			this.userSeq = userSeq;
		}
	}

	public static class RestrictBookLoanOutputDto {
		private int restrictDate;

		// Getter
		public int getRestrictDate() {
			return restrictDate;
		}

		// Setter
		public void setRestrictDate(int restrictDate) {
			this.restrictDate = restrictDate;
		}
	}

	/**
	 * 로그인
	 */
	public static class LoginMemberInputDto {
		private String id;
		private int password;

		// Getters
		public String getId() {
			return id;
		}

		public int getPassword() {
			return password;
		}

		// Setters
		public void setId(String id) {
			this.id = id;
		}

		public void setPassword(int password) {
			this.password = password;
		}

		public LoginMemberInputDto() {
			super();
		}

		public LoginMemberInputDto(String id, int password) {
			super();
			this.id = id;
			this.password = password;
		}
		
		
	}

	public static class LoginMemberOutputDto {
		private long userSeq;
		private int isAdmin;

		// Getters
		public long getUserSeq() {
			return userSeq;
		}

		public int getAdmin() {
			return isAdmin;
		}

		// Setters
		public void setUserSeq(long userSeq) {
			this.userSeq = userSeq;
		}

		public void setAdmin(int isAdmin) {
			this.isAdmin = isAdmin;
		}

	}

	public static class FindUserEmailBynameAndTelInputDto {
		private String name;
		private String tel;

		// Getters
		public String getName() {
			return name;
		}

		public String getTel() {
			return tel;
		}

		// Setters
		public void setName(String name) {
			this.name = name;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public FindUserEmailBynameAndTelInputDto() {
			super();
		}

		public FindUserEmailBynameAndTelInputDto(String name, String tel) {
			super();
			this.name = name;
			this.tel = tel;
		}
		
	}

	public static class FindUserEmailBynameAndTelOutputDto {
		private String email;

		// Getter
		public String getEmail() {
			return email;
		}

		// Setter
		public void setEmail(String email) {
			this.email = email;
		}
	}

	public static class FindUserPasswordByEmailAndNameInputDto {
		private String email;
		private String name;

		// Getters
		public String getEmail() {
			return email;
		}

		public String getName() {
			return name;
		}

		// Setters
		public void setEmail(String email) {
			this.email = email;
		}

		public void setName(String name) {
			this.name = name;
		}

		public FindUserPasswordByEmailAndNameInputDto() {
			super();
		}

		public FindUserPasswordByEmailAndNameInputDto(String email, String name) {
			super();
			this.email = email;
			this.name = name;
		}
		
	}

	public static class FindUserPasswordByEmailAndNameOutputDto {
		private int password;

		// Getter
		public int getPassword() {
			return password;
		}

		// Setter
		public void setPassword(int password) {
			this.password = password;
		}
	}
}
