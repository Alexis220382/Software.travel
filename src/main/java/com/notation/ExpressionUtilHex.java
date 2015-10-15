package com.notation;

/**
 * Created by B50-30 on 13.10.2015.
 */

import java.math.BigDecimal;
import java.util.*;


/**
 * ����� �������� ������� ��� ������� � ��������� �������������� ���������.
 *
 * @author ����� ��������
 * @version $Revision$ $Date$
 */
public class ExpressionUtilHex {
    /**
     * �������� �������������� �������� � �� ����������.
     *
     * @see (String, java.util.Map)
     */
    public static final Map<String, Integer> MAIN_MATH_OPERATIONS;

    static {
        MAIN_MATH_OPERATIONS = new HashMap<String, Integer>();
        MAIN_MATH_OPERATIONS.put("*", 1);
        MAIN_MATH_OPERATIONS.put("/", 1);
        MAIN_MATH_OPERATIONS.put("+", 2);
        MAIN_MATH_OPERATIONS.put("-", 2);
    }

    SortingStation sSt = new SortingStation();

    /**
     * ��������� �������� ���������, ����������� � ��������� �������. ��������� ����� ��������� ������, ����� �
     * ��������� ������, ������ �������� �������������� ���������.
     *
     * @param expression ���������.
     * @return ��������� ����������.
     */
    public BigDecimal calculateExpression(String expression) {
        String rpn = sSt.sortingStation(expression, MAIN_MATH_OPERATIONS);
        StringTokenizer tokenizer = new StringTokenizer(rpn, " ");
        Stack<BigDecimal> stack = new Stack<BigDecimal>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            // �������.
            if (!MAIN_MATH_OPERATIONS.keySet().contains(token)) {
                stack.push(new BigDecimal(Integer.parseInt(token, 16)));
            } else {
                BigDecimal operand2 = stack.pop();
                BigDecimal operand1 = stack.empty() ? BigDecimal.ZERO : stack.pop();
                if (token.equals("*")) {
                    stack.push(operand1.multiply(operand2));
                } else if (token.equals("/")) {
                    stack.push(operand1.divide(operand2));
                } else if (token.equals("+")) {
                    stack.push(operand1.add(operand2));
                } else if (token.equals("-")) {
                    stack.push(operand1.subtract(operand2));
                }
            }
        }
        if (stack.size() != 1)
            throw new IllegalArgumentException("Expression syntax error.");
        return stack.pop();
    }

    /**
     * �������� ����������� ������.
     */
    public ExpressionUtilHex() {
    }
}