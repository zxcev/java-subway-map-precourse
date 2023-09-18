package subway.line;

import java.util.Optional;
import subway.station.Station;
import subway.station.StationRepository;

public final class LineService {

  private final LineRepository lineRepository;
  private final StationRepository stationRepository;

  public LineService(
      final LineRepository lineRepository,
      final StationRepository stationRepository
  ) {
    this.lineRepository = lineRepository;
    this.stationRepository = stationRepository;
  }

  // 1. 지하철 노선 등록
  public void addLine(
      final String lineName,
      final String firstStationName,
      final String lastStationName
  ) {
    final Optional<Line> foundLine = lineRepository.findByLineName(lineName);
    if (foundLine.isPresent()) {
      throw new IllegalArgumentException("중복된 노선명입니다");
    }

    final Line line = createLine(lineName, firstStationName, lastStationName);
    lineRepository.addLine(line);
  }

  // 지하철 노선 생성
  private Line createLine(
      final String lineName,
      final String firstStationName,
      final String lastStationName
  ) {
    final Optional<Station> firstStation = stationRepository.findByName(firstStationName);
    final Optional<Station> lastStation = stationRepository.findByName(lastStationName);

    if (firstStation.isEmpty() || lastStation.isEmpty()) {
      throw new IllegalArgumentException("유효하지 않은 상행 or 하행역명입니다.");
    }
    return Line.of(lineName, firstStation.get(), lastStation.get());
  }


}