/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.bridge.filter.internal;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.RenderResponse;
import javax.portlet.filter.RenderResponseWrapper;

import com.liferay.faces.bridge.context.BridgeContext;
import com.liferay.faces.bridge.internal.BridgeConstants;


/**
 * @author  Neil Griffin
 */
public class RenderResponseBridgeImpl extends RenderResponseWrapper {

	// Private Data Members
	private String namespace;
	private String namespaceWSRP;

	public RenderResponseBridgeImpl(RenderResponse renderResponse) {
		super(renderResponse);
	}

	@Override
	public String getNamespace() {

		if (namespace == null) {

			namespace = super.getNamespace();

			if (namespace.startsWith(BridgeConstants.WSRP_REWRITE)) {

				BridgeContext bridgeContext = BridgeContext.getCurrentInstance();
				namespace = getNamespaceWSRP(bridgeContext);
			}
		}

		return namespace;
	}

	protected String getNamespaceWSRP(BridgeContext bridgeContext) {

		if (namespaceWSRP == null) {

			PortletConfig portletConfig = bridgeContext.getPortletConfig();
			String portletName = portletConfig.getPortletName();
			PortletContext portletContext = bridgeContext.getPortletContext();
			String portletContextName = portletContext.getPortletContextName();

			namespaceWSRP = portletName + portletContextName;
		}

		return namespaceWSRP;
	}
}
