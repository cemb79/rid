import Vue from 'vue'
import App from './App.vue'

import router from './routes/routes';
import axios from 'axios';
import store from './store/store'
import './factories/script'

import {
  Aside,
  Col,
  Container,
  Dropdown,
  DropdownMenu,
  DropdownItem,
  Header,
  Icon,
  Main,
  Menu,
  Row,
  Submenu,
  MenuItem,
  MenuItemGroup,
  Table,
  TableColumn} from 'element-ui';

Vue.use(Aside);
Vue.use(Col);
Vue.use(Container);
Vue.use(Dropdown);
Vue.use(DropdownItem);
Vue.use(DropdownMenu);
Vue.use(Header);
Vue.use(Icon);
Vue.use(Main);
Vue.use(Menu);
Vue.use(Row);
Vue.use(Submenu);
Vue.use(MenuItem);
Vue.use(MenuItemGroup);
Vue.use(Table);
Vue.use(TableColumn);

axios.defaults.baseURL = 'http://localhost:8085';
axios.defaults.headers.get['Accepts'] = 'application/json'
axios.defaults.headers.common['Authorization'] = 'Bearer ' + store.state.tokenId;

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
