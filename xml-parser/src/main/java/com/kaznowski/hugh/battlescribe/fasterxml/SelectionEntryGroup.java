package com.kaznowski.hugh.battlescribe.fasterxml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class SelectionEntryGroup {
  private String id;
  private String name;
  private Boolean hidden;
  private Boolean collective;
  @JsonProperty( "import" )
  private Boolean _import;
  private String publicationId;
  private String page;
  private List<SelectionEntry> selectionEntries;
  private List<EntryLink> entryLinks;
  private List<Constraint> constraints;
  private List<ModifierGroup> modifierGroups;
  private List<Modifier> modifiers;
  private String defaultSelectionEntryId;
  private List<SelectionEntryGroup> selectionEntryGroups;
  private List<CategoryLink> categoryLinks;

  public void setId( String id ) {
    IdTracker.INSTANCE.register( id );
    this.id = id;
  }

  public void setName( String name ) {
    IdTracker.INSTANCE.register( name );
    this.name = name;
  }

  public void setPublicationId( String publicationId ) {
    IdTracker.INSTANCE.register( publicationId );
    this.publicationId = publicationId;
  }
}
