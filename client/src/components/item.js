import React, { useState } from "react";

const Item = (props) => {
	const {
		user: { name, email },
	} = props;
	const [newUser, setNewUser] = useState({
		name: "",
		email: "",
	});

	const editUser = (e) => {
		const cardTarget = e.target.parentNode.parentNode.parentNode.children[0];

		const nameInput = cardTarget.children[0].children[1];
		nameInput.innerHTML = "";
		const input = document.createElement("input");
		input.value = name;
		input.style.fontSize = "18px";
		nameInput.appendChild(input);

		const emailInput = cardTarget.children[1].children[1];
		emailInput.innerHTML = "";
		const input2 = document.createElement("input");
		input2.value = email;
		input2.style.fontSize = "16px";
		emailInput.appendChild(input2);

		const editButton = e.target;
		editButton.className = "fas fa-save fa-lg card-tool";
		editButton.removeEventListener("click", editUser);
		editButton.addEventListener("click", saveUser);
	};

	const deleteUser = () => {
		console.log("delete");
	};

	const saveUser = (e) => {
		const cardTarget = e.target.parentNode.parentNode.parentNode.children[0];

		const nameInput = cardTarget.children[0].children[1].children[0];
		const emailInput = cardTarget.children[1].children[1].children[0];

		setNewUser({
			name: nameInput.value,
			email: emailInput.value,
		});

		const nameSpan = document.createElement("span");
		nameSpan.className = "name-span";
		nameSpan.innerHTML = nameInput.value;
		nameInput.parentNode.parentNode.appendChild(nameSpan);
		nameInput.remove();

		const emailSpan = document.createElement("span");
		emailSpan.className = "email-span";
		emailSpan.innerHTML = emailInput.value;
		emailInput.parentNode.parentNode.appendChild(emailSpan);
		emailInput.remove();

		const saveButton = e.target;
		saveButton.className = "fas fa-pen fa-lg card-tool";
		saveButton.removeEventListener("click", saveUser);
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
						<i class="far fa-envelope form-icon" />
						<span className="email-card"> Email: {email} </span>
					</h4>
				</div>

				<div className="secondary-content">
					<div className="card-tools">
						<i className="fas fa-pen fa-lg card-tool" onClick={editUser} />
						<i className="fas fa-trash fa-lg card-tool" onClick={deleteUser} />
					</div>
				</div>
			</div>
		</div>
	);
};

export default Item;
