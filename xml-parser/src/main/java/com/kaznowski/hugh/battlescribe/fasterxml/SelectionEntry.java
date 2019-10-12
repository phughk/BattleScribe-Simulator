package com.kaznowski.hugh.battlescribe.fasterxml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class SelectionEntry {
  private String id;
  private String name;
  private Boolean hidden;
  private Boolean collective;
  @JsonProperty( "import" )
  private Boolean _import;
  private Type type;
  private String page; // TODO int?
  private String publicationId;
  private List<Constraint> constraints;
  private List<Modifier> modifiers;
  private List<Profile> profiles;
  private List<InfoLink> infoLinks;
  private List<CategoryLink> categoryLinks;
  private List<SelectionEntry> selectionEntries;
  private List<EntryLink> entryLinks;
  private List<Cost> costs;
  private List<SelectionEntryGroup> selectionEntryGroups;
  private List<Rule> rules;

  public void setId( String id ) {
    IdTracker.INSTANCE.register( id );
    this.id = id;
  }

  public void setName( String name ) {
    IdTracker.INSTANCE.register( name );
    this.name = name;
  }

  public void setType( String type ) {
    IdTracker.INSTANCE.register( type );
    this.type = Type.valueOf( type );
  }

  public void setPublicationId( String publicationId ) {
    IdTracker.INSTANCE.register( publicationId );
    this.publicationId = publicationId;
  }

  public enum Type {
    unit,
    upgrade,
    model
  }
}
