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
  KEYWORD( "b900-0afb-e411-2cbb" ),
  MUTATED_BEYOND_REASON_1( "ab9e-0e23-5699-9d71" ),
  MUTATED_BEYOND_REASON_2( "0df0-4184-4497-92fd" ),
  MUTATED_BEYOND_REASON_3( "6c48-3f8e-adc6-e417" ),
  EXPLOSION_1( "0891-2df5-19c2-de63" ),
  EXPLOSION_2( "1c4c-8a58-c471-95e3" ),
  EXPLOSION_3( "a8d9-0b84-1b10-5a8f" ),
  EXPLOSION_4( "818c-0db1-36f0-462a" ),
  EXPLOSION_5( "30af-0cff-c525-cc81" ),
  EXPLOSION_6( "88a9-3700-776b-79d1" ),
  EXPLOSION_7( "6535-c5b9-7431-63ec" ),
  EXPLOSION_8( "bacf-b76e-8bbc-ac56" ),
  WOUND_TRACK_DUNE_CRAWLER( "38d6-4910-d80d-b31d" ),
  WOUND_TRACK_DROP_POD( "cfcb-6416-94fb-4744" ),
  WOUND_TRACK_KNIGHTS( "9005-1a1f-3971-8480" ),
  WOUND_TRACK_TITAN_1( "7ee9-2938-dd45-dff3" ),
  WOUND_TRACK_TITAN_2( "9276-4ade-22c4-5cb6" ),
  WOUND_TRACK_TITAN_3( "d663-48aa-4a14-260b" ),
  WOUND_TRACK_VAULT( "7c4c-335c-5534-07fe" ),
  WOUND_TRACK_TRANSPORT( "67c2-86d6-5956-58cb" ),
  WOUND_TRACK_SOKAR( "150a-3fd2-81c5-cb57" ),
  WOUND_TRACK_OBELISK( "4ec1-d4cb-eecc-b265" ),
  WOUND_TRACK_FLIER( "1355-1e88-8ca1-9111" ),
  WOUND_TRACK_SKORPIUS_DUNERIDER( "3f25-98ee-0925-acc8" ),
  WOUND_TRACK_SKORPIUS_DISINTEGRATOR( "b163-110e-a1ef-6d1c" ),
  WOUND_TRACK_VOID_SHIELD( "8760-b4e3-100c-cd59" ),
  WOUND_TRACK_XIPHON( "84ed-ecf3-5d8d-c067" ),
  WOUND_TRACK_MONOLITH( "4ef8-90f4-8b5a-2352" ),
  WOUND_TRACK_NAUT( "4f8f-111d-cdd9-6db0" ),
  WOUND_TRACK_PLAGUE_HULK_1( "23d7-4237-f378-5bcb" ),
  WOUND_TRACK_PLAGUE_HULK_2( "24bd-9b25-01b9-29f1" ),
  WOUND_TRACK_GS( "d58d-8c3d-54e1-9821" ),
  WOUND_TRACK_PLAGUEBURST_CRAWLER( "fbcc-57e7-dd64-9b10" ),
  WOUND_TRACK_KILL_TANK( "dc42-c17d-54f3-df0a" ),
  WOUND_TRACK_GAUSS_PYLONG( "d7eb-6b4b-fb4b-26fb" ),
  STAT_DMG_M_BS_A_1( "e6d5-85c5-7b01-a3c4" ),
  STAT_DMG_M_BS_A_2( "ec1e-7b4c-1c12-17a1" ),
  STAT_DMG_M_BS_A_3( "1d29-31cd-c362-d722" ),
  STAT_DMG_M_BS_A_4( "9b74-b72b-d6bc-194a" ),
  STAT_DMG_M_BS_A_5( "29af-65db-c2dc-cfa1" ),
  STAT_DMG_M_BS_A_6( "bc4a-228a-5761-6770" ),
  STAT_DMG_BS_S_A_1( "3045-9f1c-3327-a388" ),
  STAT_DMG_BS_S_A_2( "e396-53ae-c9e0-c11e" ),
  STAT_DMG_S_A( "ecce-8736-aed9-0d2e" ),
  STAT_DMG_M_S_A( "52c8-7349-4ac2-cef2" ),
  STAT_DMG_WS_BS_A( "2931-0d83-bea3-6634" ),
  STAT_DMG_WS_S_PO( "85fd-6b7a-8424-ccb2" ),
  STAT_DMG_WS_S_A( "f37a-cabe-fb51-984f" ),
  STAT_DMG_M_WS_A( "af93-555b-e64f-e4b1" ),
  STAT_DMG_M_WS_BS( "1d35-9cf8-74f1-32c4" ),
  STAT_DMG_M_WS_BS_2( "57ee-d739-8ae4-f2f8" ),
  STAT_DMG_M_WS_S( "9de5-d2fe-da97-6d0e" ),
  STAT_DMG_M_BS_1( "6963-0949-caac-f9af" ),
  STAT_DMG_M_BS_2( "8164-003b-2cc1-99b3" ),
  STAT_DMG_M_BS_3( "8e0b-501f-13be-6d2f" ),
  STAT_DMG_WS_BS_S( "30f5-815e-20ac-1e14" ),
  STAT_DMG_M_ADD_ATTKS( "6657-e5fe-e020-4f89" ), // TODO Space Wolves
  STAT_DMG_BS( "50ea-3b64-d9ae-0e3f" ),
  ROLL_D3( "3f2c-38d3-b6df-df27" ),
  ROLL_D3_BOON_OF_CHANGE_1( "b764-10e0-373e-7176" ),
  ROLL_D3_BOON_OF_CHANGE_2( "dd44-1ab7-0a76-130d" ), // Extra Limb?
  ROLL_D6_BOON_OF_TZEENTCH( "d059-e800-687c-6148" ),
  ROLL_D6_WARP_VORTEX( "9760-a771-d0c8-a624" ),
  TANK_ORDERS_FULL_THROTTLE( "92f7-e9c5-8a03-8cf2" ),
  TANK_ORDERS_PASK( "9d63-858c-c12d-0763" ),
  DEATH_KORPS_ORDERS( "df35-fad2-be79-e105" ),
  ASTRA_MILITARUM_ORDERS( "5c3a-03e3-c48d-726c" ),
  GENOMIC_ENHANCEMENT( "d01c-5195-e332-7b24" ),
  ENHANCED_WARRIORS_EFFECT( "ecda-13fc-b1ec-ed87" ),// TODO Chaos Space Marines bullshit
  FORGE_WORLD_DOGMA( "63a5-ad0e-43c1-d2f0" ), // TODO Adeptus Mechanicus
  TALLY( "5dca-3ffa-586b-4fde" ), // TODO Chaos Daemons
  TECTONIC_FRAGDRILL( "05e2-717b-01b5-60fa" ), // TODO Genestealer
  WARLORD_TRAIT_1( "b2ac-1cb8-8f3c-8ded" ),
  WARLORD_TRAIT_2( "7df1-74bd-09c9-492c" ),
  WARLORD_TRAIT_3( "0bb9-43c2-e91f-436e" ),
  PRAYERS( "7c26-78e8-b63d-70a2" ),
  DISTORT_FIELDS( "d0ed-4df2-0d98-e45f" ),
  GIFT_OF_CONTAGION_TABLE_1( "df7f-89aa-8f5b-9d81" ),
  GIFT_OF_CONTAGION_TABLE_2( "5927-38b7-bf4d-c376" ),
  HOUSEHOLD_TRADITION( "dfe7-9b0a-ece9-9141" ),
  MORTARION_DAMAGE_TABLE( "c295-780c-d1dd-e59f" ),
  QUALITY( "7cbd-dd14-7b99-0b84" ),
  LETHAL_AMBUSH( "7bf1-f257-0dfd-89c4" ),
  BURDEN( "6da8-0171-efd2-dd94" ),
  MECHANICAL_AUGMENTATION( "268c-f8fa-78cd-af4d" ),
  BIG_RED_BUTTON( "77e2-f55e-0f49-2781" ),
  DYNASTIC_CODE( "e31c-30b0-b621-edf7" ),
  FRACTURED_PERSONALITY( "23e3-de60-a404-5b0a" ),
  THE_YMGARL_FACTOR( "597c-6571-0e33-dcbe" ),
  POWER_OF_CTAN( "b81b-2c69-dd4a-ec88" ),
  ;

  public final String typeId;

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
