/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-04-01 14:57:34
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-05-20 12:30:18
 * @FilePath: \guide-vue\src\utils\requests.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import axios from "axios";
import VueCookie from 'vue-cookie';

const http = axios.create({
    timeout: 1000 * 30,
    withCredentials: true,
    headers: {
        'Content-Type': 'application/json; charset=utf-8'
    }
})

/**
* 请求拦截
* @param {*} params 
* @param {*} openDefultParams 
* @returns 
*/
http.interceptors.request.use(config => {
    let token = VueCookie.get("token");
    //设置请求头
    config.headers['Authorization'] = token;
    config.headers['accept'] = '*/*'

    return config;
})


/**
 * 响应拦截
 * @param response 响应数据
 */
http.interceptors.response.use(response => {
    console.log(response, "response")
    return response;
}, error => {
    // 检查错误是否为401
    if (error.response && error.response.status === 401) {
        //删除token
        VueCookie.delete('token')
        // console.log(this.$cookie.get('token'));
    }
    return Promise.reject(error);
});



export default http