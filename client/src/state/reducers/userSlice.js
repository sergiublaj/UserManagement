import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import * as userApi from "../../api/userApi";
import { persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage";

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
		deleteUser: (state, action) => {
			state.users = state.users.filter((user) => user.id !== action.payload);
		},
	},
	extraReducers: (builder) => {
		builder.addCase(receiveUsersAsync.fulfilled, (state, action) => {
			state.users = action.payload;
		});
	},
});

const persistConfig = {
	keyPrefix: "um-",
	key: "user",
	storage,
};

export const { setCurrentUser, deleteUser } = userSlice.actions;
export default persistReducer(persistConfig, userSlice.reducer);
