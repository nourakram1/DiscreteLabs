import java.util.ArrayList;

public class InferenceEngine implements IInferenceEngine{
    ArrayList<InferenceRule> rules;

    @Override
    public void addRule(InferenceRule rule) {
        if(!rules.contains(rule))
            rules.add(rule);
    }

    @Override
    public void addExpression(Expression exp) {

    }

    @Override
    public Expression applyRules() {
        return null;
    }
}