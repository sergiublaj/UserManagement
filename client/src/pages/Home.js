import React, { useEffect, useState } from "react";
import Item from "../components/item";
import { BACKEND_URL } from "../config";

const Home = () => {
	const [users, setUsers] = useState([]);
	const [loading, setLoading] = useState(false);
	const random = Math.floor(Math.random() * 3);

	useEffect(() => {
		fetchData();
	}, []);

	const fetchData = async () => {
		setLoading(true);
		const res = await fetch(`${BACKEND_URL}/api/users`);
		const data = await res.json();

		const res2 = await fetch(`${BACKEND_URL}/api/user/${random + 1}`);
		const data2 = await res2.json();

		setUsers(data, data2);

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

			<h1>Selecting the {random + 1}th user</h1>
			<Item user={users[random]} key={"random"} />
		</>
	);
};

export default Home;
