import Vue from 'vue'
import VueRouter from 'vue-router'
//import store from '../store/store'

import Home from '../components/dashboard/Dashboard.vue';
import CreateDO from '../components/delivery/CreateDeliveryOrder.vue';
import SearchDO from '../components/delivery/SearchDeliveryOrder.vue';
import ReportHome from '../components/reports/ReportHome.vue';
import SigninPage from '../components/auth/Signin.vue';
import DOList from '../components/delivery/DOList.vue';
import DODetail from '../components/delivery/DeliveryOrderDetail.vue';


Vue.use(VueRouter);

export const routes = [
    { path: '/dashboard', 
      name: 'Home', 
      component: Home
    },
    { path: '/signin', 
      name: 'Signin', 
      component: SigninPage
    },
    { path: '/delivery/list', name: 'DOList', component: DOList},
    { path: '/delivery/create', name: 'CreateDO', component: CreateDO},
    { path: '/delivery/search', name: 'SearchDO', component: SearchDO},
    { path: '/delivery/:doId', name: 'DODetail', component: DODetail, props:true},
    { path: '/reports', name: 'ReportHome', component: ReportHome}
];

export default new VueRouter({
    mode: 'history',
    routes
});