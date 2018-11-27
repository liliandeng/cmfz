package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {

    public Admin selectOne(@Param("admin") Admin admin);
}
