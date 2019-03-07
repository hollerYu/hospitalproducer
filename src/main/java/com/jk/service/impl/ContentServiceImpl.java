package com.jk.service.impl;

import com.jk.bean.Tree;
import com.jk.bean.User;
import com.jk.mapper.ContentMapper;
import com.jk.service.ContentService;
import com.jk.untils.ReturnPage;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;
import java.util.List;

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
        List<Tree> treePrant = contentMapper.getTreeData(0);

        getForeachData(treePrant);

        return treePrant;
    }

    /**
     * 递归
     */
    private void getForeachData(List<Tree> treePrant) {
        for (Tree tree : treePrant) {
            List<Tree> nodesData=contentMapper.getTreeData(tree.getId());

            if(nodesData.size()>0){
                tree.setNodes(nodesData);
                getForeachData(nodesData);
            }
        }
    }

    @Override
    public ReturnPage selectContent(Integer page, Integer rows) {
        List<User> list = contentMapper.queryDiscu();

        PageHelper.startPage(page, rows);
        List aa = contentMapper.queryDiscu();

        ReturnPage returnPage = new ReturnPage(list.size(), aa);
        return returnPage;
    }

    @Override
    public void changeState(Integer state, Integer id) {
        contentMapper.changeState(state,id);
    }

}
