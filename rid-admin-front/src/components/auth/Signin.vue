<template>
    <div class="flex-row">
        <div class="mt-4 flex justify-center">
            <img src="../../assets/Acolcex.png" class="center" width="60" height="60">
        </div>
        <div class="flex flex-1 justify-center pt-4">
            <el-card>
                <h1 class="flex justify-center font-bold text-2xl pb-4">Autenticación</h1>
                <hr class="py-4">
                <el-form :model="ruleForm" status-icon ref="ruleForm" :rules="rules" class="login-form">
                    <el-form-item prop="username">
                        <el-input type="text" v-model="ruleForm.username" autocomplete="off" placeholder="Usuario" prefix-icon="el-icon-user"></el-input>
                    </el-form-item>
                    <el-form-item prop="password">
                        <el-input type="password" v-model="ruleForm.password" autocomplete="off" placeholder="Contraseña" prefix-icon="el-icon-lock"></el-input>
                    </el-form-item>
                    <hr>
                    <el-form-item>
                        <el-button :loading="loading" class="login-button" type="primary" @click="submitForm('ruleForm')">Acceder</el-button>
                    </el-form-item>
                </el-form>
            </el-card>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('Por favor ingrese la contraseña'));
                } else {
                    if (this.ruleForm.checkPass !== '') {
                        this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }
            };
            var validateUser = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('Por favor ingrese el usuario'));
                } else {
                    if (this.ruleForm.checkPass !== '') {
                        this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }
            };
            return {
                ruleForm: {
                    password: '',
                    username: ''
                },
                rules: {
                    password: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    username: [
                        { validator: validateUser, trigger: 'blur' }
                    ]
                },
                loading: false
            }
        },
        methods: {
            authenticate() {
                const formData = {
                    username: this.ruleForm.username,
                    password: this.ruleForm.password
                }
                this.$store.dispatch('login', {username: formData.username, password: formData.password})
                    .then(result => {
                        result.data;
                        this.loading = false;
                    })
                    .catch((error) => {
                        console.log('failed authentication', error)
                        this.$message({
                            showClose: true,
                            message: 'Usuario o contraseña inválidos',
                            type: 'error'
                        });
                        this.loading = false;
                    });
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        this.authenticate();
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .login {
        flex: 1;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .login-form {
        width: 290px;
    }

    .login-button {
        width: 100%;
        margin-top: 40px;
    }
    
    .el-card {
        width: 340px;
        display: flex;
        justify-content: center;
    }

    .header {
        padding-bottom: 20px;
        color: #f0f4f8;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
</style>