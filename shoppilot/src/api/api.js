import axios from "axios";

const api = axios.create({
<<<<<<< HEAD
  baseURL: "http://localhost:8088", // adjust if backend runs elsewhere
=======
  baseURL: "http://localhost:8080", // adjust if backend runs elsewhere
>>>>>>> 47dceb3195e302200452e27fca3fa60c95fb6d3a
});

export default api;
