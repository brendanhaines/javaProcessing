import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import java.lang.*;
import java.io.*;
import java.net.*;

class Tester3D {
    public static Display3D area3d;
    public static JFrame frame;
    public static JSlider slider;
    public static JButton button;
    public static double rawYaw;
    public static double yawAdjust = 0.0;

    public static void main(String[] args) {
        frame = new JFrame( "Tester3D" );
        frame.setResizable( true );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout( new BorderLayout() );

        area3d = new DisplayNewQuad( 80 );
        frame.add( area3d, BorderLayout.CENTER );
        area3d.init();
        while( area3d.defaultSize && !area3d.finished )
            try { Thread.sleep( 5 ); } catch( Exception e ) {}

        slider = new JSlider( JSlider.VERTICAL, 0, 157, 79 );
        slider.addChangeListener( new ChangeListener() {
            public void stateChanged( ChangeEvent evt ) {
                Tester3D.area3d.camAngle = (float)( 157 - Tester3D.slider.getValue() ) / 100;
            }
        });
        frame.add( slider, BorderLayout.EAST );

        button = new JButton( "reset yaw" );
        button.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent evt ) {
                Tester3D.yawAdjust = rawYaw;
            }
        });
        frame.add( button, BorderLayout.NORTH );

        frame.pack();
        frame.setVisible( true );

        try {
            Socket skt = new Socket("localhost", 7777);
            BufferedReader in = new BufferedReader(new
                InputStreamReader(skt.getInputStream()));
            Scanner in2 = new Scanner( skt.getInputStream() );
            System.out.println("STARTING...");

            while( !in.ready() ) {}

            String inString;
            while( true ) {
                //while( !in.ready() ) {}
                //inString = in.readLine();
                if( in2.hasNext() ) {
                    if( in2.next().equals( "ypr" ) ) {
                        while( !in2.hasNext() ) {}
                        rawYaw = (float)( 0.01745329251 * in2.nextFloat() );
                        area3d.yaw = (float)( rawYaw - yawAdjust );
                        while( !in2.hasNext() ) {}
                        area3d.pitch = (float)( 0.01745329251 * in2.nextFloat() );
                        while( !in2.hasNext() ) {}
                        area3d.roll = (float)( 0.01745329251 * in2.nextFloat() );
                    }
                }
            }
            //System.out.print("'\n");
            //in.close();
        }
        catch(Exception e) {
            System.out.print("Whoops! It didn't work!\n");
        }
    }
}