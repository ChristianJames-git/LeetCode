/*
 * https://leetcode.com/problems/unique-email-addresses/
 * 9/27/21
 *
 * Find total unique emails in the given array.
 * Email rules, '.' ignored and everything between '+' and '@' ignored including the '+', apply
 */
public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        String[] simplified = new String[emails.length];
        int toReturn = 0;
        for (int i = 0 ; i < emails.length ; i++) {
            boolean plus = false;
            for (int j = 0 ; j < emails[i].length() ; j++) {
                if (emails[i].charAt(j) == '@') {
                    for (int k = j ; k < emails[i].length() ; k++) {
                        simplified[i] += emails[i].charAt(k);
                    }
                    break;
                }
                if (emails[i].charAt(j) == '.')
                    continue;
                if (emails[i].charAt(j) == '+')
                    plus = true;
                if (!plus)
                    simplified[i] += emails[i].charAt(j);
            }
        }
        for (int i = 0 ; i < emails.length ; i++) {
            boolean unique = true;
            for (int j = i+1 ; j < emails.length ; j++) {
                if (simplified[i].equals(simplified[j])) {
                    unique = false;
                    break;
                }
            }
            if (unique)
                toReturn++;
        }
        return toReturn;
    }

    public static void main(String[] args) {
        UniqueEmailAddress a = new UniqueEmailAddress();
        System.out.println(a.numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"})); //first two forward to testemail@leetcode.com
        System.out.println(a.numUniqueEmails(new String[] {"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));
    }
}
