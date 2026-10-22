public interface ProcessorInterface {

    /**
     * 
     * return current Pointer Counter
     * @return PC
     */
    public int getPC();

    /**
     * 
     * execute current instructions at address PC.
     * Afterward, increment PC by 2 to next instruction 
     * unless if the current instruction is HALT
     */
    public void executeInstructions();
    
    /**
     * phase the two byte of the instruction and uses one of the coorsponding method of the processors
     * @param instruction
     */
    public void phaseInstruction(Byte[] instruction);

    /**
     * Add both register1 and register2 and
     * store in register 3
     * @param register1
     * @param register2
     * @param register3
     */
    public void ADD(Byte[] register1, Byte[] register2, Byte[] register3);

    /**
     * Multiply both register1 and register2 and
     * store in register 3
     * @param register1
     * @param register2
     * @param register3
     */
    public void MUL(Byte[] register1, Byte[] register2, Byte[] register3);

    /**
     * Add both register1 and register2 as float and
     * store in register 3
     * @param register1
     * @param register2
     * @param register3
     */
    public void ADDF(Byte[] register1, Byte[] register2, Byte[] register3);

    /**
     * Multiply both register1 and register2 as float and
     * store in register 3
     * @param register1
     * @param register2
     * @param register3
     */
    public void MULF(Byte[] register1, Byte[] register2, Byte[] register3);

    /**
     * load data from memory at address IAddress
     * @param register1
     * @param IAddress
     */
    public void LOADI(Byte[] register1, int IAddress);

    /**
     * load data from memory at address register2
     * @param register1
     * @param IAddress
     */
    public void LOAD(Byte[] register1, Byte[] register2);

    /**
     * store at register memory at address register2
     * @param register1
     * @param register2
     */
    public void STORE(Byte[] register1, Byte[] register2);

    /**
     * jump condictional at address register1
     * @param register1
     */
    public void JMP(Byte[] register1);

    /**
     * jump at address register1 if register2 is less than zero
     * @param register1
     * @param register2
     */
    public void JMPL(Byte[] register1, Byte[] register2);

    /**
     * jump at address register1 if register2 is equal to zero
     * @param register1
     * @param register2
     */
    public void JMPE(Byte[] register1, Byte[] register2);

    /**
     * bitwise AND operation of register1 and register2 and store the result to
     * register3
     * @param register1
     * @param register2
     * @param register3
     */
    public void AND(Byte[] register1, Byte[] register2, Byte[] register3);

    /**
     * bitwise OR operation of register1 and register2 and store the result to
     * register3
     * @param register1
     * @param register2
     * @param register3
     */
    public void OR(Byte[] register1, Byte[] register2, Byte[] register3);

    /**
     * bitwise NOT operation of register1 and store the result to register2
     * @param register1
     * @param register2
     */
    public void NOT(Byte[] register1, Byte[] register2);

    /**
     * logical shift left operation of register1 shift to it left by register2
     * and store it result to register3
     * @param register1
     * @param register2
     * @param register3
     */
    public void LSL(Byte[] register1, Byte[] register2, Byte[] register3);

    /**
     * logical shift right operation of register1 shift to it left by register2
     * and store it result to register3
     * @param register1
     * @param register2
     * @param register3
     */
    public void LSR(Byte[] register1, Byte[] register2, Byte[] register3);

    /**
     * halt and stop the program
     */
    public void HALT();

    /**
     * load the program with input string in hexdecimal format
     * doing so will also reset the PC to 0
     */
    public void loadProgram(String program);
}


