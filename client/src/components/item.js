import React, { useState, useEffect } from "react";
import { useDispatch } from "react-redux";
import { toast } from "react-toastify";
import { updateUserAsync, deleteUserAsync } from "../state/reducers/userSlice";

const Item = (props) => {
	const [updatedUser, setUpdatedUser] = useState({
		name: props.user.name,
		email: props.user.email,
	});
	const { id } = props.user;
	const { name, email } = updatedUser;

	const dispatch = useDispatch();

	useEffect(() => {
		const editButton = document.getElementById(`edit-${id}-${name}`);
		editButton.onclick = editUser;

		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	const formHandler = (e) => {
		const { name, value } = e.target;

		setUpdatedUser({
			...updatedUser,
			[name]: value,
		});
	};

	const editUser = (e) => {
		const cardTarget = e.target.parentNode.parentNode.parentNode.children[0];

		const nameInput = cardTarget.children[0].children[1].children[0];
		const emailInput = cardTarget.children[1].children[1].children[0];

		nameInput.disabled = false;
		emailInput.disabled = false;

		const editButton = e.target;
		editButton.className = "fas fa-save fa-lg card-tool";
		editButton.onclick = updateUser;
	};

	const removeUser = () => {
		dispatch(deleteUserAsync(id));

		toast("User deleted!");
	};

	const updateUser = (e) => {
		const cardTarget = e.target.parentNode.parentNode.parentNode.children[0];

		const nameInput = cardTarget.children[0].children[1].children[0];
		const emailInput = cardTarget.children[1].children[1].children[0];

		nameInput.disabled = true;
		emailInput.disabled = true;

		dispatch(
			updateUserAsync({
				updatedUser: {
					name: nameInput.value,
					email: emailInput.value,
				},
				id,
			})
		);

		toast("User edited successfully!");

		const saveButton = e.target;
		saveButton.className = "fas fa-pen fa-lg card-tool";
		saveButton.onclick = editUser;
	};

	return (
		<div className="card">
			<div className="container">
				<div className="primary-content">
					<h3>
						<i className="far fa-id-card form-icon" />
						<label>
							Name:{" "}
							<input
								type="text"
								name="name"
								value={name}
								onChange={formHandler}
								disabled
							/>
						</label>
					</h3>
					<h4>
						<i className="far fa-envelope form-icon" />
						<label>
							Email:{" "}
							<input
								type="text"
								name="email"
								value={email}
								onChange={formHandler}
								disabled
							/>
						</label>
					</h4>
				</div>

				<div className="secondary-content">
					<div className="card-tools">
						<i
							id={`edit-${id}-${name}`}
							className="fas fa-pen fa-lg card-tool"
						/>
						<i className="fas fa-trash fa-lg card-tool" onClick={removeUser} />
					</div>
				</div>
			</div>
		</div>
	);
};

export default Item;
