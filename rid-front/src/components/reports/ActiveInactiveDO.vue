<template>
    <el-card>
        <div class="panel-heading">
            <h4>Historial DO</h4>
        </div>
        <div class="panel-body">
            <el-table :data="activeDOs">
                <el-table-column
                    prop="active"
                    label="Activos"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="inactive"
                    label="Inactivo"
                    width="180">
                </el-table-column>
            </el-table>
        </div>
    </el-card>
</template>

<script>
    export default {
        data() {
            return {
                activeDOs: [{ active: 20, inactive:5 }]
            }
        }
    }
</script>