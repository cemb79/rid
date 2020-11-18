<template>
    <div>
        <h1>Reportes</h1>
        <hr>
        <el-tabs tab-position="left" style="height: 500px;" @tab-click="selectTab">
            <el-tab-pane v-for="(item) in tabs" :key="item.key" :label="item.month">
                <app-do-list v-if="item.isVisible" :repKey="reportKey" :title="'DO por mes ' + item.month + ' ' + item.date.getFullYear()"
                    :parameters="{month: item.date.getMonth(), year: item.date.getFullYear()}"></app-do-list>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    import DOList from '../delivery/DOList.vue'
    export default {
        data() {
            return {
                numMonths: 6,
                reportKey: 'MONTH',
                tabs: []
            }
        },
        components: {
            appDoList: DOList
        },
        computed: {
            getYear(date) {
                return date.getYear
            }
        },
        methods: {
            /*eslint no-unused-vars: ["error", { "args": "none" }]*/
            selectTab(tab, event) {
                this.tabs[tab.index].isVisible = true;
            },
            lastSixMonths() {
                const months = [];
                for(let i = 0; i < this.numMonths; i++) {
                    const date = new Date();
                    date.setMonth(date.getMonth() - i);
                    var isVisible = false;
                    if(i == 0) {
                        isVisible = true;
                    }
                    const dateMap = {key: date.getMonth().toString(), date: date, month: date.toLocaleString('es', { month: 'long' }), isVisible: isVisible}
                    months.push(dateMap);
                }
                return months;
            }
        },
        filters: {
            getMonthName: function(value) {
                if (!value) 
                    return '';
                const month = value.toLocaleString('es', { month: 'long' });
                return month;
            }
        },
        created() {
            this.tabs = this.lastSixMonths();
        }
    }
</script>