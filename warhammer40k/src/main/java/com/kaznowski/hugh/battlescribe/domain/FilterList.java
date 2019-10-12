package com.kaznowski.hugh.battlescribe.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterList<E> {
  final List<E> list;

  public FilterList( List<E> list ) {
    Objects.requireNonNull( list );
    this.list = list;
  }

  public E get( Predicate<E> filter ) {
    List<E> many = getMany( filter );
    if ( many.size() != 1 ) {
      throw new NoMatchException( many );
    }
    return many.get( 0 );
  }

  public List<E> getMany( Predicate<E> filter ) {
    return list.stream()
               .filter( filter )
               .collect( Collectors.toList() );
  }

  public E getOnly() {
    return get( a -> true );
  }

  static class NoMatchException extends RuntimeException {
    NoMatchException( List items ) {
      super( "Not exactly one item " + items );
    }

  }
}
