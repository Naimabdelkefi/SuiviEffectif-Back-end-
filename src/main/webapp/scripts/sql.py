import pymysql
import time
import csv
import datetime
import shutil
import requests

r = requests.get("http://localhost:8080/suivi_effectif/download?name=lettre-de-motivation.doc", stream=True)
if r.status_code == 200:
    with open('new.doc', 'wb') as f:
        r.raw.decode_content = True
        shutil.copyfileobj(r.raw, f)   

conn = pymysql.connect(host='127.0.0.1',
                     user='root',
                     db='sofrecom',
                    )
cur = conn.cursor()

with open('effectif.csv', 'r') as fp:
    reader = csv.reader(fp, delimiter=';', quotechar='"')
    # next(reader, None)  # skip the headers
    data_read = [row for row in reader]

format_str = '%d/%m/%Y'

try:
		cur.execute("""TRUNCATE `listeeffectif1`""")
		conn.commit()
except pymysql.InternalError as e:
		print('Got error {!r}, errno is {}'.format(e, e.args[0]))
		conn.rollback()


for i in range(1, len(data_read)):
	if data_read[i][10] in ['','-']:
		date_ent=None;
	else:
		date_str = data_read[i][10]
		datetime_obj = datetime.datetime.strptime(date_str, format_str)
		date_ent=datetime_obj.date()
	if data_read[i][12]in ['','-']:
		date_sort=None;
	else:
		date_str = data_read[i][12]
		datetime_obj = datetime.datetime.strptime(date_str, format_str)
		date_sort=datetime_obj.date()
	if data_read[i][14]in ['','-']:
		date_depot=None;
	else:
		date_str = data_read[i][14]
		datetime_obj = datetime.datetime.strptime(date_str, format_str)
		date_depot=datetime_obj.date()
	for j in range(0,18):
		if data_read[i][j]=='':
			data_read[i][j]=None
	try:
		cur.execute("""INSERT INTO listeeffectif1 VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)""",(i,data_read[i][0],data_read[i][1],data_read[i][2],data_read[i][3],data_read[i][4],data_read[i][5],data_read[i][6],data_read[i][7],data_read[i][8],data_read[i][9],date_ent,data_read[i][11],date_sort,data_read[i][13],date_depot,data_read[i][15],data_read[i][16],data_read[i][17]))
		print(i)
		conn.commit()
	except pymysql.InternalError as e:
		print('Got error {!r}, errno is {}'.format(e, e.args[0]))
		print("didnt work");
		conn.rollback()

conn.close()


'''
Pôle
Nom
Prénom
CUID
Poste_Administratif
Job_list
Nom_de_responsable_associé
Département
Projet
Etat_Recrutement
Date_dentrée
Motif_dentrée
Date_de_sortie
Motif_de_sortie
Date_dépôt_Démission
Description
HF
commentaires
print(da)
# open connection to the database



book = xlrd.open_workbook("pytest.xlsx")
sheet = book.sheet_by_name("liste_effectif")
print (book.sheet_names())




for i in range(0, len(data_read)):
if (data_read[i][4].replace("%","")!=""):
  #print("""INSERT INTO audiencedata VALUES (STR_TO_DATE('%s', '%d-%m-%Y'),%s,%s,%s,%f)""",(data_read[i][0],data_read[i][1],data_read[i][2],data_read[i][3]),float(data_read[i][4].replace("%","").replace(",",".")))

  try:
    x.execute("""INSERT INTO AudienceData VALUES (%s,%s,%s,%s,%s,%s)""",(i,data_read[i][0],data_read[i][1],data_read[i][2],data_read[i][3],data_read[i][4]))
    #x.execute("""INSERT INTO audiencedata1 (date,emission,chaine,heure,ratio) VALUES (STR_TO_DATE('%s', '%d-%m-%Y'),%s,%s,%s,%f);""",(data_read[i][0],data_read[i][1],data_read[i][2],data_read[i][3]),float(data_read[i][4].replace("%","").replace(",",".")))
    conn.commit()
  except:
    conn.rollback()
'''
