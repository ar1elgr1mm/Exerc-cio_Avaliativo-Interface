import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String logFileName = "log.txt";

        try {
            Files.write(Paths.get(logFileName), new byte[0]);
        } catch (IOException e) {
            System.err.println("Erro ao limpar o arquivo de log");
            e.printStackTrace();
        }

        Logger consoleLogger = LoggerFactory.onConsole();
        Logger fileLogger = LoggerFactory.onFile();

        consoleLogger.log(Level.DEBUG);
        consoleLogger.log(Level.WARNING);
        consoleLogger.log(Level.ERROR);

        fileLogger.log(Level.DEBUG);
        fileLogger.log(Level.WARNING);
        fileLogger.log(Level.ERROR);
    }
}