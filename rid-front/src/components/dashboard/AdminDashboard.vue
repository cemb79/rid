<template>
    <el-container v-if="isAuthenticated">
        <el-aside width="200px">
            <app-side-menu></app-side-menu>
        </el-aside>
        <el-container>
            <el-header>
                <app-header></app-header>
            </el-header>
            <el-main>
                <h1>{{ name }}<br><small>NIT/COD.: {{ userId }}</small></h1>
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
            ...mapGetters(['isAuthenticated']),
            name() {
                return !this.$store.getters.getUser ? false : this.$store.getters.getUser.usuarioNombre
            },
            userId() {
                return !this.$store.getters.getUser ? false : this.$store.getters.getUser.username
            }
        }, 
        created () {
            this.$store.dispatch('fetchUser');
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