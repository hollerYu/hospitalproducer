package com.jk.service.impl;

import com.jk.bean.Permission;
import com.jk.bean.User;
import com.jk.mapper.ContentMapper;
import com.jk.service.ContentService;
import com.jk.untils.ReturnPage;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 19:21
 * @Description:
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Resource
    private ContentMapper contentMapper;

    @Override
    public User insertForm(User user) {
        return contentMapper.insertForm(user);
    }

    public List getTreeData() {
        List<Permission> permissionPrant = contentMapper.getTreeData(0);

        getForeachData(permissionPrant);

        return permissionPrant;
    }

    /**
     * 递归
     */
    private void getForeachData(List<Permission> permissionPrant) {
        for (Permission permission : permissionPrant) {
            List<Permission> nodesData=contentMapper.getTreeData(permission.getId());

            if(nodesData.size()>0){
                permission.setNodes(nodesData);
                getForeachData(nodesData);
            }
        }
    }

    @Override
    public ReturnPage selectContent(Integer page, Integer rows) {
        List<User> list = contentMapper.selectContent();

        PageHelper.startPage(page, rows);
        List aa = contentMapper.selectContent();

        ReturnPage returnPage = new ReturnPage(list.size(), aa);
        return returnPage;
    }

    @Override
    public void changeState(Integer state, Integer id) {
        contentMapper.changeState(state,id);
    }

    @Override
    public User queryByUserName(String username) {
        return contentMapper.queryByUserName(username);
    }

    @Override
    public List<String> queryPermissionByUserId(Integer id) {
        return contentMapper.queryPermissionByUserId(id);
    }



}
