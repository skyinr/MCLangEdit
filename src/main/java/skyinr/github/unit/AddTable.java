package skyinr.github.unit;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import skyinr.github.MCLangEdit;
import skyinr.github.MCLangTable;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;

public class AddTable {
    private AddTable() {
    }

    public static void addTable(JComponent component, File file) {
        if (file != null) {
            try {
                Gson gson = new Gson();
                JsonReader reader = new JsonReader(new FileReader(file));
                reader.setLenient(true);

                String[] data = new String[]{"key","old","new"};

                JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
                Object[][] table = new Object[jsonObject.size()][3];
                Object[] keys = jsonObject.keySet().toArray();
                for (int i = 0; i < jsonObject.size(); i++) {
                    table[i][0] = keys[i];
                    table[i][1] = jsonObject.get((String) keys[i]).getAsString();
                }

                MCLangEdit.jPanel.add(new JScrollPane(new MCLangTable(table, data)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
