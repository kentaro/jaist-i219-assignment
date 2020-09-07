public class TestExpParseTree {
    public static void main(String[] args) {
        ExpParseTree three = new NumParseTree(3);
        ExpParseTree four = new NumParseTree(4);
        ExpParseTree five = new NumParseTree(5);
        ExpParseTree exp1 = new AddParseTree(three,four);
        ExpParseTree exp2 = new AddParseTree(exp1,five);
        System.out.println("3: " + three.calculate());
        System.out.println("3+4: " + exp1.calculate());
        System.out.println("(3+4)+5: " + exp2.calculate());
    }
}