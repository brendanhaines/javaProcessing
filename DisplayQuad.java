class DisplayQuad extends Display3D {
    
    public DisplayQuad() {
        super();
    }

    public DisplayQuad( int bkgnd) {
        super( bkgnd );
    }

    /**
     *
     */
    public void drawObject() {
        int s = 1;
        noFill();

        beginShape();
        stroke( 250 );
        vertex( s*25,   0,      0 );
        vertex( s*100,  s*75,   0 );
        vertex( s*100,  s*85,   0 );

        // leg
        vertex( s*100,  s*85,   0 );
        vertex( s*100,  s*85,   -s*15 );
        vertex( s*100,  s*75,   -s*10 );
        vertex( s*100,  s*75,   0 );
        vertex( s*100,  s*85,   0 );
        vertex( s*100,  s*85,   -s*15 );
        vertex( s*90,   s*85,   0 );
        vertex( s*100,  s*85,   -s*15 );
        vertex( s*90,   s*85,   -s*10 );
        vertex( s*90,   s*85,   0 );
        vertex( s*100,  s*85,   0 );

        // arm
        vertex( s*100,  s*85,   0 );
        vertex( s*90,   s*85,   0 );
        vertex( 0,      s*25,   0 );
        vertex( -s*90,  s*85,   0 );
        vertex( -s*100, s*85,   0 );

        // leg
        vertex( -s*100,  s*85,   0 );
        vertex( -s*100,  s*85,   -s*15 );
        vertex( -s*100,  s*75,   -s*10 );
        vertex( -s*100,  s*75,   0 );
        vertex( -s*100,  s*85,   0 );
        vertex( -s*100,  s*85,   -s*15 );
        vertex( -s*90,   s*85,   0 );
        vertex( -s*100,  s*85,   -s*15 );
        vertex( -s*90,   s*85,   -s*10 );
        vertex( -s*90,   s*85,   0 );
        vertex( -s*100,  s*85,   0 );

        // arm
        vertex( -s*100, s*85,   0 );
        vertex( -s*100, s*75,   0 );
        vertex( -s*25,  0,      0 );

        stroke( 255, 0, 0 );

        vertex( -s*25,  0,      0 );
        vertex( -s*100, -s*75,  0 );
        vertex( -s*100, -s*85,  0 );

        // leg
        vertex( -s*100,  -s*85,   0 );
        vertex( -s*100,  -s*85,   -s*15 );
        vertex( -s*100,  -s*75,   -s*10 );
        vertex( -s*100,  -s*75,   0 );
        vertex( -s*100,  -s*85,   0 );
        vertex( -s*100,  -s*85,   -s*15 );
        vertex( -s*90,   -s*85,   0 );
        vertex( -s*100,  -s*85,   -s*15 );
        vertex( -s*90,   -s*85,   -s*10 );
        vertex( -s*90,   -s*85,   0 );
        vertex( -s*100,  -s*85,   0 );

        // arm
        vertex( -s*100, -s*85,  0 );
        vertex( -s*90,  -s*85,  0 );
        vertex( 0,      -s*25,  0 );
        vertex( s*90,   -s*85,  0 );
        vertex( s*100,  -s*85,  0 );

        // leg
        vertex( s*100,  -s*85,   0 );
        vertex( s*100,  -s*85,   -s*15 );
        vertex( s*100,  -s*75,   -s*10 );
        vertex( s*100,  -s*75,   0 );
        vertex( s*100,  -s*85,   0 );
        vertex( s*100,  -s*85,   -s*15 );
        vertex( s*90,   -s*85,   0 );
        vertex( s*100,  -s*85,   -s*15 );
        vertex( s*90,   -s*85,   -s*10 );
        vertex( s*90,   -s*85,   0 );
        vertex( s*100,  -s*85,   0 );

        // arm
        vertex( s*100,  -s*85,  0 );
        vertex( s*100,  -s*75,  0 );
        vertex( s*25,   0,      0 );
        endShape();

        // sphere
        pushMatrix();
        rotateX((float)(Math.PI/2));
        noFill();
        stroke(100);
        sphere(280);
        popMatrix();
    }
}