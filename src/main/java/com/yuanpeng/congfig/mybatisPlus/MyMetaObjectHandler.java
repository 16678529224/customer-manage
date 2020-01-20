package com.yuanpeng.congfig.mybatisPlus;


import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.yuanpeng.BuilderJava.TimeUtil;
import com.yuanpeng.BuilderJava.ToolUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class MyMetaObjectHandler extends MetaObjectHandler {
    /** mybatisplus自定义填充公共字段 ,即没有传的字段自动填充*/
    //新建插入公共字段
    @Override
    public void insertFill(MetaObject metaObject) {

        metaObject.setValue("id", ToolUtils.getUuid());
        metaObject.setValue("createTime", TimeUtil.dateFormat(new Date()));
        metaObject.setValue("createUserid", ToolUtils.getUser().getId()
		);
    }
    //更新插入公共字段
    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
