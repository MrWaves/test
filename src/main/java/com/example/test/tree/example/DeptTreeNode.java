package com.example.test.tree.example;

import com.example.test.tree.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Package: com.example.test.tree.example
 * @Author: Mr.Waves
 * @Date: 2020-04-01 23:41
 * @Description:
 **/
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DeptTreeNode extends TreeNode {
    private String name;

}
