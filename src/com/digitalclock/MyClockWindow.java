package com.digitalclock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClockWindow extends JFrame {
    //extends JFrame for Accessing all the properties of JFrame.

    //JLabel is a class, and headingLabel is reference variable of JLabel.
    private JLabel headingLabel;

    //clockLabel is reference variable for JLabel Class
    private JLabel clockLabel;

    //Font(String name, int style, int size)
    private Font font = new Font("",Font.BOLD,35); //font is object of Font Class



    //constructor of MyClockWindow Class.
    MyClockWindow(){

        //Parent Class Method i.e JFrame Class methods, without supter setTitle() methods
        // will work because of inheritance. i.e
        //setTitle("Digital Clock");
        // this will work as well like super.setTitle("Digital Clock");
        super.setTitle("Digital Clock");
        super.setSize(400,400);

        //createGUI should top of setVisible().
        //otherwise createGUI will not show.
        this.createGUI();
        this.startClock();

        //takes two int value setLocation(int x, int y)
        super.setLocation(500,100);
        super.setVisible(true); //showing the desired window.

    }


    //method for createGUI
    public void createGUI(){
        //for all GUI
        headingLabel = new JLabel("My Digital Clock");
        clockLabel = new JLabel("Clock");

        //set the created font to Label
        headingLabel.setFont(font);
        clockLabel.setFont(font);//font is the objects of Font Class what we created on top.

        //for MyClockWindows divided into two rows and 1 column.
        //rows:02, because one row for showing Heading, and one for showing Time in Col:01(in one column)
        //this refers our current Frame Window of clock
        this.setLayout(new GridLayout(2,1));
        this.add(headingLabel);//add headingLabel to GridLayout
        this.add(clockLabel);//add clockLabel to GridLayout

    }

    //startClock()
    public void startClock(){

        /*//Get Clock Without Thread, -Starts Here

        //Timer class constructor =>Timer() takes two input, one is int delay, another is ActionListener Interface
        //delay = 1000ms = 1sec(each time clock will refresh after 1sec.)
        //ActionListener, here we are using an Anonymous Class
        Timer timer = new Timer(1000, new ActionListener() { //new ActionListener is Anonymous Class.

            //when timer is starting, public void actionPerformed(ActionEvent e) will call each 1sec.
            @Override
            public void actionPerformed(ActionEvent e) { //actionPerformed() is ActionListener() Interface's method.
                //which we are override here.

                //predefine Time and Date format.
                //String dateTime = new Date().toString();//

                //predefine format for Time and Date. can not customize.
                //another way,  Time and Date-> AM:PM
                //String dateTime = new Date().toLocaleString();
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a :y");
                String dateTime = sdf.format(date);



                //set the date and time to clockLabel.
                clockLabel.setText(dateTime);
            }
        });
        //Timer() is end here.

        timer.start();//timer is starting

         *///Get Clock Without Thread, -Ends Here




        //Get Clock Using Thread...Starts Here

        Thread thread = new Thread(){//Anonymous Class which extend Thread Class and Override run()
            public void run(){
                try {

                    while(true){//infinite loop. because of time.
                        Date date = new Date();
                        SimpleDateFormat sfd = new SimpleDateFormat("hh : mm : ss a");
                        String dateTime = sfd.format(date);
                        clockLabel.setText(dateTime);

                        //continuous process = Thread sleep for 1second only. then again start through loop.
                        //Thread.sleep(1000);
                        //or this way
                        Thread.currentThread().sleep(1000);


                    }


                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        };
        //start thread.
        thread.start();

        //Get Clock Using Thread...Ends Here

    }


}
