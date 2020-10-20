<template>
    <el-row class="tac">
        <el-col v-if="isAuthenticated">
            <h2>Registro Integral Documental</h2>
            <el-menu :router="true" :default-active="activeLink" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
                background-color="#112773"
                text-color="#fff"
                active-text-color="#E5B344">
                <el-menu-item :index="{name: 'Home'}">
                    <i class="el-icon-menu"></i>
                    <span>Dashboard</span>
                </el-menu-item>
                <el-menu-item :index="{name: 'SearchDO'}">
                    <span>Buscar</span><i class="el-icon-search"></i>
                </el-menu-item>
                <el-menu-item :index="{name: 'ReportHome'}">
                    <span>Reportes</span>
                </el-menu-item>
            </el-menu>
        </el-col>
    </el-row>
</template>

<script scoped>
    import { mapGetters } from "vuex";

    export default {
        data() {
            return {
                userRole: 'ANE',
                activeLink: null,
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

    h2 {
        padding-top: 10px;
        text-align: center;
    }
</style>