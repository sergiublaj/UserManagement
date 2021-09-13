import React, { useEffect, useState } from "react";
import Item from "../components/item";
import { BACKEND_URL } from "../utils/config";

const HomePage = () => {
	const [users, setUsers] = useState([]);
	const [loading, setLoading] = useState(false);

	useEffect(() => {
		fetchData();
	}, []);

	const fetchData = async () => {
		setLoading(true);

		// nu bun
		const res = await fetch(`${BACKEND_URL}/api/users`);
		const data = await res.json();

		setUsers(data);

		setLoading(false);
	};

	return loading || users.length === 0 ? (
		<div> Loading ...</div>
	) : (
		<>
			<h1>All users</h1>
			{users.map((user) => (
				<Item user={user} key={"child" + user.name} />
			))}
		</>
	);
};

export default HomePage;
