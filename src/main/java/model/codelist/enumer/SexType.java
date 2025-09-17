/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model.codelist.enumer;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Luboš
 */
public enum SexType {
    MALE('M', "Male"),
    FEMALE('F', "Female");

    private final char sChar;
    private final String sString;

    SexType(char s, String sex) {
        this.sChar = s;
        this.sString = sex;
    }

    public char getsChar() {
        return sChar;
    }

    public String getsString() {
        return sString;
    }
}
