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

package com.liferay.portalweb.portal.permissions.announcements;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SA_AddAAAnnouncementTest extends BaseTestCase {
	public void testSA_AddAAAnnouncement() throws Exception {
		selenium.open("/web/site-name/");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Announcements Permissions Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Announcements Permissions Page",
			RuntimeVariables.replace("Announcements Permissions Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Manage Entries",
			RuntimeVariables.replace("Manage Entries"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_84_distributionScope']",
			RuntimeVariables.replace("label=Announcements Administrator"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Entry']",
			RuntimeVariables.replace("Add Entry"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_84_title']",
			RuntimeVariables.replace("Test AA Announcement"));
		selenium.type("//input[@id='_84_url']",
			RuntimeVariables.replace("http://www.liferay.com"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//td[@id='cke_contents__84_editor']/iframe")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.selectFrame("//td[@id='cke_contents__84_editor']/iframe");
		selenium.type("//body",
			RuntimeVariables.replace("This is a test AA Announcement."));
		selenium.selectFrame("relative=top");
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test AA Announcement"),
			selenium.getText("//tr[3]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("General"),
			selenium.getText("//tr[3]/td[2]/a"));
		assertTrue(selenium.isElementPresent("//tr[3]/td[3]/a"));
		assertTrue(selenium.isElementPresent("//tr[3]/td[4]/a"));
		assertTrue(selenium.isElementPresent("//tr[3]/td[5]/a"));
	}
}