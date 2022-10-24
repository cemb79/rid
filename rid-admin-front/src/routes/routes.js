import Vue from 'vue'
import VueRouter from 'vue-router'
//import store from '../store/store'

import Home from '../components/dashboard/Dashboard.vue';
import DODetail from '../components/delivery/DODetail.vue';

Vue.use(VueRouter);

export const routes = [
    { path: '/dashboard', 
      name: 'Home', 
      component: Home
    },
    { path: '/delivery/:doId', name: 'DODetail', component: DODetail, props:true }
];

export default new VueRouter({
    mode: 'history',
    routes
});