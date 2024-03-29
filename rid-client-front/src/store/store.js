import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import Urls from '../routes/urls'
import router from '../routes/routes'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        tokenId: null,
        userId: null,
        user: null
    },
    getters: {
        isAuthenticated (state) {
            return state.tokenId !== null
        },
        getTokenId (state) {
            return state.tokenId
        },
        getUserId (state) {
            return state.userId
        },
        getUser (state) {
            return state.user
        }
    },
    mutations: {
        authUser (state, userData) {
            console.log('saving state auth')
            state.tokenId = userData.token
            state.userId = userData.userId
        },
        clearAuthData (state) {
            state.tokenId = null
            state.userId = null
            localStorage.removeItem('tokenId')
            localStorage.removeItem('userId')
            localStorage.removeItem('expirationDate')
        },
        storeUser (state, user) {
            state.user = user
        }
    },
    actions: {
        setLogoutTimer({commit}, expirationTime) {
            setTimeout(() => {
                commit('clearAuthData')
            }, expirationTime * 1000);
        },
        login ({commit, dispatch}, authData) {
            return axios.post(Urls.LOGIN, {username: authData.username, password: authData.password})
                .then(result => {
                    const now = new Date();
                    var expirationTime = now.getTime() + (result.data.data.expirationTime * 100);
                    console.log(expirationTime);
                    const expirationDate = new Date(expirationTime);
                    localStorage.setItem('tokenId', result.data.data.idToken);
                    localStorage.setItem('userId', authData.username);
                    localStorage.setItem('expirationDate', expirationDate);
                    commit('authUser', {
                        token: result.data.data.idToken,
                        userId: authData.username
                    })
                    //dispatch('setLogoutTimer');
                    dispatch('fetchUser');
                    return result;
                });
        },
        tryAutoLogin ({commit}){
            console.log('tryAutoLogin')
            const token = localStorage.getItem('tokenId');
            if(!token){
                return;
            }
            const expirationDate = localStorage.getItem('expirationDate');
            if(!expirationDate) {
                return;
            }
            var expDate = new Date(expirationDate);
            const now = new Date();
            if(now.getTime() >= expDate.getTime()) {
                console.log('Expired auth data')
                commit('clearAuthData');
                return;
            }
            const userId = localStorage.getItem('userId');
            console.log('Auto login user ', userId)
            commit('authUser', {token: token, userId: userId})
        },
        logout ({commit}) {
            commit('clearAuthData')
            console.log('Loging out')
            router.replace(Urls.HOME)
        },
        getDosByCity (context, userId) {
            let url = Urls.REPORT_DO_SUMMARY_BY_PORT.format(userId);
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.state.tokenId;
            return axios.get(url)
                .then((response) => {
                    return response
                })
                .catch((error) => console.log(error));
        },
        fetchUser ({commit}) {
            let url = Urls.USER_FIND_ID.format(this.state.userId);
            console.log('FetchUser URL', url)
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.state.tokenId;
            axios.get(url)
                .then(result => {
                    const res = result.data.data
                    commit('storeUser', res)
                })
                .catch(error => console.log(error));
        },
        findDoByClientIdAndPortId (context, payload) {
            let url = Urls.DELIVERY_ORDER_FIND_CLIENT_PORT.format(payload.userId, payload.parameters.portId, payload.page);
            console.log(url);
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.state.tokenId;
            return axios.get(url)
                .then((response) => {
                    return response
                })
                .catch((error) => console.log(error));
        },
        findDoById (context, doId) {
            let url = Urls.DELIVERY_ORDER_FIND_ID.format(doId);
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.state.tokenId;
            return axios.get(url)
                .then((response) => {
                    return response
                })
                .catch((error) => console.log(error));
        },
        findDOManagement (context, doId) {
            let url = Urls.DELIVERY_ORDER_MANAGEMENT.format(doId);
            console.log(url);
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.state.tokenId;
            return axios.get(url)
                .then((response) => {
                    return response
                })
                .catch((error) => console.log(error));
        },
        findDOHistory (context, doId) {
            let url = Urls.DELIVERY_ORDER_HISTORY.format(doId);
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.state.tokenId;
            return axios.get(url)
                .then((response) => {
                    return response
                })
                .catch((error) => console.log(error));
        },
        findDoByClientIdAndCriteria (context, payload) {
            let url = Urls.DELIVERY_ORDER_FIND_CLIENT_CRITERIA.format(payload.userId, payload.criteria);
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.state.tokenId;
            return axios.get(url)
                .then((response) => {
                    return response
                })
                .catch((error) => console.log(error));
        },
        findDoByClientIdAndMonth (context, payload) {
            var params = payload.parameters;
            let url = Urls.DELIVERY_ORDER_FIND_CLIENT_MONTH.format(payload.userId, params.month, params.year, payload.page);
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.state.tokenId;
            return axios.get(url)
                .then((response) => {
                    return response
                })
                .catch((error) => console.log(error));
        },
        findDoByClientGropByStatus (context, userId) {
            let url = Urls.DELIVERY_ORDER_FIND_CLIENT_STATUS.format(userId);
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.state.tokenId;
            return axios.get(url)
                .then((response) => {
                    return response
                })
                .catch((error) => console.log(error));
        }
    }
});