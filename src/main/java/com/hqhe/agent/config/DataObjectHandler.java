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
     * @param fieldName 字段的名称
     * @param fieldVal 字段的值
     * @param metaObject MetaObject 是 MyBatis-Plus 用来在自动填充回调中读写实体属性的反射工具，避免你自己写反射逻辑。
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
