package com.turtledove.bookdrift.web;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.LabelService;
import com.turtledove.bookdrift.application.service.UserLabelAssService;
import com.turtledove.bookdrift.commom.Enum.UpdateOptionResult;
import com.turtledove.bookdrift.common.agent.LogServiceAgent;
import com.turtledove.bookdrift.common.framework.ActionMessage;
import com.turtledove.bookdrift.common.framework.AjaxBase;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.Label;

public class UserLabelAction extends AjaxBase{
	

	public String labelName;
	public Integer labelId;
	public String newLabelName;

	@Autowired
	UserLabelAssService userLabelAssService;
	@Autowired
	LabelService labelService;
	public String  addLabel(){
		try{
			Label label = labelService.createLabelByName(labelName);
			if(userLabelAssService.addLabelToCurrentUser(label))
				setSuccessResult(ActionMessage.ADD_LABEL_SUCCESS);
			else setFailureResult(ActionMessage.EXIST_DATE_IN_TABEL);
		}catch(Exception e){
			LogServiceAgent.error(ActionMessage.EXCEPTION, e);
			setFailureResult(ActionMessage.EXCEPTION);
		}
		return SUCCESS;
	}
	public String removelabel(){
		
		try{
            userLabelAssService.remove(labelId);
            setSuccessResult("success");
		}catch(Exception e ){
			setSuccessResult("fail");
			LogServiceAgent.error("error", e);
		}
		return SUCCESS;
	}
	public String updateLabel(){
		UpdateOptionResult optionResult ;
		try {
			Label newLabel = labelService.findByNameOrCreate(newLabelName);
			 optionResult =  userLabelAssService.update(LoginUtils.getCurrentLoginUserId(), labelId, newLabel.getId());
		} catch (Exception e) {
			optionResult = UpdateOptionResult.Exception;
		}
		setDateWithErrorMsg(optionResult.getDesc());
		return SUCCESS;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	public void setLabelService(LabelService labelService) {
		this.labelService = labelService;
	}
}
