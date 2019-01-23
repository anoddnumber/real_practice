package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/subdomain-visit-count/
 */
public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        /*
            Time Complexity - O(d) for the split method where d is the number of characters in a string
                              O(n) for iterating through each domain where n is the number of domains
                              Combined, it is O(nd)
            Space Complexity - O(n) for the HashMap
         */
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] strings = s.split(" ");
            int num = Integer.parseInt(strings[0]);
            String fullDomain = strings[1];
            addDomain(map, fullDomain, num);

            int fromIndex = 0;
            int pIndex = fullDomain.indexOf('.', fromIndex);

            while (pIndex > 0) {
                addDomain(map, fullDomain.substring(pIndex + 1), num);
                pIndex = fullDomain.indexOf('.', pIndex + 1);
            }
        }

        List<String> visits = new ArrayList<>();

        for (String key : map.keySet()) {
            visits.add(map.get(key).toString() + " " + key);
        }

        return visits;
    }

    private void addDomain(Map<String, Integer> map, String domain, int num) {
        if (map.containsKey(domain)) {
            map.put(domain, map.get(domain) + num);
        } else {
            map.put(domain, num);
        }
    }

    public static void main(String[] args) {
        SubdomainVisitCount s = new SubdomainVisitCount();

        String[] subdomains = {
                "9001 discuss.leetcode.com"
        };

        System.out.println(s.subdomainVisits(subdomains));

        String[] subdomains2 = {
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
        };

        System.out.println(s.subdomainVisits(subdomains2));
    }
}
