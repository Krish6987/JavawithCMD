import java.io.*;

class Parent {
    void execute() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
        String name = "srinivas";
//         processBuilder.command("cmd.exe", "/c", "md " + name + "&& dir");
        // Linux
        String url = "134.209.144.20";
        String password = "Krish@6987";
        processBuilder.command("bash", "-c", "sshpass -p '"+password+"' ssh-copy-id ansadmin@"+url+" -o StrictHostKeyChecking=no" );
        processBuilder.command("bash", "-c", "anisble-playbook /home/ansadmin/ansible.yml -i "+url+", -e 'target="+url+"'" );
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
