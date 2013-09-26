package com.turtledove.bookdrift.infrastruct.dao;

import java.util.List;

import com.turtledove.bookdrift.common.AbstractClass.DomainObjectDao;
import com.turtledove.bookdrift.domain.entity.Label;

public interface LabelDao extends DomainObjectDao<Label>{

	List<Label> getTags(String email);
	Label findById(Integer Id);
	Label findByLabelName(String labelName);
}
