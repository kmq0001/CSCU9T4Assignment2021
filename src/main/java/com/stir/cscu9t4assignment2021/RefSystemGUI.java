/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4assignment2021;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 *
 * @author saemundur
 */
public class RefSystemGUI extends JFrame implements ActionListener {

    private JTextField title = new JTextField(30);
    private JTextField authors = new JTextField(50);
    private JTextField doi = new JTextField(30);
    private JTextField pn = new JTextField(30);
    private JTextField yp = new JTextField(4);
    private JTextField d = new JTextField(2);
    private JTextField m = new JTextField(2);
    private JTextField y = new JTextField(4);
    private JTextField journal = new JTextField(30);
    private JTextField vol = new JTextField(4);
    private JTextField iss = new JTextField(4);
    private JTextField book = new JTextField(30);
    private JTextField edit = new JTextField(30);
    private JTextField conf = new JTextField(30);
    private JTextField ven = new JTextField(30);

    private JLabel labt = new JLabel("Title:");
    private JLabel laba = new JLabel("Authors (name 1st author first):");
    private JLabel labdoi = new JLabel("DOI:");
    private JLabel labpn = new JLabel("Publisher:");
    private JLabel labyp = new JLabel("Year Published:");
    private JLabel labdate = new JLabel("Date:");
    private JLabel labd = new JLabel("Day:");
    private JLabel labm = new JLabel("Month:");
    private JLabel laby = new JLabel("Year:");
    private JLabel labj = new JLabel("Journal:");
    private JLabel labvo = new JLabel("Journal Volume:");
    private JLabel labi = new JLabel("Journal Issue:");
    private JLabel labb = new JLabel("Book Title:");
    private JLabel labe = new JLabel("Book Editor:");
    private JLabel labc = new JLabel("Conference:");
    private JLabel labve = new JLabel("Conference Venue:");
    private JLabel labct = new JLabel("Citation Type:");

    private JButton addC = new JButton("Add Citation");
    private JButton clear = new JButton("Clear Bibliography");
    private JButton searchBy = new JButton("Search By:");
    private JButton numberOf = new JButton("Get Number of Citations By Type");

    String[] searchOptions = {"Journal", "Conference Venue", "Publisher"};
    private JComboBox<String> searchOpt = new JComboBox(searchOptions);
    String[] citeTypes = {"Journal Paper", "Conference Paper", "Book Chapter", "Generic"};
    private JComboBox<String> citeType = new JComboBox(citeTypes);

    private RefCollection bibliography = new RefCollection();

    private JTextArea outputArea = new JTextArea(30,60);
    
    public static void main(String[] args) {

        RefSystemGUI applic = new RefSystemGUI();
    }

    public RefSystemGUI() {

        super("Bibliography");
        setLayout(new FlowLayout());

        add(labt);
        add(title);
        title.setEditable(true);
        add(laba);
        add(authors);
        authors.setEditable(true);
        add(labdoi);
        add(doi);
        doi.setEditable(true);
        add(labpn);
        add(pn);
        pn.setEditable(true);
        add(labyp);
        add(yp);
        yp.setEditable(true);
        add(labdate);
        add(labd);
        add(d);
        d.setEditable(true);
        add(labm);
        add(m);
        m.setEditable(true);
        add(laby);
        add(y);
        y.setEditable(true);
        add(labct);
        add(citeType);
        citeType.setEditable(true);
        add(labj);
        add(journal);
        journal.setEditable(true);
        add(labvo);
        add(vol);
        vol.setEditable(true);
        add(labi);
        add(iss);
        iss.setEditable(true);
        add(labb);
        add(book);
        book.setEditable(true);
        add(labe);
        add(edit);
        edit.setEditable(true);
        add(labc);
        add(conf);
        conf.setEditable(true);
        add(labve);
        add(ven);
        ven.setEditable(true);
        add(addC);
        addC.addActionListener(this);
        add(numberOf);
        numberOf.addActionListener(this);
        add(clear);
        clear.addActionListener(this);
        add(searchBy);
        searchBy.addActionListener(this);
        add(searchOpt);
        searchOpt.setEditable(true);

        add(outputArea);
        outputArea.setEditable(false);
        setSize(1000, 600);
        setVisible(true);
        blankDisplay();
    }
    
