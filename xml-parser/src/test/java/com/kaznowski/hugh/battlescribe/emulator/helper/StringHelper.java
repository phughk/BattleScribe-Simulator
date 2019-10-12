package com.kaznowski.hugh.battlescribe.emulator.helper;

public class StringHelper {
  public static String multiLine( String... lines ) {
    return String.join( "\n", lines );
  }
}
