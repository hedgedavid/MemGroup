import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test {

    public static void main(String[] args) {
        byte mem1 = Processor.phaseHexChartoBinary('F');
        byte mem2 = Processor.phaseHexChartoBinary('A');

        Path programPath = Path.of("maxfinder.txt");
        
        String program = null; 

        StringBuilder strBuild = new StringBuilder();
        FileReader fileReader = null;
        BufferedReader bufRead = null;
        try {
             fileReader = new FileReader("maxfinder.txt");
             bufRead = new BufferedReader(fileReader);
             String line;
             bufRead.readLine();
             bufRead.readLine();
             while((line = bufRead.readLine()) != null){
                strBuild.append(line.substring(5) + "\n");
             }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        program = strBuild.toString();

        

    


        Processor processor = new Processor(program);



        while(!processor.getIsHalt())
            processor.executeInstructions();


        
        System.out.println(processor.toStringHex());
        
    }
}
