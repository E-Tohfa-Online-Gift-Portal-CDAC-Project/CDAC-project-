import axios from 'axios'
import { config } from './config'

export async function register(firstName, lastName, email, password, phone) {
  try {
    // post body
    const body = { firstName, lastName, email, password,phone}

    // send the post request
    const response = await axios.post(`${config.serverUrl}/user/register`, body)

    // return the json body from response object
    return response
  } catch (ex) {
    console.log(`exception: `, ex)
  }

  return null
}

export async function updateProfile(firstName, lastName, phone) {
  try {
    const token = sessionStorage['token']
    const body = { firstName, lastName, phone }
    const response = await axios.put(`${config.serverUrl}/user/profile`, body, {
      headers: { token },
    })
    return response.data
  } catch (ex) {
    console.log(`exception: `, ex)
    return null
  }
}

export async function getProfile() {
  try {
    const token = sessionStorage['token']
    const response = await axios.get(`${config.serverUrl}/user/profile`, {
      headers: { token },
    })
    return response.data
  } catch (ex) {
    console.log(`exception: `, ex)
    return null
  }
}

export async function login(email, password) {
  const body = { email, password }
  try {
    const response = await axios.post(`${config.serverUrl}/user/login`, body)
    return response.data
  } catch (ex) {
    console.log(`exception: `, ex)
  }

  return null
    axios
      .post(`${config.serverUrl}/admin/login`, body)
      .then((response) => {
        console.log(response.data)
        return response.data
      })
      .catch((error) => {
        console.log(error)
      })
}