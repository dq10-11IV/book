package com.turtledove.bookdrift.common.AbstractClass;

public interface DomainObjectDao<T extends AbstractDomainObject> {
	public int insert(T entity);
}
