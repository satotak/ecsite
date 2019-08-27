
package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;


public class LoginDAO {
	private DBConnector db = new DBConnector();
	private Connection con =db.getConnection();
	private LoginDTO dto = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
                                     //←LoginAction

		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass =?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			//	文字列（String sql）をSQL文として認識

			ps.setString(1, loginUserId);
			ps.setString(2,loginPassword);
			//SQL文の？に値を与える

			ResultSet rs =ps.executeQuery();
                          //SQL文の実行+実行結果の格納 ※select文はexecuteQuery();
			if(rs.next()){
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				// SQL文の実行がされたらそのDBの情報をDTOに格納

				if(rs.getString("login_id")!= null){
					dto.setLoginflg(true);
				}
				//login_idに値が入っていたらloginFlgはtrue
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		// SQLエラー処理
		return dto;
		// LoginDTOに入った値をLoginActionに戻す
	}

}
