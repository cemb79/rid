<template>
    <el-card>
        <div class="panel-heading">
            <h4>DOs Agrupado por Estado</h4>
        </div>
        <div v-if="showChart" class="panel-body">
            <Chart type="doughnut" :data="chartData" />
            <span>Inactivos: {{ inactives }}</span>
            <span class="ml-4">Total: {{ totalDO }}</span>
        </div>
    </el-card>
</template>

<script>
    import { mapGetters } from "vuex";

    export default {
        data() {
            return {
                doStatusList: [],
                showChart: false,
                backgroundColor: ["#FCA5A5", "#FCD34D", "#6EE7B7", "#93C5FD", "#A5B4FC", "#C4B5FD", "#F9A8D4"],
                hoverColor: ["#F87171", "#FBBF24", "#34D399", "#60A5FA", "#818CF8", "#A78BFA", "#F472B6"],
                chartData: {
                    labels: [],
                    datasets: [
                        {
                            data: [],//[20, 5, 10, 3, 4, 5],
                            backgroundColor: [],
                            hoverBackgroundColor: []
                        }
                    ]
                }
            }
        },
        created() {
            this.$store.dispatch('findDoByClientGropByStatus', this.getUserId)
                .then(res => {
                    this.doStatusList = res.data.data
                    const labels = []
                    for(var i = 0; i < this.doStatusList.length; i++) {
                        if(this.doStatusList[i].status !== 'INA'){
                            var nameStr = this.doStatusList[i].name;
                            labels.push(nameStr.substring(3))
                            this.chartData.datasets[0].data.push(this.doStatusList[i].numStatus);
                            this.chartData.datasets[0].backgroundColor.push(this.backgroundColor[i]);
                            this.chartData.datasets[0].hoverBackgroundColor.push(this.hoverColor[i]);
                        }
                    }
                    this.chartData.labels = labels
                    this.showChart = true;
                })
                .catch(err => {
                    console.log(err)
                });
        },
        computed: {
            ...mapGetters(['getUserId']),
            inactives() {
                var result = ''
                for(var i = 0; i < this.doStatusList.length; i++) {
                    if(this.doStatusList[i].status === 'INA') {
                        result = this.doStatusList[i].numStatus;
                    }
                }
                return result;
            },
            totalDO() {
                var result = 0;
                for(var i = 0; i < this.doStatusList.length; i++) {
                    result += this.doStatusList[i].numStatus;
                }
                return result;
            }
        }
    }
</script>