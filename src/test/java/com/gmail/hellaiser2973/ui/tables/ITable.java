package com.gmail.hellaiser2973.ui.tables;

import org.openqa.selenium.WebElement;

/**
 * Работа с таблицей
 */
public interface ITable {

    /**
     * Существует ли требуемая строка в таблице (на любой странице списка)
     *
     * @param rowCriterion Критерий отбора строки
     * @return <code>true</code> если строка есть в таблице
     */
    boolean rowExists(ITableCriterion rowCriterion);
    /**
     * Существует ли требуемая строка в таблице (на открытой сейчас странице списка)
     *
     * @param rowCriterion Критерий отбора строки
     * @return <code>true</code> если строка есть на данной странице
     */
    boolean rowExistsOnThisPage(ITableCriterion rowCriterion);

    WebElement getRowOnThisPage(ITableCriterion rowCriterion);

    WebElement getRow(ITableCriterion rowCriterion);
}
