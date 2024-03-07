package session;


public class Session {
	
	private long user_seq;
	private int Admin;
	
	public Session() {}

	public Session(long user_seq, int Admin) {
		super();
		this.user_seq = user_seq;
		this.Admin = Admin;
	}

	public long getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(long user_seq) {
		this.user_seq = user_seq;
	}

	public int getAdmin() {
		return Admin;
	}

	public void setAdmin(int Admin) {
		this.Admin = Admin;
	}
}
