package com.example.javawebdevprojekt.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "loggedin")
public class LoggedInView extends VerticalLayout {

    public LoggedInView(){
        H1 hej = new H1("hej");
        add(hej);
    }
}
