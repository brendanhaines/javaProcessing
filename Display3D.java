import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import processing.core.*;
import java.lang.Math;

class Display3D extends PApplet {
    private final int BACKGROUND_COLOR;
    private final int xDim, yDim;

    public float yaw = 0;
    public float pitch = 0;
    public float roll = 0;
    public double camAngle = 0.75;

    ////////////////////////
    ///// Constructors /////
    ////////////////////////

    /**
     * No-args constructor
     */
    public Display3D() {
        xDim = 480;
        yDim = 480;
        BACKGROUND_COLOR = 0;
    }

    /**
     * @param w - width
     * @param h - height
     */
    public Display3D( int w, int h ) {
        xDim = w;
        yDim = h;
        BACKGROUND_COLOR = 0;
    }

    /**
     * @param bkgnd - background color
     */
    public Display3D( int bkgnd ) {
        xDim = 480;
        yDim = 480;
        BACKGROUND_COLOR = bkgnd;
    }

    /**
     * @param w - width
     * @param h - height
     * @param bkgnd - background color
     */
    public Display3D( int w, int h, int bkgnd ) {
        xDim = w;
        yDim = h;
        BACKGROUND_COLOR = bkgnd;
    }

    ////////////////////////
    ///// Draw methods /////
    ////////////////////////

    public void drawBackground() {

    }

    public void drawObject() {
        noFill();
        stroke( 255 );
        box( width / 5, width / 3, width / 20 );
    }

    ///////////////////////////
    ///// PApplet methods /////
    ///////////////////////////

    public void setup() {
        size( xDim, yDim, P3D );
        background( BACKGROUND_COLOR );

        camera( (float)0.0, (float)( -width * Math.sin( camAngle )), (float)( width * Math.cos( camAngle ) ),
                (float)0.0, (float)0.0, (float)0.0,
                (float)0.0, (float)1.0, (float)0.0 );
    }

    public void draw() {
        background( BACKGROUND_COLOR );

        drawBackground();
        // draw image
        rotateZ( yaw );
        rotateX( pitch );
        rotateY( -roll );
        drawObject();

        if( keyPressed ) {
            if( keyCode == LEFT )
                roll -= 0.02;
            else if( keyCode == RIGHT )
                roll += 0.02;
            else if( keyCode == UP )
                pitch -= 0.02;
            else if( keyCode == DOWN )
                pitch += 0.02;
            else if( key == 'a' )
                yaw -= 0.02;
            else if( key == 'd' )
                yaw += 0.02;
        }

        // set camera

        camera( (float)0.0, (float)( width * Math.sin( camAngle )), (float)( width * Math.cos( camAngle ) ), // camera position
                (float)0.0, (float)0.0, (float)0.0,     // center
                (float)0.0, (float)1.0, (float)0.0 );   // up axis
    }
}


class tester {
    public static void main(String[] args) {
        JFrame frame = new JFrame( "tester" );
        frame.setResizable( true );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Display3D thing = new DisplayQuad( 80 );
        frame.add( thing );
        thing.init();
        while (thing.defaultSize&&!thing.finished)
            try {Thread.sleep(5);} catch (Exception e) {}

        frame.pack();
        frame.setVisible( true );
        while( true ) {
            System.out.printf( "\rFrames: %8d\tRate: %8f", thing.frameCount, thing.frameRate );
            try{Thread.sleep(10);}catch(Exception ex){}
        }
    }
}
