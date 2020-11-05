<template>
    <div>
        <h1>Reportes</h1>
        <hr>
        <el-tabs tab-position="left" style="height: 500px;" @tab-click="selectTab">
            <el-tab-pane v-for="(item) in lastSixMonths" :key="item.key" :label="item.month">
                <app-do-list :repKey="reportKey" :title="'DO por mes ' + item.month + ' ' + item.date.getFullYear()"
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
                numMonths: 1,
                reportKey: 'MONTH'
            }
        },
        components: {
            appDoList: DOList
        },
        computed: {
            lastSixMonths() {
                const months = [];
                for(let i = 0; i < this.numMonths; i++) {
                    const date = new Date();
                    date.setMonth(date.getMonth() - i);
                    const dateMap = {key: date.getMonth().toString(), date: date, month: date.toLocaleString('es', { month: 'long' })}
                    months.push(dateMap);
                }
                return months;
            },
            getYear(date) {
                return date.getYear
            }
        },
        methods: {
            selectTab(tab, event) {
                console.log(tab, event);
            }
        },
        filters: {
            getMonthName: function(value) {
                if (!value) 
                    return '';
                const month = value.toLocaleString('es', { month: 'long' });
                return month;
            }
        }
    }
</script>