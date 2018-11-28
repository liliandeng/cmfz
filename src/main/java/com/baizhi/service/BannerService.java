package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.Map;

public interface BannerService {

    public Map selectBannerAll(int page, int rows);

    public void delete(int id);

    public void update(String status, int id);

    public void insert(Banner ba);
}
