package it.unito.di.spaces;

import com.google.common.base.Objects;
import io.sarl.core.Failure;
import io.sarl.core.ParticipantJoined;
import io.sarl.core.ParticipantLeft;
import io.sarl.lang.annotation.FiredEvent;
import io.sarl.lang.annotation.Injectable;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.EventListener;
import io.sarl.lang.core.Scope;
import io.sarl.lang.core.SpaceID;
import io.sarl.lang.util.SerializableProxy;
import io.sarl.sre.services.logging.LoggingService;
import io.sarl.sre.spaces.OpenLocalEventSpace;
import io.sarl.sre.spaces.Participant;
import io.sarl.sre.spaces.SpaceParticipantListener;
import it.unito.di.events.MyException;
import it.unito.di.spaces.ExceptionSpace;
import java.io.ObjectStreamException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.12")
@SarlElementType(10)
@Injectable
@SuppressWarnings("all")
public class ExceptionSpaceImpl extends OpenLocalEventSpace implements ExceptionSpace {
  private HashMap<Class<? extends Failure>, UUID> handlers = new HashMap<Class<? extends Failure>, UUID>();
  
  private HashMap<Class<? extends Failure>, UUID> throwers = new HashMap<Class<? extends Failure>, UUID>();
  
  public void printMessage(final String msg) {
    System.out.println((("****" + msg) + "****"));
  }
  
  public void throwException(final MyException e, final UUID u) {
    Exception ex = e.e;
    synchronized (this.handlers) {
      synchronized (this.throwers) {
        boolean _containsKey = this.handlers.containsKey(e.getClass());
        if (_containsKey) {
          UUID handler = this.handlers.get(e.getClass());
          class $SerializableClosureProxy implements Scope<Address> {
            
            private final UUID handler;
            
            public $SerializableClosureProxy(final UUID handler) {
              this.handler = handler;
            }
            
            @Override
            public boolean matches(final Address it) {
              UUID _iD = it.getID();
              return Objects.equal(_iD, handler);
            }
          }
          final Scope<Address> _function = new Scope<Address>() {
            @Override
            public boolean matches(final Address it) {
              UUID _iD = it.getID();
              return Objects.equal(_iD, handler);
            }
            private Object writeReplace() throws ObjectStreamException {
              return new SerializableProxy($SerializableClosureProxy.class, handler);
            }
          };
          this.emit(u, e, _function);
        }
      }
    }
  }
  
  public boolean registerHandler(final Class<? extends Failure> e, final EventListener listener) {
    synchronized (this.handlers) {
      boolean _containsKey = this.handlers.containsKey(e);
      if ((!_containsKey)) {
        this.handlers.put(e, listener.getID());
        System.out.println(this.handlers);
        return true;
      }
    }
    return false;
  }
  
  public boolean registerThrower(final Class<? extends Failure> e, final EventListener listener) {
    synchronized (this.throwers) {
      boolean _containsKey = this.throwers.containsKey(e.getClass());
      if ((!_containsKey)) {
        this.throwers.put(e, listener.getID());
        return true;
      }
    }
    return false;
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
  
  @FiredEvent(ParticipantJoined.class)
  public Address registerWeakParticipant(final EventListener arg0) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @FiredEvent(ParticipantLeft.class)
  public Address unregister(final EventListener arg0) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public Address getAddress(final UUID id) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean registerStrongParticipant(final Exception ex, final EventListener el) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
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
  
  @SyntheticMember
  public ExceptionSpaceImpl(final SpaceID spaceId, final SpaceParticipantListener participantListener, final LoggingService logger) {
    super(spaceId, participantListener, logger);
  }
  
  @SyntheticMember
  public ExceptionSpaceImpl(final SpaceID spaceId, final SpaceParticipantListener participantListener, final LoggingService loggingService, final ConcurrentMap<UUID, Participant> strongRepository, final ConcurrentMap<UUID, Participant> weakRepository) {
    super(spaceId, participantListener, loggingService, strongRepository, weakRepository);
  }
}
