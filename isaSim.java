
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        if (args.length != 3){
            System.out.println("Incorrect number of arguments entered in the command line.");
            System.out.println("Needs to be in format \" $ isaSim <r|s> <assembly file> <memory file>\"");
            System.exit(1);
        }
        if (!args[0].equals("-r") && !args[0].equals("-s")){
            System.out.println("Please input what mode the simulator should run in");
            System.out.println("Input \"-r\" for run straight through. Input \"-s\" for run step-by-step");
            System.exit(1);
        }

        // Check if the provided files are accurate
        if (!CheckFilePath(args[1]) || !CheckFilePath(args[2])) System.exit(1);


        // Run Through or Step by Step
        if (args[0].equals("-s")) {
            StepByStep(args[1], args[2]);
        } else {
            RunThrough(args[1], args[2]);
        }
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
        
        try {
            String program = Files.readString(Paths.get(asFile));
            Processor processor = new Processor(program);

            int totalInstructions = 0;
            Map<String, Integer> count = new HashMap<>(); // For the number of times an element has been found in a list

            while(!processor.isHalt) {
                System.out.println("Current PC: " + processor.getPC());
                System.out.println("Total instructions executed: " + totalInstructions);
                System.out.println("Press enter to continue");

                processor.executeInstructions();
                totalInstructions++;
            }

            writeOutput(asFile, memFile, totalInstructions, count, processor);

        } catch (IOException e) {
            System.err.println("Could not load program string: " + e);
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
        try {
            String program = Files.readString(Paths.get(asFile));
            Processor processor = new Processor(program);

            int totalInstructions = 0;
            Map<String, Integer> count = new HashMap<>(); // For the number of times an element has been found in a list

            while(!processor.isHalt) {
                processor.executeInstructions();
                totalInstructions++;
            }

            writeOutput(asFile, memFile, totalInstructions, count, processor);

        } catch (IOException e) {
            System.err.println("Could not load program string: " + e);
        }
    }

    /**
     * Private helper method that writes all relevant data
     * to its corresponding output file
     * 
     * @param asFile assembly file
     * @param memFile memory file
     * @param instructCount number of executed instructions
     * @param count frequency of executed instructions
     * @param processor processor for ISA
     */
    private static void writeOutput(String asFile, String memFile, int instructCount, Map<String, Integer> count, Processor processor) {
        String benchmarkName = getBenchmarkName(asFile);
        Byte[][] mem = processor.getMemory();
        // Write instruction count to a file called <benchmarkName>.instrCount
        String output = benchmarkName + ".instrCount";
        // Write memory output to a file named <benchmarkName>.mem.out
        String memOutput = benchmarkName + ".mem.out";

        // Write the total amount of instructions executed to the output file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                bw.write(entry.getKey() + " : " + entry.getValue());
                bw.newLine();
            }

            bw.write("Total instructions executed: " + instructCount);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Could not write instruction count to file: " + e.getMessage());
        }

        // Write the final contents of the memory to the output file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(memOutput))) {
            for (Byte[] row : mem) {
                int byte1 = row[0]; // may need to be adjusted to account for null memory slots
                int byte2 = row[1];

                String hex1 = Integer.toHexString(byte1);
                String hex2 = Integer.toHexString(byte2);

                bw.write(hex1 + hex2);
                bw.newLine();
            }

            bw.write("Total instructions executed: " + instructCount);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Could not write memory to file: " + e.getMessage());
        }
    }

    /**
     * Private method to extract a given benchmark's file name
     * from the provided file path
     * 
     * @param asFile file path
     * @return filename of the benchmark as a String
     */
    private static String getBenchmarkName(String asFile) {
        String fileName = Paths.get(asFile).getFileName().toString();
        return fileName.split("\\.")[0];
    }
}
