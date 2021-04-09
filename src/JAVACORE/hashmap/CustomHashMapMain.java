package JAVACORE.hashmap;

public class CustomHashMapMain {
    public static void main(String[] args) {
        CustomHashMap hashMap = new CustomHashMapImp();
        hashMap.put(1, "Mutex");

        hashMap.put(10, "Severe");

        hashMap.put(100, "Bafana bafana");

        System.out.println(hashMap.containsKey(13));

        hashMap.remove(100);


        System.out.println(hashMap);

    }
}
