package com.example.javawebdevprojekt.views;

import com.example.javawebdevprojekt.entities.Konsult;
import com.example.javawebdevprojekt.entities.TimRapport;
import com.example.javawebdevprojekt.repositories.KonsultRepo;
import com.example.javawebdevprojekt.repositories.TimRapportRepo;
import com.example.javawebdevprojekt.service.KonsultService;
import com.example.javawebdevprojekt.service.OrganisationService;
import com.example.javawebdevprojekt.service.TimRapportService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "/user", layout = AppView.class)
@AnonymousAllowed
public class UserView extends VerticalLayout {
    KonsultService konsultService;
    TimRapportService timRapportService;
    OrganisationService organisationService;
    Grid<TimRapport> grid = new Grid(TimRapport.class, false);


    public UserView(KonsultService konsultService, TimRapportService timRapportService, OrganisationService organisationService){
        this.konsultService = konsultService;
        this.timRapportService = timRapportService;
        this.organisationService = organisationService;
        List<Konsult> konsultList = konsultService.findAll();
        int loggedInId = konsultList.get(0).getId();
        grid.setItems(timRapportService.findByKonsultId(loggedInId));

        grid.addColumn(TimRapport::getOrganisation);
        grid.addColumn(tr -> tr.getKonsult().getUsername());
        grid.addColumn(TimRapport::getDatum);
        grid.addColumn(TimRapport::getAntalTimmar);

        add(grid);

        Button addNewRapport = new Button("Add Rapport", evt -> handleAddRapport(loggedInId, new Dialog()));

        add(addNewRapport);
    }

    private void handleAddRapport(int loggedInId, Dialog dialog) {
        Konsult konsult = konsultService.findKonsultById(loggedInId);
        RapportForm newTrForm = new RapportForm(timRapportService, organisationService, this, konsult);
        //newTrForm.setTimRapport(new TimRapport());

        dialog.add(newTrForm);
        dialog.open();

    }
}
