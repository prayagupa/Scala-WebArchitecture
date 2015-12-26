package com.pseudo.calculation.model;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by prayagupd
 * on 12/26/15.
 */

@ManagedBean(name="calculationBean")
@RequestScoped
public class CalculationBean {
    private String value1;
    private String value2;
    private String result;

    public String getValue1() {
        return value1;
    }
    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void add() {
        System.out.println("Result = " + Double.valueOf(value1) +" + "+ Double.valueOf(value2));
        result = String.valueOf(Double.valueOf(value1) + Double.valueOf(value2));
    }

    public void subtract() {
        System.out.println("Result = " + Double.valueOf(value1) +" + "+ Double.valueOf(value2));
        result = String.valueOf(Double.valueOf(value1) - Double.valueOf(value2));
    }

    public void multiply() {
        System.out.println("Result = " + Double.valueOf(value1) +" + "+ Double.valueOf(value2));
        result = String.valueOf(Double.valueOf(value1) * Double.valueOf(value2));
    }

    public void divide() {
        System.out.println("Result = " + Double.valueOf(value1) +" + "+ Double.valueOf(value2));
        result = String.valueOf(Double.valueOf(value1) / Double.valueOf(value2));
    }
}