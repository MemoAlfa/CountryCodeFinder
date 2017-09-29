package com.foodora.countryapp.ui.utils;

/**
 * Enum for UI strings Clean Code and offers flexibility
 * for having multiple languages of the website
 */

public enum StringsUtil {
    TEXT_NAME_FILTER("Filter by code..."),
    TEXT_CODE_FILTER("Filter by name...."),
    LABLE_TITE("Country CodeFinder"),
    GRID_CAPTION("click on Country to sort by country or code to sort by code"),
    GRID_COLUMN_NAME("Country");
    private final String string;

    StringsUtil(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }

}
