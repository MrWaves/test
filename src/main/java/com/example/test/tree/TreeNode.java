package com.example.test.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.example.test.tree
 * @Author: Mr.Waves
 * @Date: 2020-04-01 17:41
 * @Description: 树节点领域模型
 **/
@Data
public class TreeNode {
    protected Long id;
    protected Long pid;
    protected List<TreeNode> children = new ArrayList<>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
