package com.example.test.collection;

import com.example.test.springMVC.vo.UserVO;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: bo.wang
 * @Date: 2017/12/12
 * @Project: test
 */
public class SetTest {
    public static void main(String[] args) {
        test1();
    }

    //@Data相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
    private static void test1() {
        Set<UserVO> set = new HashSet<>();
        set.add(new UserVO(15, "aaa"));
        set.add(new UserVO(15, "aaa"));
        System.out.println(set.toString());   //[UserVO(age=15, name=aaa)]
    }
}
