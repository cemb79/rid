<template>
    <el-container>
        <el-container>
            <el-main v-if="user.userRole !== 'ANE'">
                <h1>Dashboard</h1>
                <hr>       
            </el-main>
            <el-main v-else>
                <h2>{{ getUser.usuarioNombre }}<br><small>NIT/COD.: {{ getUser.username }}</small></h2>
                <hr>
                <div class="row">
                    <div class="col-sm-5">
                        <app-do-by-port></app-do-by-port>
                    </div>
                    <div class="col-sm-5">
                        <app-report></app-report>
                    </div>
                </div>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    import SideMenu from '../SideMenu.vue';
    import DOByPort from '../reports/DOByPort.vue';
    import ActiveInactiveDO from '../reports/ActiveInactiveDO.vue';
    import Report from '../reports/report.vue';
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
            appSideMenu: SideMenu,
            'app-do-by-port': DOByPort,
            'app-active-orders': ActiveInactiveDO,
            appReport: Report
        },
        computed: {
            ...mapGetters(['getUser'])
        }
    }
</script>