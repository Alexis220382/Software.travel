package com.console;

import com.notation.ExpressionUtilDecimal;

import java.util.Scanner;

/**
 * Created by Ivanovskiy Alexey on 13.10.2015.
 */
public class Console10 {

    public static void main(String[] arg) {

        Scanner in = new Scanner(System.in);
        ExpressionUtilDecimal expressionUtilDecimal = new ExpressionUtilDecimal();

        System.out.print("Введите формулу: ");
        String infix10 = in.nextLine();
        String calculated10 = String.valueOf(expressionUtilDecimal.calculateExpression(infix10));
        System.out.println("Результат: "+calculated10);

        in.close();
    }
}
