package it.unito.di.spaces;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.SpaceID;
import io.sarl.sre.spaces.AbstractSpace;
import it.unito.di.spaces.MyException;
import it.unito.di.spaces.MySpace;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.12")
@SarlElementType(10)
@SuppressWarnings("all")
public class MySpaceImpl extends AbstractSpace implements MySpace {
  public void printMessage(final String msg) {
    System.out.println((("****" + msg) + "****"));
  }
  
  public void forEachStrongParticipant(final Procedure1<? super UUID> callback) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void forEachWeakParticipant(final Procedure1<? super UUID> callback) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public int getNumberOfStrongParticipants() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public int getNumberOfWeakParticipants() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public boolean isPseudoEmpty(final UUID id) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void throwException(final MyException e) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @SyntheticMember
  public MySpaceImpl(final SpaceID id) {
    super(id);
  }
}
