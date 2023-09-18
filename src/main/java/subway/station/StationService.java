package subway.station;

import java.util.Optional;

public final class StationService {

  private final StationRepository stationRepository;

  public StationService(final StationRepository stationRepository) {
    this.stationRepository = stationRepository;
  }

  // 1. 지하철 역 등록
  public void addStation(final String stationName) {
    final Optional<Station> station = stationRepository.findByName(stationName);
    if (station.isPresent()) {
      throw new IllegalArgumentException("이미 존재하는 역입니다.");
    }
    stationRepository.addStation(Station.of(stationName));
  }
}