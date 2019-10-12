package emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class ForceEntry {
  private String id;
  private String name;
  private Boolean hidden;
  private String publicationId;
  private String page;
  private List<ForceEntry> forceEntries;
  private List<CategoryLink> categoryLinks;
}
