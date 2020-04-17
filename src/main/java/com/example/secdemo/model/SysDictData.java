package com.example.secdemo.model;

import com.example.secdemo.model.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.model.SysDictData
 * @Description
 * @createTime 2020/1/14
 */
public class SysDictData extends BaseEntity {
    private Long dictCode;

    private Long dictSort;

    private String dictLable;

    private String dictValue;

    private String dictType;

    private String cssClass;

    private String listClass;

    private String isDefault;

    private String status;


    public Long getDictCode() {
        return dictCode;
    }

    public void setDictCode(Long dictCode) {
        this.dictCode = dictCode;
    }

    public Long getDictSort() {
        return dictSort;
    }

    public String getDictLable() {
        return dictLable;
    }

    public void setDictLable(String dictLable) {
        this.dictLable = dictLable;
    }

    public void setDictSort(Long dictSort) {
        this.dictSort = dictSort;
    }


    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getListClass() {
        return listClass;
    }

    public void setListClass(String listClass) {
        this.listClass = listClass;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("dictCode", getDictCode())
                .append("dictSort", getDictSort())
                .append("dictLabel", getDictLable())
                .append("dictValue", getDictValue())
                .append("dictType", getDictType())
                .append("cssClass", getCssClass())
                .append("listClass", getListClass())
                .append("isDefault", getIsDefault())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
