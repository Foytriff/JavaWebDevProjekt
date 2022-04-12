package com.example.javawebdevprojekt.views;

import com.example.javawebdevprojekt.entities.Konsult;
import com.example.javawebdevprojekt.entities.Organisation;
import com.example.javawebdevprojekt.entities.TimRapport;
import com.example.javawebdevprojekt.repositories.OrganisationRepo;
import com.example.javawebdevprojekt.service.OrganisationService;
import com.example.javawebdevprojekt.service.TimRapportService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import java.util.List;


public class RapportForm extends FormLayout {

    TextField konsultField = new TextField("Konsult");
    NumberField antalTimmar = new NumberField("Enter the amount of hours");
    ComboBox<Organisation> organisation = new ComboBox<>("Select Organisation");
    Button saveButton = new Button("Save", evt -> onSave());

    Binder<TimRapport> binder = new BeanValidationBinder<>(TimRapport.class);

    Converter<Organisation, String> converter = new Converter<>(){

        @Override
        public Result<String> convertToModel(Organisation organisation, ValueContext valueContext) {
            try {
                return Result.ok(organisation.getName());
            } catch (Exception e){
                System.out.println("error");
                return Result.error("bad");
            }
        }

        @Override
        public Organisation convertToPresentation(String s, ValueContext valueContext) {
            return organisation.getValue();
        }
    };

    UserView userView;
    TimRapportService timRapportService;

    OrganisationService organisationService;


    public RapportForm(TimRapportService timRapportService, OrganisationService organisationService, UserView userView, Konsult konsult){
        this.timRapportService = timRapportService;
        this.organisationService = organisationService;
        this.userView = userView;
        konsultField.setReadOnly(false);
        organisation.setItems(organisationService.findAll());
        konsultField.setValue(konsult.getFirstName() + " " + konsult.getLastName());

        konsultField.setReadOnly(true);
        binder.forField(organisation).withConverter(
                converter
        ).bind(TimRapport::getOrganisation, (tr, what) -> {
            Organisation org = organisationService.findAll().stream()
                    .filter(o -> o.getName().equals(what))
                    .findFirst().orElseThrow();
            tr.setOrganisation(org);
        });
        binder.bindInstanceFields(this);

        add(antalTimmar, organisation, konsultField, saveButton);
    }

    private void onSave() {

        TimRapport timRapport = new TimRapport();
        binder.setBean(timRapport);
        timRapport = binder.validate().getBinder().getBean();
        timRapportService.saveTR(timRapport);
        this.getParent().ifPresent(component -> {
            if(component instanceof Dialog){
                ((Dialog) component).close();
            }
        });
    }

    public void setTimRapport(TimRapport timRapport){
        if (timRapport != null)
            binder.setBean(timRapport);
    }
}
