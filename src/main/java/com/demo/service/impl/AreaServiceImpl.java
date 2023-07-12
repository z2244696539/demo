package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.mapper.AreaMapper;

import com.demo.pojo.Area;

import com.demo.service.AreaService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {
    @Override
    public IPage<Area> selectPage(Page<Area> page, Area area) {
        LambdaQueryWrapper<Area> wrapper = new LambdaQueryWrapper<>();
        //设置查询条件

        wrapper.eq(
                !StringUtils.isEmpty(area.getAreaName()),
                Area::getAreaName,
                area.getAreaName()
        ).like(
                !StringUtils.isEmpty(area.getAddress()),
                Area::getAddress,
                area.getAddress()
        ).ge(
                !ObjectUtils.isEmpty(area.getCreateTime()),
                Area::getCreateTime,
                area.getCreateTime()
        );
        Page<Area> adminPage = baseMapper.selectPage(page, wrapper);

        return adminPage;
    }
}
