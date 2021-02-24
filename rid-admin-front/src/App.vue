<template>
    <transition name="slide" mode="out-in">
        <app-home></app-home>
    </transition>
</template>

<script>
    import Home from './components/Home.vue';

    export default {
        components: {
            appHome: Home
        },
        created() {
            this.$store.dispatch('tryAutoLogin');
        }
    }
</script>