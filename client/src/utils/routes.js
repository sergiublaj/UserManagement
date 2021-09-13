import React, { Suspense } from "react";
import { Route, Switch } from "react-router-dom";

import HomePage from "../pages/HomePage";
import AboutPage from "../pages/AboutPage";
import NotFoundPage from "../pages/NotFoundPage";

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
