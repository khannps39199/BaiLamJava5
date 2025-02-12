import axios from 'axios';

const apiService = {
  getAll(resource) {
    return axios.get(`/api/${resource}`);
  },
  getById(resource, id) {
    return axios.get(`/api/${resource}/${id}`);
  },
  create(resource, data) {
    return axios.post(`/api/${resource}`, data);
  },
  update(resource, id, data) {
    return axios.put(`/api/${resource}/${id}`, data);
  },
  delete(resource, id) {
    return axios.delete(`/api/${resource}/${id}`);
  },
};

export default apiService;