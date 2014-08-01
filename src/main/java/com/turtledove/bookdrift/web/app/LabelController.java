package com.turtledove.bookdrift.web.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.turtledove.bookdrift.application.service.LabelService;
import com.turtledove.bookdrift.application.service.UserLabelAssService;
import com.turtledove.bookdrift.commom.Enum.UpdateOptionResult;
import com.turtledove.bookdrift.common.agent.LogServiceAgent;
import com.turtledove.bookdrift.common.framework.ActionMessage;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.Label;

public class LabelController extends AbstractController{

    
    public String labelName;
    public Integer labelId;
    public String newLabelName;

    @Autowired
    UserLabelAssService userLabelAssService;
    @Autowired
    LabelService labelService;
   
    public String myLabel(){
        
        try{
            List<Label> labels = labelService.getLabelsByEmail(LoginUtils.getCurrentLoginUserEmail());
            setSuccessResultWithList(labels);
        }catch(Exception e){
            LogServiceAgent.error("myLabel", e);
            setFailureResult("get mylabel error");
        }
        return SUCCESS;
    }
    
    public String  add(){
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
    
   
    public String remove(){
        
        try{
            userLabelAssService.remove(labelId);
            setSuccessResult("remove success");
        }catch(Exception e ){
            setSuccessResult("removefail");
            LogServiceAgent.error("error", e);
        }
        return SUCCESS;
    }
    public String update(){
        try {
              Label newLabel = labelService.findByNameOrCreate(newLabelName);
              UpdateOptionResult     optionResult =  userLabelAssService.update(LoginUtils.getCurrentLoginUserId(), labelId, newLabel.getId());
              setSuccessResult(optionResult.getDesc());
        } catch (Exception e) {
          setFailureResult(UpdateOptionResult.Exception.getDesc());
        }
        
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
