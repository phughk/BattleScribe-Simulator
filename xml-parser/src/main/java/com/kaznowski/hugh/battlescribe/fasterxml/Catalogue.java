package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class Catalogue {
  private String id;
  private String name;
  private String revision;
  private String battleScribeVersion;
  private String authorName;
  private String authorContact;
  private String authorUrl;
  private Boolean library;
  private String gameSystemId;
  private String gameSystemRevision;
  private String xmlns;
  private List<Publication> publications;
  private List<ProfileType> profileTypes;
  private List<CategoryEntry> categoryEntries;
  private List<EntryLink> entryLinks;
  private List<SelectionEntry> sharedSelectionEntries;
  private List<SelectionEntryGroup> sharedSelectionEntryGroups;
  private List<Rule> sharedRules;
  private List<Profile> sharedProfiles;
  private List<InfoLink> infoLinks;
  private List<CatalogueLink> catalogueLinks;
  private List<Rule> rules;
  private List<SelectionEntry> selectionEntries;
  private List<InfoGroup> sharedInfoGroups;
  private List<ForceEntry> forceEntries;

  public void setId(String id) {
    IdTracker.INSTANCE.register( id );
    this.id = id;
  }

  public void setGameSystemId( String gameSystemId ) {
    IdTracker.INSTANCE.register( gameSystemId );
    this.gameSystemId = gameSystemId;
  }

  public void setName( String name ) {
    IdTracker.INSTANCE.register( name );
    this.name = name;
  }
}
