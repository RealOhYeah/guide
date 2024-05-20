/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-04-02 17:11:18
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-04-06 11:35:53
 * @FilePath: \guide-vue\vue.config.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */

const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  // assetsDir: 'static',
  transpileDependencies: true,
  productionSourceMap: false,
  // 关闭ESLINT校验工具
  lintOnSave: false,

  // 配置代理跨域
  devServer: {
    proxy: {
      "/api": {
        target: "http://localhost:8083",
        pathRewrite: {
          "^/api": "/",
        },
        // ws:true
      },
    },
  },
  publicPath: "/"
  
  
});
