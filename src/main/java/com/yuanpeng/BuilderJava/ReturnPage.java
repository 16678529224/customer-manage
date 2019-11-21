package com.yuanpeng.BuilderJava;


import com.baomidou.mybatisplus.plugins.Page;

import java.io.Serializable;
import java.util.List;

public class ReturnPage  implements Serializable {

    private Integer code; //返回标志0正确 1异常
    private String msg;//异常信息
    private String count;//\总条数
    private List<?> data ;//\返回实体


    public ReturnPage(List<?> list , Page<?> page){
        this.code = 0;
        this.count = page.getTotal()+"";
        this.data = list;
    };
    public ReturnPage(String msg){
        this.code = 1;
        this.msg = msg;
    };
    public ReturnPage(){

    };
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "code="+code+"\n\t"+
                "msg="+msg+"\n\t"+
                "count="+count+"\n\t"+
                "data="+data.toString()+"\n\t";
    }
}
