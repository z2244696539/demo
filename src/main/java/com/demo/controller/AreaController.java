package com.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.pojo.Area;
import com.demo.pojo.Result;
import com.demo.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱吃山楂的小天
 * @Date: 2023/07/12/19:54
 * @Description:
 */
@Api(tags = "area")
@RestController
@RequestMapping("/area")
public class AreaController {

    @Resource
    private AreaService areaService;

    @ApiOperation(value = "条件分页查询")
    @GetMapping("{current}/{limit}")
    public Result pageList(
            @PathVariable Long current,
            @PathVariable Long limit,
            Area area
    ) {
        // 创建page对象
        // current 当前页
        // limit 每页记录数
        Page<Area> page = new Page<>(current, limit);
        IPage<Area> pageModel = areaService.selectPage(page, area);
        return Result.ok(pageModel);
    }

    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Area byId = areaService.getById(id);
        return Result.ok(byId);
    }


    @PostMapping("save")
    public Result save(@RequestBody Area area) {
        areaService.save(area);
        return Result.ok();
    }


    @PutMapping("update")
    public Result update(@RequestBody Area area) {
        areaService.updateById(area);
        return Result.ok();
    }

    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        areaService.removeById(id);
        return Result.ok();
    }
}
