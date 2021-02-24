import Vue from 'vue'
import VueRouter from 'vue-router'
//import store from '../store/store'

import Home from '../components/dashboard/Dashboard.vue';

Vue.use(VueRouter);

export const routes = [
    { path: '/dashboard', 
      name: 'Home', 
      component: Home
    }
];

export default new VueRouter({
    mode: 'history',
    routes
});