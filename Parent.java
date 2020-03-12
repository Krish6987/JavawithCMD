import java.io.*;

class Parent {
    void execute() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
        String name = "srinivas";
        processBuilder.command("cmd.exe", "/c", "md " + name + "&& dir");
        // Linux
        // processBuilder.command("bash", "-c", "mkdir srinivas");
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}