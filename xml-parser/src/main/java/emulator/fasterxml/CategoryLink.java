package emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class CategoryLink {
  private String id;
  private String name;
  private Boolean hidden;
  private String targetId;
  private Boolean primary;
  private String publicationId;
  private List<Constraint> constraints;
  private List<Modifier> modifiers;
}
