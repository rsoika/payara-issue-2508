/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsoika;

import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;


@Stateless
public class DocumentServiceImpl implements DocumentService {

	@Resource
	SessionContext ctx;

	@Inject
	protected Event<DocumentEvent> events;

	@Inject
	BeanManager beanManager;

        @Inject
        private DocumentServiceCDI docServiceCDI;

	private final static Logger logger = Logger.getLogger(DocumentService.class.getName());

	/**
	 * 
         * @return
	 */
        @Override
	public String test() {
		String result = "";
		// cdi test

		if (events != null) {
			result = "EJB: CDI supported for Event<DocumentEvent> ";
			logger.warning("EJB: CDI supported for Event<DocumentEvent> ");
			events.fire(new DocumentEvent(DocumentEvent.ON_DOCUMENT_SAVE));
		} else {
			result = "EJB: Missing CDI support for Event<DocumentEvent> !";
			logger.warning("EJB: Missing CDI support for Event<DocumentEvent> !");

			if (beanManager == null) {
				result += " - also benManager is null!";
			} else {
				// also null
				beanManager.fireEvent(new DocumentEvent(DocumentEvent.ON_DOCUMENT_SAVE));
			}
		}

		return result + docServiceCDI.test();
	}

}
