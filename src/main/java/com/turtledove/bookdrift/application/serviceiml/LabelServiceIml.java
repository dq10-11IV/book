package com.turtledove.bookdrift.application.serviceiml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtledove.bookdrift.application.service.LabelService;
import com.turtledove.bookdrift.domain.entity.Label;
import com.turtledove.bookdrift.infrastruct.dao.LabelDao;

@Service
public class LabelServiceIml implements LabelService {

	@Autowired
	LabelDao labelDao;
	public List<Label> getLabels(String email) {
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

}
