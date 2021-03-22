package com.stir.cscu9t4assignment2021;

public class RefBookChapter extends Ref{

    private String book;
    private String editor;

    public RefBookChapter(String t, String a, String py, String pn, String doi, String d, String b, String e){
        super(t, a, py, pn, doi, d);
        this.book = b;
        this.editor = e;
    }

    public String getBook(){
        return book;
    }

    public String getEditor(){
        return editor;
    }

    @Override
    public String getCitation(){
        String result = getAuthors() + ". \"" + getTitle() + ". \"" + getDoi()
                + ". " + getBook() + ", " + getEditor() + ". " + getPubName()
                + ", " + getPubYear() + ". " + getDate() + ".";
        return result;
    }
}
