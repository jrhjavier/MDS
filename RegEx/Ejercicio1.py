import re

text = input()
pattern = "\\b[0-9]{4}\\b|^\\b[0-9]{4}\\b"

results = re.findall(pattern, text)
for match in results:
    print(match)
