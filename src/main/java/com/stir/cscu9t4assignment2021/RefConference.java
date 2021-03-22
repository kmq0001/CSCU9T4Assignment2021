package com.stir.cscu9t4assignment2021;

public class RefConference extends Ref{
    private String conference;
    private String venue;

    public RefConference(String t, String a, String py, String pn, String doi, String d, String c, String v){
        super(t, a, py, pn, doi, d);
        this.conference = c;
        this.venue = v;
    }

    public String getConference(){
        return conference;
    }

    public String getVenue(){
        return venue;
    }

    @Override
    public String getCitation(){
        String result = getAuthors() + ". \"" + getTitle() + ". \"" + getDoi()
                + ". " + getConference() + ", " + getVenue() + ". " + getPubName()
                + ", " + getPubYear() + ". " + getDate() + ".";
        return result;
    }
}
