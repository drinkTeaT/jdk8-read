package serialize;

import com.alibaba.fastjson.JSON;
import lombok.*;

/**
 * @author EDZ
 * @description :
 * 1:fastJson序列化和反序列化的类不需要实现Serializable接口
 * 2:私有属性有get和set方法即可
 * @date 2020/7/28 10:57
 */
public class FastJsonSerializableDemo {
    public static void main(String[] args) {
        String person = JSON.toJSONString(new Person("tacbin", 24));
        System.out.println(person);
        // 反序列化
        PersonOne personOne = JSON.parseObject(person, PersonOne.class);
        System.out.println(personOne);
        // 反序列化，字段类型不一致直接反序列化失败
        try {
            PersonTwo perSonTwo = JSON.parseObject(person, PersonTwo.class);
            System.out.println(perSonTwo);
        } catch (Exception e) {
            System.out.println("failed!");
        }
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
class Person {
    private static final long serialVersionUID = 329042304823l;
    private String name;
    private int age;
}

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
class PersonOne {
    // 有无版本号都可以反序列化
//    private static final long serialVersionUID = 329042304823l;
    // 序列化的版本号不一致也可以？！
    private static final long serialVersionUID = 2l;
    private String name;
    private int age;
}

@Setter
@Getter
@AllArgsConstructor
class PersonTwo {
    private static final long serialVersionUID = 329042304823l;
    private int name;
    private int age;
}