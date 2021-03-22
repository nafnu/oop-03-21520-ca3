package com.jetbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieTrackerFrame extends JFrame{

    private JLabel movieNameLabel;
    private JLabel movieLeadActorLabel;
    private JLabel movieYearLabel;

    private JButton addMovieButton;
    private JButton resetInputButton;
    private JButton resetOutputButton;

    private JTextField movieNameField;
    private JTextField movieLeadActorField;
    private JTextField movieYearField;

    private JTextArea output;

    private ArrayList<Movie> movieList;

    public MovieTrackerFrame(){

        super("MovieTracker-ca3-Student21520");

        //Design of the array view - in order to add multiples lines
        output = new JTextArea(20,70);
        output.setEditable(false);
        output.setText("\t" + "Movie Name      " + "\t" + "Lead Actor      " + "\t" + "Release Year      " + "\n");
        setSize(700,600);

        movieList = new ArrayList<Movie>();

        createComponents();

    }

    private void createComponents() {


        //Design of the inputs
        final int FIELD_WIDTH = 60;
        movieNameLabel = new JLabel("MovieName: ", SwingConstants.LEFT);
        movieNameField = new JTextField(FIELD_WIDTH);
        movieNameField.setFont(new Font("Serif", Font.PLAIN, 12));
        movieNameField.setBounds(119, 111, 80, 20);

        movieLeadActorLabel = new JLabel("LeadActor: ", SwingConstants.LEFT);
        movieLeadActorField = new JTextField(FIELD_WIDTH);
        movieLeadActorField.setFont(new Font("Serif", Font.PLAIN, 12));
        movieLeadActorField.setBounds(119, 111, 80, 20);

        movieYearLabel = new JLabel("Release Year: ", SwingConstants.LEFT);
        movieYearField = new JTextField(FIELD_WIDTH);
        movieYearField.setFont(new Font("Serif", Font.PLAIN, 12));
        movieYearField.setBounds(119, 111, 80, 20);

        addMovieButton = new JButton("AddMovie");
        resetInputButton = new JButton("ResetInput");
        resetOutputButton = new JButton("ResetOutput");



        // Adding components to panel
        JPanel jpanel = new JPanel();
        jpanel.add(movieNameLabel);
        jpanel.add(movieNameField);
        jpanel.add(movieLeadActorLabel);
        jpanel.add(movieLeadActorField);
        jpanel.add(movieYearLabel);
        jpanel.add(movieYearField);
        jpanel.add(addMovieButton);
        jpanel.add(resetInputButton);
        jpanel.add(resetOutputButton);

        JScrollPane scroll = new JScrollPane(output);
        jpanel.add(scroll);

        add(jpanel);

        // Define action listeners
        ActionListener listener1 = new AddMovieListener();
        addMovieButton.addActionListener(listener1);
        ActionListener listener3 = new ResetInputListener();
        resetInputButton.addActionListener(listener3);
        ActionListener listener4 = new ResetOutputListener();
        resetOutputButton.addActionListener(listener4);
    }

    class AddMovieListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String movieName = movieNameField.getText();
            String movieLead = movieLeadActorField.getText();
            String releaseYear = movieYearField.getText();
            Movie movie = new Movie(movieName, movieLead, releaseYear);
            movieList.add(movie);
            output.append("\t" + movieName + "\t" + movieLead + "\t" + releaseYear + "\n");
        }
    }



    class ResetInputListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            movieNameField.setText(null);
            movieLeadActorField.setText(null);
            movieYearField.setText(null);
        }
    }


    class ResetOutputListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            output.setText(null);
            output.setText("\t" + "MovieName" + "\t\t" + "LeadActor" + "\t\t" + "Release Year" + "\n");
        }
    }

}