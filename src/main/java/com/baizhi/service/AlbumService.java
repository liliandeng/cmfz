package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.Map;

public interface AlbumService {

    public Map selectAlbumAll(int page, int rows);

    public void addAlbum(Album al);
}
