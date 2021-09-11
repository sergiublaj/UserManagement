import React from "react";

const Item = ({ user }) => {
	const { name, email } = user;
	return (
		<div className="card">
			<h3>Name: {name}</h3>
			<h4>Email: {email}</h4>
		</div>
	);
};

export default Item;
