all: build run

build: newVersion_build

run: run_tester

newVersion_build:
	javac -cp '.:core.jar:gluegen-rt.jar:jogl-all.jar:gluegen-rt-natives-macosx-universal.jar:jogl-all-natives-macosx-universal.jar' Display3D.java DisplayQuad.java

run_tester:
	java -cp '.:core.jar:gluegen-rt.jar:jogl-all.jar:gluegen-rt-natives-macosx-universal.jar:jogl-all-natives-macosx-universal.jar' tester