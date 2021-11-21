package di.unito.ExceptionSpace;

import com.google.common.base.Objects;
import di.unito.ExceptionSpace.ExceptionSpace;
import di.unito.ExceptionSpace.ExceptionSpecification;
import io.sarl.core.Failure;
import io.sarl.core.ParticipantJoined;
import io.sarl.core.ParticipantLeft;
import io.sarl.lang.annotation.FiredEvent;
import io.sarl.lang.annotation.Injectable;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.EventListener;
import io.sarl.lang.core.Scope;
import io.sarl.lang.core.SpaceID;
import io.sarl.lang.util.SerializableProxy;
import io.sarl.sre.services.logging.LoggingService;
import io.sarl.sre.spaces.OpenLocalEventSpace;
import io.sarl.sre.spaces.Participant;
import io.sarl.sre.spaces.SpaceParticipantListener;
import java.io.ObjectStreamException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.12")
@SarlElementType(10)
@Injectable
@SuppressWarnings("all")
public class ExceptionSpaceImpl extends OpenLocalEventSpace implements ExceptionSpace {
  private ConcurrentSkipListSet<ExceptionSpecification> throwers = new ConcurrentSkipListSet<ExceptionSpecification>();
  
  private ConcurrentHashMap<Class<? extends Failure>, CopyOnWriteArrayList<UUID>> handlers = new ConcurrentHashMap<Class<? extends Failure>, CopyOnWriteArrayList<UUID>>();
  
  public void printMessage(final String msg) {
    System.out.println((("****" + msg) + "****"));
  }
  
  public void registerAsThrower(final Class<? extends Event> ev, final Class<? extends Failure> e, final EventListener listener) {
    System.out.println("****REGISTER AS THROWER****");
    this.registerStrongParticipant(listener);
    UUID _iD = listener.getID();
    ExceptionSpecification exSpec = new ExceptionSpecification(ev, e, _iD);
    this.throwers.add(exSpec);
  }
  
  public void registerAsHandler(final Class<? extends Failure> e, final EventListener listener) {
    System.out.println("****REGISTER AS HANLDER****");
    this.registerStrongParticipant(listener);
    boolean _containsKey = this.handlers.containsKey(e);
    if (_containsKey) {
      CopyOnWriteArrayList<UUID> h = this.handlers.get(e);
      h.add(listener.getID());
    } else {
      CopyOnWriteArrayList<UUID> h_1 = new CopyOnWriteArrayList<UUID>();
      h_1.add(listener.getID());
      this.handlers.put(e, h_1);
    }
  }
  
  public void throwException(final Failure f, final UUID u) {
    System.out.println("****THROW****");
    if ((this.handlers.containsKey(f.getClass()) && (this.handlers.get(f.getClass()) != null))) {
      CopyOnWriteArrayList<UUID> handlers = this.handlers.get(f.getClass());
      for (final UUID handler : handlers) {
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
        this.emit(u, f, _function);
      }
    } else {
      Class<? extends Failure> _class = f.getClass();
      System.out.println(((("ExceptionSpace: none handler \n\t\t\t\t\t\t\t\tregistered for exception " + _class) + " thrown by agent ") + u));
    }
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
