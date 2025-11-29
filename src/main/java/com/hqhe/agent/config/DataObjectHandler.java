package com.hqhe.agent.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;


public class DataObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByNameIfNull("createTime", new Date(), metaObject);
        this.setFieldValByNameIfNull("modifiedTime", new Date(), metaObject);
        this.setFieldValByName("deleted", 0, metaObject);
        this.setFieldValByName("lockVersion", 0, metaObject);
    }

    /**
     * 当没有值的时候再设置属性，如果有值则不设置。主要是方便单元测试
     * @param fieldName
     * @param fieldVal
     * @param metaObject
     */
    private void setFieldValByNameIfNull(String fieldName, Object fieldVal, MetaObject metaObject) {
        if (metaObject.getValue(fieldName) == null) {
            this.setFieldValByName(fieldName, fieldVal, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifiedTime", new Date(), metaObject);
    }
}
