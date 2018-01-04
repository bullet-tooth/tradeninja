export const user = (state) => {
  return state.user
}
export const isLogged = (state) => {
  return typeof state.user !== 'undefined' && state.user !== null
}
