package com.example.test.tree;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.example.test.tree
 * @Author: Mr.Waves
 * @Date: 2020-04-01 17:43
 * @Description:
 **/
@UtilityClass
public class TreeUtil {
    /*
     * 方式一：两层循环
     */
    public <T extends TreeNode> T build(List<T> treeNodes, T root) {

        for (T treeNode : treeNodes) {
            // 筛选第一层节点
            if (root.getId().equals(treeNode.getPid())) {
                root.add(treeNode);
            }

            // 筛选当前节点的子节点
            for (T node : treeNodes) {
                if (treeNode.getId().equals(node.getPid())) {
                    treeNode.add(node);
                }
            }
        }
        return root;
    }

    /*
     * 方式二：递归
     */
    public <T extends TreeNode> T buildByRecursive(List<T> treeNodes, T root) {
        for (T treeNode : treeNodes) {
            if (root.getId().equals(treeNode.getPid())) {
                root.add(findChildren(treeNode, treeNodes));
            }
        }
        return root;
    }

    /*
     * 递归查找子节点
     */
    public <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T node : treeNodes) {
            if (treeNode.getId().equals(node.getPid())) {
                treeNode.add(findChildren(node,treeNodes));
            }
        }
        return treeNode;
    }
}
