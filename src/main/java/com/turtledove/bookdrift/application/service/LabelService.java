package com.turtledove.bookdrift.application.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.turtledove.bookdrift.domain.entity.Label;

public interface LabelService {

	public List<Label> getLabelsByEmail(String email);
	public Label findById(Integer Id);
	public int insert(Label label);
	public Label findByLabelName(String labelName);
	public Label findByNameOrCreate(String labelName) throws UnsupportedEncodingException;
	public Label createLabelByName(String labelName) throws UnsupportedEncodingException;
}
