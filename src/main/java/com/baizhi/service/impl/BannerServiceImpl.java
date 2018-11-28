package com.baizhi.service.impl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public Map selectBannerAll(int page, int rows) {
        int start = (page - 1) * rows;
        int end = rows;
        int count = bannerDao.selectCount();
        List<Banner> list = bannerDao.selectBannerAll(start, end);
        Map map = new HashMap();
        map.put("total", count);
        map.put("rows", list);
        return map;
    }

    @Override
    public void delete(int id) {
        bannerDao.delete(id);
    }

    @Override
    public void update(String status, int id) {
        bannerDao.update(status, id);
    }

    @Override
    public void insert(Banner ba) {
        bannerDao.insert(ba);
    }
}
