package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	//jspの変数を宣言（初期値）


	public String execute(){
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		//LoginDAOにgetLoginUserInfoの処理をさせ、loginDTOにその結果を格納
		session.put("loginUser", loginDTO);
        //loginDTOの値をloginUserに格納しセッションに入れる


		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			//loginUserのgetLoginFlgをセッションから取り出したらSUCCESSを渡す
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());

			return result;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	//jspに値を渡す

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	//jspで入力された値を取得

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;

	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session =session;
	}

}
