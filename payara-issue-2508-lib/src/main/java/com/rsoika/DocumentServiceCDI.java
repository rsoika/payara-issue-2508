/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsoika;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author lprimak
 */
@ApplicationScoped
public class DocumentServiceCDI {
    	@Inject
	protected Event<DocumentEvent> events;

	/**
	 *
         * @return
	 */
	public String test() {
		String result = "";
		// cdi test

		if (events != null) {
			result = "CDI supported for Event<DocumentEvent> ";
			events.fire(new DocumentEvent(DocumentEvent.ON_DOCUMENT_SAVE));
		} else {
			result = "Missing CDI support for Event<DocumentEvent> !";
		}

		return result;
	}
}
