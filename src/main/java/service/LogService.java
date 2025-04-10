package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogService {
    private static final String LOG_DIRECTORY = "logs";
    private static final String LOG_FILE = "conversion_logs.txt";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Insere os logs no arquivo conversion_logs
     * @param amount
     * @param baseCode
     * @param convertAmount
     * @param targetCode
     * @param convertionRate
     * @throws IOException
     */
    public static void logConversion(Double amount, String baseCode, Double convertAmount, String targetCode, Double convertionRate) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        createFile();

        String fullPath = LOG_DIRECTORY + File.separator + LOG_FILE;
        String log = String.format("[%s] Conversão: %.2f %s -> %.2f %s | Taxa: %.8f",
                TIMESTAMP_FORMATTER.format(now),
                amount,
                baseCode,
                convertAmount,
                targetCode,
                convertionRate
                );

        try(BufferedWriter bfw = new BufferedWriter(new FileWriter(fullPath, true))) {
            bfw.write(log);
            bfw.newLine();
            bfw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Cria um diretorio logs e um arquivo conversion_logs.txt caso não exista
     * @throws IOException
     */
    private static void createFile() throws IOException {
       File directory = new File(LOG_DIRECTORY);
       File logFile = new File(directory, LOG_FILE);

       if (!directory.exists()){
           directory.mkdirs();
       }

        if (!logFile.exists()){
            logFile.createNewFile();
        }

    }
}
