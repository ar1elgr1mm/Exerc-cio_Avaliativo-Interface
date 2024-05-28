import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EscreverArquivo {

    public static void main(String[] args) {
        String filename = "log.txt";
        String mensagem = "Mensagem incluída ao final do log\n";
        try {
            if (!Files.exists(Paths.get(filename))) {
                throw new IOException("O arquivo " + filename + " não existe.");
            }
            Files.write(Paths.get(filename), mensagem.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo do log");
            e.printStackTrace();
        }
    }
}