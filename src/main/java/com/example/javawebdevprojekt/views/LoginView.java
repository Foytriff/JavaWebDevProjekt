package com.example.javawebdevprojekt.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;

@Route("/login")
public class LoginView extends Div {

    LoginOverlay loginOverlay = new LoginOverlay();

    public LoginView() {

        loginOverlay.setTitle("MyHrs");
        loginOverlay.setDescription("Login");
        loginOverlay.setOpened(true);
        loginOverlay.setAction("login");

        add(loginOverlay);

    }
}
