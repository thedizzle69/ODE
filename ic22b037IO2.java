import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ic22b037IO2 {
    public static void main(String[] args) {
        try {
            File file = new File("pic.jpeg");

            // Create a logfile
            FileOutputStream logFile = new FileOutputStream("log.txt");
            PrintStream logStream = new PrintStream(logFile);

            // Redirect System.out and System.err to the logfile
            System.setOut(logStream);
            System.setErr(logStream);

            // Rest of your code remains unchanged
            if (file.exists()) {
                System.out.println("Datei existiert: " + file.exists());
                System.out.println("Ist ein Verzeichnis: " + file.isDirectory());
                System.out.println("Pfad: " + file.getPath());
                System.out.println("Absoluter Pfad: " + file.getAbsolutePath());
                System.out.println("Dateiname: " + file.getName());
                System.out.println("Länge der Datei: " + file.length() + " Bytes");
                System.out.println("Kann gelesen werden: " + file.canRead());
                System.out.println("Kann geschrieben werden: " + file.canWrite());
                System.out.println("Zuletzt geändert: " + file.lastModified());

                // Message in der Datei suchen
                findHiddenMessage(file);
            } else {
                System.out.println("Die Datei existiert nicht.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findHiddenMessage(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputStream.read(buffer);
        inputStream.close();

        boolean messageFound = false;

        for (int i = 0; i < buffer.length - 1; i++) {
            if (buffer[i] == '#' && buffer[i + 1] == '#') {
                int messageStartIndex = i + 2;
                while (messageStartIndex < buffer.length && buffer[messageStartIndex] != '\0') {
                    System.out.print((char) buffer[messageStartIndex]);
                    messageStartIndex++;
                }
                messageFound = true;
                break;
            }
        }

        if (!messageFound) {
            System.out.println("Versteckte Nachricht nicht gefunden.");
        }
    }
}
