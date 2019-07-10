package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Syntax("RegEx")
@TypeQualifierNickname
public @interface RegEx
{
  public abstract When when();

  public static class Checker
    implements TypeQualifierValidator<RegEx>
  {
    public When forConstantValue(RegEx paramRegEx, Object paramObject)
    {
      if (!(paramObject instanceof String))
        return When.NEVER;
      try
      {
        Pattern.compile((String)paramObject);
        return When.ALWAYS;
      }
      catch (java.util.regex.PatternSyntaxException paramRegEx)
      {
      }
      return When.NEVER;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     javax.annotation.RegEx
 * JD-Core Version:    0.6.0
 */