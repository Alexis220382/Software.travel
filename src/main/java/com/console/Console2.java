package com.console;

import com.notation.ExpressionUtilBinary;

import java.util.Scanner;

/**
 * Created by Ivanovskiy Alexey on 13.10.2015.
 */
public class Console2 {

    public static void main(String[] arg) {

        Scanner in = new Scanner(System.in);
        ExpressionUtilBinary expressionUtilBinary = new ExpressionUtilBinary();

        System.out.print("Введите формулу: ");
        String infix2 = in.nextLine();
        String calculated2 = String.valueOf(expressionUtilBinary.calculateExpression(infix2));
        System.out.println("Результат: "+Integer.toBinaryString(Integer.parseInt(calculated2)));

        in.close();
    }
}

