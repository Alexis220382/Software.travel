package com.console;

import com.notation.ExpressionUtilHex;

import java.util.Scanner;

/**
 * Created by Ivanovskiy Alexey on 13.10.2015.
 */
public class Console16 {

    public static void main(String[] arg) {

        Scanner in = new Scanner(System.in);
        ExpressionUtilHex expressionUtilHex = new ExpressionUtilHex();

        System.out.print("Введите формулу: ");
        String infix16 = in.nextLine();
        String calculated16 = String.valueOf(expressionUtilHex.calculateExpression(infix16));
        System.out.println("Результат: "+Integer.toHexString(Integer.parseInt(calculated16)));

        in.close();
    }
}
