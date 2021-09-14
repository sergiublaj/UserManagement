import { BACKEND_URL } from "../utils/config";

export const getUsers = () => {
	return fetch(`${BACKEND_URL}/api/users`)
		.then((response) => response.json())
		.catch((error) => console.error(error));
};

export const getUser = (userId) => {
	return fetch(`${BACKEND_URL}/api/users/${userId}`)
		.then((response) => response.json())
		.catch((error) => console.error(error));
};

export const saveUser = (newUser) => {
	const config = {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(newUser),
	};

	return fetch(`${BACKEND_URL}/api/users`, config)
		.then((response) => response.json())
		.catch((error) => console.error(error));
};

export const updateUser = (updatedUser, userId) => {
	const config = {
		method: "PUT",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(updatedUser),
	};

	return fetch(`${BACKEND_URL}/api/users/${userId}`, config)
		.then((response) => response.json())
		.catch((error) => console.error(error));
};

export const deleteUser = (userId) => {
	return fetch(`${BACKEND_URL}/api/users/${userId}`, { method: "DELETE" })
		.then((response) => response.json())
		.catch((error) => console.error(error));
};
