package com.example.javawebdevprojekt.views;

import com.example.javawebdevprojekt.entities.Konsult;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;


public class LoggedInView extends VerticalLayout {

    Grid<Konsult> grid = new Grid<>(Konsult.class);
    TextField filterText = new TextField();

    public LoggedInView(){
        //Make admin view, should be able to manage konsulter.
        configureGrid();
        add(getToolbar(), grid);
    }

    private void configureGrid() {

        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addKonsultButton = new Button("Add Konsult");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addKonsultButton);

        return toolbar;
    }

}
