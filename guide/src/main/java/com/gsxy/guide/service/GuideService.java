package com.gsxy.guide.service;

import com.gsxy.guide.domain.Guide;
import com.gsxy.guide.domain.bo.GuidePagingToGetDataBo;
import com.gsxy.guide.domain.vo.ResponseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 向导接口
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:40
 */
public interface GuideService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ResponseVo  queryById(Long id);

    /**
     * 分页查询
     *
     * @param guide 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    ResponseVo queryByPage(GuidePagingToGetDataBo guidePagingToGetDataBo);

    /**
     * 新增数据
     *
     * @param guide 实例对象
     * @return 实例对象
     */
    ResponseVo insert(Guide guide);

    /**
     * 修改数据
     *
     * @param guide 实例对象
     * @return 实例对象
     */
    ResponseVo update(Guide guide);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    ResponseVo deleteById(Long id);

}
