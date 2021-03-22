package com.stir.cscu9t4assignment2021;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;

public class RefCollection {
    private List <? extends Ref> rc;

    public RefCollection(){
        rc = new ArrayList<Ref>();
    }

    public void addCite(Ref c){
        rc.add(c);
    }

    public void clearAll(){
        rc.clear();
    }

    public String lookUpByPublisher(String publisher){
        ListIterator<? extends Ref> iter = rc.listIterator();
        String result = "No citations found.";
        ArrayList<String> rcp = new ArrayList<String>();

        while(iter.hasNext()){
            Ref current = iter.next();
            if(current.getPubName().equalsIgnoreCase(publisher)){
                rcp.add(current.getCitation());
            }
        }

        if(rcp.size() > 0){
            Collections.sort(rcp, String.CASE_INSENSITIVE_ORDER);
            result = " ";
            for(String s : rcp){
                result += s + "\t";
            }
        }
        return result.trim();
    }

    public String lookUpByJournal(String journal){
        ListIterator<? extends Ref> iter = rc.listIterator();
        String result = "No citations found.";
        ArrayList<String> rcj = new ArrayList<String>();

        while(iter.hasNext()){
            Ref current = iter.next();
            if(current.getJournal().equalsIgnoreCase(journal)){
                rcj.add(current.getCitation());
            }
        }

        if(rcj.size() > 0){
            Collections.sort(rcj, String.CASE_INSENSITIVE_ORDER);
            result = " ";
            for(String s : rcj){
                result += s +"\t";
            }
        }
        return result.trim();
    }

    public String lookUpByVenue(String venue){
        ListIterator<? extends Ref> iter = rc.listIterator();
        String result = "No citations found.";
        ArrayList<String> rcv = new ArrayList<String>();

        while(iter.hasNext()){
            Ref current = iter.next();
            if(iter.next().getVenue().equalsIgnoreCase(venue)){
                rcv.add(current.getCitation());
            }
        }

        if(rcv.size() > 0){
            Collections.sort(rcv, String.CASE_INSENSITIVE_ORDER);
            result = " ";
            for(String s : rcv){
                result += s +"\t";
            }
        }
        return result.trim();
    }

    public String getNumberOfRefs(){
        String result = "There are " + rc.size() + " citation in the bibliography.";
        return result;
    }

    public String getNumberOfJournalRefs(){
        ListIterator<? extends Ref> iter = rc.listIterator();
        int count = 0;

        while(iter.hasNext()){
            Ref current = iter.next();
            if(current.getJournal()) {
                count++;
            }
        }

        String result = "There are " + count + " journal paper citations in the bibliography.";
        return result;
    }

    public String getNumberOfConferenceRefs(){
        ListIterator<? extends Ref> iter = rc.listIterator();
        int count = 0;

        while(iter.hasNext()){
            Ref current = iter.next();
            if(current.getConference()) {
                count++;
            }
        }

        String result = "There are " + count + " conference paper citations in the bibliography.";
        return result;
    }

    public String getNumberOfBookChapterRefs(){
        ListIterator<? extends Ref> iter = rc.listIterator();
        int count = 0;

        while(iter.hasNext()){
            Ref current = iter.next();
            if(current.getBook()) {
                count++;
            }
        }

        String result = "There are " + count + " book chapter citations in the bibliography.";
        return result;
    }

    File input = new File("all_data.csv");
    File output = new File("output.txt");
    public void importMany(){


    }

}
