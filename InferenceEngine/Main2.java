public class Main2 {
    public static void main(String[] args) {
        InferenceEngine Engine = new InferenceEngine();
        Engine.addRule(new InferenceRule("Modus ponens", new Expression("P>Q"),new Expression("P"),new Expression("Q")));
        Engine.addRule(new InferenceRule("Modus tollens", new Expression("P>Q"),new Expression("~Q"),new Expression("~P")));
        Engine.addRule(new InferenceRule("Hypothetical syllogism", new Expression("P>Q"),new Expression("Q>R"),new Expression("P>R")));
        Engine.addRule(new InferenceRule("Disjunctive syllogism", new Expression("PvQ"),new Expression("~P"),new Expression("Q")));
        Engine.addRule(new InferenceRule("Resolution", new Expression("PvQ"),new Expression("~PvR"),new Expression("QvR")));
    }
}
