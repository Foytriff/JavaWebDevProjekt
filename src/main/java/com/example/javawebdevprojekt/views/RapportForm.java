package com.example.javawebdevprojekt.views;

import com.example.javawebdevprojekt.entities.Konsult;
import com.example.javawebdevprojekt.entities.Organisation;
import com.example.javawebdevprojekt.entities.TimRapport;
import com.example.javawebdevprojekt.repositories.OrganisationRepo;
import com.example.javawebdevprojekt.service.KonsultService;
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

    int loggedInId;

    Binder<TimRapport> binder = new BeanValidationBinder<>(TimRapport.class);

    Converter<String, Organisation> orgConverter = new Converter<String, Organisation>() {
        @Override
        public Result<Organisation> convertToModel(String s, ValueContext valueContext) {
            try {
                return Result.ok(organisationService.findAll().stream().filter(o -> o.getName().equals(s)).findFirst().orElseThrow());
            } catch (Exception e){
                return Result.error("bad");
            }
        }

        @Override
        public String convertToPresentation(Organisation organisation, ValueContext valueContext) {
            return null;
        }
    };

    Converter<String, Konsult> konsultConverter = new Converter<String, Konsult>() {
        @Override
        public Result<Konsult> convertToModel(String s, ValueContext valueContext) {
            try {
                return Result.ok(konsultService.findKonsultById(loggedInId));
            } catch (Exception e){
                return Result.error("badKon");
            }
        }

        @Override
        public String convertToPresentation(Konsult konsult, ValueContext valueContext) {
            return konsultField.getValue();
        }
    };

    UserView userView;
    TimRapportService timRapportService;

    OrganisationService organisationService;

    KonsultService konsultService;


    public RapportForm(TimRapportService timRapportService, OrganisationService organisationService, KonsultService konsultService, UserView userView, Konsult konsult){
        this.timRapportService = timRapportService;
        this.organisationService = organisationService;
        this.loggedInId = konsult.getId();
        this.konsultService = konsultService;
        this.userView = userView;
        konsultField.setReadOnly(false);
        organisation.setItems(organisationService.findAll().stream().toList());
        konsultField.setValue(konsult.getFirstName() + " " + konsult.getLastName());

        binder.forField(konsultField).withConverter(konsultConverter).bind(TimRapport::getKonsult, TimRapport::setKonsult);
        binder.forField(organisation).bind(TimRapport::getOrganisation, TimRapport::setOrganisation);
        binder.bindInstanceFields(this);

        konsultField.setReadOnly(true);

        add(antalTimmar, organisation, konsultField, saveButton);
    }

    private void onSave() {

        TimRapport timRapport = binder.validate().getBinder().getBean();
        timRapportService.saveTR(timRapport);

        this.getParent().ifPresent(component -> {
            if(component instanceof Dialog){
                ((Dialog) component).close();
            }
        });

        userView.updateView(loggedInId);
    }

    public void setTimRapport(TimRapport timRapport){
        if (timRapport != null)
            binder.setBean(timRapport);
    }
}
