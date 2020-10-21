<template>
    <div class="content">
        <h1>Delivery Order: {{deliveryOrder.noDO}}<br><small>DOC. TRANSPORTE: {{ deliveryOrder.docTransporte }}</small></h1>
        <hr>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Estado de la Operacion</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.codEstadoDO}}</el-col>
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
            <el-col :span="4">{{deliveryOrder.codModalidadDO}}</el-col>
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
                <span>Observaciones</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.descripcionMercancia}}</el-col>
        </el-row>
        <hr>
        <el-row>
            <el-col :span="12">
                <h1>Indicadores</h1>
                <el-timeline :reverse="reverse">
                    <el-timeline-item v-for="(activity, index) in activities"
                        :key="index"
                        :timestamp="activity.timestamp">
                        {{activity.content}}
                    </el-timeline-item>
                </el-timeline>
            </el-col>
            <el-col :span="12">
                <h1>Detalles de Actividades de la Operación</h1>
                <app-history :doId="deliveryOrder.noDO"></app-history>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import DOHistory from './DOHistory.vue';

    export default {
        props: ['doId'],
        data() {
            return {
                reverse: false,
                deliveryOrder: null,
                doManagement: null,
                activities: [{
                        content: 'Event start',
                        timestamp: '2018-04-15'
                        }, {
                        content: 'Approved',
                        timestamp: '2018-04-13'
                        }, {
                        content: 'Success',
                        timestamp: '2018-04-11'
                    }]
            }
        },
        components: {
            appHistory: DOHistory
        },
        created() {
            this.$store.dispatch('findDoById', this.doId)
                .then(res => {
                    this.deliveryOrder = res.data.data;
                })
                .catch(err => {
                    console.log(err)
                });
            
            this.$store.dispatch('findDOManagement', this.doId)
                .then(res => {
                    console.log(res.data.data);
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