
import re

text = input()

pattern = "\\b([0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}.[0-9]{3}\\s+([A-Z]+)\\s[0-9]{7}\\s---\\s\\[([a-zA-Z0-9]+)\\]\\s([a-z|\\.]+([A-Za-z]+)|[A-Za-z]+)\\s+:\\s([^\r\n]+))"
results = re.findall(pattern, text)

for match in results:

    if match[4] == '':
        print("\"" + match[1] + "\",\"" + match[2] + "\",\"" + match[3] + "\",\"" + match[5] + "\"")
    else:
        print("\"" + match[1] + "\",\"" + match[2] + "\",\"" + match[4] + "\",\"" + match[5] + "\"")

