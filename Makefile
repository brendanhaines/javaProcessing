all: build run

run: run_tester3d

build:
	javac -cp '.:core.jar:gluegen-rt.jar:jogl-all.jar:gluegen-rt-natives-macosx-universal.jar:jogl-all-natives-macosx-universal.jar' Display3D.java DisplayQuad.java Tester3D.java DisplayNewQuad.java

run_tester:
	java -cp '.:core.jar:gluegen-rt.jar:jogl-all.jar:gluegen-rt-natives-macosx-universal.jar:jogl-all-natives-macosx-universal.jar' tester

run_tester3d:
	java -cp '.:core.jar:gluegen-rt.jar:jogl-all.jar:gluegen-rt-natives-macosx-universal.jar:jogl-all-natives-macosx-universal.jar' Tester3D

