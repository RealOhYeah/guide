/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-04-04 10:51:58
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-04-06 00:13:53
 * @FilePath: \guide-vue\src\api\guide\index.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import http from "@/utils/requests";

/**
 * 分页查询
 * @param {*} listMessage
 * @returns
 */
export function guideList(listMessage) {
  return http({
    url: "/api/guide/queryByPage",
    method: "post",
    data: listMessage,
  });
}

/**
 * 根据id查询
 * @param {*} id
 * @returns
 */
export function guideGet(id) {
  return http({
    url: `/api/guide/${id}`,
    method: "get",
  });
}

/**
 * 根据id删除
 * @param {*} id
 * @returns
 */
export function guideDelete(id) {
  return http({
    url: "/api/guide/deleteById",
    method: "post",
    params: { id: id },
  });
}

/**
 * 增加用例
 * @param {*} guide
 * @returns
 */
export function guideAdd(guide) {
  return http({
    url: "/api/guide/add",
    method: "post",
    data: guide,
  });
}

/**
 * 修改用例
 * @param {*} guide
 * @returns
 */
export function guideUpdate(guide) {
  return http({
    url: "/api/guide/edit",
    method: "post",
    data: guide,
  });
}
