package com.example.test.tree.example;

import com.example.test.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Package: com.example.test.tree.example
 * @Author: Mr.Waves
 * @Date: 2020-04-02 00:05
 * @Description:
 **/
public class DeptTreeTest {
    public static void main(String[] args) {
        Dept dept1 = new Dept(1L, 0L, "1");
        Dept dept11 = new Dept(11L, 1L, "11");
        Dept dept12 = new Dept(12L, 1L, "12");


        Dept dept2 = new Dept(2L, 0L, "2");
        Dept dept21 = new Dept(21L, 2L, "21");
        Dept dept22 = new Dept(22L, 2L, "22");
        Dept dept23 = new Dept(23L, 2L, "23");

        ArrayList<Dept> depts = new ArrayList<>();
        depts.add(dept1);
        depts.add(dept11);
        depts.add(dept12);
        depts.add(dept2);
        depts.add(dept21);
        depts.add(dept22);
        depts.add(dept23);

        DeptTreeNode tree = getDeptTree(depts);
        System.out.println(tree);

    }

    /*
     * 方式一：两次循环
     */
    public static DeptTreeNode getDeptTree(List<Dept> depts) {
        DeptTreeNode root = new DeptTreeNode();
        root.setName("默认顶级节点");
        root.setId(0L);
        // 将entity映射成node，然后进行建树操作
        List<DeptTreeNode> deptTreeNodes = depts.stream()
                .filter(dept -> !dept.getId().equals(dept.getPid()))
                .map(dept -> {
                    DeptTreeNode treeNode = new DeptTreeNode();
                    treeNode.setId(dept.getId());
                    treeNode.setPid(dept.getPid());
                    treeNode.setName(dept.getName());
                    return treeNode;
                }).collect(Collectors.toList());

        return TreeUtil.build(deptTreeNodes, root);
    }

}
