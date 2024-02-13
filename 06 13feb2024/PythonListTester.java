public class PythonListTester {
    public static void main(String[] args) {
        int[] list = {10,30,20,40};
        PythonList d = new PythonList(list);
        System.out.println(d.findMax());
        System.out.println(d.findMin());
        d.setFastMode();
        System.out.println(d.findMax());
        System.out.println(d.findMin());
    }
}
