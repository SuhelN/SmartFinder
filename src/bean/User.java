package bean;

import java.io.Serializable;

public class User implements Serializable
{
	int u_id, u_cno;
	String u_name, u_lname, u_fname,u_pwd,u_address,u_email;
	public User() {
		super();
	}
	public User(int u_id, int u_cno, String u_name, String u_lname, String u_fname, String u_pwd, String u_address,
			String u_email) {
		super();
		this.u_id = u_id;
		this.u_cno = u_cno;
		this.u_name = u_name;
		this.u_lname = u_lname;
		this.u_fname = u_fname;
		this.u_pwd = u_pwd;
		this.u_address = u_address;
		this.u_email = u_email;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getU_cno() {
		return u_cno;
	}
	public void setU_cno(int u_cno) {
		this.u_cno = u_cno;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_lname() {
		return u_lname;
	}
	public void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}
	public String getU_fname() {
		return u_fname;
	}
	public void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}
	public String getU_pwd() {
		return u_pwd;
	}
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_cno=" + u_cno + ", u_name=" + u_name + ", u_lname=" + u_lname + ", u_fname="
				+ u_fname + ", u_pwd=" + u_pwd + ", u_address=" + u_address + ", u_email=" + u_email + "]";
	}
	
	
	
}
