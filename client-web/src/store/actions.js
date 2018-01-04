import * as types from './mutation-types'
import authService from '../services/auth'

export const login = (store, request) => {
  console.log('VUEX LOGIN: ' + request)
  return authService.authenticate(request)
    .then((response) => {
      console.log('vuex auth response:', response)
      store.commit(types.USER_LOGIN, response)
    })
    .catch((error) => console.error('Error in vuex action: ' + error))
}

export const logout = (store) => {
  store.commit(types.USER_LOGOUT)
}
