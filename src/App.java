import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        String[] test = new String[] { "test.email+alex@leetcode.com", "test.ee.mail.cathy@leetcode.com",
                "testemailll@lee.tcode.com" };
        numUniqueEmails(test);
        System.out.println(numUniqueEmails(test));
    }

    public static int numUniqueEmails(String[] emails) {

        Set<String> unique = new HashSet<>();

        for (String e : emails) {
            StringBuilder local = new StringBuilder();
            int i = 0;
            while (i < e.length()) {
                if (e.charAt(i) == '+') {
                    break;
                }
                if (e.charAt(i) != '.') {
                    local.append(e.charAt(i));
                }
                i++;
            }

            // Skip everything after '+' till '@'
            while (i < e.length() && e.charAt(i) != '@') {
                i++;
            }

            local.append(e.substring(i));
            unique.add(local.toString());
        }
        System.out.println(unique);
        return unique.size();
    }
}
