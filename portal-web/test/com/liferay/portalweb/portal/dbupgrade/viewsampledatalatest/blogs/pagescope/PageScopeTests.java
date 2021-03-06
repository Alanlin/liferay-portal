/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.blogs.pagescope;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PageScopeTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(ViewPage1BlogsEntry1Test.class);
		testSuite.addTestSuite(ViewPage1BlogsEntry1Comment1Test.class);
		testSuite.addTestSuite(ViewPage1BlogsEntry1Comment2Test.class);
		testSuite.addTestSuite(ViewRatePage1BlogsEntry1Test.class);
		testSuite.addTestSuite(ViewRatePage1BlogsEntry1Comment1Test.class);
		testSuite.addTestSuite(ViewRatePage1BlogsEntry1Comment2Test.class);
		testSuite.addTestSuite(ViewPage2BlogsEntry2Test.class);
		testSuite.addTestSuite(ViewPage2BlogsEntry2Comment1Test.class);
		testSuite.addTestSuite(ViewPage2BlogsEntry2Comment2Test.class);
		testSuite.addTestSuite(ViewRatePage2BlogsEntry2Test.class);
		testSuite.addTestSuite(ViewRatePage2BlogsEntry2Comment1Test.class);
		testSuite.addTestSuite(ViewRatePage2BlogsEntry2Comment2Test.class);
		testSuite.addTestSuite(ViewPage2BlogsEntry3Test.class);
		testSuite.addTestSuite(ViewPage2BlogsEntry4Test.class);
		testSuite.addTestSuite(
			ViewConfigurePortlet2MaximumItemsToDisplay1Test.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(Guest_ViewPage1BlogsEntry1Test.class);
		testSuite.addTestSuite(Guest_ViewPage2BlogsEntry2Test.class);
		testSuite.addTestSuite(Guest_ViewPage2BlogsEntry3Test.class);
		testSuite.addTestSuite(Guest_ViewPage2BlogsEntry4Test.class);
		testSuite.addTestSuite(
			Guest_ViewConfigurePortlet2MaximumItemsToDisplay1Test.class);
		testSuite.addTestSuite(SignInTest.class);

		return testSuite;
	}

}