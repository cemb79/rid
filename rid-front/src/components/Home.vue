<template>
    <div id="home">
        <div v-if="!isAuthenticated">
            <app-login/>
        </div>
        <div v-if="isAuthenticated">
            <app-dashboard/>
        </div>
    </div>
</template>

<script>
    
    import Login from './auth/Signin.vue';
    import Dashboard from './dashboard/Dashboard.vue';

    export default {
        
        components: {
            'app-login': Login,
            'app-dashboard': Dashboard
        },
        computed: {
            isAuthenticated () {
                return this.$store.getters.isAuthenticated
            }
        }
    }
</script>