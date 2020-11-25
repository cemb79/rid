<template>
    <div>
        <h1>Buscar DO</h1>
        <div class="pt-2 pb-4 w-full">
            <el-autocomplete
                v-model="criteria"
                placeholder="Número DO, Documento transporte o número de pedido"
                prefix-icon="el-icon-search"
                :fetch-suggestions="querySearchAsync"
                :trigger-on-focus="false"
                @select="handleSelect"
            >
            </el-autocomplete>
        </div>
        <hr>
        <div class="pt-4">
            <el-card v-if="doContent.length > 0">
                <el-table :data="doContent" height="350" stripe @row-click="selectRow">
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
            </el-card>
        </div>
    </div>
</template>

<script>
    import { mapGetters } from "vuex";

    export default {
        data() {
            return {
                criteria: '',
                doContent: []
            };
        },
        computed: {
            ...mapGetters(['getUserId'])
        },
        methods: {
            querySearchAsync(queryString, callback) {
                const payload = { userId: this.getUserId, criteria: queryString }
                this.$store.dispatch('findDoByClientIdAndCriteria', payload)
                    .then(res => {
                        const suggest = [];
                        const contents = res.data.data.content;
                        this.doContent = contents;
                        for (let i = 0; i < contents.length; i++) {
                            suggest.push({ value: contents[i].docTransporte});
                        }
                        callback(suggest);
                    })
                    .catch(err => {
                        console.log(err)
                    });
            },
            handleSelect(item) {
                const arr = [];
                for (let i = 0; i < this.doContent.length; i++) {
                    if(this.doContent[i].docTransporte === item.value) {
                        arr.push(this.doContent[i]);
                        this.doContent = arr;
                        break;
                    }
                }
            },
            selectRow(row) {
                this.$router.push({ name: 'DODetail', params: { doId: row.noDO } });
            },
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
            }
        }
    };
</script>
 
<style scoped>
    .el-autocomplete {
        width: 50%;
    }
</style>
