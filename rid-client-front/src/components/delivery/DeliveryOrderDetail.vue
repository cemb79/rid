<template>
    <div class="content" v-if="deliveryOrder">
        <h1 class="pb-3">Delivery Order: {{deliveryOrder.noDO}}<br><small>DOC. TRANSPORTE: {{ deliveryOrder.docTransporte }}</small></h1>
        <hr class="pb-4">
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Estado de la Operacion</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.status.name | trimPrefix}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Tipo de Operacion</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.tipoOperacion}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Modalidad</span>
            </el-col>
            <el-col :span="4">{{modality}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Fecha de apertura DO</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.fechaRegistro | formatDate}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Tipo de Mercancia</span>
            </el-col>
            <el-col :span="6">{{deliveryOrder.goods.nombreMercancia}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Descripcion de Mercancia</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.descripcionMercancia}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span class="text-blue-800 font-bold">Observaciones</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.descripcionMercancia}}</el-col>
        </el-row>
        <hr class="pb-3">
        <el-row>
            <el-col :span="12">
                <h1 class="py-3">Indicadores</h1>
                <app-history-timeline :doId="deliveryOrder.noDO"></app-history-timeline>
            </el-col>
            <!--<el-col :span="12">
                <h1>Detalles de Actividades de la Operación</h1>
                <app-history :doId="deliveryOrder.noDO"></app-history>
            </el-col>-->
        </el-row>
    </div>
</template>

<script>
    //import DOHistory from './DOHistory.vue';
    import DOHistoryTimeline from './DOHistoryTimeline.vue';

    export default {
        props: ['doId'],
        data() {
            return {
                reverse: false,
                deliveryOrder: null,
                doManagement: null
            }
        },
        components: {
            //appHistory: DOHistory,
            appHistoryTimeline: DOHistoryTimeline
        },
        created() {
            this.$store.dispatch('findDoById', this.doId)
                .then(res => {
                    console.log('findDoById', res);
                    this.deliveryOrder = res.data.data;
                })
                .catch(err => {
                    console.log(err)
                });
            
            this.$store.dispatch('findDOManagement', this.doId)
                .then(res => {
                    console.log('findDOManagement', res.data.data);
                    this.doManagement = res.data.data;
                })
                .catch(err => {
                    console.log(err)
                });
        },
        filters: {
            formatDate: function (value) {
                if (!value) 
                    return ''
                return new Date(value).toISOString().slice(0,10);
            },
            trimPrefix(value) {
                if(!value)
                    return '';
                var pattern = new RegExp('[0-9]{3}');
                return pattern.test(value) ? value.substring(3) : value;
            }
        },
        computed: {
            modality() {
                var result = 'Desconocido';
                if(this.deliveryOrder.codModalidadDO === 'DEF') {
                    result = 'Definitiva';
                } else if (this.deliveryOrder.codModalidadDO === 'TEM') {
                    result = 'Temporal';
                }
                return result;
            }
        }
    }
</script>

<style>
    .el-row {
        margin-bottom: 10px;
        &:last-child {
            margin-bottom: 0;
        }
    }
</style>