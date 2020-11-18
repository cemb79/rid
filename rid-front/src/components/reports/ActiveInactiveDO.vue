<template>
    <el-card>
        <div class="panel-heading">
            <h4>DOs Activos/Inactivos</h4>
        </div>
        <div class="panel-body">
            <Chart type="doughnut" :data="chartData" />
        </div>
    </el-card>
</template>

<script>
    export default {
        data() {
            return {
                activeDOs: [{ active: 20, inactive:5 }],
                chartData: {
                    labels: ['Activos', 'Inactivos'],
                    datasets: [
                        {
                            data: [20, 5],
                            backgroundColor: [
                                "#42A5F5",
                                "#66BB6A"
                            ],
                            hoverBackgroundColor: [
                                "#64B5F6",
                                "#81C784"
                            ]
                        }
                    ]
                }
            }
        }
    }
</script>