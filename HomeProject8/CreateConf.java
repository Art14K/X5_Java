import java.util.*;
import java.io.*;

public class CreateConf {
    private String[] config = new String[20];
    private String[] sub_config = new String[40];
    private int i = 0;
    private String file_read;
    private String[] temp_config = new String[2];
    private String input;
    private int temp = 0;


    public void createConfig() {
        File file = new File("config.conf");
        if (file.exists() == false) {
            System.out.println("Не удалось обнаружить конфигурационный файл!");
            System.out.println("Пытаюсь создать конфигурационный файл с параметрами по умолчанию....");
            try (FileWriter fileWriter = new FileWriter("config.conf", true)) {
                config[0] = "mode:file\n";
                config[1] = "file base name:base.txt\n";
                config[2] = "login:none\n";
                config[3] = "password:none\n";
                config[4] = "base:none\n";
                config[5] = "server:none";
                for (int i = 0; i < 6; i++) {
                    fileWriter.write(config[i]);
                }
                System.out.println("Конфигурационный файл успешно создан!");
                System.out.println("Режим работы программы: файловый");
                System.out.println("Имя базы данных: base.txt");
            } catch (IOException exc) {
                System.out.println("Не могу создать конфигурационный файл! Продолжение работы программы не возможно!");
                System.out.println(exc.getMessage());
                System.exit(0);
            }

        }
        if (file.exists() == true) {
            try (FileReader fileReader = new FileReader("config.conf")) {
                BufferedReader reader = new BufferedReader(fileReader);
                file_read = reader.readLine();
                sub_config[0] = file_read;
                i++;

                while (file_read != null) {
                    file_read = reader.readLine();
                    sub_config[i] = file_read;
                    i++;
                }

                for (int s = 0; s < 6; s++) {
                    input = sub_config[s];
                    temp_config = input.split(":");
                    config[temp] = temp_config[0];
                    temp++;
                    config[temp] = temp_config[1];
                    temp++;
                }

                if (config[0].indexOf("mode") == -1 || config[2].indexOf("file base name") == -1 || config[4].indexOf("login") == -1 || config[6].indexOf("password") == -1 || config[8].indexOf("base") == -1 || config[10].indexOf("server") == -1) {
                    System.out.println("Структура конфигурационного файла возможно нарушена!");
                }

            } catch (IOException exc) {
                System.out.println(exc.getMessage());
                System.out.println("Не удалось прочитать конфигурационный файл! Продолжение работы программы не возможно!");
                System.exit(0);
            } catch (ArrayIndexOutOfBoundsException exc) {
                System.out.println("Структура конфигкрационного файла программы нарушена!");
                System.out.println("Продолжение работы не возможно!");
                System.out.println("Если Вы хотите, что бы программа сама создала файл по умолчанию - просто удалите существующий.");
                System.out.println("Причина: " + exc.getMessage());
                System.exit(0);
            } catch (NullPointerException exc) {
                System.out.println("Структура конфигкрационного файла программы нарушена!");
                System.out.println("Продолжение работы не возможно!");
                System.out.println("Если Вы хотите, что бы программа сама создала файл по умолчанию - просто удалите существующий.");
                System.out.println("Причина: " + exc.getMessage());
                System.exit(0);
            }
        }
    }


    public String[] getConfig() {
        return config;
    }
}