package com.gsxy.guide.service.impl;

import com.gsxy.guide.domain.User;
import com.gsxy.guide.mapper.UserMapper;
import com.gsxy.guide.domain.bo.UserLoginBo;
import com.gsxy.guide.domain.vo.ResponseVo;
import com.gsxy.guide.service.UserService;
import com.gsxy.guide.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Date;

/**
 * 用户实现类
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 18:25:21
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;



    /**
     * @param userLoginBo
     * @return ResponseVo.class
     * @Auther Oh… Yeah!!! 2024-3-5
     * 用户注册
     */
    public ResponseVo userReg(UserLoginBo userLoginBo){

        System.out.println(userLoginBo);
        User user = userMapper.findByUsername(userLoginBo.getUsername());

        if(user != null){
            return new ResponseVo("该用户名已存在",null,"0x202");
        }

        Long aLong = userMapper.userReg(new User(
                userLoginBo.getUsername(),
                userLoginBo.getPassword(),
                new Date(),
                new Date(),
                0,
                0
        ));

        if(aLong.longValue() == 0L){
            return new ResponseVo("注册失败",null,"0x203");
        }

        return new ResponseVo("注册成功",null,"0x200");
    }

    /**
     *  @Auther Oh… Yeah!!! 2024-3-5
     *  用户登录
     * @param userLoginBo
     * @return ResponseVo.class
     */
    public ResponseVo userLogin(UserLoginBo userLoginBo){
        //通过username去获取用户
        User user = userMapper.findByUsername(userLoginBo.getUsername());

        //比较用户密码和数据库中密码是否一致
        if(user == null || !user.getPassword().equals(userLoginBo.getPassword())){
            return new ResponseVo("登录失败",null,"0x500");
        }

        String jwt = JwtUtil.createJWT(user);


        //修改当前的登录时间
        user.setUpdateTime(new Date());
        userMapper.updateLoginTime(user);

        return new ResponseVo("登录成功",jwt,"0x200");
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userMapper.count(user);
        return new PageImpl<>(this.userMapper.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userMapper.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userMapper.deleteById(id) > 0;
    }
}
