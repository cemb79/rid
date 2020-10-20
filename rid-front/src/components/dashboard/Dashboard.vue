<template>
    <el-row :gutter="20">
        <el-col :span="12">
            <app-do-by-port></app-do-by-port>
        </el-col>
        <el-col :span="12">
            <app-active-orders></app-active-orders>
        </el-col>
    </el-row>
</template>

<script>
    import DOByPort from '../reports/DOByPort.vue';
    import ActiveInactiveDO from '../reports/ActiveInactiveDO.vue';
    import { mapGetters } from "vuex";

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
            'app-do-by-port': DOByPort,
            'app-active-orders': ActiveInactiveDO
        },
        computed: {
            ...mapGetters(['getUser'])
        }
    }
</script>