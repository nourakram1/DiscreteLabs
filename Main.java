import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        Expression e1 = new Expression();

        e1.setRepresentation("(~P^(QvR))>S");

        System.out.println(Arrays.toString(e1.getOperands()));
        System.out.println(e1.getRepresentation());
    }
}