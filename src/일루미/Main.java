package 일루미;

public class Main {

    public static void main(String[] args) {
        String[] arr = {"A","A","B","C","D","B","C","D","E","F","G","QQ","FF", "FF"};
        MyLinkedList<String> list = new MyLinkedList<>();

        String a = "b";
        a.hashCode();

        for(String s : arr) {
            list.add(s);
        }

        System.out.print("중복제거 이전 : ");
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i).value+ " ");
        }
        System.out.println("\n사이즈 : " + list.size());
        System.out.println("=============================================================");


        list.deduplication();

        System.out.print("중복제거 후 : ");
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i).value + " ");
        }
        System.out.println("\n사이즈 : " + list.size());
        System.out.println("=============================================================");

        for(String s : arr) {
            list.add(s);
        }

        System.out.print("다시 값 추가 : ");
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i).value + " ");
        }
        System.out.println("\n사이즈 : " + list.size());


    }
}
