import axios from 'axios'

export default {
  authenticate (request) {
    console.log('AUthService authenticate: ' + request)
    return axios.post('/v1/login', request)
      .then((response) => Promise.resolve(response.data))
      .catch((error) => Promise.reject(error))
  }
}
