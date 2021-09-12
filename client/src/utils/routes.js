import React, { Suspense } from "react";
import { Route, Switch } from "react-router-dom";

import HomePage from "../pages/HomePage";
import AboutPage from "../pages/NotFoundPage";
import NotFoundPage from "../pages/AboutPage";

const AppRoutes = () => {
	return (
		<Suspense>
			<Switch>
				<Route exact path={`/`} component={HomePage} />
				<Route exact path={`/about`} component={AboutPage} />
				<Route component={NotFoundPage} />
			</Switch>
		</Suspense>
	);
};

export default AppRoutes;
