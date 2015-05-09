class DisplayNewQuad extends Display3D {
    
    public DisplayNewQuad() {
        super();
    }

    public DisplayNewQuad( int bkgnd) {
        super( bkgnd );
    }

    public void drawBackground() {
        // sphere
        pushMatrix();
        rotateX((float)(Math.PI/2));
        noFill();
        stroke(100, 127 );
        sphere( width );
        popMatrix();
    }

    /**
     *
     */
    public void drawObject() {
        int s = 1;
        noStroke();
        lights();

        fill( 255 );
        rotateZ( (float)( Math.PI/4 ) );
        translate( 80, 0, 0 );
        box( 100, 10, 10 );
        translate( 40, 0, -20 );
        fill( 255, 255, 0 );
        sphere( 15 );
        translate( -40, 0, 20 );
        translate( -80, 0, 0 );

        fill( 255 );
        rotateZ( (float)( Math.PI/2 ) );
        translate( 80, 0, 0 );
        box( 100, 10, 10 );
        translate( 40, 0, -20 );
        fill( 255, 255, 0 );
        sphere( 15 );
        translate( -40, 0, 20 );
        translate( -80, 0, 0 );

        fill( 255, 0, 0 );
        rotateZ( (float)( Math.PI/2 ) );
        translate( 80, 0, 0 );
        box( 100, 10, 10 );
        translate( 40, 0, -20 );
        fill( 255, 255, 0 );
        sphere( 15 );
        translate( -40, 0, 20 );
        translate( -80, 0, 0 );

        fill( 255, 0, 0 );
        rotateZ( (float)( Math.PI/2 ) );
        translate( 80, 0, 0 );
        box( 100, 10, 10 );
        translate( 40, 0, -20 );
        fill( 255, 255, 0 );
        sphere( 15 );
        translate( -40, 0, 20 );
        translate( -80, 0, 0 );

        rotateZ( (float)( Math.PI/4 ) );

        fill( 20 );
        box( 50, 50, 15 );
    }
}