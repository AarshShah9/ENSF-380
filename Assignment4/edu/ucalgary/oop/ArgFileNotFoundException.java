package edu.ucalgary.oop;

public class ArgFileNotFoundException extends Exception {
    public ArgFileNotFoundException(String e) {
        super("File not found:" + e);
    }
}