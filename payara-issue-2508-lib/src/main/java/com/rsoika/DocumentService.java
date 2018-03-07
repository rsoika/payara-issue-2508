/*******************************************************************************
 *  Imixs Workflow 
 *  Copyright (C) 2001, 2011 Imixs Software Solutions GmbH,  
 *  http://www.imixs.com
 *  
 *  This program is free software; you can redistribute it and/or 
 *  modify it under the terms of the GNU General Public License 
 *  as published by the Free Software Foundation; either version 2 
 *  of the License, or (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful, 
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You can receive a copy of the GNU General Public
 *  License at http://www.gnu.org/licenses/gpl.html
 *  
 *  Project: 
 *  	http://www.imixs.org
 *  	http://java.net/projects/imixs-workflow
 *  
 *  Contributors:  
 *  	Imixs Software Solutions GmbH - initial API and implementation
 *  	Ralph Soika - Software Developer
 *******************************************************************************/

package com.rsoika;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

/**
 * Test Service * @author rsoika
 * 
 * @version 1.0
 * 
 */

@Stateless
@LocalBean
public class DocumentService {

	@Resource
	SessionContext ctx;

	@Inject
	protected Event<DocumentEvent> events;

	@Inject
	BeanManager beanManager;

	private final static Logger logger = Logger.getLogger(DocumentService.class.getName());

	/**
	 * 
	 */
	public String test() {
		String result = "";
		// cdi test

		if (events != null) {
			result = "CDI supported for Event<DocumentEvent> ";
			logger.warning("CDI supported for Event<DocumentEvent> ");
			events.fire(new DocumentEvent(DocumentEvent.ON_DOCUMENT_SAVE));
		} else {
			result = "Missing CDI support for Event<DocumentEvent> !";
			logger.warning("Missing CDI support for Event<DocumentEvent> !");

			if (beanManager == null) {
				result += " - also benManager is null!";
			} else {
				// also null
				beanManager.fireEvent(new DocumentEvent(DocumentEvent.ON_DOCUMENT_SAVE));
			}
		}

		return result;
	}

}
