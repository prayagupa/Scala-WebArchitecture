package com.pseudo.calculation.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Arrays;

/**
 * Created by prayagupd
 * on 12/26/15.
 */

@ManagedBean(name="flightBean")
@RequestScoped
public class FlightBean {
    private String from;
    private String to;
    private String departureDate;
    private String returnDate;
    private String tripType;
    private String[] options = {"First class", "Exact these days", "No stopover"};
    private String result;

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void book() {
        System.out.println(toString());
        result = toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Result : ");
        builder.append(System.getProperty("line.separator"));

        builder.append("From = " + from);
        builder.append(System.getProperty("line.separator"));

        builder.append("To = " + to);
        builder.append(System.getProperty("line.separator"));

        builder.append("departureDate = " + departureDate);
        builder.append(System.getProperty("line.separator"));

        builder.append("returnDate = " + returnDate);
        builder.append(System.getProperty("line.separator"));

        builder.append("tripType = " + tripType);
        builder.append(System.getProperty("line.separator"));

        builder.append("options = " + Arrays.toString(options));
        return builder.toString();
    }
}
