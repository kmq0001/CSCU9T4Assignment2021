package com.stir.cscu9t4assignment2021;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class Ref {
    protected String title;
    protected String authors;
    protected String pubYear;
    protected String pubName;
    protected String doi;
    protected String date;

    public Ref(String t, String a, String py, String pn, String doi, String d){
        this.title = t;

        String[] array = a.split(","); // may be issues of too many spaces here, but have not included space after input semi colon a few lines down to counteract this
        String[] array2 = array[0].split(" ");
        array[0] = array2[1] + ", " + array2[0];
        a = " ";
        for(int i = 0; i < array.length; i++){
            a += array[i];
            if (i < array.length-1){
                a += ";";
            }
        }
        this.authors = a.trim();
        this.pubYear = py;
        this.pubName = pn;
        this.doi = doi;
        this.date = d;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthors(){
        return authors;
    }

    public String getPubYear(){
        return pubYear;
    }

    public String getPubName(){
        return pubName;
    }

    public String getDoi() {
        return doi;
    }

    public String getDate(){
        return date;
    }

    public String getCitation(){
        String result = getAuthors() + ". \"" + getTitle() + ". \"" + getDoi() + ". "
                + getPubName() + ", " + getPubYear() + ". " + getDate() + ".";
        return result;
    }
}
