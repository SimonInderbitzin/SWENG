package ch.fhnw.richards.lecture10_JavaAppTemplate.globalResources.dependencyInjection;

import java.util.Locale;

public class ServiceLocator {
    // Resources
    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
