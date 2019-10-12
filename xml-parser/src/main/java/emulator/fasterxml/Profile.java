package emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class Profile {
  private String id;
  private String name;
  private String publicationId;
  private String page;
  private Boolean hidden;
  private String typeId;
  private String typeName;
  private List<Characteristic> characteristics;
  private List<Modifier> modifiers;
}
