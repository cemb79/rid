<template>
    <div class="panel panel-default panel-success">
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
                dosByCity: [
                    /*{port: 'CTG', portName: 'Cartagena', numDO: 5},
                    {port: 'BOG', numDO: 10},
                    {port: 'MDE', numDO: 7}*/
                ],
                userId: ''
            }
        },
        methods: {
            selectRow(row) {
                this.$store.commit('storeContext', { port: row.port })
                this.$router.push('/delivery/list');
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