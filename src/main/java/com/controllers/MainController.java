package com.controllers;

import com.dao.FormulaDAO;
import com.dao.ResultDAO;
import com.entity.*;
import com.io.ReadFile;
import com.io.WriteFile;
import com.notation.ExpressionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
    ExpressionUtils expressionUtils;
    ResultDAO resultDAO;
    FormulaDAO formulaDAO;

    private static final String PATH_IN = "d://Programming/Projects/IDEA/Software.travel/src/main/java/com/txt/Formula.txt";
    private static final String PATH_OUT = "d://Programming/Projects/IDEA/Software.travel/src/main/java/com/txt/Result.txt";

    @RequestMapping(value = "/hand", method = RequestMethod.GET)
    public ModelAndView hand(HttpServletRequest request) throws IOException {

        modelAndView = new ModelAndView();
        expressionUtils = new ExpressionUtils();

        infix = request.getParameter("textfield");

        if (infix == null || infix == "") {
            infix = "0";
        }

        String calculated = String.valueOf(expressionUtils.calculateExpression(infix));

        request.setAttribute("result", calculated);

        resultDAO = new ResultDAO();
        resultDAO.save(calculated);

        writeFile = new WriteFile();
        writeFile.write(PATH_OUT, calculated);

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
