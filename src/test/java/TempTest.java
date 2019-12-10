import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TempTest {
    public static void main(String[] args) {
        List<String> errors = new ArrayList<>();
//        errors.add("企业");
//        errors.add("法定代表人");
//        errors.add("被授权人");
        String errorMessage = errors.stream().collect(Collectors.joining("、"));
        if (!errorMessage.isEmpty()) {
            String wholeErrorMessage = new StringBuilder().append("请补充填写").append(errorMessage).append("英文名称或拼音").toString();
            System.out.println(wholeErrorMessage);
        }
    }
}

