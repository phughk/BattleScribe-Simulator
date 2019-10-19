package com.kaznowski.hugh.battlescribe.warhammer40k;

import java.util.Arrays;

/**
 * Profiles in the Warhammer 40k datasets have these types
 */
public enum W40kProfileType {
  UNIT_WOUNDS_BASED( "5f4f-ea74-0630-4afe" ),
  WEAPON( "d5f97c0b-9fc9-478d-aa34-a7c414d3ea48" ),
  UNIT( "800f-21d0-4387-c943" ),
  ABILITY( "72c5eafc-75bf-4ed9-b425-78009f1efe82" ),
  TRANSPORT( "b3a8-0452-7436-44d1" ),
  PSYKER( "bc97-dea9-9e88-bb7d" ),
  PSYCHIC_POWER( "ae70-4738-0161-bec0" );

  private final String typeId;

  W40kProfileType( String typeId ) {
    this.typeId = typeId;
  }

  public static W40kProfileType getById( String typeId ) {
    return Arrays.stream( values() )
                 .filter( type -> type.typeId.equals( typeId.toLowerCase() ) )
                 .findFirst()
                 .orElseThrow( () -> new IllegalArgumentException( "Unknown typeId " + typeId ) );
  }
}
