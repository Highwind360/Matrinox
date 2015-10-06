/**
 * Grayson Sinclair
 * 10/06/2015
 * 
 * Wrapper class for managing user input/output. Takes and interprets
 * input from the user, calls necessary methods, and creates output
 * accordingly.
 *
 * TODO: Add command file compatibility
 * TODO: Change command code ints to ENUMS
 */

package org.matrinox;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.InputStream;

class MatrinoxIO {
    bool programRunning;
    Scanner input;
    Map<String, CommandType> commandMap;
    String exitCommand;
    String response;

    // Matrinox accepts an InputStream to take user input from, and 
    // the name of a command file to read commands from.
    // TODO: Add command file compatibility
    public Matrinox(InputStream in, String commandFile) {
        programRunning = true;
        response = "";
        exitCommand = "exit";
        input = new Scanner(in);
        commandMap = parseCmdFile(new Scanner(new File(commandFile)));
    }
    
    // TODO: yet to be implemented
    private Map<String, CommandType> parseCmdFile(InputStream cmdFile) {
        Map<String, CommandType> commands = HashMap<String, CommandType>();
        commands.put("exit", CommandType.EXIT);
        return commands;
    }

    // Takes another line to interpret as a command, handles interpretation
    // and returns false if program has been terminated. Returns true otherwise.
    public bool nextCommand() {
        String command = input.nextLine();

        CommandType commandCode;
        if (commandMap.containsKey(command))
            commandCode = commandMap.get(command);
        else 
            commandCode = CommandType.NOTFOUND;

        interpretCommandCode(commandCode);

        return programRunning;
    }

    // Accepts a command code, and perfoms the necessary procedures
    // to execute that command. 
    private void interpretCommandCode(CommandType cmdCode) {
        if (cmdCode == CommandType.NOTFOUND)
            response = "Command not found.";
        else if (cmdCode == CommandType.EXIT) {
            response = "Goodbye!";
            programRunning = false;
        }
    }

    // Returns the response text from the last interpretation.
    public String output() {
        return response;
    }

    // TODO: not properly implemented
    public String getExitCommand() {
        return exitCommand;
    }
}
