/**
 * 栗林健太郎
 * 2030006
 * 2020年10月27日
 */

public class UmiParseTree
    implements ExpParseTree
{
    private ExpParseTree ept;

    public UmiParseTree(ExpParseTree e) {
        ept = e;
    }

    public int calculate()
        throws CalculatorException
    {
        int n = ept.calculate();
        return -n;
    }

    public String toString() {
        return "umi(" + ept + ")";
    }
}
