public class LoggerConsole implements Logger {
    @Override
    public void log(Level level) {
        String color = switch (level) {
            case DEBUG -> "\u001B[32m";
            case WARNING -> "\u001B[33m";
            case ERROR -> "\u001B[31m";
        };
        System.out.println(color + level + "\u001B[0m");
    }
}