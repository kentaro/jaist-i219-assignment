public class TestExpParseTree {
    public static void main(String[] args)
        throws CalculatorException
    {
        ExpParseTree zero = new NumParseTree(0);
        ExpParseTree three = new NumParseTree(3);
        ExpParseTree four = new NumParseTree(4);
        ExpParseTree five = new NumParseTree(5);
        ExpParseTree e1 = new AddParseTree(three,four);
        ExpParseTree e2 = new AddParseTree(four,five);
        ExpParseTree e3 = new AddParseTree(e1,five);
        ExpParseTree e4 = new AddParseTree(three,e2);
        ExpParseTree e5 = new MulParseTree(e1,five);
        ExpParseTree e6 = new MulParseTree(four,five);
        ExpParseTree e7 = new MulParseTree(three,e5);
        ExpParseTree e8 = new QuoParseTree(e6,e1);
        ExpParseTree e9 = new QuoParseTree(e6,zero);
        System.out.println(zero.calculate());
        System.out.println(three.calculate());
        System.out.println(four.calculate());
        System.out.println(five.calculate());
        System.out.println(e1.calculate());
        System.out.println(e2.calculate());
        System.out.println(e3.calculate());
        System.out.println(e4.calculate());
        System.out.println(e5.calculate());
        System.out.println(e6.calculate());
        System.out.println(e7.calculate());
        System.out.println(e8.calculate());
        //
        System.out.println(e9.calculate());
        // an exception occurs because of "division by zero"
        // so, the program terminates here, and the control
        // does not move to the next.
        System.out.println(e8.calculate());
    }
}