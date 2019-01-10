package ch.fhnw.richards.lecture14_Messaging.serialization.commons;

import java.io.Serializable;

import org.w3c.dom.Document;

public class Message_Goodbye extends Message implements Serializable {
	private static final long serialVersionUID = 1; // This is version 1
    public Message_Goodbye() {
    	super();
    }
}
