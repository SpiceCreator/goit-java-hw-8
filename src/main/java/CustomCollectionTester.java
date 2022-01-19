public class CustomCollectionTester {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();

        customHashMap.put("A", 1);
        System.out.println("customHashMap = " + customHashMap);
        customHashMap.put("B", 2);
        System.out.println("customHashMap = " + customHashMap);
        customHashMap.put("fdshtdhfdhgnrtdbfgbtfbtbxbd", 3);
        System.out.println("customHashMap = " + customHashMap);
        customHashMap.put("B", 3);
        System.out.println("customHashMap = " + customHashMap);
        customHashMap.remove("A");
        System.out.println("customHashMap.size() = " + customHashMap.size());
        System.out.println("customHashMap = " + customHashMap);
        

        System.out.println("customHashMap.get(\"B\") = " + customHashMap.get("B"));
    }
}
