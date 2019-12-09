package com.example.test.java;

import java.util.Date;
import java.util.List;

/**
 * @Author: bo.wang
 * @Date: 2017/12/27
 * @Project: test
 */
public interface StuDao {

    List<StuDTO> findStuByCreatedTime( Date date);

    void insert(StuDTO stuDTO);
}
