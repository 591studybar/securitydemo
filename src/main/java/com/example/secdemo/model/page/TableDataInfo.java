package com.example.secdemo.model.page;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collections;
import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.model.page.TableDataInfo
 * @Description
 * @createTime 2020/1/14
 */
public class TableDataInfo {
    /**
     * 总记录数
     */
    private long total;

    /**
     * 查询数据列表
     */
    private List<?> rows;

    /**
     *消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private int msg;

    public TableDataInfo() {

    }

    public TableDataInfo(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
                append("total",getTotal())
                .append("rows", getRows().size())
                .append("code",getCode())
                .append("msg",getMsg())
                .toString();
    }
}
