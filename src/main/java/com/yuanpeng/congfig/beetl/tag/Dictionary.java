package com.yuanpeng.congfig.beetl.tag;

import com.yuanpeng.domain.SysDictionary;
import org.beetl.core.GeneralVarTagBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 此类为beetl下拉选字典专用
 *attr 添加要查询变量  这个字段dictionary_type
 *  <select name="rolename" lay-filter="LAY-user-adminrole-type">
 *               <#dictionary attr="sex" ; value>
 *               *[value]
 *               </#dictionary>
 *  </select>
 */
public class Dictionary extends GeneralVarTagBinding {
    private final static Logger logger = LoggerFactory.getLogger(Dictionary.class);

    @Override
    public void render() {
        Map atters = (Map) args[1];
        String value = (String) atters.get("attr");//接受值
        logger.debug(value);
        //模拟数据库查询
        List<SysDictionary> list = new ArrayList<>();
        SysDictionary s1 = new SysDictionary();
        s1.setDictionaryValue("男");
        s1.setDictionaryCode("0");
        SysDictionary s2 = new SysDictionary();
        s2.setDictionaryValue("女");
        s2.setDictionaryCode("1");
        list.add(s1);
        list.add(s2);
        this.binds("<option value='"+list.get(0).getDictionaryCode()+"'>"+list.get(0).getDictionaryValue()+"</option>" +
                "<option value='"+list.get(1).getDictionaryCode()+"'>"+list.get(1).getDictionaryValue()+"</option>");
        this.doBodyRender();
    }
}
