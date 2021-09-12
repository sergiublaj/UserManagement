export const getUsers = () => {
	return fetch("/api/users")
		.then((response) => {
			return response.data;
		})
		.catch((error) => {
			console.log(error);
		});
};
