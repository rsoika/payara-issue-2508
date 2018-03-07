package com.rsoika;

/**
 * 
 * 
 * @author Ralph Soika
 * @version 1.0
 * @see DocumentService
 */
public class DocumentEvent {

	public static final int ON_DOCUMENT_SAVE = 1;
	public static final int ON_DOCUMENT_LOAD = 2;
	
 	private int eventType;

	public DocumentEvent( int eventType) {
		this.eventType = eventType;
	}

	public int getEventType() {
		return eventType;
	}


	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	

}
