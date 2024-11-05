import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HypotheticalSyllogism implements InferenceRule {
    private final Expression inferringResult = new Expression();
    public String getName(){
        return "Hypothetical Syllogism";
    }

    private boolean check(Expression exp, Matcher matcher){
        Pattern checker = Pattern.compile(matcher.group(2).trim()+">(.*)");
        Matcher checkerMatcher = checker.matcher(exp.getRepresentation());

        if(checkerMatcher.matches()){
            try {
                inferringResult.setRepresentation(matcher.group(1).trim() + " > " + checkerMatcher.group(1).trim());
            }
            catch (Exception e){
                System.out.println("Wrong Expression : " + e.getMessage());
                System.exit(0);
            }
            return true;
        }

        checker = Pattern.compile("(.*)>" + matcher.group(1).trim());
        checkerMatcher = checker.matcher(exp.getRepresentation());

        if(checkerMatcher.matches()){
            try {
                inferringResult.setRepresentation(checkerMatcher.group(1).trim() + " > " + matcher.group(2).trim());
            }
            catch (Exception e){
                System.out.println("Wrong Expression : " + e.getMessage());
                System.exit(0);
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean matches(Expression exp1, Expression exp2) {
        try {
            exp1.setRepresentation(exp1.getRepresentation().replaceAll(" ", ""));
            exp2.setRepresentation(exp2.getRepresentation().replaceAll(" ", ""));
        }
        catch (Exception e){
            System.out.println("Wrong Expression : " + e.getMessage());
            System.exit(0);
        }

        Pattern pattern = Pattern.compile("(.*)>(.*)");

        Matcher matcher = pattern.matcher(exp1.getRepresentation());
        if (matcher.matches()) {
            return check(exp2, matcher);
        }

        return false;
    }

    @Override
    public Expression apply(Expression exp1, Expression exp2) {
        return  inferringResult;
    }
}