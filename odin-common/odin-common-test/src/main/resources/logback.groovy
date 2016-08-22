import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO

appender("CONSOLE", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%-4relative [%thread] - %msg%n"
  }
}

logger("org.springframework", INFO, ["CONSOLE"])
logger("org.apache", INFO, ["CONSOLE"])
logger("org.hibernate", INFO, ["CONSOLE"])
logger("org.odin", DEBUG, ["CONSOLE"])
