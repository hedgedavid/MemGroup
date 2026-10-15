
import static java.lang.System.exit;


/**
 * Simulates an ISA
 * @author David Hedge, Dakotah Williams, Dedi Seme, Haylee Staub
 */
public class isaSim {
    public static void main(String[] args) {
        if (args.length < 4){
            System.out.println("Incorrect number of arguments entered in the command line.");
            System.out.println("Needs to be in format \" $ isaSim <r|s> <assembly file> <memory file>\"");
            exit(1);
        }
        if (!args[1].equals("-r") || !args[1].equals("-s")){
            System.out.println("Please input what mode the simulator should run in");
            System.out.println("Input \"-r\" for run straight through. Input \"-s\" for run step-by-step");
            exit(1);
        }
    }
}
