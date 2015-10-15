package com.controllers;

import com.dao.FormulaDAO;
import com.dao.ResultDAO;
import com.io.ReadFile;
import com.io.WriteFile;
import com.notation.ExpressionUtilHex;
import com.notation.ExpressionUtilBinary;
import com.notation.ExpressionUtilDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by Ivanovskiy Alexey on 12.10.2015.
 */
@Controller
public class MainController {

    public String infix;
    ModelAndView modelAndView;
    ReadFile readFile;
    WriteFile writeFile;
    ExpressionUtilDecimal expressionUtilDecimal;
    ExpressionUtilBinary expressionUtilBinary;
    ExpressionUtilHex expressionUtilHex;
    ResultDAO resultDAO;
    FormulaDAO formulaDAO;

    private final String PATH_IN = getClass().getResource("/txt/Formula.txt").getPath();
    private final String PATH_OUT = getClass().getResource("/txt/Result.txt").getPath();

    @RequestMapping(value = "/hand2", method = RequestMethod.GET)
    public ModelAndView hand2(HttpServletRequest request) throws IOException {

        modelAndView = new ModelAndView();
        expressionUtilBinary = new ExpressionUtilBinary();

        infix = request.getParameter("textfield");

        if (infix == null || infix == "") {
            infix = "0";
        }

        String calculated = String.valueOf(expressionUtilBinary.calculateExpression(infix));

        request.setAttribute("result2", Integer.toBinaryString(Integer.parseInt(calculated)));

        resultDAO = new ResultDAO();
        resultDAO.save(Integer.toBinaryString(Integer.parseInt(calculated)));

        writeFile = new WriteFile();

        writeFile.write(PATH_OUT, Integer.toBinaryString(Integer.parseInt(calculated)));

        modelAndView.setViewName("index");

        writeFile.close();

        return modelAndView;
    }

    @RequestMapping(value = "/hand10", method = RequestMethod.GET)
    public ModelAndView hand10(HttpServletRequest request) throws IOException {

        modelAndView = new ModelAndView();
        expressionUtilDecimal = new ExpressionUtilDecimal();

        infix = request.getParameter("textfield");

        if (infix == null || infix == "") {
            infix = "0";
        }

        String calculated = String.valueOf(expressionUtilDecimal.calculateExpression(infix));

        request.setAttribute("result10", calculated);

        resultDAO = new ResultDAO();
        resultDAO.save(calculated);

        writeFile = new WriteFile();
        writeFile.write(PATH_OUT, calculated);

        modelAndView.setViewName("index");

        writeFile.close();

        return modelAndView;
    }

    @RequestMapping(value = "/hand16", method = RequestMethod.GET)
    public ModelAndView hand16(HttpServletRequest request) throws IOException {

        modelAndView = new ModelAndView();
        expressionUtilHex = new ExpressionUtilHex();

        infix = request.getParameter("textfield");

        if (infix == null || infix == "") {
            infix = "0";
        }

        String calculated = String.valueOf(expressionUtilHex.calculateExpression(infix));

        request.setAttribute("result16", Integer.toHexString(Integer.parseInt(calculated)));

        resultDAO = new ResultDAO();
        resultDAO.save(Integer.toHexString(Integer.parseInt(calculated)));

        writeFile = new WriteFile();
        writeFile.write(PATH_OUT, Integer.toHexString(Integer.parseInt(calculated)));

        modelAndView.setViewName("index");

        writeFile.close();

        return modelAndView;
    }

    @RequestMapping(value = "/fromFile", method = RequestMethod.GET)
    public ModelAndView fromFile(HttpServletRequest request) throws IOException {

        modelAndView = new ModelAndView();

        readFile = new ReadFile();

        request.setAttribute("fromFile", readFile.read(PATH_IN));

        modelAndView.setViewName("index");

        readFile.close();

        return modelAndView;
    }

    @RequestMapping(value = "/fromDB", method = RequestMethod.GET)
    public ModelAndView fromDB(HttpServletRequest request){

        modelAndView = new ModelAndView();

        formulaDAO = new FormulaDAO();

        int numberFormula = Integer.parseInt(request.getParameter("number"));

        if(request.getParameter("number") == null
                || request.getParameter("number") == ""){
            numberFormula = 0;
        }
        String formula = (String) formulaDAO.getFormula().get(numberFormula);

        request.setAttribute("fromDB", formula);

        modelAndView.setViewName("index");

        return modelAndView;
    }

}
