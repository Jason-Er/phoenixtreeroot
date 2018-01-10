package com.phoenixtreeroot.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.phoenixtreeroot.model.system.User;

@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {
	public final String appUrl;
    public final Locale locale;
    public final User user;

    public OnRegistrationCompleteEvent(final User user, final Locale locale, final String appUrl) {
        super(user);
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }
}
