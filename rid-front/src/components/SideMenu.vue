<template>
    <el-row v-if="isAuthenticated">
        <img src="../assets/Acolcex-full.jpg" class="center" width="200" height="60">
        <el-menu :router="true" :default-active="activeLink" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
            background-color="#112773"
            text-color="#fff"
            active-text-color="#E5B344">
            <el-menu-item index="/dashboard">
                <i class="el-icon-menu"></i>
                <span>Dashboard</span>
            </el-menu-item>
            <el-menu-item index="/delivery/search">
                <span>Buscar</span><i class="el-icon-search"></i>
            </el-menu-item>
            <el-menu-item index="/reports">
                <span>Reportes</span>
            </el-menu-item>
        </el-menu>
    </el-row>
</template>

<script scoped>
    import { mapGetters } from "vuex";

    export default {
        data() {
            return {
                userRole: 'ANE',
                activeLink: '/dashboard',
            }
        },
        computed: {
            ...mapGetters(['isAuthenticated'])
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        },
        mounted () {
            this.activeLink = this.$route.path
        },
        watch: {
            $route (newVal) {
                this.activeLink = newVal.path
            }
        }
    }
</script>

<style>
    .el-menu {
        border: 0 !important;
    }

    .center {
        display: block;
        margin-left: auto;
        margin-right: auto;
    }

    h2 {
        padding-top: 10px;
        text-align: center;
    }
</style>