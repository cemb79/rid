<template>
    <el-table :data="doHistory">
        <el-table-column
            prop="fechaEstadoDO"
            label="Fecha Estado"
            width="180"
            :formatter="formatDate"
            >
        </el-table-column>
        <el-table-column
            prop="operationState.nombreEstOpeDO"
            label="Operación"
            width="200">
        </el-table-column>
        <el-table-column
            prop="observaciones"
            label="Observaciones"
            width="300">
        </el-table-column>
    </el-table>
</template>

<script>
    export default {
        props: ['doId'],
        data() {
            return {
                doHistory: []
            }
        },
        created() {
            this.$store.dispatch('findDOHistory', this.doId)
                .then(res => {
                    this.doHistory = res.data.data;
                })
                .catch(err => {
                    console.log(err)
                });
        },
        methods: {
            formatDate(row) {
                var dateStr = '';
                var date = row.fechaEstadoDO;
                if(date !== null) {
                    dateStr = date.substring(0, 10);
                }
                return dateStr
            }
        }
    }
</script>