import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import static ch.qos.logback.classic.Level.INFO
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

String PATTERN = "%d{yyyy-MM-dd HH:mm:ss.SSS} %level [%thread] %logger - %msg%n"

appender("CONSOLE", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = PATTERN
  }
}

appender("FILE", RollingFileAppender) {
  file = "queens.log"
  append = true
  encoder(PatternLayoutEncoder) {
    pattern = PATTERN
  }
  rollingPolicy(TimeBasedRollingPolicy) {
    fileNamePattern = "queens.log.%d{yyyy-MM}"
  }
}

root(INFO, ["CONSOLE", "FILE"])

