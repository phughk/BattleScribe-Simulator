package com.kaznowski.hugh.battlescribe;

import java.util.HashMap;
import java.util.Map;

/**
 * This registry takes care of tracking data as it is being deserialised
 */
public class UniversalRegistry {
  private final Map<String,Object> registryOfReferences = new HashMap<>();

  public void register( String id, Object object ) {
    registryOfReferences.put( id, object );
  }

  public Object findById( String id ) {
    return registryOfReferences.get( id );
  }
}
