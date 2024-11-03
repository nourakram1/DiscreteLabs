public class InferenceRule implements IInferenceRule{
    private final String Name;
    private final Expression expression1;
    private final Expression expression2;
    private final Expression inferenceResult;

    public InferenceRule(String name, Expression expression1, Expression expression2, Expression inferenceResult) {
        this.Name = name;
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.inferenceResult = inferenceResult;
    }

    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        
        if(exp1.getOperands().length != expression1.getOperands().length)
            return false;
        if(exp2.getOperands().length != expression2.getOperands().length)
            return false;


    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        return null;
    }
}
