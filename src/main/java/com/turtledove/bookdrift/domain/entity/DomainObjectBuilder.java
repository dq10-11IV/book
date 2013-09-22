package com.turtledove.bookdrift.domain.entity;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.turtledove.bookdrift.common.AbstractClass.AbstractDomainObject;


public class DomainObjectBuilder {

    private Map<String, Object> attributeMap = new HashMap<String, Object>();

    public DomainObjectBuilder withField(String attributeName, Object attributeValue) {
        attributeMap.put(attributeName, attributeValue);
        return this;
    }

    public static DomainObjectBuilder newInstance() {
        return new DomainObjectBuilder();
    }

    public <T> T build(Class<T> clazz) {

        T entity = null;

        try {
            entity = clazz.newInstance();

            for (String attribute : attributeMap.keySet()) {
                try {
                    Field field = getFieldByName(clazz, attribute);
                    field.setAccessible(true);

                    field.set(entity, attributeMap.get(attribute));

                } catch (Exception e) {
                    throw new Error(e);
                }
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {

            e.printStackTrace();
        }

        return entity;
    }

    private <T> Field getFieldByName(Class<T> entityClass, String fieldName) {
        Class currentClass = entityClass;

        while (!currentClass.equals(Object.class)) {

            for (Field f : currentClass.getDeclaredFields()) {

                if (f.getName().equals(fieldName)) {
                    return f;
                }
            }
            currentClass = currentClass.getSuperclass();
        }

        return null;
    }

}
