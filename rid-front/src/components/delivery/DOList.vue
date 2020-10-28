<template>
    <el-card>
        <h2>Puerto {{ port }}</h2>
        <el-row>
            <el-table :data="doData" height="750" stripe @row-click="selectRow" v-loading="loading">
                <el-table-column
                    prop="noDO"
                    label="Código DO"
                    width="120">
                </el-table-column>
                <el-table-column
                    prop="docTransporte"
                    label="Documento Transporte"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="codEstadoDO"
                    label="Estado"
                    width="90">
                </el-table-column>
                <el-table-column
                    prop="goods.codMercancia"
                    label="Código Mercancía"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="codMoneda"
                    label="Moneda"
                    width="90">
                </el-table-column>
                <el-table-column
                    prop="tipoOperacion"
                    label="Tipo Operación"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="fechaRegistro"
                    label="Fecha Registro"
                    width="180"
                    :formatter="formatRegisterDate">
                </el-table-column>
                <el-table-column
                    prop="manifiestoFecha"
                    label="Fecha Manifiesto"
                    width="180"
                    :formatter="formatManifestDate">
                </el-table-column> 
            </el-table>
        </el-row>
        <el-row>
            <el-pagination
                layout="prev, pager, next"
                :page-size="25"
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
        data() {
            return {
                doData: [],
                totalPages: 0, 
                currentPage: 0,
                totalElements: 0,
                port: '',
                loading: true
            }
        },
        computed: {
            ...mapGetters(['getUserId'])
        },
        created() {
            this.port = this.$route.params.portId;
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
                const payload = {userId: this.getUserId, 
                                portId:this.port,
                                page: pageNum }
                this.$store.dispatch('findDoByClientIdAndPortId', payload)
                    .then(res => {
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
            }
        }
    }
</script>

<style scoped>

</style>