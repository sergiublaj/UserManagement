import React from "react";
import { useDispatch } from "react-redux";
import { toast } from "react-toastify";
import { updateUserAsync, deleteUserAsync } from "../state/reducers/userSlice";

const Item = (props) => {
	const {
		user: { id, name, email },
	} = props;

	const dispatch = useDispatch();

	const editUser = (e) => {
		const cardTarget = e.target.parentNode.parentNode.parentNode.children[0];

		const nameSpan = cardTarget.children[0].children[1];
		nameSpan.innerHTML = "Name: ";

		const input = document.createElement("input");
		input.value = name;
		input.style.fontSize = "18px";
		cardTarget.children[0].appendChild(input);

		const emailSpan = cardTarget.children[1].children[1];
		emailSpan.innerHTML = "Email: ";

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
		dispatch(deleteUserAsync(id));

		toast("User deleted!");
	};

	const updateUser = async (e) => {
		const cardTarget = e.target.parentNode.parentNode.parentNode.children[0];

		const nameInput = cardTarget.children[0].children[2];
		const emailInput = cardTarget.children[1].children[2];

		const updatedUser = {
			name: nameInput.value,
			email: emailInput.value,
		};
		const { name, email } = updatedUser;

		nameInput.remove();
		emailInput.remove();

		const nameSpan = cardTarget.children[0].children[1];
		nameSpan.innerHTML = `Name: ${name}`;

		const emailSpan = cardTarget.children[1].children[1];
		emailSpan.innerHTML = `Email: ${email}`;

		dispatch(updateUserAsync({ updatedUser, id }));

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

export default Item;
