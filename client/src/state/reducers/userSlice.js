import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import * as userApi from "../../api/userApi";

const initialState = {
	users: [],
	current: null,
};

export const receiveUsersAsync = createAsyncThunk(
	"user/fetchUsers",
	async () => {
		return await userApi.getUsers();
	}
);

export const userSlice = createSlice({
	name: "user",
	initialState,
	reducers: {
		setCurrentUser: (state, action) => {
			state.current = action.payload;
		},
	},
	extraReducers: (builder) => {
		builder.addCase(receiveUsersAsync.fulfilled, (state, action) => {
			state.users = action.payload;
		});
	},
});

export const { setCurrentUser } = userSlice.actions;
export default userSlice.reducer;
