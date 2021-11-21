package di.unito.Exceptions;

import io.sarl.core.Failure;
import io.sarl.lang.annotation.DefaultValue;
import io.sarl.lang.annotation.DefaultValueSource;
import io.sarl.lang.annotation.DefaultValueUse;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SarlSpecification("0.12")
@SarlElementType(15)
@SuppressWarnings("all")
public class TestException extends Failure {
  public Exception e;
  
  @SyntheticMember
  @DefaultValueUse(value = "io.sarl.lang.core.Address,java.lang.Object")
  public TestException(final Object cause) {
    super(cause);
  }
  
  @SyntheticMember
  @DefaultValueSource
  public TestException(@DefaultValue(value = "io.sarl.core.Failure#NEW_0") final Address source, final Object cause) {
    super(source, cause);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
  
  /**
   * Returns a String representation of the TestException event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected void toString(final ToStringBuilder builder) {
    super.toString(builder);
    builder.add("e", this.e);
  }
  
  @SyntheticMember
  private static final long serialVersionUID = -5362598L;
}
