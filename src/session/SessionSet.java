package session;

import java.util.HashSet;
import java.util.Set;

public class SessionSet {
	private static SessionSet ss = new SessionSet();
	private Set<Session> set;
	
	private SessionSet() {
		set = new HashSet<Session>();
	}
	
	public static SessionSet getInstance() {
		return ss;
	}
	
	//세션 객체들 반환
	public Set<Session> getSet(){
			return set;
	}
			
	/**
	 * 로그인 된 사용자 추가
	 * */
	public void add(Session session) {
		set.add(session);
	}
	
	/**
	 * 사용자 제거 - 로그아웃
	 * */
	public void remove(Session session) {
		set.remove(session);
	}
}
