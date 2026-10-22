import java.security.InvalidParameterException;
import java.util.stream.Stream;

public class Processor implements ProcessorInterface{

    final int NUMBER_OF_REG = 16;
    
    private int PC;
    
    private Byte register[][];

    private Byte[][] memory;
    

    


    public Processor(){
        this.PC = 0;
        this.register = new Byte[NUMBER_OF_REG][2];
        memory = null; //since program hasn't been added, there's no way determining the size
    }

    public Processor(String program){
        this();
        loadProgram(program); //use the program string to load the program into the memory 
    }
        




    public int getPC(){
        return this.PC;
    }




    @Override
    public void executeInstructions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeInstructions'");
    }




    @Override
    public void phaseInstruction(Byte[] instruction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'phaseInstruction'");
    }




    @Override
    public void ADD(Byte[] register1, Byte[] register2, Byte[] register3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ADD'");
    }




    @Override
    public void MUL(Byte[] register1, Byte[] register2, Byte[] register3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'MUL'");
    }




    @Override
    public void ADDF(Byte[] register1, Byte[] register2, Byte[] register3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ADDF'");
    }




    @Override
    public void MULF(Byte[] register1, Byte[] register2, Byte[] register3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'MULF'");
    }




    @Override
    public void LOADI(Byte[] register1, Byte[] IAddress) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LOADI'");
    }




    @Override
    public void LOAD(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LOAD'");
    }




    @Override
    public void STORE(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'STORE'");
    }




    @Override
    public void JMP(Byte[] register1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'JMP'");
    }




    @Override
    public void JMPL(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'JMPL'");
    }




    @Override
    public void JMPE(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'JMPE'");
    }




    @Override
    public void AND(Byte[] register1, Byte[] register2, Byte[] register3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AND'");
    }




    @Override
    public void OR(Byte[] register1, Byte[] register2, Byte[] register3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'OR'");
    }




    @Override
    public void NOT(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'NOT'");
    }




    @Override
    public void LSL(Byte[] register1, Byte[] register2, Byte[] register3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LSL'");
    }




    @Override
    public void LSR(Byte[] register1, Byte[] register2, Byte[] register3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LSR'");
    }




    @Override
    public void HALT() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'HALT'");
    }


    @Override
    public void loadProgram(String program) {

        


        Stream<String> instructionStream = program.lines();
        int lineCount = (int)instructionStream.count();
        memory = new Byte[lineCount][2];

        for(int i = 0; i < lineCount; i++){
            memory[i][0] = (byte)5;
            memory[i][1] = (byte)5;
        }
    }


    public static Byte phaseHexChartoBinary(char character){
        if(Character.isDigit(character)){
            return (byte) ((int)character - (int)'0');
        } else if (Character.isUpperCase(character) && character <= 'F'){
            return (byte) ((int)character - (int)'A' + 10);
        } else{
            throw new InvalidParameterException();
        }
        
        
        
    }



    
        
}
