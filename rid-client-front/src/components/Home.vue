<template>
    <div id="home">
        <div v-if="!isAuthenticated">
            <app-login/>
        </div>
        <div v-if="isAuthenticated">
            <app-admin-dashboard></app-admin-dashboard>
        </div>
    </div>
</template>

<script>
    
    import Login from './auth/Signin.vue';
    import AdminDashboard from './dashboard/AdminDashboard.vue';

    export default {
        
        components: {
            'app-login': Login,
            appAdminDashboard: AdminDashboard
        },
        computed: {
            isAuthenticated () {
                return !this.$store.getters.isAuthenticated ? false : this.$store.getters.isAuthenticated
            }
        }
    }
</script>