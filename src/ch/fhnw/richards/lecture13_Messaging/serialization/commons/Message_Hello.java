package ch.fhnw.richards.lecture13_Messaging.serialization.commons;

import java.io.Serializable;

public class Message_Hello extends Message implements Serializable {    
	private static final long serialVersionUID = 1; // This is version 1
    public Message_Hello() {
    	super();
    }
}
