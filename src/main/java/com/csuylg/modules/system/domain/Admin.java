package com.csuylg.modules.system.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 管理员表构建
 *
 * @author dyf
 */
@Table(name="admin")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 管理员ID
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
	private Integer adminId;

	/**
	 * 用户账号
	 */
    @Column(name = "user_name")
	private String userName;

	/**
	 * 密码
	 */
    @Column(name = "password")
	private String password;

	public Admin(String userName) {
		this.userName = userName;
	}

	public Admin(Integer adminId, String userName, String password) {
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
