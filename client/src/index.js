import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import { BrowserRouter } from "react-router-dom";
import { PersistGate } from "redux-persist/integration/react";

import store, { persistor } from "./state/store";
import AppRoutes from "./utils/routes";

const Root = () => {
	return (
		// // <Provider store={store}>
		// 	{/* <PersistGate persistor={persistor}> */}
		<BrowserRouter>
			<AppRoutes />
		</BrowserRouter>
		// 	// </PersistGate>
		// // </Provider>
	);
};

ReactDOM.render(<Root />, document.getElementById("root"));
