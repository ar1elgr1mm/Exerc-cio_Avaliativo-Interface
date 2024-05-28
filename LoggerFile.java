import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerFile implements Logger {
    private static final String FILE_NAME = "log.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public void log(Level level) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logMessage = timestamp + " " + level + System.lineSeparator();

        try {
            java.nio.file.Files.write(Paths.get(FILE_NAME), logMessage.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo");
            e.printStackTrace();
        }
    }
}