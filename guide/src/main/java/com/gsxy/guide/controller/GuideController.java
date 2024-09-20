package com.gsxy.guide.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.guide.domain.Guide;
import com.gsxy.guide.domain.bo.GuidePagingToGetDataBo;
import com.gsxy.guide.domain.vo.ResponseVo;
import com.gsxy.guide.service.GuideService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 向导
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:24
 */
@RestController
@Api(value = "向导版块接口",tags = {"向导版块接口"})
@RequestMapping(value = "guide", produces = "text/plain;charset=UTF-8")
public class GuideController {
    /**
     * 服务对象
     */
    @Autowired
    private GuideService guideService;

    /**
     * 分页查询
     *
     * @param guide 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation("分页查询Guide数据")
    public String queryByPage(@RequestBody GuidePagingToGetDataBo guidePagingToGetDataBo) {

        return JSONArray.toJSONString(guideService.queryByPage(guidePagingToGetDataBo));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("根据id查询Guide数据")
    public String queryById(@PathVariable("id") Long id) {
        return JSONArray.toJSONString(guideService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param guide 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增Guide数据")
    public String add(@RequestBody Guide guide) {
        return JSONArray.toJSONString(guideService.insert(guide));
    }

    /**
     * 编辑数据
     *
     * @param guide 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    @ApiOperation("修改Guide数据")
    public String edit(@RequestBody Guide guide) {
        return JSONArray.toJSONString(guideService.update(guide));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById")
    @ApiOperation("根据id删除Guide数据")
    public String deleteById(@RequestParam("id")  Long id) {
        return JSONArray.toJSONString(guideService.deleteById(id));
    }


}

