public class test {

    public static void main(String[] args) {
        byte mem1 = Processor.phaseHexChartoBinary('F');
        byte mem2 = Processor.phaseHexChartoBinary('A');


        Processor processor = new Processor("ABCDE\n1234");


        
        processor.executeInstructions();


        
        System.out.println((byte)((mem2 << 4) + mem1));
    }
}
