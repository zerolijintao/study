package java8;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {

//        List<Staff> staff = Arrays.asList(
//                new Staff(1, "lee"),
//                new Staff(2, "jin")
//        );
//
//        //Before Java 8
//        List<String> result = new ArrayList<>();
//        for (Staff x : staff) {
//            result.add(x.getName());
//        }
//        System.out.println(result); //[lee, jin]
//
//        //Java 8
//        List<String> collect = staff.stream().map(Staff::getName).collect(Collectors.toList());
//        System.out.println(collect); //[lee, jin]

        List<Staff> staff = Arrays.asList(
                new Staff(1, "lee", 10),
                new Staff(2, "jin", 20),
                new Staff(3, "tao", 30)
        );

        List<StaffPublic> result = staff.stream()
                .filter(s -> s.getScore() > 15)
                .sorted(Comparator.comparing(Staff::getScore))
                .map(temp -> {
                    StaffPublic obj = new StaffPublic();
                    obj.setName(temp.getName());
                    if ("jin".equals(temp.getName())) {
                        obj.setExtra("this field is for jin only!");
                    }
                    obj.setScore(temp.getScore());
                    return obj;
                })
                .collect(Collectors.toList());

        System.out.println(result);

        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
    }
}
