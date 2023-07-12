package com.demo.controller;

import com.demo.pojo.City;
import com.demo.pojo.Result;
import com.demo.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱吃山楂的小天
 * @Date: 2023/07/12/19:54
 * @Description:
 */
@Api(tags = "city")
@RestController
@RequestMapping("/city")
public class CityController {

    @Resource
    private CityService cityService;
    @ApiOperation(value = "条件分页查询")
    @GetMapping("list")
    public Result List() {
        List<City> list = cityService.list();
        return Result.ok(list);
    }

    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        City byId = cityService.getById(id);
        return Result.ok(byId);
    }


    @PostMapping("save")
    public Result save(@RequestBody City city) {
       cityService.save(city);
        return Result.ok();
    }


    @PutMapping("update")
    public Result update(@RequestBody City city) {
     cityService.updateById(city);
        return Result.ok();

    }

    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
       cityService.removeById(id);
        return Result.ok();

    }
}
