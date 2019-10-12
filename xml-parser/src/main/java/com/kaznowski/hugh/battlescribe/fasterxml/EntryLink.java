package com.kaznowski.hugh.battlescribe.fasterxml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class EntryLink {
  private String id;
  private String name;
  private Boolean hidden;
  private Boolean collective;
  @JsonProperty( "import" )
  private Boolean _import;
  private String targetId;
  private Type type;
  private String publicationId;
  private String page;
  private List<CategoryLink> categoryLinks;
  private List<Constraint> constraints;
  private List<ModifierGroup> modifierGroups;
  private List<Modifier> modifiers;
  private List<EntryLink> entryLinks;
  private List<Profile> profiles;
  private List<InfoLink> infoLinks;
  private List<Cost> costs;

  public void setId( String id ) {
    IdTracker.INSTANCE.register( id );
    this.id = id;
  }

  public void setName( String name ) {
    IdTracker.INSTANCE.register( name );
    this.name = name;
  }

  public void setTargetId( String targetId ) {
    IdTracker.INSTANCE.register( targetId );
    this.targetId = targetId;
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
    selectionEntryGroup,
    selectionEntry
  }
}
