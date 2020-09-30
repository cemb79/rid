<template>
    <div class="container border">
        <div class="col-sm-2">
        </div>
        <div class="col-sm-6 panel panel-default">
            <form class="form-horizontal" @submit.prevent="authenticate">
                <div class="row">
                    <h3>Autenticación</h3>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3" for="email">Usuario</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="username" v-model="username"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3" for="pwd">Contraseña</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" id="pwd" v-model="password"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10">
                        <div class="checkbox">
                            <label><input type="checkbox" name="remember" /> Recordarme</label>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Log in</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-sm-2">
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                username: '',
                password: ''
            }
        },
        methods: {
            authenticate() {
                const formData = {
                    username: this.username,
                    password: this.password
                }
                this.$store.dispatch('login', {username: formData.username, password: formData.password})
                    .then(result => {
                        console.log('fetching user')
                        this.$store.dispatch('fetchUser')
                    })
                    .catch((error) => console.log(error));
            }
        }
    }
</script>