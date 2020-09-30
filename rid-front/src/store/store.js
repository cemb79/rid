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
            state.tokenId = userData.token
            state.userId = userData.userId
        },
        clearAuthData (state) {
            state.tokenId = null
            state.userId = null
        },
        storeUser (state, user) {
            state.user = user
        }
    },
    actions: {
        login ({commit, dispatch}, authData) {
            return axios.post(Urls.LOGIN, {username: authData.username, password: authData.password})
                .then(result => {
                    localStorage.setItem('tokenId', result.data.data.idToken)
                    localStorage.setItem('userId', authData.username)
                    commit('authUser', {
                        token: result.data.data.idToken,
                        userId: authData.username
                    })
                })
                .catch(error => console.log(error));
        },
        logout ({commit}) {
            commit('clearAuthData')
            localStorage.removeItem('token')
            localStorage.removeItem('userId')
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
        fetchUser ({commit, state}) {
            let url = Urls.USER_FIND_ID.format(state.userId);
            console.log(state.userId + ' ' + url)
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + this.state.tokenId;
            axios.get(url)
                .then(result => {
                    const res = result.data.data
                    console.log(res)
                    commit('storeUser', res)
                })
                .catch(error => console.log(error));
        }
    }
});