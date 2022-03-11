package com.foxminded.lyudmila.formula1;


import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Formula1 {
    private static final DateTimeFormatter FORMAT_PARS_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    private static final DateTimeFormatter FORMAT_BEST_TIME = DateTimeFormatter.ofPattern("m:ss.SSS");
    private static final int COUNT_COLUM_SIZE = 3;
    private static final int TIME_COLUMN_SIZE = 10;
    private static final int TOP_RACERS = 15;

    public String formula1(final String startMomentsFile, final String finishMomentsFile,
                           final String abbreviationsFile) {
        Map<String, LocalDateTime> startTimes = parseTime(readFile(startMomentsFile));
        Map<String, LocalDateTime> finishTimes = parseTime(readFile(finishMomentsFile));
        List<Racer> racers = getRacers(abbreviationsFile, startTimes, finishTimes);
        return formResult(racers);
    }

    private BufferedReader readFile(final String fileName) {
        final InputStream file = this.getClass().getResourceAsStream(fileName);
        if (file == null) {
            throw new NullPointerException("File is null.");
        }
        return new BufferedReader(new InputStreamReader(file));
    }

    private Map<String, LocalDateTime> parseTime(final BufferedReader time) {
        return time.lines().collect(Collectors.toMap(s -> s.substring(0, 3).toUpperCase(),
            s -> LocalDateTime.parse(s.substring(3), FORMAT_PARS_TIME)));
    }

    private List<Racer> getRacers(final String abbreviationsFile, final Map<String, LocalDateTime> startTimes,
                                  final Map<String, LocalDateTime> finishTimes) {
        if (startTimes.isEmpty() || finishTimes.isEmpty()) {
            throw new IllegalArgumentException("File is empty.");
        }
        return (readFile(abbreviationsFile)).lines()
            .map(line -> line.split("_")).map(line -> new Racer(line[1], line[2],
                Duration.between(startTimes.get(line[0].toUpperCase()), finishTimes.get(line[0].toUpperCase())))).toList();
    }

    private String formResult(final List<Racer> racers) {
        final int nameColumnSize = getFieldMaxLength(racers, Racer::fullName);
        final int teamColumnSize = getFieldMaxLength(racers, Racer::team);
        final String lineFormat = "%-" + COUNT_COLUM_SIZE + "s%-" + nameColumnSize + "s|%-" + teamColumnSize + "s|%s";
        final AtomicInteger count = new AtomicInteger(0);
        final StringBuilder result = new StringBuilder();

        racers.stream().sorted(Comparator.comparing(Racer::bestTime))
            .forEach(racer -> {
                final int position = count.incrementAndGet();
                result.append(String.format(lineFormat, position + ".", racer.fullName(), racer.team(),
                    FORMAT_BEST_TIME.format(LocalTime.MIDNIGHT.plus(racer.bestTime()))));
                if (position == TOP_RACERS) {
                    result.append(System.lineSeparator());
                    result.append("-".repeat(COUNT_COLUM_SIZE + nameColumnSize + teamColumnSize + TIME_COLUMN_SIZE));
                }
                if (position < racers.size()) {
                    result.append(System.lineSeparator());
                }
            });
        return result.toString();
    }

    private int getFieldMaxLength(final List<Racer> racers, final Function<Racer, String> field) {
        if (racers.isEmpty()) {
            throw new IllegalArgumentException("File is empty.");
        }
        return racers.stream().mapToInt(racer -> field.apply(racer).length()).max().getAsInt();
    }
}
