package it.unito.di.spaces;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.SpaceID;
import io.sarl.lang.core.SpaceSpecification;
import it.unito.di.spaces.MySpace;
import it.unito.di.spaces.MySpaceImpl;
import jdk.internal.HotSpotIntrinsicCandidate;

@SarlSpecification("0.12")
@SarlElementType(10)
@SuppressWarnings("all")
public class MySpaceSpecification implements SpaceSpecification<MySpace> {
  public MySpace create(final SpaceID id, final Object... params) {
    return new MySpaceImpl(id);
  }
  
  @SyntheticMember
  @HotSpotIntrinsicCandidate
  public MySpaceSpecification() {
    super();
  }
}
