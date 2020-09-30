import Vue from 'vue'
import App from './App.vue'

import router from './routes/routes';
import axios from 'axios';
import store from './store/store'
import './factories/script'

axios.defaults.baseURL = 'http://localhost:8085';
axios.defaults.headers.get['Accepts'] = 'application/json'
axios.defaults.headers.common['Authorization'] = 'Bearer ' + store.state.tokenId;

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
