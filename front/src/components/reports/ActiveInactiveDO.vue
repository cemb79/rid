<template>
    <div class="panel panel-default">
        <div class="panel-heading">Historial DO</div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-striped table-condensed table-responsive">
                    <tbody>
                        <tr>
                            <td class="text-center">Activos</td> 
                            <td class="text-center">{{ activeDOs.active }}</td>  
                        </tr>
                        <tr>
                            <td class="text-center">Inactivos</td> 
                            <td class="text-center">{{ activeDOs.inactive }}</td>  
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                activeDOs: { active: 20, inactive:5 }
            }
        }
    }
</script>