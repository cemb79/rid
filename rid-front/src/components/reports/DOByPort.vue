<template>
    <div>
        <el-card>
            <div class="panel-heading">
                <h4>DO Activos por Puerto</h4>
            </div>
            <el-table :data="dosByCity" @row-click="selectRow">
                <el-table-column
                    prop="port"
                    label="Puerto"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="portName"
                    label="Ciudad"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="numDO"
                    label="DOs Activos"
                    width="180">
                </el-table-column>
            </el-table>
        </el-card>
    </div>
</template>

<script>
    import { mapGetters } from "vuex";

    export default {
        data() {
            return {
                dosByCity: [],
                userId: ''
            }
        },
        methods: {
            selectRow(row) {
                this.$router.push({name: 'DOListPort', 
                    params: { portId: row.port }, 
                    query: {title: 'DO por puerto ' + row.portName, 
                            reportKey: 'PORT',
                            parameters: row.port} });
            }
        },
        created() {
            this.$store.dispatch('getDosByCity', this.getUserId)
                .then(res => {
                    this.dosByCity = res.data.data
                })
                .catch(err => {
                    console.log(err)
                });
        },
        computed: {
            ...mapGetters(['getUserId'])
        }
    }
</script>