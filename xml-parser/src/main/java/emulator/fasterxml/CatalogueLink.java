package emulator.fasterxml;

import lombok.Data;

@Data
public class CatalogueLink {
  private String id;
  private String name;
  private String targetId;
  private String type;
  private String importRootEntries;
}
