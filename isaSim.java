
import java.io.IOException;
import static java.lang.System.exit;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Simulates an ISA
 * @author David Hedge, Dakotah Williams, Dedi Seme, Haylee Staub
 */
public class isaSim {
    public static void main(String[] args) {
        // Check if the input is correct
        if (args.length < 3){
            System.out.println("Incorrect number of arguments entered in the command line.");
            System.out.println("Needs to be in format \" $ isaSim <r|s> <assembly file> <memory file>\"");
            exit(1);
        }
        if (!args[0].equals("-r") && !args[0].equals("-s")){
            System.out.println("Please input what mode the simulator should run in");
            System.out.println("Input \"-r\" for run straight through. Input \"-s\" for run step-by-step");
            exit(1);
        }

        // Check if the provided files are accurate
        if (!CheckFilePath(args[1]) || !CheckFilePath(args[2])) exit(1);


        // Run Through or Step by Step
        if (args[0].equals("-s")) StepByStep(args[1], args[2]);
        else RunThrough(args[1], args[2]);
    }

    private static boolean CheckFilePath(String pathToString) {
        Path path = Paths.get(pathToString);
        if (!Files.exists(path)) {
            System.err.println("Does not exist: " + path);
            return false;
        }
        if (!Files.isReadable(path)) {
            System.err.println("Not readable: " + path);
            return false;
        }
        return true;
    }

    /**
     * Step By Step function for the isa benchmark
     *  At each step, display: 
     *      the current contents of all the registers mentioned in the RTL (e.g. PC, register file, etc.)
     *  Total number of instructions executed so far
     *  Wait for user to press enter before executing the next step (If you want to bonus it up, you may allow the user to enter a number of 
     *   steps to execute before pausing and displaying the required data. That is not required, though)
     *  At end of execution of the benchmark, 
     *      Display to the console the number of times each instruction was executed (e.g. how many times was add executed, how many times was beq executed, etc.)
     *      Write the instruction count information out to a file called <benchmarkName>.instrCount
     *      write the final contents of the memory to the appropriately named .out file(e.g. <benchmarkName>.mem.out)
     * @param asFile assembly File
     * @param memFile memory File
     */
    @SuppressWarnings("UseSpecificCatch")
    private static void StepByStep(String asFile, String memFile) {
        Scanner scn = new Scanner(System.in);
        int linesToSkip = 0;
        Map<String, Integer> count = new HashMap<>(); // For the number of times an element has been found in a list
        while (linesToSkip > 1){ // TODO: while file still has next line/There are still instructions to be executed
            // Run through instruction
            // Count the contents of all the registers mentioned in the RTL
            // Print the total number of instructions executed so far
            int total = 0;
            for (int n: count.values()) total += n;
            System.out.println("Total Number of Instructions Executed: " + total);

            // Wait for user input before beginning next line
            if (linesToSkip > 0)
                try {
                    linesToSkip = Integer.parseInt(scn.nextLine());
                } catch(Exception e) {
                    System.out.println("Please input a valid number. Skipping 0 for now");
                }
            else
                linesToSkip--;
        }

        // Write instruction count to a file called <benchmarkName>.instrCount
        Path output = Paths.get("memoryGroupBenchmark.instrCount");
        // Display the number of times each instruction was executed to the user as well
        System.out.println("The number of times instructions have been executed");
        int total = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String countInfo = entry.getKey() + ": " + entry.getValue();
            total += entry.getValue();
            System.out.println(countInfo);
            try {
                Files.writeString(output, countInfo);
            } catch (IOException e) {
                System.err.println("Could not write file: " + e.getMessage());
            }
        }
        // Write the total amount of instructions executed to the output file
        try {
            Files.writeString(output, total + "");
        } catch (IOException e) {
            System.err.println("Could not write file: " + e.getMessage());
        }

        // Write the final contents of the memory to the appropriately named .out file <benchmarkName>.mem.out
        Path source = Paths.get(memFile);
        Path target = Paths.get("memoryGroupBenchmark.mem.out");

        try {
            Files.copy(source, target);
        } catch (IOException e) {
            System.err.println("Copy failed: " + e.getMessage());
        }
        scn.close();
    }

    /**
     * Run Through function for the isa benchmark
     *  At the end of execution of the benchmark,
     *      Display to the console the number of times each instruction was executed (e.g. how many times was add executed, how many times was beq executed, etc.)
     *      Write the instruction count information out to a file called <benchmarkName>.instrCount
     *      write the final contents of the memory to the appropriately named .out file(e.g. <benchmarkName>.mem.out)
     * @param asFile assembly File
     * @param memFile memory File
     */
    private static void RunThrough(String asFile, String memFile) {
        Scanner scn = new Scanner(System.in);
        int linesToSkip = 0;
        Map<String, Integer> count = new HashMap<>(); // For the number of times an element has been found in a list
        while (linesToSkip > 1){ // TODO: while file still has next line/There are still instructions to be executed
        
        }

        // Write instruction count to a file called <benchmarkName>.instrCount
        Path output = Paths.get("memoryGroupBenchmark.instrCount");
        // Display the number of times each instruction was executed to the user as well
        System.out.println("The number of times instructions have been executed");
        int total = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String countInfo = entry.getKey() + ": " + entry.getValue();
            total += entry.getValue();
            System.out.println(countInfo);
            try {
                Files.writeString(output, countInfo);
            } catch (IOException e) {
                System.err.println("Could not write file: " + e.getMessage());
            }
        }
        // Write the total amount of instructions executed to the output file
        try {
            Files.writeString(output, total + "");
        } catch (IOException e) {
            System.err.println("Could not write file: " + e.getMessage());
        }

        // Write the final contents of the memory to the appropriately named .out file <benchmarkName>.mem.out
        Path source = Paths.get(memFile);
        Path target = Paths.get("memoryGroupBenchmark.mem.out");

        try {
            Files.copy(source, target);
        } catch (IOException e) {
            System.err.println("Copy failed: " + e.getMessage());
        } 
        scn.close();
    }
}
