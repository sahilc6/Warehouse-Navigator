import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8088", // adjust if backend runs elsewhere
});

export default api;
