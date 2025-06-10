
public class ExpWithStrings {

    public static void main(String[] args) {
        // String s = "";
        // for (int i = 0; i < 26; i++) {
        //     s += (char) (i + 'a');
        //     System.out.println("Value of s: " + s + ", value of hashcode: " + s.hashCode());
        // }

        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < 26; i++) {
        //     sb.append((char) (i + 'a'));
        //     System.out.println("Value of sb: " + sb + ", value of hashcode: " + sb.hashCode());
        // }

        String a = new String("Harshal");
        String b = new String("Harshal");
        System.out.println(a == b);
        System.out.println(a.equals(b));

        StringBuffer c = new StringBuffer("Harshal");
        StringBuffer d = new StringBuffer("Harshal");
        System.out.println(c == d);
        System.out.println(c.equals(d));
    }
}
