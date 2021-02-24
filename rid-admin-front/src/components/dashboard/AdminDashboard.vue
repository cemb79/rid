<template>
    <div>
        <header>
            <app-navbar></app-navbar>
        </header>
        <main class="mt-6 mx-2 lg:mx-10">
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
    import Navbar from '../Navbar.vue'
    import { mapGetters } from "vuex";

    export default {
        components: {
            appNavbar: Navbar
        },
        computed: {
            ...mapGetters(['isAuthenticated'])
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