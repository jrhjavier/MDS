import re

text = input()
pattern = "\\b((Calle|C\\/)\\s([A-Z|\\u00C1-\\u00DA][a-z|\\u00E1-\\u00FA]+)\\s*(,|)\\s+(Nº|nº|N |n |Nº |nº |n|N|)([0-9]+)\\s*(,|)\\s+([0-9]{5}))\\b"
results = re.findall(pattern, text)

for match in results:
    print(match[7] + "-" + match[2] + "-" + match[5])


# C/ Dulcinea Nº 10, 28936 , jshaijdhk Calle Dulcineañ 10, 28106. Calle Dulcinea N10, 28091

"""
HECHO EN JAVA
package com.company;

import java.util.Scanner;
import java.util.regex.*;

class Scratch {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String text = teclado.nextLine();

        Pattern p = Pattern.compile("\\b((Calle|C\\/)\\s([A-Z|\\u00C1-\\u00DA][a-z|\\u00E1-\\u00FA]+)\\s*(,|)\\s+(Nº|nº|N |n |Nº |nº |n|N|)([0-9]+)\\s*(,|)\\s+([0-9]{5}))\\b");
        Matcher m = p.matcher(text);
        while(m.find()){
            System.out.println( m.group(8) + "-" + m.group(3) + "-" + m.group(6));
        }
    }
}

"""
