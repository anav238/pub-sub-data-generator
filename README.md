# pub-sub-data-generator
Homework made for the Event Based Systems laboratory

Limbaj de programare: Java

Versiune JDK: 17

IDE: IntelliJ IDEA 2021.2.2

Scrieti un program care sa genereze aleator seturi echilibrate de subscriptii si publicatii cu posibilitatea de fixare a: numarului total de mesaje (publicatii, respectiv subscriptii), ponderii pe frecventa campurilor din subscriptii si ponderii operatorilor de egalitate din subscriptii pentru cel putin un camp. Publicatiile vor avea o structura fixa de campuri la alegere.

Exemplu:
Publicatie: {(company,"Google");(value,90.0);(drop,10.0);(variation,0.73);(date,2.02.2022)} - Structura fixa a campurilor publicatiei e: company-string, value-double, drop-double, variation-double, date-data; pentru anumite campuri (company, date), se pot folosi seturi de valori prestabilite de unde se va alege una la intamplare; pentru celelalte campuri se pot stabili limite inferioare si superioare intre care se va alege una la intamplare.

Subscriptie:{(company,=,"Google");(value,>=,90);(variation,<,0.8)} - Unele campuri pot lipsi; frecventa campurilor prezente trebuie sa fie configurabila (ex. 90% company - 90% din subscriptiile generate trebuie sa includa campul "company"); pentru cel putin un camp (exemplu - company) trebui sa se poate configura un minim de frecventa pentru operatorul "=" (ex. macar 70% din subscriptiile generate sa aiba ca operator pe acest camp egalitatea).

Note:
- cazul in care suma procentelor configurate pentru campuri e mai mica decat 100 reprezinta o situatie de exceptie care nu e necesar sa fie tratata (pentru testare se vor folosi intotdeauna valori de procentaj ce sunt egale sau depasesc 100 ca suma)
- tema cere doar generarea de date, nu implementarea unei topologii Storm care sa includa functionalitatea de matching intre subscriptii si publicatii; nu exista restrictii de limbaj sau platforma pentru implementare
- optional, implementarea temei poate include o optimizare de performanta prin paralelizarea generarii subscriptiilor si publicatiilor; in acest caz trebuie evident considerata posibila necesitate de sincronizare a threadurilor ce poate sa apara in functie de algoritmul ales pentru generarea subscriptiilor


Hint: NU se recomanda utilizarea distributiei random in obtinerea procentelor cerute pentru campurile subscriptiilor (nu garanteaza o distributie precisa).
