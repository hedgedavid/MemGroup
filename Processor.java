import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Processor implements ProcessorInterface{

    final int NUMBER_OF_REG = 16;
    
    private int PC;
    
    private Byte register[][];

    private Byte[][] memory;

    boolean isHalt; // if ture the program will not run another instruction till it reset
    

    


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
        Byte sample = (byte)(instruction[0] >> 4);

        Byte[] register1 = register[instruction[0] & 0x0F];
        Byte[] register2 = register[(instruction[1] & 0xF0) >> 4];
        Byte[] register3 = register[instruction[1] & 0x0F];

        switch(sample){
            case 0x00:
                ADD(register1, register2, register3);
                break;
            case 0x01:
                MUL(register1, register2, register3);
                break;
            case 0x02:
                ADDF(register1, register2, register3);
                break;
            case 0x03:
                MULF(register1, register2, register3);
                break;
            case 0x04:
                int IAddress = (int)(((instruction[0] & 0x0F) << 8) | (instruction[1] & 0xFF));
                LOADI(register1, IAddress);
                break;
            case 0x05:
                LOAD(register1, register2);
                break;
            case 0x06:
                STORE(register1, register2);
                break;
            case 0x07:
                JMP(register1);
                break;
            case 0x08:
                JMPL(register1, register2);
                break;
            case 0x09:
                JMPE(register1, register2);
                break;
            case 0x0A:
                AND(register1, register2, register3);
                break;
            case 0x0B:
                OR(register1, register2, register3);
                break;
            case 0x0C:
                NOT(register1, register2);
                break;
            case 0x0D:
                LSL(register1, register2, register3);
                break;
            case 0x0E:
                LSR(register1, register2, register3);
                break;
            case 0x0F:
                HALT();
                break;
                
        }
    }




    @Override
    public void ADD(Byte[] register1, Byte[] register2, Byte[] register3) {
        int num1 = ((register1[0] & 0xFF) << 8) | (register1[1] & 0xFF);
        int num2 = ((register2[0] & 0xFF) << 8) | (register2[1] & 0xFF);
        int result = num1 + num2;
        register3[0] = (byte)((result & 0xFF00) >> 8);
        register3[1] = (byte)(result & 0xFF);
    }




    @Override
    public void MUL(Byte[] register1, Byte[] register2, Byte[] register3) {
        int num1 = ((register1[0] & 0xFF) << 8) | (register1[1] & 0xFF);
        int num2 = ((register2[0] & 0xFF) << 8) | (register2[1] & 0xFF);
        int result = num1 * num2;
        register3[0] = (byte)((result & 0xFF00) >> 8);
        register3[1] = (byte)(result & 0xFF);
    }




    @Override
    public void ADDF(Byte[] register1, Byte[] register2, Byte[] register3) {
        float num1 = Float.float16ToFloat((short)(((register1[0] & 0xFF) << 8) | (register1[1] & 0xFF)));
        float num2 = Float.float16ToFloat((short)(((register2[0] & 0xFF) << 8) | (register2[1] & 0xFF)));

        float result = num1 + num2;
        short halfFloat = Float.floatToFloat16(result);

        register3[0] = (byte)((halfFloat & 0xFF00) >> 8);
        register3[1] = (byte)(halfFloat & 0xFF);
    }




    @Override
    public void MULF(Byte[] register1, Byte[] register2, Byte[] register3) {
        float num1 = Float.float16ToFloat((short)(((register1[0] & 0xFF) << 8) | (register1[1] & 0xFF)));
        float num2 = Float.float16ToFloat((short)(((register2[0] & 0xFF) << 8) | (register2[1] & 0xFF)));

        float result = num1 * num2;
        short halfFloat = Float.floatToFloat16(result);

        register3[0] = (byte)((halfFloat & 0xFF00) >> 8);
        register3[1] = (byte)(halfFloat & 0xFF);
    }




    @Override
    public void LOADI(Byte[] register1, int IAddress) {
        register1 = memory[IAddress];
    }




    @Override
    public void LOAD(Byte[] register1, Byte[] register2) {
        register1 = memory[(int)(((register2[0] & 0x0F) << 8) | (register2[1] & 0xFF))];
    }




    @Override
    public void STORE(Byte[] register1, Byte[] register2) {
        memory[(int)(((register2[0] & 0x0F) << 8) | (register2[1] & 0xFF))] = register1;
    }




    @Override
    public void JMP(Byte[] register1) {
        PC = ((register1[0] & 0xFF) << 8) | (register1[1] & 0xFF);
    }




    @Override
    public void JMPL(Byte[] register1, Byte[] register2) {
        
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

        


        
        

        List<String> list = program.lines().toList();

        int lineCount = list.size();

        memory = new Byte[lineCount][2];
        

        String temp = null;

        for(int i = 0; i < lineCount; i++){
            temp = list.get(i);
            memory[i][0] = (byte)((phaseHexChartoBinary(temp.charAt(0)) << 4) + phaseHexChartoBinary(temp.charAt(1)));
            memory[i][1] = (byte)((phaseHexChartoBinary(temp.charAt(2)) << 4) + phaseHexChartoBinary(temp.charAt(3)));
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
