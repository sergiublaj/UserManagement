import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { toast } from "react-toastify";
import { saveUserAsync } from "../state/reducers/userSlice";

const UserForm = () => {
	const [user, setUser] = useState({
		name: "",
		email: "",
	});
	const { name, email } = user;
	const dispatch = useDispatch();

	const formHandler = (e) => {
		const { name, value } = e.target;

		setUser({
			...user,
			[name]: value,
		});
	};

	const submitForm = (e) => {
		dispatch(saveUserAsync(user));

		toast("User successfully added!");

		setUser({
			name: "",
			email: "",
		});

		e.preventDefault();
	};

	return (
		<div className="card" onSubmit={submitForm}>
			<h2>Insert new user: </h2>
			<form action="#">
				<h3>
					<span className="name-card">Name: </span>
					<input
						className="full-width"
						type="text"
						name="name"
						value={name}
						onChange={formHandler}
						required
					/>
				</h3>

				<h3>
					<span className="email-card">Email: </span>
					<input
						className="full-width"
						type="text"
						name="email"
						value={email}
						onChange={formHandler}
						required
					/>
				</h3>

				<input type="submit" className="btn btn-block" value="Add user" />
			</form>
		</div>
	);
};

export default UserForm;
