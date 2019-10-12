package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

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
}
