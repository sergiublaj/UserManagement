import React, { useEffect } from "react";
import { connect, useDispatch } from "react-redux";
import UserForm from "../components/user-form";
import Item from "../components/item";
import { CSSTransition, TransitionGroup } from "react-transition-group";
import { setLoading, getUsersAsync } from "../state/reducers/userSlice";

const HomePage = (props) => {
	const { users, loading } = props;

	const dispatch = useDispatch();

	useEffect(() => {
		dispatch(setLoading(true));

		dispatch(getUsersAsync());

		dispatch(setLoading(false));
	}, []);

	return (
		<>
			<UserForm />
			{loading ? (
				<h1> Loading ...</h1>
			) : users.length === 0 ? (
				<h1> No users found. </h1>
			) : (
				<>
					<h1>All users</h1>
					<TransitionGroup>
						{users.map((user) => (
							<CSSTransition key={user.id} timeout={500} classNames="item">
								<Item user={user} />
							</CSSTransition>
						))}
					</TransitionGroup>
				</>
			)}
		</>
	);
};

const mapStateToProps = (state) => ({
	users: state.user.users,
	loading: state.user.loading,
});

export default connect(mapStateToProps)(HomePage);
