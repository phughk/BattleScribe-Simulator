package emulator.fasterxml;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  private String type;
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
}
