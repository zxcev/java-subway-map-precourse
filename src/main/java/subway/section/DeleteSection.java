package subway.section;

public final class DeleteSection {

  private final String lineName;
  private final String stationName;

  public DeleteSection(
      final String lineName,
      final String stationName
  ) {
    this.lineName = lineName;
    this.stationName = stationName;
  }

  public String getLineName() {
    return lineName;
  }

  public String getStationName() {
    return stationName;
  }
}
