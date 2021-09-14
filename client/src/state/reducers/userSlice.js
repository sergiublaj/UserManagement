import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import * as userApi from "../../api/userApi";
import { persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage";

const initialState = {
	users: [],
	current: null,
	loading: false,
};

export const getUsersAsync = createAsyncThunk("user/fetchUsers", async () => {
	return await userApi.getUsers();
});

export const getUserAsync = createAsyncThunk(
	"user/fetchUser",
	async (userId) => {
		return await userApi.getUser(userId);
	}
);

export const saveUserAsync = createAsyncThunk(
	"user/saveUser",
	async (newUser) => {
		return await userApi.saveUser(newUser);
	}
);

export const updateUserAsync = createAsyncThunk(
	"user/updateUser",
	async (updatedUser, userId) => {
		return await userApi.updateUser(updatedUser, userId);
	}
);

export const deleteUserAsync = createAsyncThunk(
	"user/deleteUser",
	async (userId) => {
		return await userApi.deleteUser(userId);
	}
);

export const userSlice = createSlice({
	name: "user",
	initialState,
	reducers: {
		setLoading: (state, action) => {
			state.loading = action.payload;
		},
		setCurrentUser: (state, action) => {
			state.current = action.payload;
		},
	},
	extraReducers: (builder) => {
		builder
			.addCase(getUsersAsync.fulfilled, (state, action) => {
				state.users = action.payload;
			})
			.addCase(getUserAsync.fulfilled, (state, action) => {
				state.current = action.payload;
			})
			.addCase(saveUserAsync.fulfilled, (state, action) => {
				state.users.push(action.payload);
			})
			.addCase(updateUserAsync.fulfilled, (state, action) => {
				console.log(action.payload);

				// state.users = state.users.map((user) =>
				// 	user.id === action.payload.id ? action.payload : user
				// );
			})
			.addCase(deleteUserAsync.fulfilled, (state, action) => {
				state.users = state.users.filter((user) => user.id !== action.payload);
			});
	},
});

const persistConfig = {
	keyPrefix: "um-",
	key: "user",
	storage,
};

export const { setLoading, setCurrentUser } = userSlice.actions;
export default persistReducer(persistConfig, userSlice.reducer);
