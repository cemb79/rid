<template>
    <el-card>
        <h2>Puerto {{ getContext.port }}</h2>
        <el-row>
            <el-table :data="doData" height="750" stripe>
                <el-table-column
                    prop="codDeposito"
                    label="Código Depósito"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="codMercancia"
                    label="Código Mercancía"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="codMoneda"
                    label="Moneda"
                    width="90">
                </el-table-column>
                <el-table-column
                    prop="docTransporte"
                    label="Documento Transporte"
                    width="180">
                </el-table-column> tipoOperacion
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
                page-size="25"
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
                totalElements: 0
            }
        },
        computed: {
            ...mapGetters(['getUserId', 'getContext'])
        },
        created() {
            console.log(this.getContext.port);
            this.fetchData(0);
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
            fetchData(page) {
                const payload = {userId: this.getUserId, 
                                portId:this.getContext.port,
                                page }
                this.$store.dispatch('findDoByClientIdAndPortId', payload)
                .then(res => {
                    console.log(res)
                    this.totalPages = res.data.data.totalPages;
                    this.doData = res.data.data.content;
                    this.currentPage = res.data.data.currentPage;
                    this.totalElements = res.data.data.totalElements;
                })
                .catch(err => {
                    console.log(err)
                });
            }
        }
    }
</script>

<style scoped>

</style>