import React from "react";
import ReactDOM from "react-dom";
import { ToastContainer } from "react-toastify";
import { Provider } from "react-redux";
import { BrowserRouter } from "react-router-dom";
import { PersistGate } from "redux-persist/integration/react";
import store, { persistor } from "./state/store";
import AppRoutes from "./utils/routes";
import { initFunctions } from "./utils/utils";

const Root = () => {
	initFunctions();

	return (
		<Provider store={store}>
			<PersistGate persistor={persistor} loading={null}>
				<BrowserRouter>
					<AppRoutes />
					<ToastContainer />
				</BrowserRouter>
			</PersistGate>
		</Provider>
	);
};

ReactDOM.render(<Root />, document.getElementById("root"));
