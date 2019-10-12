package emulator.fasterxml;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  private String type;
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
}
