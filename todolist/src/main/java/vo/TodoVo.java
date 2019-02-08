package vo;

import java.sql.Date;

public class TodoVo {
	private int userid;
	private Date date;
	private String todo;
	private boolean done;
	
	public TodoVo(){}
	
	public TodoVo(int userid, Date date, String todo, boolean done) {
		this.userid = userid;
		this.date = date;
		this.todo = todo;
		this.done = done;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	public boolean getDone() {
		return done;
	}

	public String toString() {
		return "TodoVo [userid=" + userid + ", date=" + date + ", todo=" + todo + ", done=" + done + "]";
	}
	
}
