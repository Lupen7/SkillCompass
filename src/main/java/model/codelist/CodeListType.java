/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model.codelist;

/**
 *
 * @author Luboš
 */
public enum CodeListType {
    STATES(CLState.class, "CLState");
   // CURRENCIES(Currency.class, "APP_CURRENCIES_TBL");

    private final Class<?> entityClass;
    private final String tableName;

    CodeListType(Class<?> entityClass, String tableName) {
        this.entityClass = entityClass;
        this.tableName = tableName;
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public String getTableName() {
        return tableName;
    }
}
