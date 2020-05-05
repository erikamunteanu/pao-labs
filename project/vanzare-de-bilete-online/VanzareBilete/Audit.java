package VanzareBilete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Audit {

    private static Audit single_instance = null;

    private Audit() {
    }

    public static Audit getInstance() {
        if (single_instance == null) {
            single_instance = new Audit();
        }
        return single_instance;
    }

    public void action(String getAction) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try {
            String auditToCSV = "src/VanzareBilete/data/audit.csv";
            BufferedWriter bw = new BufferedWriter(new FileWriter(auditToCSV, true));
            bw.write(getAction + "," + timestamp + "\n");
            bw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

