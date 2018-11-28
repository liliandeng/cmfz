package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {

    public List<Banner> selectBannerAll(@Param("start") int start, @Param("end") int end);

    public int selectCount();

    public void delete(int id);

    public void update(@Param("status") String status, @Param("id") int id);

    public void insert(Banner ba);
}
