package com.turtledove.bookdrift.application.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.LabelService;
import com.turtledove.bookdrift.application.service.UserLabelAssService;
import com.turtledove.bookdrift.commom.Enum.UpdateOptionResult;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.Label;
import com.turtledove.bookdrift.domain.entity.UserLabelAss;
import com.turtledove.bookdrift.infrastruct.dao.UserLabelAssDao;

@Service
public class UserLabelAssServiceIml implements UserLabelAssService {

	@Autowired
	UserLabelAssDao userLabelAssDao;
	@Autowired 
	LabelService labelService;
	public UserLabelAss findById(Integer Id) {
		return userLabelAssDao.findById(Id);
	}
	public Integer insert(UserLabelAss userLabelAss) {
		return userLabelAssDao.insert(userLabelAss);
	}
	public boolean addLabelToCurrentUser(Label label) {
		UserLabelAss userLabelAss = new UserLabelAss();
		Label find = labelService.findByLabelName(label.getLabelName());
		if(find==null)
			labelService.insert(label);
		userLabelAss.setLabelId(find==null ? label.getId():find.getId());
		userLabelAss.setCreateDate(label.getCreateDate());
		userLabelAss.setUserId(LoginUtils.getCurrentLoginUserId());
		if(userLabelAssDao.ValidateUserLabelAss(userLabelAss) == null){
			   userLabelAssDao.insert(userLabelAss);
			   return true;
			}
		return false;
	}
	public UpdateOptionResult update(Integer userId, Integer oldlabelId, Integer newLabelId) {
		if(userLabelAssDao.findByUserIdAndLabelId(userId, newLabelId)!= null)
		  return UpdateOptionResult.EXIT;
		userLabelAssDao.update(userId, oldlabelId, newLabelId);
		  return UpdateOptionResult.SUCCESS;
	}
	public void remove(Integer labelId) {
		if(userLabelAssDao.findByUserIdAndLabelId(LoginUtils.getCurrentLoginUserId(), labelId)!=null){
			userLabelAssDao.remove(LoginUtils.getCurrentLoginUserId(), labelId);
		}
	}
}
