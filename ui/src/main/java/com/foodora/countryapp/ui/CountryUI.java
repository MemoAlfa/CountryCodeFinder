package com.foodora.countryapp.ui;

import com.foodora.countryapp.models.Country;
import com.foodora.countryapp.service.CountryService;
import com.foodora.countryapp.ui.utils.StringsUtil;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.HasValue;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.util.List;

/**
 * The Controller using Vaadin components that eventually produce the html and compile java code into javascript
 * using the valo built-in theme.
 */
@SpringUI(path = "/")
@Title("Country Service")
@Theme("valo")
public class CountryUI extends UI {

    @Autowired
    private CountryService countryService;
    //  grid field is excluded from the init function because
//  it needs to be accessed from the listeners to change content
    private Grid<Country> grid = new Grid<>();

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        GridLayout root = new GridLayout(3, 1);

        TextField nameFilter = new TextField();
        nameFilter.addValueChangeListener(this::nameFieldChange);
        nameFilter.setPlaceholder(StringsUtil.TEXT_CODE_FILTER.getString());

        Label title = new Label(StringsUtil.LABLE_TITE.getString());
        title.addStyleName(ValoTheme.LABEL_H1);
        title.addStyleName(ValoTheme.LABEL_COLORED);

        TextField codeFilter = new TextField();

//      telling the code filter component to call our function when text changes
        codeFilter.addValueChangeListener(this::codeFieldChange);
        codeFilter.setPlaceholder(StringsUtil.TEXT_NAME_FILTER.getString());

//      populating the grid with all rows from country table
        List<Country> all = countryService.getAll();
        grid.setItems(all);
        grid.setCaption(StringsUtil.GRID_CAPTION.getString());
//      adding the Columns that the grid is supposed to show
        grid.addColumn(Country::getName).setCaption(StringsUtil.GRID_COLUMN_NAME.getString());
        grid.addColumn(Country::getCode).setCaption(StringsUtil.GRID_COLUMN_NAME.getString());
        grid.setHeightByRows(15);

//      adding all components to the container they will appear in the same order as added
        VerticalLayout container = new VerticalLayout();
        container.addComponents(title, nameFilter, codeFilter, grid);
        container.setHeightUndefined();
        container.setMargin(true);

//      adding the container to the grid layout at the specified rows and columns
        root.addComponent(container, 1, 0);
        root.setSizeFull();

        setContent(root);

    }


    /**
     * event listener function gets called once the text field 'namefilter' has been changed
     * it queries the service layer and uploads the grid with the new content
     *
     * @param event
     */
    public void nameFieldChange(HasValue.ValueChangeEvent<String> event) {
        String textInput = event.getValue();
        List<Country> countries = countryService.getCountryByName(textInput);

//      notify message that nothing was found
        if (countries.isEmpty()) {
            Notification.show("No thing found", Notification.Type.HUMANIZED_MESSAGE);
        }
        grid.setItems(countries);
    }

    /**
     * event listener function gets called once the text field 'codeFilter' has been changed
     * it queries the service layer and uploads the grid with the new content
     *
     * @param event
     */
    public void codeFieldChange(HasValue.ValueChangeEvent<String> event) {
        String value = event.getValue();
        List<Country> countries = countryService.getCountryByCode(value);

        if (countries.isEmpty()) {
            Notification.show("No thing found", Notification.Type.HUMANIZED_MESSAGE);
        }
        grid.setItems(countries);
    }
}
