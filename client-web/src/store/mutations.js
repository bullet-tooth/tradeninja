import Vue from 'vue'
import * as types from './mutation-types'

export default {
  [types.USER_LOGIN] (state, user) {
    console.log('Got user in vuex mutation: ', user)
    Vue.set(state, 'user', user)
  },
  [types.USER_LOGOUT] (state) {
    console.log('logout in vuex mutation')
    state.user = null
  }
}
