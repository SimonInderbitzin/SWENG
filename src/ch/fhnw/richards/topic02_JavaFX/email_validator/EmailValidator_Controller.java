package ch.fhnw.richards.topic02_JavaFX.email_validator;

public class EmailValidator_Controller {    
    final private EmailValidator_Model model;
    final private EmailValidator_View view;
    
    protected EmailValidator_Controller(EmailValidator_Model model, EmailValidator_View view) {
        this.model = model;
        this.view = view;
        
        view.txtEmail.textProperty().addListener(
                // Parameters of any PropertyChangeListener
                (observable, oldValue, newValue) -> validateEmailAddress(newValue) );
    }
    
    private void validateEmailAddress(String newValue) {
        boolean valid = false;
        
        if (newValue.charAt(newValue.length()-1) != '@') {
            String[] addressParts = newValue.split("@");
            if (addressParts.length == 2 && !addressParts[0].isEmpty()) {
                String[] domainParts = addressParts[1].split("\\.");
                if (domainParts.length >= 2) {
                    valid = true;
                    for (String s : domainParts) {
                        if (s.length() < 2) {
                            valid = false;
                            break;
                        }
                    }                
                }
            }
        }
        
        if (valid) {
            view.txtEmail.setStyle("-fx-text-inner-color: green;");
        } else {
            view.txtEmail.setStyle("-fx-text-inner-color: red;");
        }
    }
}
