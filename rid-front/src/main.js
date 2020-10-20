import Vue from 'vue'
import App from './App.vue'

import router from './routes/routes';
import axios from 'axios';
import store from './store/store'
import './factories/script'
import 'element-ui/lib/theme-chalk/index.css';
import 'element-ui/lib/theme-chalk/reset.css';
import lang from 'element-ui/lib/locale/lang/es'
import locale from 'element-ui/lib/locale'

import {
  Aside,
  Button,
  Card,
  Col,
  Container,
  Dropdown,
  DropdownMenu,
  DropdownItem,
  Form,
  FormItem,
  Header,
  Icon,
  Input,
  Main,
  Menu,
  Pagination,
  Row,
  Submenu,
  MenuItem,
  MenuItemGroup,
  Table,
  TableColumn} from 'element-ui';

Vue.use(Aside);
Vue.use(Button);
Vue.use(Card);
Vue.use(Col);
Vue.use(Container);
Vue.use(Dropdown);
Vue.use(DropdownItem);
Vue.use(DropdownMenu);
Vue.use(Form);
Vue.use(FormItem);
Vue.use(Header);
Vue.use(Icon);
Vue.use(Input);
Vue.use(Main);
Vue.use(Menu);
Vue.use(Pagination);
Vue.use(Row);
Vue.use(Submenu);
Vue.use(MenuItem);
Vue.use(MenuItemGroup);
Vue.use(Table);
Vue.use(TableColumn);

locale.use(lang);

axios.defaults.baseURL = 'http://localhost:8085';
axios.defaults.headers.get['Accepts'] = 'application/json'
axios.defaults.headers.common['Authorization'] = 'Bearer ' + store.state.tokenId;

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
