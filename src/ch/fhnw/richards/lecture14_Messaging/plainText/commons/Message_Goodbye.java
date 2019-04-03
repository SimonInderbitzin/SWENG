package ch.fhnw.richards.lecture14_Messaging.plainText.commons;

import java.util.ArrayList;

public class Message_Goodbye extends Message {
    public Message_Goodbye() {
    	super();
    }
	@Override
	protected void receiveAttributes(ArrayList<NameValue> pairs) {
	}    
	
	@Override
	protected void sendAttributes(ArrayList<NameValue> pairs) {
	}
}
