package com.yuanpeng.domain;

import com.baomidou.mybatisplus.annotations.TableField;

public class  utilDomain {
    @TableField(exist = false)
    private Integer page ;//页数
    @TableField(exist = false)
    private Integer limit ;//条数

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
