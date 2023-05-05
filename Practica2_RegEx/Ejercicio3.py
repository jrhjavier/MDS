
import re

text = input()
pattern = "\\b(\\d{4}-\\d{2}-\\d{2})\\b"

results = re.findall(pattern, text)
for match in results:
    div = match.split('-')
    sol = div[2] + "." + div[1] + "." + div[0]
    text = re.sub(match, sol, text)

print(text)

