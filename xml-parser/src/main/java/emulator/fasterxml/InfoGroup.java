package emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class InfoGroup {
  private String id;
  private String name;
  private Boolean hidden;
  private List<Profile> profiles;
  private List<Modifier> modifiers;
  private List<InfoLink> infoLinks;
}
