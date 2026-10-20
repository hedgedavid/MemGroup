public interface ProcessorInterface {

    public int getPC();

    public void executeInstructions();
    
    public void phaseInstruction(Byte[] instruction);

    public void ADD(Byte[] register1, Byte[] register2);

    public void MUL(Byte[] register1, Byte[] register2);

    public void ADDF(Byte[] register1, Byte[] register2);

    public void MULF(Byte[] register1, Byte[] register2);

    public void LOADI(Byte[] register1, Byte[] IAddress);

    public void LOAD(Byte[] register1, Byte[] register2);

    public void STORE(Byte[] register1, Byte[] register2);

    public void JMP(Byte[] register1, Byte[] register2);

    public void JMPL(Byte[] register1, Byte[] register2);

    public void JMPE(Byte[] register1, Byte[] register2);

    public void AND(Byte[] register1, Byte[] register2);

    public void OR(Byte[] register1, Byte[] register2);

    public void NOT(Byte[] register1, Byte[] register2);

    public void LSL(Byte[] register1, Byte[] register2);

    public void LSR(Byte[] register1, Byte[] register2);

    public void HALT(Byte[] register1, Byte[] register2);
}
