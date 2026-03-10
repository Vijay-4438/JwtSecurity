package com.example.login.signin.payload;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String email;
    private String newPassword;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getEmail1() {
		// TODO Auto-generated method stub
		return email;
	}
	public String getNewPassword1() {
		// TODO Auto-generated method stub
		return newPassword;
	}
}
