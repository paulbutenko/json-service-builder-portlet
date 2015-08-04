<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<portlet:defineObjects />

This is the <b>Json Service Builder</b> portlet.

<p>Result of <b>get-all-data:</b></p>
<div id="result"></div>
<p/>

<aui:script use="aui-base">
Liferay.Service(
		  '/json-service-builder-portlet.data/get-all-data',
		  successCallback = function(res) {
			  A.one('#result').html('Success: ' + JSON.stringify(res));
		  },
		  exceptionCallback = function(res) {
				A.one('#result').html('Exception: ' + res);
		  }
);
</aui:script>