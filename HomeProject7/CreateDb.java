import java.util.*;
import java.io.*;

public class CreateDb {
    private String way_file; // путь к файлу
    private String[] db_creator = new String[11];
    public int i = 0;

    CreateDb(String way_file) {
        this.way_file = way_file;
    }

    // метод проверяет ниличие файла и создаёт его в случае отсутствия
    public void createDb () {
        File base = new File(way_file);
        if (base.exists() == false) {

        System.out.println("Файл базы данных отсутствует!\nСоздаю файл....");

        try(FileWriter fileWriter = new FileWriter(way_file, true))
        {
            db_creator[0] = "Иван Петров:18000\n";
            db_creator[1] = "Сергей Николаев:186000\n";
            db_creator[2] = "Михаил Николаев:29300\n";
            db_creator[3] = "Татьяна Николаева:52300\n";
            db_creator[4] = "Ирина Никоненко:38150\n";
            db_creator[5] = "Алексей Дмитриев:12900\n";
            db_creator[6] = "Иван Соболев:62100\n";
            db_creator[7] = "Михаил Дурманов:39000\n";
            db_creator[8] = "Наталья Беляева:120900\n";
            db_creator[9] = "Денис Алексеев:72100";

            for (int i = 0; i < 10; i++) {
                fileWriter.write(db_creator[i]);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        }
    }

    // Метод возвращает размер массива для базы данных
    // Разобраться с длинной массива
    public int lenghtDb() {
        try {
            File base = new File(way_file);
            FileReader fileReader = new FileReader(base);
            BufferedReader reader = new BufferedReader(fileReader);
            String file = reader.readLine();
            while (file != null) {
                file = reader.readLine();
                i++;
            } } catch (IOException exc) {

                System.out.println(exc.getMessage());
            }

        return i;
        }


    // Метод возвращает массив строк из файла

    public String[] readDb(int i) {
        String[] db_reader = new String[i];

        try {
            File base = new File(way_file);
            FileReader fileReader = new FileReader(base);
            BufferedReader reader = new BufferedReader(fileReader);

            for (int s = 0; s < i; s++) {
                db_reader[s] = reader.readLine();

            }
        } catch(IOException exc){

                System.out.println(exc.getMessage());
            }
            return db_reader;

        }
    }
