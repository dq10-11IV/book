package com.turtledove.bookdrift.application.serviceiml;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.LabelService;
import com.turtledove.bookdrift.common.utils.LoginUtils;
import com.turtledove.bookdrift.domain.entity.Label;
import com.turtledove.bookdrift.infrastruct.dao.LabelDao;

@Service
public class LabelServiceIml implements LabelService {

	@Autowired
	LabelDao labelDao;
	public List<Label> getLabelsByEmail(String email) {
		return labelDao.getTags(email);
	}
	public Label findById(Integer Id) {
		return labelDao.findById(Id);
	}
	public int insert(Label label) {
		return labelDao.insert(label);
	}
	public Label findByLabelName(String labelName) {
		return labelDao.findByLabelName(labelName);
	}
	public Label findByNameOrCreate(String labelName) throws UnsupportedEncodingException {
		Label label = findByLabelName(labelName);
		if(label != null)
			return label;
		label = createLabelByName(labelName);
		labelDao.insert(label);
		return label;
	}
	public Label createLabelByName(String labelName) throws UnsupportedEncodingException {
		Label label = new Label();
		label.setLabelName(labelName);
		label.setCreateDate(new Date());
		label.setCreatorId(LoginUtils.getCurrentLoginUserId());
		label.setLastUpdateDate(new Date());
		return label;
	}
}
