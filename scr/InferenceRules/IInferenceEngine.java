package InferenceRules;

import InferenceRules.InferenceRule;
import LogicalExpressionSolver.Expression;

public interface IInferenceEngine {
    void addRule(InferenceRule rule);
    void addExpression(Expression exp);
    Expression applyRules();
}