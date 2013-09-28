package com.turtledove.bookdrift.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.UserLabelAssService;
import com.turtledove.bookdrift.common.framework.ActionMessage;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.Label;

public class UserLabelAction extends AjaxBase{
	
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String labelName;
	@Autowired
	UserLabelAssService userLabelAssService;
	public String  addLabel(){
		try{
			Label label = createLabelByName();
			if(userLabelAssService.addLabelToCurrentUser(label))
				setSuccessResult(ActionMessage.ADD_LABEL_SUCCESS);
			else setFailureResult(ActionMessage.EXIST_DATE_IN_TABEL);
		}catch(Exception e){
			e.printStackTrace();
			setFailureResult(ActionMessage.EXCEPTION);
		}
		return SUCCESS;
	}
	private Label createLabelByName() throws UnsupportedEncodingException {
		Label label = new Label();
		label.setLabelName(enCoding(labelName));
		label.setCreateDate(new Date());
		label.setCreatorId(LoginUtils.getCurrentLoginUserId());
		label.setLastUpdateDate(new Date());
		return label;
	}

}
