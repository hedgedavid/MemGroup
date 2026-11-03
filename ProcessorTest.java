import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Random;


public class ProcessorTest {



   private Processor processor;
   String mem = "0000\n1000\n2000\n3000\n4000\n5000\n6000\n7000\n8000\n9000\nA000\nB000\nC000\nD000\nE000\nF000";

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

//    /*
//     * Test for empty list
//    */
//    @Test
//    void testEmptyList(){
//         maxHeap = new MaxHeap<>();

//         assertTrue(maxHeap.isEmpty());
//    }

//    /*
//     * Test for one element list
//    */
//    @Test
//    void testOneElementList(){
//         maxHeap = new MaxHeap<>();
//         TestObject element1 = new TestObject("element1", 0);
//         maxHeap.insert(element1);

//         assertFalse(maxHeap.isEmpty());
//    }

//    /*
//     * Test for two element list
//    */
//    @Test
//    void testTwoElementList(){
//         maxHeap = new MaxHeap<>();

//         TestObject element1 = new TestObject("element1", 1);
//         TestObject element2 = new TestObject("element2", 2);

//         maxHeap.insert(element1);
//         maxHeap.insert(element2);

//         TestObject expected[] = new TestObject[2];

//         expected[0] = element2;
//         expected[1] = element1;


//         ArrayList<TestObject> listResult = maxHeap.getHeap();
//         TestObject result[] = new TestObject[2];
//         result[0] = listResult.get(0);
//         result[1] = listResult.get(1);
//         assertArrayEquals(result, expected); // should be {element2, element1}
//    }


//    /*
//     * Test two element list using extractMax() method
//    */
//    @Test
//    void testTwoElementListExtractMax () throws HeapException{
//         maxHeap = new MaxHeap<>();

//         // test element
//         TestObject element1 = new TestObject("element1", 1);
//         TestObject element2 = new TestObject("element2", 2);

//         // add test element into maxHeap
//         maxHeap.insert(element1);
//         maxHeap.insert(element2);

//         //extract element
//         TestObject extractElement;

//         //extract first element from the list (should be element2)
//         assertEquals(maxHeap.max(), element2);
//         extractElement = maxHeap.extractMax();
//         assertEquals(extractElement, element2);

//         //extract second element from the list (should be element1)
//         assertEquals(maxHeap.max(), element1);
//         extractElement = maxHeap.extractMax();
//         assertEquals(extractElement, element1);


//         assertTrue(maxHeap.isEmpty()); // should be empty after calling extractMax() two time.
//    }


//    /*
//     * Test three element list using extractMax() method
//    */
//    @Test
//    void testThreeElementListExtractMax () throws HeapException{
//         maxHeap = new MaxHeap<>();

//         // test element
//         TestObject element1 = new TestObject("element1", 1);
//         TestObject element2 = new TestObject("element2", 2);
//         TestObject element3 = new TestObject("element3", 3);

//         // add test element into maxHeap
//         maxHeap.insert(element1);
//         maxHeap.insert(element2);
//         maxHeap.insert(element3);

//         //extract element
//         TestObject extractElement;

//         //extract first element from the list (should be element3)
//         assertEquals(maxHeap.max(), element3);
//         extractElement = maxHeap.extractMax();
//         assertEquals(extractElement, element3);

//         //extract second element from the list (should be element2)
//         assertEquals(maxHeap.max(), element2);
//         extractElement = maxHeap.extractMax();
//         assertEquals(extractElement, element2);

//         //extract first element from the list (should be element1)
//         assertEquals(maxHeap.max(), element1);
//         extractElement = maxHeap.extractMax();
//         assertEquals(extractElement, element1);


//         assertTrue(maxHeap.isEmpty()); // should be empty after calling extractMax() three time.
//    }

//    /*
//     * Test two element list using increaseKey() method
//    */
//    @Test
//    void testTwoElementListIncreaseKey() throws HeapException{
//         maxHeap = new MaxHeap<>();

//         // test element
//         TestObject element1 = new TestObject("element1", 1);
//         TestObject element2 = new TestObject("element2", 2);

//         // add test element into maxHeap
//         maxHeap.insert(element1);
//         maxHeap.insert(element2);

//         // test increaseKey() method
//         assertThrows(HeapException.class, () -> {maxHeap.increaseKey(element1, new TestObject("element1", 0));}, 
//             "new key is smaller than current key");
//         assertDoesNotThrow(() -> {maxHeap.increaseKey(element1, new TestObject("element1", 3));});

//         TestObject expected[] = new TestObject[2];

//         element1.setPriority(3); // priority changed
//         expected[0] = element1;
//         expected[1] = element2;

//         ArrayList<TestObject> listResult = maxHeap.getHeap();
//         TestObject result[] = new TestObject[2];
//         result[0] = listResult.get(0);
//         result[1] = listResult.get(1);

//         assertArrayEquals(result, expected); // should be {element1, element2}
        
//    }


//    /*
//     * Test three element list using increaseKey() method
//    */
//    @Test
//    void testThreeElementListIncreaseKey() throws HeapException{
//         maxHeap = new MaxHeap<>();

//         // test element
//         TestObject element1 = new TestObject("element1", 1);
//         TestObject element2 = new TestObject("element2", 2);
//         TestObject element3 = new TestObject("element3", 3);

//         // add test element into maxHeap
//         maxHeap.insert(element1);
//         maxHeap.insert(element2);
//         maxHeap.insert(element3);

//         // test increaseKey() method
//         assertThrows(HeapException.class, () -> {maxHeap.increaseKey(element1, new TestObject("element1", 0));}, 
//             "new key is smaller than current key");
//         assertDoesNotThrow(() -> {maxHeap.increaseKey(element1, new TestObject("element1", 5));});

//         assertThrows(HeapException.class, () -> {maxHeap.increaseKey(element3, new TestObject("element3", 0));}, 
//             "new key is smaller than current key");
//         assertDoesNotThrow(() -> {maxHeap.increaseKey(element3, new TestObject("element3", 4));});

//         TestObject expected[] = new TestObject[3];

//         element1.setPriority(5); // key changed
//         element3.setPriority(4); // key changed
//         expected[0] = element1;
//         expected[1] = element3;
//         expected[2] = element2;

//         ArrayList<TestObject> listResult = maxHeap.getHeap();
//         TestObject result[] = new TestObject[3];
//         result[0] = listResult.get(0);
//         result[1] = listResult.get(1);
//         result[2] = listResult.get(2);

//         assertArrayEquals(result, expected); // should be {element1, element3, element2}
//    }

//    /**
//     * test for inserting element in ascending order
//     * @throws HeapException
//     */
//    @Test
//    void testAddAscendingOrder() throws HeapException{
//         maxHeap = new MaxHeap<>();

//         // test element
//         TestObject element1 = new TestObject("element1", 1);
//         TestObject element2 = new TestObject("element2", 2);
//         TestObject element3 = new TestObject("element3", 3);
//         TestObject element4 = new TestObject("element4", 4);
//         TestObject element5 = new TestObject("element5", 5);

//         // add test element into maxHeap
//         maxHeap.insert(element1);
//         maxHeap.insert(element2);
//         maxHeap.insert(element3);
//         maxHeap.insert(element4);
//         maxHeap.insert(element5);

//         assertTrue(checkIfMaxHeap(maxHeap));

//         TestObject test[] = new TestObject[5];
//         test[0] = maxHeap.extractMax();
//         test[1] = maxHeap.extractMax();
//         test[2] = maxHeap.extractMax();
//         test[3] = maxHeap.extractMax();
//         test[4] = maxHeap.extractMax();
//         assertTrue(checkIfReverseSorted(test));
//         assertTrue(maxHeap.isEmpty()); // maxHeap should be empty
//    }

//    /**
//     * test for inserting element in descending order
//     * @throws HeapException
//     */
//    @Test
//    void testAddDescendingOrder() throws HeapException{
//         maxHeap = new MaxHeap<>();

//         // test element
//         TestObject element1 = new TestObject("element1", 1);
//         TestObject element2 = new TestObject("element2", 2);
//         TestObject element3 = new TestObject("element3", 3);
//         TestObject element4 = new TestObject("element4", 4);
//         TestObject element5 = new TestObject("element5", 5);

//         // add test element into maxHeap
//         maxHeap.insert(element5);
//         maxHeap.insert(element4);
//         maxHeap.insert(element3);
//         maxHeap.insert(element2);
//         maxHeap.insert(element1);

//         assertTrue(checkIfMaxHeap(maxHeap));

//         TestObject test[] = new TestObject[5];
//         test[0] = maxHeap.extractMax();
//         test[1] = maxHeap.extractMax();
//         test[2] = maxHeap.extractMax();
//         test[3] = maxHeap.extractMax();
//         test[4] = maxHeap.extractMax();
//         assertTrue(checkIfReverseSorted(test));
//         assertTrue(maxHeap.isEmpty()); // maxHeap should be empty
//    }

//    /**
//     * test for inserting element in random order
//     * @throws HeapException
//     */
//    @Test
//    void testAddRandomOrder() throws HeapException{
//         maxHeap = new MaxHeap<>();

//         // test element
//         TestObject element1 = new TestObject("element1", 1);
//         TestObject element2 = new TestObject("element2", 2);
//         TestObject element3 = new TestObject("element3", 3);
//         TestObject element4 = new TestObject("element4", 4);
//         TestObject element5 = new TestObject("element5", 5);
//         TestObject element6 = new TestObject("element6",6);
//         TestObject element7 = new TestObject("element7",7);
//         TestObject element8 = new TestObject("element8", 8);
//         TestObject element9 = new TestObject("element9", 9);
//         TestObject element10 = new TestObject("element10", 10);


//         TestObject selectedElement[] = {element1, element2, element3, element4, element5, element6, 
//             element7, element8, element9, element10};

//         Random random = new Random();

//         for(int i = 0; i < 10; i++){
//             int index = random.nextInt() % 10;
//             index = index < 0 ? -index : index;
//             maxHeap.insert(selectedElement[index]);
//         }

//         assertTrue(checkIfMaxHeap(maxHeap));


//         TestObject result[] = new TestObject[10];

//         for(int i = 0; i < 10; i++){
//             result[i] = maxHeap.extractMax();
//         }


//         assertTrue(checkIfReverseSorted(result));
//         assertTrue(maxHeap.isEmpty());
        


        
//    }

//    /**
//     * test for adding element
//  * @throws HeapException 
//    */
//    @Test
//    void testAddFirstObject_Remove() throws HeapException{

//        maxHeap = new MaxHeap<>();

//        maxHeap.insert(new TestObject("firstElement", 0));
//        TestObject object = maxHeap.extractMax();

//        assertEquals(object.getContent(), "firstElement");
//        assertEquals(object.getPriority(), 0);

//        assertThrows(HeapException.class, () -> {maxHeap.max();}, "heap underflow");

//        assertThrows(HeapException.class, () -> {maxHeap.extractMax();}, "heap underflow");

//        assertDoesNotThrow(() -> {maxHeap.insert(new TestObject("insertElement1", 3));});
//        assertDoesNotThrow(() -> {maxHeap.extractMax();});

//        assertThrows(HeapException.class, () -> {maxHeap.increaseKey(new TestObject("searchElement", 3), new TestObject("searchElement", 5));}, "object element is not found in the heap");

//        assertTrue(maxHeap.isEmpty());

//    }



//    boolean checkIfMaxHeap(MaxHeap<?> maxHeap){

//     ArrayList<?> array = maxHeap.getHeap();
//     TestObject list[] = new TestObject[array.size()];
//     for(int i = 0; i < array.size(); i++){
//         list[i] = (TestObject)array.get(i);
//     }

//     for(int i = list.length / 2 - 1; i >= 0; i--){
//         int left = left(i);
//         int right = right(i);
//         //check on right side
//         if(right < list.length){
//             if(list[i].compareTo(list[right]) < 0){
//                 return false;
//             }
//         }
//         //check on left side
//         if(list[i].compareTo(list[left]) < 0){
//             return false;
//         }
//     }

//     return true;
//    }

//    private boolean checkIfReverseSorted(TestObject array[]){
//         for(int i = 0; i < array.length - 1; i++){
//             if(array[i].compareTo(array[i+1]) < 0){
//                 return false;
//             }
//         }
//         return true;
//    }

//    private int left(int i){
//         return i * 2 + 1;
//     }

//     private int right(int i){
//         return 2*i + 2;
//     }

//     private int parent(int i){
//         int result = (i - 1) / 2;
//         result = result < 0 ? 0 : result;
//         return result;
//     }


}
