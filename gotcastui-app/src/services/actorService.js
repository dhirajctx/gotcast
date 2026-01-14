import axios from "axios";

const BASE_URL = "http://localhost:8081"; // your backend URL

export const getActors = () => axios.get(`${BASE_URL}/getActors`);

export const createActor = (actor) => axios.post(`${BASE_URL}/createActor`, actor);

export const getActorById = (id) => axios.get(`${BASE_URL}/getActor/${id}`);

export const updateActor = (id, actor) => axios.put(`${BASE_URL}/updateActor/${id}`, actor);

export const deleteActor = (id) => axios.delete(`${BASE_URL}/deleteActor/${id}`);

