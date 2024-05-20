<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-04 16:04:06
 * @LastEditTime: 2024-04-16 18:34:51
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @Description: 
 * @FilePath: /guide-vue/src/views/guide/GuideList.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
  <div class="receptacle">
    <div class="target">
      <el-row>
        <el-button @click="refresh" type="primary" style="margin-right: 665px;">页面刷新</el-button>

        <el-button @click="handleAdd()" type="success">添加数据</el-button>
      </el-row>

      <el-table :data="tableData" border>
        <el-table-column prop="id" label="序号" width="180" align="center">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="180" align="center">
        </el-table-column>
          <el-table-column prop="toLink" @click="toPage(id)" label="链接" width="180" align="center">
          </el-table-column>
        <el-table-column prop="updateTime" label="更新时间" width="180" align="center">
        </el-table-column>
        <el-table-column label="操作" width="150px" align="center">
          <template slot-scope="scope">
            <el-button @click="handleGet(scope.$index, scope.row)" type="text" size="small">查看
            </el-button>
            <el-button @click="handleUpdate(scope.$index, scope.row)" type="text" size="small">编辑</el-button>
            <el-button @click="handleDelete(scope.$index, scope.row)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog :title=target.name :visible.sync="dialogFormVisible">
        <div slot="footer" class="dialog-footer">
          <el-form ref="form" :model="target" label-width="80px">
            <el-form-item label="编号">
              <el-input v-model="target.id" readonly></el-input>
            </el-form-item>
            <el-form-item label="名字">
              <el-input v-model="target.name" readonly></el-input>
            </el-form-item>
            <el-form-item label="链接">
              <el-input v-model="target.toLink" readonly></el-input>
            </el-form-item>
            <el-form-item label="创建时间">
              <el-input v-model="target.createTime" readonly></el-input>
            </el-form-item>
            <el-form-item label="创建人">
              <el-input v-model="target.createBy" readonly></el-input>
            </el-form-item>
            <el-form-item label="修改时间">
              <el-input v-model="target.updateTime" readonly></el-input>
            </el-form-item>
            <el-form-item label="修改人">
              <el-input v-model="target.updateBy" readonly></el-input>
            </el-form-item>
            <el-form-item label="状态">
              <el-input v-model="target.delFlag" readonly></el-input>
            </el-form-item>
            <el-form-item label="逻辑删除">
              <el-input v-model="target.status" readonly></el-input>
            </el-form-item>

          </el-form>

          <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import {
  guideList,
  guideDelete,
  guideGet,
} from "@/api/guide";

export default {
  data() {
    return {
      target: {},
      listMessage: {
        start: 0,
        size: 10,
        guide: {},
      },
      message: "",
      tableData: [],
      dialogFormVisible: false,
    };
  },
  //页面直接获取数据并刷新
  created() {
    const _this = this;
    const resp = guideList(this.listMessage).then((res) => {
      if (res.data.code === "0x200") {
        this.$message({
          showClose: true,
          message: "查询成功!",
          type: "success",
        });
      }
      _this.tableData = res.data.data.list;
      // console.log("???");
      // console.log(_this.tableData);
    });
  },
  methods: {
    handleAdd() {
      this.$router.push('/guideAdd')
    },
    //index:元素在数组中的索引
    //row:元素本身
    handleGet(index, row) {
      guideGet(row.id).then((res) => {

        res.data.data.delFlag = res.data.data.delFlag === 0 ? '未删除' : '已删除';
        res.data.data.status = res.data.data.status === 0 ? '正常状态' : '特殊状态';
        this.target = res.data.data;

        this.dialogFormVisible = true;

      });
    },
    handleUpdate(index, row) {
      console.log(index, row);

      //直接跳转到编辑页面 
      // this.$router.push('/guideUpdate')

      //在页面跳转时传递参数
      // this.$router.push({
      //   name: 'guideUpdate',
      //   params: { id: row.id }
      // })

      //跳转并将参数存储到本地
      localStorage.setItem('updateGuide', row.id)
      this.$router.push('/guideUpdate')


    },
    handleDelete(index, row) {
      console.log(index, row);

      console.log(row.id);
      this.$confirm('此操作将永久删除该网页信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        console.log(row.id);
        console.log("???");
        const resp = guideDelete(row.id).then((res) => {
          if (res.data.code === "0x200") {
            this.$message({
              showClose: true,
              message: "删除成功!",
              type: "success",
            });
          }
        })

        location.reload()

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });

    },
    refresh() {
      const resp = guideList(this.listMessage).then((res) => {
        if (res.data.code === "0x200") {
          this.$message({
            showClose: true,
            message: "查询成功!",
            type: "success",
          });
        }
        this.tableData = res.data.data.list;
        console.log(this.tableData);
      });
    },

  },
};
</script>

<style lang="scss">
.el-dialog__body {
  padding: 0px 0px;

}

.receptacle {
  width: 100%;
  display: flex;
  height: 100%;
  align-items: center;
  justify-content: center;
}
</style>
