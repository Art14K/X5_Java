import java.util.*;
import java.io.*;

public class CreateDb {
    private String way_file; // путь к файлу
    private String[] db_creator = new String[11];

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
            db_creator[0] = "1 Иван Петров 18000\n";
            db_creator[1] = "2 Сергей Николаев 186000\n";
            db_creator[2] = "3 Михаил Николаев 29300\n";
            db_creator[3] = "4 Татьяна Николаева 52300\n";
            db_creator[4] = "5 Ирина Никоненко 38150\n";
            db_creator[5] = "6 Алексей Дмитриев 12900\n";
            db_creator[6] = "7 Иван Соболев 62100\n";
            db_creator[7] = "8 Михаил Дурманов 39000\n";
            db_creator[8] = "9 Наталья Беляева 120900\n";
            db_creator[9] = "10 Денис Алексеев 72100";

            for (int i = 0; i < 10; i++) {
                fileWriter.write(db_creator[i]);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        }
    }
}