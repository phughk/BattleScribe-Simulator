package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static com.kaznowski.hugh.battlescribe.emulator.fixture.RealDatasetFixture.tyranidDataset;

public class CatalogueIT {
  @Test
  void loadsTyranids() throws IOException {
    XmlMapper xmlMapper = new XmlMapper();
    Catalogue catalogue = xmlMapper.readValue( new FileReader( tyranidDataset() ), Catalogue.class );
  }
}
