package ch.fhnw.richards.topic13_Messaging.jaxpDOM.commons;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Message_NewCustomerAccepted extends Message {
    private static final String ELEMENT_NAME = "name";

    private String name;
    
    public Message_NewCustomerAccepted() {
    	super();
    }

	@Override
	protected void receiveAttributes(Document docIn) {
        Element root = docIn.getDocumentElement();
		
		NodeList tmpElements = root.getElementsByTagName(ELEMENT_NAME);
        if (tmpElements.getLength() > 0) {
            Element name = (Element) tmpElements.item(0);
            this.name = name.getTextContent();
        }
	} 
	
	@Override
	protected void sendAttributes(Document docIn) {
        Element root = docIn.getDocumentElement();
		
		Element name = docIn.createElement(ELEMENT_NAME);
		name.setTextContent(this.name);
		root.appendChild(name);
	}
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
