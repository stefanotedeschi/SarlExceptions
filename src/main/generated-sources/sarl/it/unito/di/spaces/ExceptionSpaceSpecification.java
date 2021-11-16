package it.unito.di.spaces;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import io.sarl.core.OpenEventSpace;
import io.sarl.lang.annotation.Injectable;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.SpaceID;
import io.sarl.lang.core.SpaceSpecification;
import io.sarl.sre.KernelScope;
import io.sarl.sre.services.logging.LoggingService;
import io.sarl.sre.spaces.SpaceParticipantListener;
import io.sarl.sre.spaces.SpaceParticipantListenerFactory;
import it.unito.di.spaces.ExceptionSpace;
import it.unito.di.spaces.ExceptionSpaceImpl;
import java.util.logging.Logger;
import jdk.internal.HotSpotIntrinsicCandidate;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.12")
@SarlElementType(10)
@Injectable
@SuppressWarnings("all")
public class ExceptionSpaceSpecification implements SpaceSpecification<ExceptionSpace> {
  @Inject
  private Injector injector;
  
  @Inject
  private LoggingService loggingService;
  
  @Inject
  @KernelScope
  private SpaceParticipantListenerFactory spaceParticipantListenerFactory;
  
  @Inject
  @Named("defaultSpace")
  private OpenEventSpace defaultSpace;
  
  public ExceptionSpace create(final SpaceID id, final Object... params) {
    final Logger logger = this.loggingService.getKernelLogger();
    final SpaceParticipantListener listener = this.spaceParticipantListenerFactory.create(this.defaultSpace, logger);
    final ExceptionSpaceImpl space = new ExceptionSpaceImpl(id, listener, this.loggingService);
    listener.setDefaultSpace(space);
    this.injector.injectMembers(space);
    return space;
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
  @HotSpotIntrinsicCandidate
  public ExceptionSpaceSpecification() {
    super();
  }
}
