

package com.internousdev.ecsite.dto;

public class LoginDTO {

	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg =false;
	//テーブルの変数を宣言


	public String getLoginId(){
		return loginId;
	}
	//LoginActionに値(loginId)を渡す
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}
	//LoginDAOから受け取った値(loginId)を格納

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}

	public boolean getLoginFlg(){
		return loginFlg;
	}

	public void setLoginflg(boolean loginFlg){
		this.loginFlg=loginFlg;
	}

}
