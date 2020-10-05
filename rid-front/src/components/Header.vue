<template>
    <div class="container-fluid">
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
            <a class="navbar-brand" href="/">
                        <img src="../assets/Acolcex.png" width="30" height="30">
                    </a>
            <el-submenu index="2" v-if="isAuthenticated">
                <template slot="title">{{username}}</template>
                <el-menu-item index="2-1">Administración de Usuarios</el-menu-item>
                <el-menu-item index="logoutMenu">Salir</el-menu-item>
            </el-submenu>
        </el-menu>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                isDropdownOpen: false
            }
        },
        methods: {
            logout() {
                this.$store.dispatch('logout')
            },
            handleSelect(key, keyPath) {
                if(key === 'logoutMenu') {
                    this.logout();
                }
            }
        },
        computed: {
            isAuthenticated () {
                return this.$store.getters.isAuthenticated
            },
            username() {
                return this.$store.state.userId
            }
        }
    }
</script>
<style scoped>
    strong {
        text-align: center
    }

    div {
        border-bottom: 1px solid #112873;
    }
</style>