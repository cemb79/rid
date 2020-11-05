import Vue from 'vue'
import App from './App.vue'

import router from './routes/routes';
import axios from 'axios';
import store from './store/store'
import './assets/styles/index.css';
import './factories/script'
import 'element-ui/lib/theme-chalk/index.css';
import 'element-ui/lib/theme-chalk/reset.css';
import lang from 'element-ui/lib/locale/lang/es'
import locale from 'element-ui/lib/locale'

import {
  Aside,
  Autocomplete,
  Button,
  Card,
  Col,
  Container,
  Divider,
  Dropdown,
  DropdownMenu,
  DropdownItem,
  Form,
  FormItem,
  Header,
  Icon,
  Input,
  Loading,
  Main,
  Menu,
  MessageBox,
  Message,
  Pagination,
  Row,
  Submenu,
  MenuItem,
  MenuItemGroup,
  Table,
  TableColumn,
  Tabs,
  TabPane,
  Timeline,
  TimelineItem,} from 'element-ui';

Vue.use(Aside);
Vue.use(Autocomplete);
Vue.use(Button);
Vue.use(Card);
Vue.use(Col);
Vue.use(Container);
Vue.use(Divider);
Vue.use(Dropdown);
Vue.use(DropdownItem);
Vue.use(DropdownMenu);
Vue.use(Form);
Vue.use(FormItem);
Vue.use(Header);
Vue.use(Icon);
Vue.use(Input);
Vue.use(Loading);
Vue.use(Main);
Vue.use(Menu);
Vue.use(Pagination);
Vue.use(Row);
Vue.use(Submenu);
Vue.use(MenuItem);
Vue.use(MenuItemGroup);
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(Tabs);
Vue.use(TabPane);
Vue.use(Timeline);
Vue.use(TimelineItem);
Vue.use(Loading.directive);

Vue.prototype.$loading = Loading.service;
Vue.prototype.$msgbox = MessageBox;
Vue.prototype.$alert = MessageBox.alert;
Vue.prototype.$confirm = MessageBox.confirm;
Vue.prototype.$prompt = MessageBox.prompt;
Vue.prototype.$message = Message;

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
