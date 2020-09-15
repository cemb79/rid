<template>
    <ul class="col-md-2 sidenav">
        <h4>Registro Integral Documental</h4>
        <hr class="sidebar-divider">
        <ul class="nav nav-pills nav-stacked">
            <router-link to="/" activeClass="active" tag="li"><a><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></router-link>
        </ul>
        <hr class="sidebar-divider">
        <ul class="nav nav-pills nav-stacked" v-if="userRole !== 'ANE'">
            <router-link :to="{name: 'CreateDO'}" activeClass="active" tag="li"><a>Crear DO</a></router-link>
            <li><a href="#section2">Asignaciones</a></li>
            <li><a href="#section3">Reportes</a></li>
        </ul>
        <ul class="nav nav-pills nav-stacked" v-else>
            <router-link :to="{name: 'SearchDO'}" tag="li"><a>Buscar <span class="glyphicon glyphicon-search"></span></a></router-link>
            <router-link :to="{name: 'ReportHome'}" tag="li"><a>Reportes</a></router-link>
        </ul>
        <hr class="sidebar-divider">
    </ul>
</template>

<script>
    export default {
        data() {
            return {
                userRole: 'ANE'
            }
        }
    }
</script>