    public void actionPerformed(ActionEvent event) {
        String message = " ";

        if(event.getSource() == addC){
            message = addCitation((String) citeType.getSelectedItem());
        }
        if(event.getSource() == clear){
            message = clear();
        }
        if(event.getSource() == searchBy){
            message = lookUpBy((String) searchOpt.getSelectedItem());
        }
        if(event.getSource() == numberOf){
            message = getNumberOfRefs((String) citeType.getSelectedItem());
        }

        outputArea.setText(message);
        blankDisplay();
    }

    public String addCitation(String type){
        String message = "Citation added\n";
        System.out.println("Adding " + type.toLowerCase() + "citation to bibliography...");
        String t = title.getText();
        String a = authors.getText();
        int puby = Integer.parseInt(yp.getText());
        String pubn = pn.getText();
        String cdoi = doi.getText();
        int day = Integer.parseInt(d.getText());
        int month = Integer.parseInt(m.getText());
        int year = Integer.parseInt(y.getText());

        if(type.equals("Book Chapter")){
            String bt = book.getText();
            String e = edit.getText();

            Ref c = new RefBookChapter(t, a, puby, pubn, cdoi, day, month, year, bt, e);
            bibliography.addCite(c);
        }
        else if(type.equals("Journal Paper")){
            String j = journal.getText();
            int v = Integer.parseInt(vol.getText());
            int i = Integer.parseInt(iss.getText());

            Ref c = new RefJournal(t, a, puby, pubn, cdoi, day, month, year, j, v, i);
            bibliography.addCite(c);
        }
        else if(type.equals("Conference Paper")){
            String cn = conf.getText();
            String v = ven.getText();

            Ref c = new RefConference(t, a, puby, pubn, cdoi, day, month, year, cn, v);
            bibliography.addCite(c);
        }
        return message;
    }

    public String lookUpBy(String opt){
        outputArea.setText("Searching bibliography...");
        String message = " ";

        if(opt.equals("Journal")){
            String j = journal.getText();
            message = bibliography.lookUpByJournal(j);
        }
        else if(opt.equals("Conference Venue")){
            String v = ven.getText();
            message = bibliography.lookUpByVenue(v);
        }
        else if(opt.equals("Publisher")){
            String p = pn.getText();
            message = bibliography.lookUpByPublisher(p);
        }

        return message;
    }

    public String clear(){
        String message = "Bibliography cleared.";
        outputArea.setText("Clearing Bibliography...");
        bibliography.clearAll();
        return message;
    }

    public String getNumberOfRefs(String type){
        String message = " ";
        outputArea.setText("Getting number of " + type.toLowerCase() + "citations in the bibliography...");

        if(type.equalsIgnoreCase("Generic")){
            message = bibliography.getNumberOfRefs();
        }
        else if(type.equalsIgnoreCase("Journal Paper")){
            message = bibliography.getNumberOfJournalRefs();
        }
        else if(type.equalsIgnoreCase("Conference Paper")){
            message = bibliography.getNumberOfConferenceRefs();
        }
        else if(type.equalsIgnoreCase("Book Chapter")){
            message = bibliography.getNumberOfBookChapterRefs();
        }

        return message;
    }

    public void blankDisplay(){
        title.setText(" ");
        authors.setText(" ");
        pn.setText(" ");
        yp.setText(" ");
        doi.setText(" ");
        d.setText(" ");
        m.setText(" ");
        y.setText(" ");
        journal.setText(" ");
        vol.setText(" ");
        iss.setText(" ");
        conf.setText(" ");
        ven.setText(" ");
        book.setText(" ");
        edit.setText(" ");
    }
}