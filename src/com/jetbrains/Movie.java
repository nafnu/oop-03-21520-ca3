package com.jetbrains;

public class Movie {
    private String leadActor;
    private String year;
    private String name;

    public Movie()
    {
        name="";
        leadActor="";
        year="";
    }

    public Movie(String name, String lead, String year)
    {
        this.name = name;
        this.leadActor = lead;
        this.year= year;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getLeadActor() {

        return leadActor;
    }

    public void setLeadActor(String leadActor) {

        this.leadActor = leadActor;
    }

    public String getYear() {

        return year;
    }

    public void setYear(String year) {

        this.year = year;
    }

}
