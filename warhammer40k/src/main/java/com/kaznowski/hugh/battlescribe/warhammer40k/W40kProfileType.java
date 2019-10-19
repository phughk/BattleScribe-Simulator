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
  PSYCHIC_POWER( "ae70-4738-0161-bec0" ),
  KEYWORD("b900-0afb-e411-2cbb"),
  MUTATED_BEYOND_REASON_1("ab9e-0e23-5699-9d71"),
  MUTATED_BEYOND_REASON_2("0df0-4184-4497-92fd"),
  MUTATED_BEYOND_REASON_3("6c48-3f8e-adc6-e417"),
  EXPLOSION("0891-2df5-19c2-de63"),
  WOUND_TRACK_DUNE_CRAWLER("38d6-4910-d80d-b31d"),
  STAT_DMG_M_BS_A("e6d5-85c5-7b01-a3c4"),
  VOID_SHIELD_WOUND_TRACK("8760-b4e3-100c-cd59")
  ;

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
