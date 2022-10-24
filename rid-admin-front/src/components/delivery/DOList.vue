<template>
    <el-card>
        <el-row>
            <el-table :data="doData" height="750" stripe @row-click="selectRow" v-loading="loading">
                <el-table-column
                    prop="noDO"
                    label="Código DO"
                    width="120">
                </el-table-column>
                <el-table-column
                    prop="office.nombreSucursal"
                    label="Oficina"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="fechaRegistro"
                    label="Fecha Registro"
                    width="180"
                    :formatter="formatRegisterDate">
                </el-table-column>
                <el-table-column
                    prop="status.name"
                    label="Estado"
                    width="120">
                </el-table-column>
                <el-table-column
                    prop="customer.name"
                    label="Razón Social"
                    width="500">
                </el-table-column>
            </el-table>
        </el-row>
        <el-row>
            <el-pagination
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="totalElements"
                @next-click="nextPage"
                @prev-click="previousPage"
                @current-change="goToPage">
            </el-pagination>
        </el-row>
    </el-card>
</template>

<script>
    import { mapGetters } from "vuex";

    export default {
        props: ['repKey', 'title', 'parameters'],
        data() {
            return {
                doData: [],
                totalPages: 0, 
                currentPage: 0,
                totalElements: 0,
                pageSize: 25,
                port: '',
                loading: true,
                reportKey: this.repKey,
                reportTitle: this.title,
                reportParameters: this.parameters,
                reports: [{key: 'PORT', reportName: 'findDoByClientIdAndPortId'},
                          {key: 'MONTH', reportName: 'findDoByClientIdAndMonth'},
                          {key: 'USER', reportName: 'findDoByUserId'}
                         ]
            }
        },
        computed: {
            ...mapGetters(['getUserId'])
        },
        created() {
            this.port = this.$route.params.portId;
            if(!this.reportKey) {
                this.reportKey = this.$route.query.reportKey;
            }
            if(!this.reportTitle) {
                this.reportTitle = this.$route.query.title;
            }
            if(!this.reportParameters) {
                this.reportParameters = {portId: this.port}
            }
            this.fetchData(1);
        },
        methods: {
            formatDate(date) {
                var dateStr = '';
                if(date !== null) {
                    dateStr = new Date(date).toISOString().slice(0,10);
                }
                return dateStr
            },
            formatRegisterDate(row) {
                return this.formatDate(row.fechaRegistro);
            },
            formatManifestDate(row) {
                return this.formatDate(row.manifiestoFecha);
            },
            nextPage(page){
                this.fetchData(page);
            },
            previousPage(page){
                this.fetchData(page);
            },
            goToPage(page) {
                this.fetchData(page);
            },
            fetchData(pageNum) {
                this.loading = true;
                pageNum = pageNum - 1;
                console.log('DOList userId', this.getUserId, pageNum);
                const payload = {userId: this.getUserId, 
                                parameters: this.reportParameters,
                                page: pageNum }
                const report = this.getReportName();
                this.$store.dispatch(report, payload)
                    .then(res => {
                        console.log(res)
                        this.totalPages = res.data.data.totalPages;
                        this.doData = res.data.data.content;
                        this.currentPage = res.data.data.currentPage;
                        this.totalElements = res.data.data.totalElements;
                        this.loading = false;
                    })
                    .catch(err => {
                        console.log(err)
                        this.loading = false;
                    });
            },
            selectRow(row) {
                this.$router.push({ name: 'DODetail', params: { doId: row.noDO } });
            },
            getReportName() {
                var resp = ''
                const val = this.reports.find(element => element.key === this.reportKey);
                if(val !== null) {
                    resp = val.reportName;
                }
                return resp;
            }
        }
    }
</script>

<style scoped>

</style>