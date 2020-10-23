<template>
    <el-container>
        <el-aside width="200px">
            <app-side-menu></app-side-menu>
        </el-aside>
        <el-container>
            <el-header>
                <app-header></app-header>
            </el-header>
            <el-main>
                <h1>{{ getUser.usuarioNombre }}<br><small>NIT/COD.: {{ getUser.username }}</small></h1>
                <hr>
                <transition name="el-fade-in-linear">
                    <router-view></router-view>
                </transition>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    import SideMenu from '../SideMenu.vue';
    import Header from '../Header.vue';
    import { mapGetters } from "vuex";

    export default {
        components: {
            appSideMenu: SideMenu,
            appHeader: Header
        },
        computed: {
            ...mapGetters(['getUser'])
        }
    }
</script>

<style scoped>
    h1 {
        text-align: center;
    }

    .el-aside {
        min-height: 100vh;
        background-color: #112773;
    }
</style>