package emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class ProfileType {
  private List<CharacteristicType> characteristicTypes;
  private String id;
  private String name;
}
