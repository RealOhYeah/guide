<template>
    <div class="Register">
        <div>
            <Top></Top>
        </div>

        <!-- Main content -->
        <section>
            <div class="container">
                <!-- Title -->
                <!-- Section title -->
                <div class="row mb-5 justify-content-center text-center">
                    <div class="col-lg-6">
                        <h2 class="mt-4">注册您的账户</h2>
                        <div class="mt-2">
                            <p class="lead lh-180">Register Your Account</p>
                        </div>

                        <div>
                            <div class="form-group">
                                <label for="exampleInputusername">账号</label>
                                <input type="text" class="form-control" id="exampleInputusername"
                                    v-model="user.username" />
                                <small id="username" class="form-text text-muted">We'll never share your account
                                    information with anyone
                                    else.</small>
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">密码</label>
                                <input type="password" class="form-control" id="exampleInputPassword1"
                                    v-model="user.password" />
                            </div>

                            <div class="form-group">
                                <label for="exampleInputagainPassword1">再次输入密码</label>
                                <input type="password" class="form-control" id="exampleInputagainPassword1"
                                    v-model="user.againPassword" />
                            </div>

                            <button class="btn btn-primary" style="width: 100%" @click="submit()"
                                :disabled="switchbutton">
                                Submit
                            </button>
                        </div>
                    </div>
                    <div class="msg">
                        <router-link to="/LoginTwo"><--去登陆</router-link>
                    </div>
                </div>
            </div>
        </section>

        <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer>
    </div>
</template>

<script>
import Foot from "./fream/Foot.vue";
import Top from "./fream/LoginTop.vue"; 
import { userRegister } from '@/api/user';

export default {
    name: "Register",
    components: {
        Foot,
        Top,
    },

    data() {
        return {
            //获取今年年份-5，开始循环
            startYear: 2019,
            numYearsToShow: 5, // 显示最新的5个年份选项,
            user: {
                username: "",
                password: "",
                againPassword: "",
            },
            input: "",
            //按钮开关
            switchbutton: false,
            yearsList: [],
        };
    },
    mounted() {
        const currentDate = new Date();
        const currentYear = currentDate.getFullYear();
        for (let i = currentYear - 4; i <= currentYear; i++) {
            this.yearsList.push(i);
        }
        console.log(this.yearsList);
    },

    methods: {
        //提交登入
        async submit() {
            this.switchbutton = true;
            // 判断不为空提示弹窗
            if (this.user.username === "") {
                alert("用户名不能为空");
                this.switchbutton = false;
                return;
            }
            if (this.user.password === "" || this.user.againPassword === "") {
                alert("密码不能为空");
                this.switchbutton = false;
                return;
            }

            //密码的重复输入正确判断
            if (this.user.password !== this.user.againPassword) {
                alert("密码设置失败");
                return;
            }

            const us = {
                username: this.user.username,
                password: this.user.password,
            }

            console.log(us); 
            userRegister(us).then((res) => {
                if (res.data.code === '0x200') {
                    this.$message({
                        showClose: true,
                        message: '注册成功!',
                        type: 'success'
                    });
                    this.$router.push('/LoginTwo')
                } else {
                    this.$message({
                        showClose: true,
                        message: res.data.message,
                        type: 'error'
                    });
                    this.user.username = ''
                    this.user.password = ''
                    this.user.confirmPassword = ''
                }
            })
 
            this.switchbutton = false;
        },
    },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
    font-weight: normal;
}

ul {
    list-style-type: none;
    padding: 0;
}

li {
    display: inline-block;
    margin: 0 10px;
}

a {
    color: #42b983;
}
</style>
