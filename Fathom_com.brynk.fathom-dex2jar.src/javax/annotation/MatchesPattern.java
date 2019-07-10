package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier(applicableTo=String.class)
public @interface MatchesPattern
{
  public abstract int flags();

  @RegEx
  public abstract String value();

  public static class Checker
    implements TypeQualifierValidator<MatchesPattern>
  {
    public When forConstantValue(MatchesPattern paramMatchesPattern, Object paramObject)
    {
      if (Pattern.compile(paramMatchesPattern.value(), paramMatchesPattern.flags()).matcher((String)paramObject).matches())
        return When.ALWAYS;
      return When.NEVER;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     javax.annotation.MatchesPattern
 * JD-Core Version:    0.6.0
 */