package ch.fhnw.richards.lecture14_Messaging.plainText.commons;

import java.util.ArrayList;

public class Message_Hello extends Message {    
    public Message_Hello() {
    	super();
    }

	@Override
	protected void receiveAttributes(ArrayList<NameValue> pairs) {
	}    
	
	@Override
	protected void sendAttributes(ArrayList<NameValue> pairs) {
	}
}
