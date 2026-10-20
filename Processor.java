public class Processor implements ProcessorInterface{

    
    private int PC;
    
    private char register[];


    public Processor(){
        this.PC = 0;
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
    public void ADD(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ADD'");
    }




    @Override
    public void MUL(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'MUL'");
    }




    @Override
    public void ADDF(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ADDF'");
    }




    @Override
    public void MULF(Byte[] register1, Byte[] register2) {
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
    public void JMP(Byte[] register1, Byte[] register2) {
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
    public void AND(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AND'");
    }




    @Override
    public void OR(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'OR'");
    }




    @Override
    public void NOT(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'NOT'");
    }




    @Override
    public void LSL(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LSL'");
    }




    @Override
    public void LSR(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LSR'");
    }




    @Override
    public void HALT(Byte[] register1, Byte[] register2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'HALT'");
    }
}
