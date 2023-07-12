package com.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.pojo.Area;
import com.demo.pojo.City;


public interface AreaService extends IService<Area> {
    IPage<Area> selectPage(Page<Area> page, Area area);
}
