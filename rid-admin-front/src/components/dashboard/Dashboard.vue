<template>
    <div>
        <app-do-list :repKey="reportKey" :title="'DO por usuario'"></app-do-list>
    </div>
</template>

<script>
    import DOList from '../delivery/DOList.vue'

    export default {
        data() {
            return {
                reportKey: 'USER'
            }
        },
        components: {
            appDoList: DOList
        }
    }
</script>