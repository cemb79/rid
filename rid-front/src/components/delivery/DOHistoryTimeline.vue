<template>
    <el-timeline :reverse="false">
        <el-timeline-item v-for="(activity, index) in activities"
            :key="index"
            :timestamp="activity.fechaEstadoDO | formatDate"
            placement="top">
            {{activity.operationState.nombreEstOpeDO}}
            <el-card v-if="activity.observaciones">
                <div slot="header">
                    <h4 class="font-bold">Observaciones</h4>
                </div>
                <p>{{ activity.observaciones }}</p>
            </el-card>
        </el-timeline-item>
    </el-timeline>
</template>

<script>
    export default {
        props: ['doId'],
        data() {
            return {
                activities: []
            }
        },
        created() {
            this.$store.dispatch('findDOHistory', this.doId)
                .then(res => {
                    this.activities = res.data.data;
                })
                .catch(err => {
                    console.log(err)
                });
        },
        filters: {
            formatDate(value) {
                var dateStr = '';
                if(value !== null) {
                    dateStr = value.substring(0, 10);
                }
                return dateStr
            }
        }
    }
</script>