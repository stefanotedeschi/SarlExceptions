package di.unito.ExceptionSpace;

import io.sarl.core.Failure;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import java.util.Objects;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Stefano
 */
@SarlSpecification("0.12")
@SarlElementType(10)
@SuppressWarnings("all")
public class ExceptionSpecification implements Comparable {
  private Class<? extends Event> ev;
  
  private Class<? extends Failure> failure;
  
  private UUID ag;
  
  public ExceptionSpecification(final Class<? extends Event> ev, final Class<? extends Failure> failure, final UUID ag) {
    this.ev = ev;
    this.failure = failure;
    this.ag = ag;
  }
  
  public int compareTo(final Object o) {
    return 1;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ExceptionSpecification other = (ExceptionSpecification) obj;
    if (!Objects.equals(this.ag, other.ag))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.ag);
    return result;
  }
}
