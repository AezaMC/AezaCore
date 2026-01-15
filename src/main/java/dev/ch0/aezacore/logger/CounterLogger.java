package dev.ch0.aezacore.logger;

import static dev.ch0.aezacore.logger.BaseLogger.send;

public class CounterLogger {
    private final String indentation;
    private final int max;
    private int current;

    public CounterLogger(int level, int max) {
        this.indentation = "    ".repeat(level);
        this.max = max;
        this.current = 1;
    }

    public void Step(String msg) {
        if (current > max) return;
        String formatted = String.format("%s(%d/%d) %s", indentation, current, max, msg);
        send(formatted);
        current++;
    }
}
