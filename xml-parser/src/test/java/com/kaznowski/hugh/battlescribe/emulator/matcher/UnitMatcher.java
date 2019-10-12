package com.kaznowski.hugh.battlescribe.emulator.matcher;

import com.kaznowski.hugh.battlescribe.emulator.game.Unit;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class UnitMatcher {
  public static TypeSafeMatcher<Unit> unitWithName( Matcher<String> nameMatcher ) {
    return new TypeSafeMatcher<Unit>() {
      @Override
      protected boolean matchesSafely( Unit unit ) {
        return nameMatcher.matches( unit.getName() );
      }

      @Override
      public void describeTo( Description description ) {
        nameMatcher.describeTo( description );
      }
    };
  }
}
