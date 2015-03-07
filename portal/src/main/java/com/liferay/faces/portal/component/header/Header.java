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
package com.liferay.faces.portal.component.header;

import javax.faces.component.FacesComponent;

import com.liferay.faces.util.component.ComponentUtil;

/**
 * @author	Vernon Singleton
 */
@FacesComponent(value = Header.COMPONENT_TYPE)
public class Header extends HeaderBase {

	// Public Constants
	public static final String COMPONENT_TYPE = "com.liferay.faces.portal.component.header.Header";
	public static final String RENDERER_TYPE = "com.liferay.faces.portal.component.header.internal.HeaderRenderer";
	public static final String STYLE_CLASS_NAME = "portal-header";

	public Header() {
		super();
		setRendererType(RENDERER_TYPE);
	}

	@Override
	public String getStyleClass() {

		// getStateHelper().eval(PropertyKeys.styleClass, null) is called because super.getStyleClass() may return the
		// STYLE_CLASS_NAME of the super class.
		String styleClass = (String) getStateHelper().eval(PropertyKeys.styleClass, null);

		return ComponentUtil.concatCssClasses(styleClass, STYLE_CLASS_NAME);
	}
}
