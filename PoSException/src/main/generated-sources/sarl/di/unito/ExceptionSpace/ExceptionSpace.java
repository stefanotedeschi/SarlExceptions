package di.unito.ExceptionSpace;

import io.sarl.core.Failure;
import io.sarl.core.OpenEventSpace;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.EventListener;
import java.util.UUID;

@SarlSpecification("0.12")
@SarlElementType(11)
@SuppressWarnings("all")
public interface ExceptionSpace extends OpenEventSpace {
  void printMessage(final String msg);
  
  void throwException(final Failure f, final UUID u);
  
  void registerAsThrower(final Class<? extends Event> ev, final Class<? extends Failure> ex, final EventListener listener);
  
  void registerAsHandler(final Class<? extends Failure> ex, final EventListener listener);
}
