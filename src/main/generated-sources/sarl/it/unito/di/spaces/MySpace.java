package it.unito.di.spaces;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.core.Space;
import it.unito.di.spaces.MyException;

@SarlSpecification("0.12")
@SarlElementType(11)
@SuppressWarnings("all")
public interface MySpace extends Space {
  void printMessage(final String msg);
  
  void throwException(final MyException e);
}
