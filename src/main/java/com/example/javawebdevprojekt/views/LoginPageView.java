package com.example.javawebdevprojekt.views;

import com.example.javawebdevprojekt.entities.Anv;
import com.example.javawebdevprojekt.entities.Konsult;
import com.example.javawebdevprojekt.repositories.AppUserRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.Router;
import com.vaadin.flow.router.RouterLink;

import java.util.List;

@Route("/login")
public class LoginPageView extends VerticalLayout {

    AppUserRepo appUserRepo;

    public LoginPageView(AppUserRepo appUserRepo){
        this.appUserRepo = appUserRepo;

        setAlignItems(Alignment.CENTER);

        TextField username = new TextField("Username");
        TextField password = new TextField("Password");

        Binder<Anv> binder = new BeanValidationBinder<>(Anv.class);

        Button loginButton = new Button("Login", evt -> {
            testLogin(username.getValue(), password.getValue());
        });

        Button signUpButton = new Button("Create New Account", evt -> {
            Dialog dialog = new Dialog();
            TextField userField = new TextField("Enter Username");
            TextField passField = new TextField("Enter Password");
            Button createUser = new Button("Create User", e -> {
                createUser(userField, passField, dialog);
            });
            dialog.add(userField, passField, createUser);
            dialog.open();
        });

        add(username, password, loginButton, signUpButton);
    }

    private void testLogin(String username, String password) {

        List<Anv> loginAnv = appUserRepo.findByUsername(username);

        if(loginAnv.isEmpty()){
            System.out.println("failed");
            return;
        }


        String userPass = loginAnv.stream().findFirst().get().getPassword();
        if(password.equals(userPass)){
            //Change view

                RouterLink routerLink = new RouterLink("LoggedIn", LoggedInView.class);
                add(routerLink);
            System.out.println("success");
            return;
        }


    }

    private void createUser(TextField userField, TextField passField, Dialog dialog) {
        Anv newUser = new Konsult(userField.getValue(), passField.getValue());
        appUserRepo.save(newUser);
        dialog.close();
        appUserRepo.findAll().forEach(u -> System.out.println(u.getId() + " " + u.getUsername() + " " + u.getPassword()));
    }

}
