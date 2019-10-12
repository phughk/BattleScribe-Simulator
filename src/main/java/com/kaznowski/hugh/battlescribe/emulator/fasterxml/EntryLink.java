package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

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
  private List<CategoryLink> categoryLinks;
}
