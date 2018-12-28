package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class NumUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> s = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String localName = getLocalName(emails[i]);
            String domainName = getDomainName(emails[i]);
            s.add(localName + domainName);
        }
        return s.size();
    }

    String getLocalName(String email) {
        return email.substring(0, Math.min(email.indexOf('+'), email.indexOf('@'))).replace(".", "");
    }

    String getDomainName(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

    public static void main(String[] args) {
        NumUniqueEmails n = new NumUniqueEmails();
        System.out.println(n.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}
