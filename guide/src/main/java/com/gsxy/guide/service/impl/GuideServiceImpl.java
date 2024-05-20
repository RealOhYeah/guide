package com.gsxy.guide.service.impl;

import com.gsxy.guide.domain.Guide;
import com.gsxy.guide.domain.bo.GuidePagingToGetDataBo;
import com.gsxy.guide.domain.vo.GuidePagingToData;
import com.gsxy.guide.domain.vo.GuidePagingToGetDataVo;
import com.gsxy.guide.domain.vo.ResponseVo;
import com.gsxy.guide.mapper.GuideMapper;
import com.gsxy.guide.service.GuideService;
import com.gsxy.guide.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import java.time.LocalDateTime;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * 向导实现类
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:43
 */
@Service("guideService")
public class GuideServiceImpl implements GuideService {
    @Autowired
    private GuideMapper guideMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResponseVo queryById(Long id) {

        Guide guide = guideMapper.queryById(id);

        if (guide == null){
            return new ResponseVo("查询失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("查询成功", guide,"0x200");
    }



    /**
     * 分页查询
     *
     * @param guide 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public ResponseVo queryByPage(GuidePagingToGetDataBo guidePagingToGetDataBo) {
//        String userId = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
//        System.out.println(userId);
        Guide guide = guidePagingToGetDataBo.getGuide();
        if (guide==null){
            guide = new Guide();
        }
//        guide.setCreateBy(Long.valueOf(userId));

        List<GuidePagingToData> fileList = guideMapper.guidePagingToGetUserData(guidePagingToGetDataBo.getStart(),guidePagingToGetDataBo.getSize(),guidePagingToGetDataBo.getGuide());
        Long count = guideMapper.getCount(guidePagingToGetDataBo.getGuide());
//        System.out.println(count);

//        HashMap<String,Object> map = new HashMap<>();
//        map.put("count",count);
//        map.put("list",fileList);

        return new ResponseVo("查询成功",new GuidePagingToGetDataVo(fileList,Math.toIntExact(count)),"0x200");
    }
    /**
     * 新增数据
     *
     * @param guide 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseVo insert(Guide guide) {

        int insert = guideMapper.insert(guide);

        if (insert == 0){
            new ResponseVo("添加失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("添加成功", null,"0x200");
    }

    /**
     * 修改数据
     *
     * @param guide 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseVo update(Guide guide) {
        int update = this.guideMapper.update(guide);

        if (update == 0){
            new ResponseVo("修改失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("修改成功", null,"0x200");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public ResponseVo deleteById(Long id) {

        boolean b = guideMapper.deleteById(id) > 0;

        if (!b){
            new ResponseVo("删除失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("删除成功", null,"0x200");
    }
}
