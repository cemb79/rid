<template>
    <div class="panel panel-default panel-success">
        <div class="panel-heading">
            <h4>DO Activos por Puerto</h4>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover table-condensed table-responsive">
                    <thead>
                        <tr>
                            <th class="text-center">Puerto</th>
                            <th class="text-center">Ciudad</th>
                            <th class="text-center">DOs Activos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="doCity in dosByCity">
                            <td class="text-center">{{ doCity.port }}</td>
                            <td class="text-center">{{ doCity.portName }}</td>
                            <td class="text-center">{{ doCity.numDO }}</td>  
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from "axios";
    import Urls from "../../routes/urls";
    import { mapGetters } from "vuex";
    export default {
        data() {
            return {
                dosByCity: [
                    /*{city: 'CTG', numDO: 5},
                    {city: 'BOG', numDO: 10},
                    {city: 'MDE', numDO: 7}*/
                ],
                userId: 'fhernandez'
            }
        },
        created() {
            this.$store.dispatch('getDosByCity', this.getUserId)
                .then(res => {
                    this.dosByCity = res.data.data
                })
                .catch(err => {
                    console.log(err)
                });
        },
        computed: {
            ...mapGetters(['getUserId'])
        }
    }
</script>