import Home from '../components/Home.vue';
import CreateDO from '../components/delivery/CreateDeliveryOrder.vue';
import SearchDO from '../components/delivery/SearchDeliveryOrder.vue';
import ReportHome from '../components/reports/ReportHome.vue';

export const routes = [
    { path: '/', name: 'Home', component: Home },
    { path: '/delivery/create', name: 'CreateDO', component: CreateDO},
    { path: '/delivery/search', name: 'SearchDO', component: SearchDO},
    { path: '/reports', name: 'ReportHome', component: ReportHome}
];