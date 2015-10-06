all:
	javac -d classes -cp src src/org/matrinox/Matrinox.java
	jar cfm matrinox.jar manifest -C classes .
