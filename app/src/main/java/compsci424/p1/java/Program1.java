/* COMPSCI 424 Program 1
 * Name:
 * 
 * This is a template. Program1.java *must* contain the main class
 * for this program. Otherwise, feel free to edit these files, even
 * these pre-written comments or my provided code. You can add any
 * classes, methods, and data structures that you need to solve the
 * problem and display your solution in the correct format.
 */
package compsci424.p1.java;

/**
 * Main class for this program. The required steps have been copied
 * into the main method as comments. Feel free to add more comments to
 * help you understand your code, or for any other reason. Also feel
 * free to edit this comment to be more helpful for you.
 */
public class Program1 {
    // Declare any class/instance variables that you need here.

    /**
     * @param args command-line arguments, which can be ignored
     */
    public static void main(String[] args) {

        // 1. Ask the user to enter commands of the form "create N",
        //    "destroy N", or "end", where N is an integer between 0 
        //    and 15.
    	
    	
    	Scanner scanner = new Scanner(System.in);
    	List<String> actions = new ArrayList<>();
        System.out.println("Enter 'create N', 'destroy N', or 'end', where N is an integer between 0 and 15:");
        String command = scanner.nextLine();//dont want to put value straight into actions before checking
        
        // 2. While the user has not typed "end", continue accepting
        //    commands. Add each command to a list of actions to take 
        //    while you run the simulation.
        while (!command.equals("end")) {
        	// 3. When the user types "end" (or optionally any word that 
            //    is not "create" or "destroy"), stop accepting commands 
            //    and complete the following steps.
            //
            // Hint: Steps 2 and 3 refer to the same loop. ;-)
        	if (isValidCommand(command)) {
                actions.add(command); // adds the command to the list
            } else {
                System.out.println("Invalid command. Please enter a valid command.");//to make sure user only enters create,destroy, or end
            }

            command = scanner.nextLine(); // Read the next command
        }

        scanner.close(); // Close the scanner

        System.out.println("Actions entered by the user:");//prints actions that were entered and valid
        for (String action : actions) {//all valid actions copied onto string and printed
            System.out.println(action);
        }
        
        // 4. Create an object of the Version 1 class and an object of
        //    the Version 2 class.
		 Version1 v1 = new Version1();
		
        // 5. Run the command sequence once with the Version 1 object, 
        //    calling its showProcessTree method after each command to
        //    show the changes in the tree after each command.
		 runCommands(v1, actions);
        // 6. Repeat step 5, but with the Version 2 object.
		 Version2 v2 = new Version2();
	     runCommands(v2, actions);
        // 7. Store the current system time in a variable

        // ... then run the command sequence 200 times with Version 1.

        // ... After this, store the new current system time in a
        //     second variable. Subtract the start time from the end 
        //     time to get the Version 1 running time, then display 
        //     the Version 1 running time.
	     long startTimeV1 = System.currentTimeMillis();
	        for (int i = 0; i < 200; i++) {
	            runCommands(v1, actions);
	        }
	        long endTimeV1 = System.currentTimeMillis();

	        //calculate Version1 running time and display it
	        long runningTimeV1 = endTimeV1 - startTimeV1;
	        System.out.println("Version 1 Running Time: " + runningTimeV1 + " milliseconds");
        // 8. Repeat step 7, but with the Version 2 object.
	        long startTimeV2 = System.currentTimeMillis();
	        for (int i = 0; i < 200; i++) {
	            runCommands(v2, actions);
	        }
	        long endTimeV2 = System.currentTimeMillis();

	        //calculate Version2 running time and display it
	        long runningTimeV2 = endTimeV2 - startTimeV2;
	        System.out.println("Version 2 Running Time: " + runningTimeV2 + " milliseconds");
     
        System.out.println("Builds without errors and runs to completion.");
  }
 }
}//end main
    private static boolean isValidCommand(String command) {
        String[] parts = command.split(" "); // splits the command with a space
        if (parts.length != 2) {
            return false; // checks if the command has two parts or not
        }
        if (!parts[0].equals("create") && !parts[0].equals("destroy")) {
            return false; // checks if the first part is create or destroy
        }
        try {
            int n = Integer.parseInt(parts[1]);
            if (n < 0 || n > 15) {
                return false; // checks if the second part is a valid integer between 0 and 15
            }
        } catch (NumberFormatException e) {
            return false; // if 2nd part isn't a number between 0-15
        }
        return true; // overall command is a valid command and number
    }
    
    private static void runCommands(Version1 version, List<String> actions) {//runCommands for Version1
        for (String action : actions) {
            String[] parts = action.split(" ");
            int pid = Integer.parseInt(parts[1]);
            if (parts[0].equals("create")) {
                version.create(pid);
            } else if (parts[0].equals("destroy")) {
                version.destroy(pid);
            }
            version.showProcessInfo();
        }
    }
    
    private static void runCommands(Version2 version, List<String> actions) {//runCommands for Version2
        for (String action : actions) {
            String[] parts = action.split(" ");
            int pid = Integer.parseInt(parts[1]);
            if (parts[0].equals("create")) {
                version.create(pid);
            } else if (parts[0].equals("destroy")) {
                version.destroy(pid);
            }
            version.showProcessInfo();
        }
    }
    
    
    
    
    
    
}//end Program1
        

      