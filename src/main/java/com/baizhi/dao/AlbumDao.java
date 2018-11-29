package com.baizhi.dao;


import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {
    public List<Album> selectAlbumAll(@Param("start") int start, @Param("end") int end);

    public int getCount();

    public void addAlbum(Album al);
}