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

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * 
 * @author rsoika
 * 
 */
@Path("/test")
@Produces({ MediaType.TEXT_HTML, MediaType.APPLICATION_XHTML_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,
		MediaType.TEXT_XML })
@Stateless
public class RestService {
	private static Logger logger = Logger.getLogger(RestService.class.getName());

	static List<String> modelEntityTypes = Arrays.asList("WorkflowEnvironmentEntity", "processentity",
			"activityentity");

	@EJB
	DocumentService documentService;

	
	@javax.ws.rs.core.Context
	private HttpServletRequest servletRequest;


	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_XML })
	public String getTest() {
		
		String result=documentService.test();
		return result;
	}
}
