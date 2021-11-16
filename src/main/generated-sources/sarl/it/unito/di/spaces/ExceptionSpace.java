package it.unito.di.spaces;

import io.sarl.core.Failure;
import io.sarl.core.OpenEventSpace;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.EventListener;
import it.unito.di.events.MyException;
import java.util.UUID;

@SarlSpecification("0.12")
@SarlElementType(11)
@SuppressWarnings("all")
public interface ExceptionSpace extends OpenEventSpace {
  void printMessage(final String msg);
  
  void throwException(final MyException e, final UUID u);
  
  boolean registerThrower(final Class<? extends Failure> ex, final EventListener el);
  
  boolean registerHandler(final Class<? extends Failure> ex, final EventListener el);
}
