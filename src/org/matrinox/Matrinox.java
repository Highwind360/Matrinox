/**
 * Grayson Sinclair
 * 10/06/2015
 *
 * This is the main class. It manages all the other classes and handles
 * user i/o.
 */

package org.matrinox;

class Matrinox {
    // Manages input/output for Matrinox
    MatrinoxIO mio;

    public static void main(String[] args) {
        mio = new MatrinoxIO(System.in, ".matrinfo");
        printGreeting();
        
        while(mio.nextCommand()) {
            System.out.println(mio.output());
        }
    }

    private static void printGreeting() {
        String greeting = "Welcome to the Matrix. Type '?' for help, " +
        "or '" + mio.getExitCommand() + "' to quit.";
        System.out.println(greeting);
    }
}
