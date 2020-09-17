<template>
    <div>
        <div class="col-md-10" v-if="user.userRole !== 'ANE'">
            <h1>DOs Asignados</h1>
            <hr>       
        </div>
        <div class="col-md-10" v-else>
            <h2>{{ user.name }}<br><small>NIT/COD.: {{ user.code }}</small></h2>
            <hr>
            <div class="row">
                <div class="col-sm-5">
                    <app-do-by-city></app-do-by-city>
                </div>
                <div class="col-sm-5">
                    <app-active-orders></app-active-orders>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import DOByCity from './reports/DOByCity.vue';
    import ActiveInactiveDO from './reports/ActiveInactiveDO.vue';

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
            'app-do-by-city': DOByCity,
            'app-active-orders': ActiveInactiveDO
        }
    }
</script>