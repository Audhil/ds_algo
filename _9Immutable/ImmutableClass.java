package _9Immutable;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {

    private final String name;
    private final int regNo;
    private final Map<String, String> metaData;

    public ImmutableClass(String name, int regNo, Map<String, String> metaData) {
        this.name = name;
        this.regNo = regNo;

        Map<String, String> temp = new HashMap<>();
        for (Map.Entry<String, String> entry : metaData.entrySet()) {
            temp.put(entry.getKey(), entry.getValue());
        }
        this.metaData = temp;
    }

    public String getName() {
        return name;
    }

    public Integer getRegNo() {
        return regNo;
    }

    public Map<String, String> getMetaData() {
        Map<String, String> temp = new HashMap<>();
        for (Map.Entry<String, String> entry : metaData.entrySet()) {
            temp.put(entry.getKey(), entry.getValue());
        }
        return temp;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", regNo=" + regNo +
                ", metaData=" + metaData +
                '}';
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");
        ImmutableClass clas = new ImmutableClass("Audhil", 1, map);

        System.out.println("yup: class: " + clas);
        map.put("3", "third");
        System.out.println("yup: 2nd class: " + clas.getMetaData());    // Remains unchanged due to deep copy in constructor


        clas.getMetaData().put("4", "fourth");
        System.out.println("yup: 3rd class: " + clas.getMetaData());    // Remains unchanged due to deep copy in getter
    }
}


