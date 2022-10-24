<template>
    <div class="content" v-if="deliveryOrder">
        <h1 class="pb-3 text-xl text-primary">Delivery Order: {{deliveryOrder.noDO}}<br><small>DOC. TRANSPORTE: {{ deliveryOrder.docTransporte }}</small></h1>
        <h2>Fecha de Apertura: {{ deliveryOrder.fechaRegistro | formatDate }}</h2>
        <hr class="pb-4">
        <h2 class="text-gray-600 font-semibold text-lg">Encabezado DO</h2>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Oficina</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.office.nombreSucursal}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Tipo de Operación</span>
            </el-col>
            <el-col :span="7">
                <div class="hover:bg-gray-200 rounded-sm transition duration-300 ease-in-out" v-if="!isOperationTypeEditable" @click="isOperationTypeEditable = !isOperationTypeEditable">{{deliveryOrder.tipoOperacion}}</div>
                <div v-else>
                    <el-select v-model="deliveryOrder.tipoOperacion" @change="isOperationTypeEditable = !isOperationTypeEditable">
                        <el-option v-for="item in opertationType" :key="item" :label="item" :value="item"></el-option>
                    </el-select>
                </div>
            </el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Asociado Negocio</span>
            </el-col>
            <el-col :span="7">
                <div class="hover:bg-gray-200 rounded-sm transition duration-300 ease-in-out" v-if="!isCustomerEditable" @click="fetchCustomerList">{{deliveryOrder.customer.name}}</div>
                <div v-else>
                    <el-select class="w-96" filterable v-model="deliveryOrder.customer.name" @change="isCustomerEditable = !isCustomerEditable" @click="isCustomerEditable = !isCustomerEditable">
                        <el-option v-for="item in customerList" :key="item.codCliente" :label="item.name" :value="item.name"></el-option>
                    </el-select>
                </div>
            </el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Estado Operación</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.status.name}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Número Pedido</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.noPedido}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Descripción de mercancía</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.descripcionMercancia}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Ejecutivo Responsable</span>
            </el-col>
            <el-col :span="4"></el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="4">
                <span>Observaciones Generales</span>
            </el-col>
            <el-col :span="4">{{deliveryOrder.observaciones}}</el-col>
        </el-row>
        <hr class="pb-4">
        <h2 class="text-gray-600 text-lg font-semibold">Datos de Operación</h2>
        <el-row :gutter="10">
            <el-col :span="3">
                <span>Puerto Arribo</span>
            </el-col>
            <el-col :span="3">
                <div class="hover:bg-gray-200 rounded-sm transition duration-300 ease-in-out" v-if="!isPortEditable" @click="isPortEditable = !isPortEditable">{{deliveryOrder.portId}}</div>
                <div v-else>
                    <el-input v-model="deliveryOrder.portId"></el-input>
                    <el-button slot="append" icon="el-icon-check" @click="isPortEditable = !isPortEditable"></el-button>
                </div>
            </el-col>
            <el-col :span="3">
                <span>Deposito Aduanero</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.portId}}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="3">
                <span>Manifiesto</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.manifiesto}}</el-col>
            <el-col :span="3">
                <span>Fecha Manifiesto</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.manifiestoFecha | formatDate }}</el-col>
            <el-col :span="3">
                <span>Fecha Vencimiento</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.manifiestoVencimiento | formatDate }}</el-col>
        </el-row>
        <el-row :gutter="10">
            <el-col :span="3">
                <span>Tipo Declaracion</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.codTipoDeclaracion}}</el-col>
        </el-row>
        <el-row>
            <el-col :span="3">
                <span>Declaración Anticipada</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.declaracionAnticipada}}</el-col>
            <el-col :span="3">
                <span>Inspección Previa</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.inspeccionPrevia}}</el-col>
            <el-col :span="3">
                <span>Manejo Seriales</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.mercanciaSerial}}</el-col>
        </el-row>
        <el-row>
            <el-col :span="3">
                <span>Medio de Transporte</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.transportationType.nombreTransporte}}</el-col>
            <el-col :span="3">
                <span>Doc. Transporte</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.docTransporte}}</el-col>
            <el-col :span="3">
                <span>Valor</span>
            </el-col>
            <el-col :span="3">{{deliveryOrder.codTerminoNegociacion}} - {{deliveryOrder.currency.name}} ${{ deliveryOrder.valor }}</el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        props: ['doId'],
        data() {
            return {
                deliveryOrder: null,
                isCustomerEditable: false,
                isPortEditable: false,
                isOperationTypeEditable: false,
                opertationType: ['EXP', 'IMP'],
                customerList: []

            }
        },
        created() {
            this.$store.dispatch('findDoById', this.doId)
                .then(res => {
                    this.deliveryOrder = res.data.data;
                })
                .catch(err => {
                    console.log(err)
                });
            this.$store.dispatch('fetchCustomers')
                .then(res => {
                    this.customerList = res.data.data;
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
        },
        methods: {
            fetchCustomerList() {
                this.isCustomerEditable = !this.isCustomerEditable
            }
        }
    }
</script>

<style scoped>
    span {
        font-weight: 600;
    }
</style>