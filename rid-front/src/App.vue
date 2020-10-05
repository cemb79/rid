<template>
    <el-container>
        <el-header>
            <app-header></app-header>
        </el-header>
        <el-container>
            <el-aside width="300px">
                <appSideMenu/>
            </el-aside>
            <el-main>
                <transition name="slide" mode="out-in">
                    <router-view></router-view>
                </transition>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    import Header from './components/Header.vue';
    import SideMenu from './components/SideMenu.vue';
    
    export default {
        components: {
            appHeader: Header,
            appSideMenu: SideMenu
        }
    }
</script>

<style>
    body {
        padding: 30px;
    }

    .slide-enter-active {
        animation: slide-in 200ms ease-out forwards;
    }

    .slide-leave-active {
        animation: slide-out 200ms ease-out forwards;
    }

    @keyframes slide-in {
        from {
            transform: translateY(-30px);
            opacity: 0;
        }
        to {
            transform: translateY(0);
            opacity: 1;
        }
    }

    @keyframes slide-out {
        from {
            transform: translateY(0);
            opacity: 1;
        }
        to {
            transform: translateY(-30px);
            opacity: 0;
        }
    }
</style>

