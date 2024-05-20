// /$$
//  $ @Author: tianleiyu 
//  $ @Date: 2024-04-01 16:32:02
//  $ @LastEditTime: 2024-04-01 16:33:56
//  $ @LastEditors: tianleiyu
//  $ @Description: 
//  $ @FilePath: /guide-vue/src/api/user/index.js
//  $ @可以输入预定的版权声明、个性签名、空行等
//  $/
import http from '@/utils/requests'
 
export function  userLogin(user){
        return http({
            url: "/api/user/login",
            method: "post",
            data: user
    })
    
};


export function userRegister(user){ 
    return http({ 
        url: "/api/user/userReg", 
        method: "post",
        data: user 
        })

    };


export function userList(listMessage){ 
    return http({
      url: "/api/guide/queryByPage",
      method: "post",
      data: listMessage,
    });

    };




 