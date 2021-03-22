package com.stir.cscu9t4assignment2021;

public class RefJournal extends Ref{
    private String journal;
    private int volume;
    private int issue;

    public RefJournal(String t, String a, String py, String pn, String doi, String d, String j, int v, int i){
        super(t, a, py, pn, doi, d);
        this.journal = j;
        this.volume = v;
        this.issue = i;
    }

    public String getJournal(){
        return journal;
    }

    public int getVolume(){
        return volume;
    }

    public int getIssue(){
        return issue;
    }

    @Override
    public String getCitation(){
        String result = getAuthors() + ". \"" + getTitle() + ". \"" + getDoi()
                + ". " + getJournal() + ", " + getVolume() + ", " + getIssue()
                + ". " + getPubName() + ", " + getPubYear() + ". " + getDate() + ".";
        return result;
    }
}
