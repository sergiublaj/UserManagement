import React from "react";
import { connect, useDispatch } from "react-redux";
import { toast } from "react-toastify";
import { BACKEND_URL } from "../utils/config";
import { deleteUser } from "../state/reducers/userSlice";

const Item = (props) => {
	const {
		user: { id, name, email },
		deleteUser,
	} = props;

	const dispatch = useDispatch();

	const editUser = (e) => {
		const cardTarget = e.target.parentNode.parentNode.parentNode.children[0];

		const nameSpan = cardTarget.children[0].children[1];
		nameSpan.remove();

		const input = document.createElement("input");
		input.value = name;
		input.style.fontSize = "18px";
		cardTarget.children[0].appendChild(input);

		const emailSpan = cardTarget.children[1].children[1];
		emailSpan.remove();

		const input2 = document.createElement("input");
		input2.value = email;
		input2.style.fontSize = "16px";
		cardTarget.children[1].appendChild(input2);

		const editButton = e.target;
		editButton.className = "fas fa-save fa-lg card-tool";
		editButton.removeEventListener("click", editUser);
		editButton.addEventListener("click", updateUser);
	};

	const removeUser = async () => {
		dispatch(deleteUser(id));

		await fetch(`${BACKEND_URL}/api/users/${id}`, { method: "DELETE" });

		toast("User deleted!");
	};

	const updateUser = async (e) => {
		const cardTarget = e.target.parentNode.parentNode.parentNode.children[0];

		const nameInput = cardTarget.children[0].children[1];
		const emailInput = cardTarget.children[1].children[1];

		const newUser = {
			name: nameInput.value,
			email: emailInput.value,
		};
		const { name, email } = newUser;

		cardTarget.remove();
		emailInput.remove();

		const nameSpan = document.createElement("span");
		nameSpan.className = "name-span";
		nameSpan.innerHTML = name;
		cardTarget.children[0].appendChild(nameSpan);

		console.log(nameSpan);

		const emailSpan = document.createElement("span");
		emailSpan.className = "email-span";
		emailSpan.innerHTML = email;
		cardTarget.children[1].appendChild(emailSpan);

		const config = {
			method: "PUT",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(newUser),
		};

		await fetch(`${BACKEND_URL}/api/users/${id}`, config);

		toast("User edited successfully!");

		const saveButton = e.target;
		saveButton.className = "fas fa-pen fa-lg card-tool";
		saveButton.removeEventListener("click", updateUser);
		saveButton.addEventListener("click", editUser);
	};

	return (
		<div className="card">
			<div className="container">
				<div className="primary-content">
					<h3>
						<i className="far fa-id-card form-icon" />{" "}
						<span className="name-card"> Name: {name} </span>
					</h3>
					<h4>
						<i className="far fa-envelope form-icon" />
						<span className="email-card"> Email: {email} </span>
					</h4>
				</div>

				<div className="secondary-content">
					<div className="card-tools">
						<i className="fas fa-pen fa-lg card-tool" onClick={editUser} />
						<i className="fas fa-trash fa-lg card-tool" onClick={removeUser} />
					</div>
				</div>
			</div>
		</div>
	);
};

export default connect(null, { deleteUser })(Item);
