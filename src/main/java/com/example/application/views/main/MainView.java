package com.example.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Main")
@Route(value = "")
@RouteAlias(value = "")
public class MainView extends VerticalLayout {

    private TextField name;
    private Button sayHello;

    public MainView() {
        // Postavite pozadinu cijele stranice na svijetlo smeđu boju
        getElement().executeJs("document.body.style.backgroundColor = '#D2B48C';");

        // Stvorite VerticalLayout za postavljanje slike iznad ostalih komponenti
        VerticalLayout imageLayout = new VerticalLayout();
        imageLayout.setHeight("40vh"); // Postavite visinu na polovicu visine stranice
        imageLayout.setWidthFull(); // Neka slika zauzima cijelu širinu stranice

        // Postavite pozadinu slike koristeći CSS
        imageLayout.getStyle().set("background-image", "url('https://images.unsplash.com/photo-1488190211105-8b0e65b80b4e?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzV8fGpvdXJuYWx8ZW58MHx8MHx8fDA%3D')");
        imageLayout.getStyle().set("background-size", "cover"); // Postavite veličinu slike na cover
        imageLayout.getStyle().set("background-position", "center"); // Postavite poziciju slike na sredinu

        // Dodajte sliku u glavni layout
        add(imageLayout);

        // Dodajte tekst "WELCOME TO JOURNAL" ispod slike
        Span welcomeText = new Span("WELCOME TO JOURNAL");
        welcomeText.getStyle().set("font-family", "Inter, sans-serif");
        welcomeText.getStyle().set("font-size", "24px");
        welcomeText.getStyle().set("font-weight", "700");
        welcomeText.getStyle().set("color", "#333");
        add(welcomeText);
        setHorizontalComponentAlignment(Alignment.CENTER, welcomeText);

// Dodajte ikonu "Write about your day" ispod teksta "WELCOME TO JOURNAL"
        Icon writeIcon = VaadinIcon.PENCIL.create();
        writeIcon.setSize("24px");
        Span writeAboutYourDayText = new Span("Write about your day");
        add(writeIcon, writeAboutYourDayText);
        setHorizontalComponentAlignment(Alignment.CENTER, writeIcon);
        setHorizontalComponentAlignment(Alignment.CENTER, writeAboutYourDayText);

// Dodajte input polje ispod teksta "Write about your day"
        TextField pinInput = new TextField();
        pinInput.setPlaceholder("ENTER YOUR PIN");
        pinInput.getStyle().set("border", "15px solid #65493C"); // Postavite tamno smeđi okvir
        pinInput.getStyle().set("border-radius", "15px"); // Postavite zaobljeni rub
        pinInput.getStyle().set("padding", "0px"); // Postavite unutarnji razmak za bolji izgled
        pinInput.getStyle().set("outline", "none"); // Uklonite vanjski okvir
        pinInput.getStyle().set("background-color", "FFFFFF"); // Postavite transparentnu boju pozadine
        add(pinInput);
        setHorizontalComponentAlignment(Alignment.CENTER, pinInput);

        // Dodajte gumb "SUBMIT" ispod input polja
        Button submitButton = new Button("SUBMIT");
        submitButton.getStyle().set("background-color", "#319104"); // Postavite boju pozadine na zelenu
        submitButton.getStyle().set("color", "#FFFFFF"); // Postavite boju teksta na bijelu
        submitButton.getStyle().set("border", "none"); // Uklonite rub gumba
        add(submitButton);
        setHorizontalComponentAlignment(Alignment.CENTER, submitButton);

// Dodajte slušač događaja za gumb "SUBMIT"
        submitButton.addClickListener(e -> {
            // Preusmjeri korisnika na drugu stranicu
            UI.getCurrent().navigate("journals");
        });


    }
}

