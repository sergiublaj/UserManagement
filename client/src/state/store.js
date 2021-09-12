import { createStore, applyMiddleware } from "redux";
import thunkMiddleware from "redux-thunk";
import { persistStore } from "redux-persist";

import rootReducer from "./reducers/rootReducer";

const appliedMiddleware = applyMiddleware(thunkMiddleware);

const store = createStore(rootReducer, appliedMiddleware);

export const persistor = persistStore(store);

export default store;
