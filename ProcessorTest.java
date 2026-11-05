
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ProcessorTest {



   private Processor processor;
   String mem = "00\n00\n10\n00\n20\n00\n30\n00\n40\n00\n50\n00\n60\n00\n70\n00\n80\n00\n90\n00\nA0\n00\nB0\n00\nC0\n00\nD0\n00\nE0\n00\nF0\n00";

   @Test
   void testCreateProcessorClass(){
        Processor processor;

        processor = new Processor();

        assertTrue(processor != null);
   }

   @Test
   void testProcessorAddInteger(){
        
        Processor processor = new Processor();
        Byte[] register1 = new Byte[2];
        Byte[] register2 = new Byte[2];
        Byte[] register3 = new Byte[2];

        //test 1 add 0b11111111 with 0b00000001

        

        

        register2[0] = (byte)0xFF;
        register2[1] = (byte)0xFF;

        register3[0] = (byte)0x00;
        register3[1] = (byte)0x01;


        
        processor.ADD(register1, register2, register3);

        assertEquals((byte)0x00, register1[0]);
        assertEquals((byte)0x00, register1[1]);
   }


   @Test
   void testProcessorMulInteger(){
        
        Processor processor = new Processor();
        Byte[] register1 = new Byte[2];
        Byte[] register2 = new Byte[2];
        Byte[] register3 = new Byte[2];

        //test 1 add 0b00001001 with 0b00000010

        

        

        register2[0] = (byte)0x09;
        register2[1] = (byte)0x00;

        register3[0] = (byte)0x00;
        register3[1] = (byte)0x02;


        
        processor.MUL(register1, register2, register3);

        assertEquals((byte)0x12, register1[0]);
        assertEquals((byte)0x00, register1[1]);
   }


   @Test
   void testProcessorAddFloat(){
        
        Processor processor = new Processor();
        Byte[] register1 = new Byte[2];
        Byte[] register2 = new Byte[2];
        Byte[] register3 = new Byte[2];

        //test 1 add 0b11111111 with 0b00000001

        
        

        
        short halfFloat2 = Float.floatToFloat16(2.0f);
        short halfFloat3 = Float.floatToFloat16(7.5f);

        register2[0] = (byte)((halfFloat2 & 0xFF00) >> 8);
        register2[1] = (byte)(halfFloat2 & 0xFF);

        register3[0] = (byte)((halfFloat3 & 0xFF00) >> 8);
        register3[1] = (byte)(halfFloat3 & 0xFF);
        
        float halfFloat1 = 9.5f;
        


        
        processor.ADDF(register1, register2, register3);

        float result = Float.float16ToFloat((short)(((register1[0] & 0xFF) << 8) | (register1[1] & 0xFF)));

        float num = Math.abs(halfFloat1 - result);
        assertTrue(num < 0.05);
    
        
   }


      @Test
   void testProcessorMulFloat(){
        
        Processor processor = new Processor();
        Byte[] register1 = new Byte[2];
        Byte[] register2 = new Byte[2];
        Byte[] register3 = new Byte[2];

        //test 1 add 0b11111111 with 0b00000001

        
        

        
        short halfFloat2 = Float.floatToFloat16(2.0f);
        short halfFloat3 = Float.floatToFloat16(7.5f);

        register2[0] = (byte)((halfFloat2 & 0xFF00) >> 8);
        register2[1] = (byte)(halfFloat2 & 0xFF);

        register3[0] = (byte)((halfFloat3 & 0xFF00) >> 8);
        register3[1] = (byte)(halfFloat3 & 0xFF);
        
        float halfFloat1 = 15.0f;
        


        
        processor.MULF(register1, register2, register3);

        float result = Float.float16ToFloat((short)(((register1[0] & 0xFF) << 8) | (register1[1] & 0xFF)));

        float num = Math.abs(halfFloat1 - result);
        assertTrue(num < 0.05);
    
        
   }


   @Test
   void testProcessorMem(){
     
     Processor processor = new Processor(mem);

     Byte[] register1 = new Byte[3];
     
     processor.LOADI(register1, 16);

     short expected = (short)0x8000;

     short result = (short)((short)((register1[0] & 0xFF) << 8) | (register1[1] & 0xFF));

          assertEquals(expected, result);
   }


}
