
import re

text = input()
pattern = "\\b[a-z]\.[a-z]{2,}\.[0-9]{4}@alumnos\.urjc\.es\\b|\\b[a-z]+\.[a-z]+@urjc\.es\\b"
results = re.findall(pattern, text)

alumno = "@alumnos"
profesor = "@urjc"

for match in results:
    div = match.split('.')
    if alumno in match:
        print("alumno " + div[1] + " matriculado en " + div[2][:4])
    else:
        div2 = div[1].split('@')
        print("profesor " + div[0] + " apellido " + div2[0])

