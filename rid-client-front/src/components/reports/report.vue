<template>
    <el-table :data="dosByCity">
        <el-table-column prop="port" label="Puerto"></el-table-column>
        <el-table-column prop="portName" label="Ciudad"></el-table-column>
        <el-table-column prop="numDO" label="DOs Activos"></el-table-column>
    </el-table>
</template>

<script>
    export default {
        data() {
            return {
                dosByCity: [
                    {port: 'CTG', portName: 'Cartagena', numDO: 5},
                    {port: 'BOG', portName: 'Bogotá', numDO: 10},
                    {port: 'MDE', portName: 'Medellín',numDO: 7}
                ],
                userId: 'fhernandez'
            }
        }
    }
</script>