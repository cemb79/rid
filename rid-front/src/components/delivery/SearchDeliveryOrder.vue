<template>
    <div class="container">
        <h1>Buscar Delivery Orders</h1>
        <hr>
        <div class="row">
            <div class="col-lg-10">
                <div class="input-group">
                <input type="text" class="form-control" placeholder="Search for...">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Go!</button>
                </span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="table-responsive">
                <table class="table table-striped table-condensed table-responsive">
                    <thead>
                        <tr>
                            <th class="text-center">#</th>
                            <th class="text-center">Ciudad</th>
                            <th class="text-center">Transporte</th>
                            <th class="text-center">Número Pedido</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="orden in dos">
                            <td class="text-center">{{ orden.id }}</td> 
                            <td class="text-center">{{ orden.ciudad }}</td> 
                            <td class="text-center">{{ orden.transporte }}</td>
                            <td class="text-center">{{ orden.numPedido }}</td>
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
                dos: [
                    {id:1, ciudad:'Bogota', transporte:'Aereo', numPedido: '1234'},
                    {id:3, ciudad:'Medellin', transporte:'Terrestre', numPedido: '7896546'}
                ]
            }
        }
    }
</script>