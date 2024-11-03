import java.util.ArrayList;

public class InferenceEngine implements IInferenceEngine {
    ArrayList<InferenceRule> rules;
    Expression expression1;
    Expression expression2;

    @Override
    public void addRule(InferenceRule rule) {
        if (!rules.contains(rule))
            rules.add(rule);
    }

    @Override
    public void addExpression(Expression exp) {
        if (expression1 == null) {
            expression1 = exp;
            return;
        }
        if (expression2 == null) {
            expression2 = exp;
            return;
        }
        expression1 = expression2 = null;
        addExpression(exp);
    }

    @Override
    public Expression applyRules() {
        if(expression1 == null || expression2 == null) return null;

        for (InferenceRule rule : rules) {
            if (rule.matches(expression1, expression2)) {
                System.out.print("By " + rule.getName() + " : " );
                return rule.apply(expression1, expression2);
            }
        }
        return null;
    }
}
