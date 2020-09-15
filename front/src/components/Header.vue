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
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">RID</a>
                </div>
                <ul class="nav navbar-nav">
                    <router-link :to="{name: 'Home'}" activeClass="active" tag="li"><a>Home</a></router-link>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-bell"></span></a></li>
                    <li class="dropdown" :class="{open: isDropdownOpen}" @click="isDropdownOpen = !isDropdownOpen">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                                    aria-haspopup="true"
                                    aria-expanded="false"><span class="glyphicon glyphicon-cog"></span></a>
                        <ul class="dropdown-menu">
                            <h4 align="center"><small><strong>Configuración</strong></small></h4>
                            <li><a href="#">Administración de Usuarios</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> Usuario</a></li>
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
        }
    }
</script>
<style scoped>
    strong {
        text-align: center
    }
</style>