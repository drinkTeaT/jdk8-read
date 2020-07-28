package serialize;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EDZ
 * @description <br/>
 * 1:GSon 也不需要序列化
 * @date 2020/7/28 11:42
 */
public class GSonSerializableDemo {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Animal animal = new Animal("tiger", 2);
        String a = gson.toJson(animal);
        // 正常使用没问题
        animal = gson.fromJson(a, Animal.class);
        System.out.println(animal);
        // 转换为不同类名
        AnimalOne animalOne = gson.fromJson(a, AnimalOne.class);
        System.out.println(animalOne);
        // 不同版本号
        AnimalTwo animalTwo = gson.fromJson(a, AnimalTwo.class);
        System.out.println(animalTwo);
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Animal {
    private final static long serialVersionUID = 1l;
    private String name;
    private int age;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class AnimalOne {
    private String name;
    private int age;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class AnimalTwo {
    private final static long serialVersionUID = 12l;
    private String name;
    private int age;
}
