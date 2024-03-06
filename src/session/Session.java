package session;


public class Session {
	LoginMemberOutputDto loginMember = new 
	
	private long user_seq;
	private long bookseq;
	private boolean isAdmin;
	
	public Session() {}

	public Session(long user_seq, long bookseq, boolean isAdmin) {
		super();
		this.user_seq = user_seq;
		this.bookseq = bookseq;
		this.isAdmin = isAdmin;
	}

	public long getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(long user_seq) {
		this.user_seq = user_seq;
	}

	public long getBookseq() {
		return bookseq;
	}

	public void setBookseq(long bookseq) {
		this.bookseq = bookseq;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
