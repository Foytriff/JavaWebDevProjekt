package com.example.javawebdevprojekt.views;

import com.example.javawebdevprojekt.repositories.KonsultRepo;
import com.example.javawebdevprojekt.service.KonsultService;
import com.example.javawebdevprojekt.service.TimRapportService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

public class AppView extends AppLayout {

    public AppView(){
        HorizontalLayout navbarLayout = new HorizontalLayout();
        H1 navbarTitle = new H1("myHrs");
        Button loginBtn = new Button("login", evt -> {
            Notification.show("meddelande");});
        navbarLayout.add(new DrawerToggle(), navbarTitle);

        navbarLayout.setWidthFull();
        navbarLayout.setMargin(true);
        navbarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        navbarLayout.setVisible(true);

        addToNavbar(navbarLayout);

        RouterLink userViewLink = new RouterLink("UserVieww(Konsult)", UserView.class);
        addToDrawer(new VerticalLayout(userViewLink));

    }

}
