package com.example.secdemo.service.impl;

import com.example.secdemo.dao.SysMenuDao;
import com.example.secdemo.model.SysMenu;
import com.example.secdemo.model.SysUser;
import com.example.secdemo.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.service.impl.SysMenuServiceImpl
 * @Description
 * @createTime 2020/1/6
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysMenu> findAllSysMenuByUserName(String s) {
        return sysMenuDao.findAllSysMenuByUserName(s);
    }

    @Override
    public List<SysMenu> findAllSysMenuByUserId(Long userId) {
        return sysMenuDao.findAllSysMenuByUserId(userId);
    }

    /**
     * 根据用户查询菜单
     *
     * @param user 用户信息
     * @return 菜单列表
     */
    @Override
    public List<SysMenu> selectMenusByUser(SysUser user)
    {
        List<SysMenu> menus = new LinkedList<SysMenu>();
        // 管理员显示所有菜单信息
        if (user.isAdmin())
        {
            menus = sysMenuDao.selectMenuNormalAll();
        }
        else
        {
            menus = sysMenuDao.findAllSysMenuByUserId(user.getUserId());
        }
        return getChildPerms(menus, 0);
    }

    @Override
    public List<SysMenu> selectMenuAll() {
        return sysMenuDao.selectMenuAll();
    }

    @Override
    public List<SysMenu> selectMenuByurl(String url) {
        return sysMenuDao.selectMenuByUrl(url);
    }


    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<SysMenu> getChildPerms(List<SysMenu> list, int parentId)
    {
        List<SysMenu> returnList = new ArrayList<SysMenu>();
        for (Iterator<SysMenu> iterator = list.iterator(); iterator.hasNext();)
        {
            SysMenu t = (SysMenu) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId)
            {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private void recursionFn(List<SysMenu> list, SysMenu t)
    {
        // 得到子节点列表
        List<SysMenu> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysMenu tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<SysMenu> it = childList.iterator();
                while (it.hasNext())
                {
                    SysMenu n = (SysMenu) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<SysMenu> getChildList(List<SysMenu> list, SysMenu t)
    {
        List<SysMenu> tlist = new ArrayList<SysMenu>();
        Iterator<SysMenu> it = list.iterator();
        while (it.hasNext())
        {
            SysMenu n = (SysMenu) it.next();
            if (n.getParentId().longValue() == t.getMenuId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysMenu> list, SysMenu t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }


}
