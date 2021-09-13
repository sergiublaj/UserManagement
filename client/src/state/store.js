import { createStore, applyMiddleware, compose } from "redux";
import thunkMiddleware from "redux-thunk";
import { persistStore } from "redux-persist";

import rootReducer from "./reducers/rootReducer";

const appliedMiddleware = applyMiddleware(thunkMiddleware);

const store = createStore(
	rootReducer,
	compose(
		appliedMiddleware,
		window.__REDUX_DEVTOOLS_EXTENSION__
			? window.__REDUX_DEVTOOLS_EXTENSION__()
			: function (f) {
					return f;
			  }
	)
);

export const persistor = persistStore(store);

export default store;
