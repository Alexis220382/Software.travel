package com.console;

import com.notation.ExpressionUtils;

import java.util.Scanner;

/**
 * Created by Ivanovskiy Alexey on 13.10.2015.
 */
public class Console {

    public static void main(String[] arg) {

        Scanner in = new Scanner(System.in);
        ExpressionUtils expressionUtils = new ExpressionUtils();

        System.out.print("Введите формулу: ");
        String infix = in.nextLine();

        String calculated = String.valueOf(expressionUtils.calculateExpression(infix));

        System.out.println("Результат: "+calculated);
        in.close();
    }
}
