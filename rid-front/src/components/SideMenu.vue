<template>
    <el-row class="tac">
        <el-col v-if="isAuthenticated">
            <h4>Registro Integral Documental</h4>
            <el-menu :router="true" default-active="Home" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
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

<script>
    import { mapGetters } from "vuex";

    export default {
        data() {
            return {
                userRole: 'ANE'
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
        }
    }
</script>

<style>
    .el-menu {
        border: 0 !important;
    }
</style>