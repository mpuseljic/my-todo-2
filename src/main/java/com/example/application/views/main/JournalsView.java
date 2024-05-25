package com.example.application.views.main;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Journals")
@Route(value = "journals")
public class JournalsView extends VerticalLayout {

    public JournalsView() {
        // Postavite pozadinu cijele stranice na boju #D2B48C
        getElement().executeJs("document.body.style.backgroundColor = '#D2B48C';");

        // Stilizirajte glavni vertikalni layout
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        getStyle().set("display", "flex");
        getStyle().set("flex-direction", "column");

        // Dodajte naslov "My Journals" na vrh stranice
        Span title = new Span("My Journals");
        title.getStyle().set("font-family", "Inter, sans-serif");
        title.getStyle().set("font-size", "40px");
        title.getStyle().set("font-weight", "700");
        title.getStyle().set("color", "#000000");

        // Dodajte naslov na stranicu i centrirajte ga
        add(title);
        setHorizontalComponentAlignment(Alignment.CENTER, title);

        // Kreirajte layout koji će rasti i gurati gumb na dno
        VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.setSizeFull();
        contentLayout.setPadding(false);
        contentLayout.setSpacing(true);
        contentLayout.getStyle().set("flex-grow", "1");

        // Dodajte content layout u glavni layout
        add(contentLayout);

        // Kreirajte gumb "+ Create new" i postavite ga na dno stranice
        Button createNewButton = new Button("+ Create new");
        createNewButton.getStyle().set("background-color", "#65493C");
        createNewButton.getStyle().set("color", "#FFFFFF");
        createNewButton.getStyle().set("width", "70%");

        // Dodajte gumb na stranicu i centrirajte ga
        add(createNewButton);
        setHorizontalComponentAlignment(Alignment.CENTER, createNewButton);

        // Kreirajte dijalog za unos naslova
        Dialog dialog = new Dialog();
        VerticalLayout dialogLayout = new VerticalLayout();
        dialogLayout.getStyle().set("background-color", "#D2B48C");
        TextField titleField = new TextField("Title");
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        dialogLayout.add(titleField, saveButton, cancelButton);
        dialog.add(dialogLayout);

        // Dodajte funkcionalnost za otvaranje dijaloga kada se klikne na gumb "+ Create new"
        createNewButton.addClickListener(e -> dialog.open());

        // Dodajte funkcionalnost za spremanje naslova
        saveButton.addClickListener(e -> {
            String enteredTitle = titleField.getValue();
            if (!enteredTitle.isEmpty()) {
                VerticalLayout titleLayout = new VerticalLayout();
                Span newTitle = new Span(enteredTitle);
                newTitle.getStyle().set("font-family", "Inter, sans-serif");
                newTitle.getStyle().set("font-size", "24px");
                newTitle.getStyle().set("font-weight", "700");
                newTitle.getStyle().set("color", "#000000");
                newTitle.getStyle().set("background-color", "#65493C");
                newTitle.getStyle().set("padding", "10px");
                newTitle.getStyle().set("border-radius", "10px");
                newTitle.getStyle().set("width", "90%");
                newTitle.getStyle().set("box-sizing", "border-box");

                // Dodajte gumb "..." za brisanje naslova
                Icon deleteIcon = new Icon(VaadinIcon.ELLIPSIS_DOTS_V);
                deleteIcon.getStyle().set("cursor", "pointer");
                deleteIcon.getStyle().set("color", "#000000");

                // Kreirajte dijalog za brisanje
                Dialog deleteDialog = new Dialog();
                VerticalLayout deleteDialogLayout = new VerticalLayout();
                deleteDialogLayout.getStyle().set("background-color", "#FFFFFF");
                Button deleteConfirmButton = new Button("Delete");
                Button deleteCancelButton = new Button("Cancel");

                deleteDialogLayout.add(new Span("Are you sure you want to delete journal?"), deleteConfirmButton, deleteCancelButton);
                deleteDialog.add(deleteDialogLayout);

                deleteIcon.addClickListener(new ComponentEventListener<ClickEvent<Icon>>() {
                    @Override
                    public void onComponentEvent(ClickEvent<Icon> event) {
                        deleteDialog.open();
                    }
                });

                deleteConfirmButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
                    @Override
                    public void onComponentEvent(ClickEvent<Button> event) {
                        contentLayout.remove(titleLayout);
                        deleteDialog.close();
                    }
                });

                titleLayout.add(newTitle, deleteIcon);
                contentLayout.add(titleLayout);
                contentLayout.setHorizontalComponentAlignment(Alignment.CENTER, titleLayout);

                // Zatvorite dijalog
                dialog.close();
            }
        });

        // Dodajte funkcionalnost za zatvaranje dijaloga kada se klikne na gumb "Cancel"
        cancelButton.addClickListener(e -> dialog.close());
    }
}
