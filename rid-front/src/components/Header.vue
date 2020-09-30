<template>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>                        
                </button>
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">RID</a>
                </div>
            </div> -->
            <div class="collapse navbar-collapse" id="myNavbar">
                <div class="nav navbar-nav">
                    <a class="navbar-brand" href="/">
                        <img src="../assets/Acolcex.png" width="30" height="30">
                    </a>
                </div>
                <ul class="nav navbar-nav">
                    <router-link :to="{name: 'Home'}" activeClass="active" tag="li"><a>Home</a></router-link>
                </ul>
                <ul class="nav navbar-nav navbar-right" v-if="isAuthenticated">
                    <li><a href="#"><span class="glyphicon glyphicon-bell"></span></a></li>
                    <!--<li class="dropdown" :class="{open: isDropdownOpen}" @click="isDropdownOpen = !isDropdownOpen">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                                    aria-haspopup="true"
                                    aria-expanded="false"><span class="glyphicon glyphicon-cog"></span></a>
                        <ul class="dropdown-menu">
                            <h4 align="center"><small><strong>Configuración</strong></small></h4>
                            <li><a href="#">Administración de Usuarios</a></li>
                        </ul>
                    </li>-->
                    <li class="dropdown" :class="{open: isDropdownOpen}" @click="isDropdownOpen = !isDropdownOpen">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                            <span class="glyphicon glyphicon-user"></span> {{username}}</a>
                        <ul class="dropdown-menu">
                            <h4 align="center"><small><strong>Configuración</strong></small></h4>
                            <li><a href="#">Administración de Usuarios</a></li>
                            <hr>
                            <li><a href="#" @click="logout">Salir</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
    export default {
        data() {
            return {
                isDropdownOpen: false
            }
        },
        methods: {
            logout() {
                this.$store.dispatch('logout')
            }
        },
        computed: {
            isAuthenticated () {
                return this.$store.getters.isAuthenticated
            },
            username() {
                return this.$store.state.userId
            }
        }
    }
</script>
<style scoped>
    strong {
        text-align: center
    }
</style>