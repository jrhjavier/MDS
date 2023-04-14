
import re

text = input()
pattern = "\\b((Calle|C\\/)\\s([A-Z|\\u00C1-\\u00DA][a-z|\\u00E1-\\u00FA]+)\\s*(,|)\\s+(Nº|nº|N |n |Nº |nº |n|N|)([0-9]+)\\s*(,|)\\s+([0-9]{5}))\\b"
results = re.findall(pattern, text)

for match in results:
    print(match[7] + "-" + match[2] + "-" + match[5])
