#!/usr/bin/python
__author__ = 'dedda'

import json
import jinja2

DURCHSUCHUNGSPFAD = 'src/main/html'
LADER = jinja2.FileSystemLoader(searchpath=DURCHSUCHUNGSPFAD)
UMGEBUNG = jinja2.Environment(loader=LADER)
DATEINAME = 'prozess.libidoInternetseitenVorlage'
VORLAGE = UMGEBUNG.get_template(DATEINAME)

print('DIE DATEI WIRD JETZT GELADEN...')
JSON_DATEINAME = 'DATEN.json'
JSON_DATEIDATEN = open(JSON_DATEINAME).read()
JSON_DATEN = json.loads(JSON_DATEIDATEN)
vorlagedaten = {}
vorlagedaten['speicherbelegt'] = JSON_DATEN['speicherbelegt']
# vorlagedaten = JSON_DATEN
print('DIE DATEI IST JETZT GELADEN!!!')

print('DIE DATEI WIRD JETZT AUSGEGEBEN...')
AUSGABE_DATEINAME = 'AUSGABE.html'
AUSGABE_DATEI = open(AUSGABE_DATEINAME, 'w')
GEZEICHNET = VORLAGE.render(vorlagedaten)
AUSGABE_DATEI.write(GEZEICHNET)
print('DIE DATEI WURDE JETZT AUSGEGEBEN!!!')
