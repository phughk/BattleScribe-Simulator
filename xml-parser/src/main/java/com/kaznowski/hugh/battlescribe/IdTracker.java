package com.kaznowski.hugh.battlescribe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.String.format;

public class IdTracker {
  public static final IdTracker INSTANCE = new IdTracker();

  private final Map<String,List<String>> data;
  private final Map<String,Set<String>> reverse;

  public IdTracker() {
    data = new HashMap<>();
    reverse = new HashMap<>();
  }

  public void save( File file ) {
    try {
      if ( file.exists() ) {
        file.delete();
      }
      BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( file ) );
      bufferedWriter.write( "ID to field mapping\n" );
      for ( String key : data.keySet() ) {
        bufferedWriter.write( format( "\t`%s`:\n", key ) );
        List<String> values = data.get( key );
        for ( String invocation : values ) {
          bufferedWriter.write( format( "\t\t%s\n", invocation ) );
        }
      }

      bufferedWriter.write( "Field to values mapping\n" );
      for ( String invocation : reverse.keySet() ) {
        bufferedWriter.write( format( "\t%s:\n", invocation ) );
        for ( String reverseValue : reverse.get( invocation ) ) {
          bufferedWriter.write( format( "\t\t%s\n", reverseValue ) );
        }
      }
      bufferedWriter.flush();
      bufferedWriter.close();
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public void register( String key ) {
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    StackTraceElement invoker = stackTrace[2];
    String identifier = format( "%s$%s", invoker.getClassName(), invoker.getMethodName() );

    data.putIfAbsent( key, new ArrayList<>() );
    data.get( key ).add( identifier );

    reverse.putIfAbsent( identifier, new HashSet<>() );
    reverse.get( identifier ).add( key );
  }

}
