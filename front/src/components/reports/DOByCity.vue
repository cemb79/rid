<template>
    <div class="panel panel-default">
        <div class="panel-heading">DO Activos por ciudad</div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover table-condensed table-responsive">
                    <thead>
                        <tr>
                            <th class="text-center">Ciudad</th>
                            <th class="text-center">DOs Activos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="doCity in dosByCity">
                            <td class="text-center">{{ doCity.city }}</td> 
                            <td class="text-center">{{ doCity.numDO }}</td>  
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
                dosByCity: [
                    {city: 'CTG', numDO: 5},
                    {city: 'BOG', numDO: 10},
                    {city: 'MDE', numDO: 7}
                ]
            }
        }
    }
</script>