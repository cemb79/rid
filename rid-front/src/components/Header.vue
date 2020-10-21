<template>
    <div>
        <el-menu class="el-menu-demo" mode="horizontal" :default-active="activeIndex" @select="handleSelect">
            <el-menu-item index="1">Registro Integral Documental</el-menu-item>
            <el-menu-item>
                <el-input
                    placeholder="Buscar"
                    prefix-icon="el-icon-search"
                    >
                </el-input>
            </el-menu-item>
            <el-submenu index="2" v-if="isAuthenticated">
                <template slot="title">
                    <i class="el-icon-user-solid"></i>
                    <span>{{username}}</span>
                </template>
                <el-menu-item index="2-1">Administración de Usuarios</el-menu-item>
                <el-menu-item index="logoutMenu">Salir</el-menu-item>
            </el-submenu>
        </el-menu>
    </div>
</template>

<script>
    import { mapGetters } from "vuex";

    export default {
        data() {
            return {
                isDropdownOpen: false,
                activeIndex: '1'
            }
        },
        methods: {
            logout() {
                this.$store.dispatch('logout')
            },
            handleSelect(key, keyPath) {
                if(key === 'logoutMenu') {
                    console.log(keyPath)
                    this.logout();
                }
            }
        },
        computed: {
            ...mapGetters(['isAuthenticated']),
            username() {
                return this.$store.state.userId
            }
        }
    }
</script>
<style scoped>
    div {
        border-bottom: 1px solid #EBEEF5;
    }
</style>