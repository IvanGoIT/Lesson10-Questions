package question;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import entity.Fruit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionDate {

    private static String readJson(String fileName) throws FileNotFoundException {
        return new Scanner(new File(fileName)).useDelimiter("\\Z").next();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Объект в JSON");
        Fruit fruit = new Fruit();

        // Вариант с аннотацией в Fruit
        // String json = JSON.toJSONString(fruit);

        // Вариант без аннотации в Fruit
        String json = JSON.toJSONStringWithDateFormat(fruit, "MM/dd/yyyy");
        System.out.println(json);


        fruit.name = "apple";
        fruit.type = Fruit.Type.spoiled;
        json = JSON.toJSONString(fruit);

        System.out.println("JSON в Объект");
        Fruit fruit2 = JSON.parseObject(json, Fruit.class); // НЕ РАБОТАЕТ без аннотации

        int x;
    }
}
