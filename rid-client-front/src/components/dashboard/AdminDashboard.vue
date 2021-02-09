<template>
    <div>
        <header>
            <!-- <app-header></app-header> -->
            <app-navbar></app-navbar>
        </header>
        <main class="mt-6 mx-2 lg:mx-10">
            <h1 class="text-center text-xl pb-2">{{ name }}<br><small>NIT/COD.: {{ userId }}</small></h1>
            <hr class="py-3">
            <transition name="el-fade-in-linear">
                <router-view></router-view>
            </transition>
        </main>
        <footer class="w-auto bg-primary ">
            <!--<div class="md:flex md:flex-row-reverse justify-around">
                <ul class="flex mt-4 mb-4 ml-4">
                    <li class="mx-10">Soporte</li>
                    <li class="mx-10">Acerca de nosotros</li>
                    <li class="mx-10">Aviso de privacidad</li>
                </ul>
            </div>-->
        </footer>
    </div>
</template>

<script>
    //import SideMenu from '../SideMenu.vue';
    //import Header from '../Header.vue';
    import Navbar from '../Navbar.vue'
    import { mapGetters } from "vuex";

    export default {
        components: {
            //appSideMenu: SideMenu,
            appNavbar: Navbar
            //appHeader: Header
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
        },
        mounted () {
            this.$router.push({ name: 'Home' });
        }
    }
</script>

<style scoped>

</style>