<template>

      <div class="container">
        <div class="login-wrapper">
          <el-form :model="user" :rules="rules" ref="user" class="demo-ruleForm">
            <div class="form-wrapper">
              <div class="header">Register</div>
              <el-form-item prop="username">
                <el-input v-model="user.username" placeholder="username" class="input-item"></el-input>
              </el-form-item>
              <el-form-item prop="password">
                <el-input v-model="user.password" show-password placeholder="password" class="input-item"></el-input>
              </el-form-item>
              <el-form-item prop="confirmPassword">
                <el-input v-model="user.confirmPassword" show-password placeholder="confirmPassword"
                  class="input-item"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button class="btn" type="primary" @click="submitForm('user')">注册</el-button>
              </el-form-item>
            </div>
          </el-form>
          <div class="msg">
            <router-link to="/login"><--去登陆</router-link>
          </div>
        </div>
      </div>

  </template> 

  <script>
  import { userRegister } from '@/api/user';

  export default {
    name: 'HomeView',
    data() {
      return {
        user: {
          username: '',
          password: '',
          confirmPassword: ''
        },
        rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          confirmPassword: [
            { required: true, message: '请输入确认密码', trigger: 'blur' },
            // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if (this.user.password !== this.user.confirmPassword) {
              this.$message({
                  showClose: true,
                  message:  '两次密码输入不一致请重新输入!',
                  type: 'error'
                });
                this.user.password = ''
                this.user.confirmPassword = ''
            }
            let user = {
              username : this.user.username,
              password : this.user.password

            }
            userRegister(user).then((res)=>{
              if (res.data.code === '0x200') {
                this.$message({
                  showClose: true,
                  message: '注册成功!',
                  type: 'success'
                });
                this.$router.push('/login')
              } else {
                this.$message({
                  showClose: true,
                  message: res.data.message,
                  type: 'error'
                });
                this.user.username=''
                this.user.password=''
                this.user.confirmPassword=''
              }
            })
          } else {
            return false;
          }
        });
      },
    }
  }
  </script>

  <style lang="scss" scoped>



    /*
        这里写PC端的样式
      */
    .container {
      height: 100%;
      background-image: linear-gradient(to right, #fbc2eb, #3a6bbd);
    }

    .login-wrapper {
      background-color: #fff;
      width: 358Px;
      height: 588Px;
      border-radius: 15Px;
      padding: 0 50Px;
      position: absolute;
      left: 50%;
      top: 50%;
      transform: translate(-50%, -50%);
    }

    .header {
      font-size: 38Px;
      font-weight: bold;
      text-align: center;
      line-height: 100Px;
    }

    .input-item {
      display: block;
      width: 100%;
      margin-bottom: 20Px;
      border: 0;
      padding: 10Px;
      border-bottom: 1Px solid rgb(128, 125, 125);
      font-size: 15Px;
      outline: none;
    }

    .input-item:placeholder {
      text-transform: uppercase;
    }

    .btn {
      text-align: center;
      padding: 10Px;
      width: 100%;
      margin-top: 20Px;
      background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
      color: #fff;
    }

    .msg {
      text-align: center;
      line-height: 88Px;
    }

    a {
      text-decoration-line: none;
      color: #abc1ee;
    }

    ::v-deep .el-input__inner {
      border: 0;
      padding: 0;
    }


    ::v-deep .el-button--primary {
      border: 0;
    }


  </style>
