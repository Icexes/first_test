package com.gmail.hellaiser2973.ui.tables;

import org.openqa.selenium.WebElement;

/**
 * Критерий отбора строки
 */
public interface ITableCriterion {

    /**
     * Соответствует ли строка критерию
     *
     * @param rowElement Элемент строки
     * @return <code>true</code> если строка соответствует данному критерию
     *
     */

    boolean matches(WebElement rowElement);




}
