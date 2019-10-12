package emulator.loader;

import emulator.game.Unit;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class Dataset {
  private final Collection<Unit> units;

  Dataset() {
    units = new ArrayList<>();
  }

  public void addUnit( Unit unit ) {
    units.add( unit );
  }
}
