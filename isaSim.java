
import static java.lang.System.exit;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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
        if (args[0].equals("-s")) StepByStep();
        else RunThrough();
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
            the current contents of all the registers mentioned in the RTL (e.g. PC, register file, etc.)
        Total number of instructions executed so far
        Wait for user to press enter before executing the next step (If you want to bonus it up, you may allow the user to enter a number of 
         steps to execute before pausing and displaying the required data. That is not required, though)
        At end of execution of the benchmark, 
            Display to the console the number of times each instruction was executed (e.g. how many times was add executed, how many times was beq executed, etc.)
            Write the instruction count information out to a file called <benchmarkName>.instrCount
            write the final contents of the memory to the appropriately named .out file(e.g. <benchmarkName>.mem.out)

     */
    private static void StepByStep() {

    }

    /**
     * Run Through function for the isa benchmark
     *  At the end of execution of the benchmark,
            Display to the console the number of times each instruction was executed (e.g. how many times was add executed, how many times was beq executed, etc.)
            Write the instruction count information out to a file called <benchmarkName>.instrCount
            write the final contents of the memory to the appropriately named .out file(e.g. <benchmarkName>.mem.out)
     */
    private static void RunThrough() {

    }
}
