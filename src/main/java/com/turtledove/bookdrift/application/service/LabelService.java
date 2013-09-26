package com.turtledove.bookdrift.application.service;

import java.util.List;

import com.turtledove.bookdrift.domain.entity.Label;

public interface LabelService {

	public List<Label> getTags(String email);
	public Label findById(Integer Id);
	public int insert(Label label);
	public Label findByLabelName(String labelName);
}
