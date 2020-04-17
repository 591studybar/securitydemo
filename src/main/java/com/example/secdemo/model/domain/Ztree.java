package com.example.secdemo.model.domain;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.model.domain.Ztree
 * @Description
 * @createTime 2020/1/14
 */
public class Ztree {

    private Long id;

    private Long pId;

    private String name;

    private String title;

    private boolean checked = false;

    private boolean open = false;

    private boolean nochecked = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isNochecked() {
        return nochecked;
    }

    public void setNochecked(boolean nochecked) {
        this.nochecked = nochecked;
    }
}
