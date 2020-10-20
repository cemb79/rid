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
                <h2 v-if="getUser">{{ getUser.usuarioNombre }}<br><small>NIT/COD.: {{ getUser.username }}</small></h2>
                <hr>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    import SideMenu from '../SideMenu.vue';
    import Header from '../Header.vue';
    import { mapGetters } from "vuex";

    export default {
        data() {
            return {
                user: {
                    name: 'WESTCON GROUP COLOMBIA LTDA',
                    code: '830089336',
                    userRole: 'ANE'
                },
                activeDOs: { active: 20, inactive:5}
            }
        },
        components: {
            appSideMenu: SideMenu,
            appHeader: Header
        },
        computed: {
            ...mapGetters(['getUser'])
        }
    }
</script>