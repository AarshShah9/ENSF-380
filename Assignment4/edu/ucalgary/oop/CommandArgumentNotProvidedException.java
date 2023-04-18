package edu.ucalgary.oop;

public class CommandArgumentNotProvidedException extends Exception {
    public CommandArgumentNotProvidedException() {
        super("Command-line argument not provided.");
    }
}
