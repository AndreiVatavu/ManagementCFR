0xFeedCode - CFR
Preselecție HackITall

Nume echipă: 0xFeedCode
Componența echipei: Vătavu Andrei-Marian , Crețu Diana-Irina, Ioniță Alexandru-Cătălin

Documentație
Descrierea problemei
La nivel internațional și local, trenul este, după mașina personală, al doilea cel mai răspândit mod de transport persoane.
Din acest motiv este necesar să putem avea un mijloc eficient și rapid de distribuire a biletelor.  Fiind al doilea cel mai răspândit mod
de transport, comfortul pasagerilor și timpul lor reprezintă cele mai importante variabile.  Deoarece nu putem să influențăm comfortul 
pasagerilor, putem creea un sistem de management al biletelor care să le salveze timp prețios. În timpul pe care l-ar petrece la casă,
utilizatorii ar putea doar să primească biletul, iar distribuirea locurilor s-ar face printr-un sistem ca cel de la metrou. O casă
electronică care să primească un bilet și va ștampila pe acesta locul/locurile. 
Descrierea situațiilor care pot să apară
În cazul biletelor vândute la casă, prima problemă este aceea a cozilor foarte lungi. Din cauza cozilor pot apărea situații prin care se 
pot pierde trenuri importante. De aceea noi punem la dispoziție un mod eficient al cumpărării biletelor. Se cumpără de la casă doar 
biletul care ar avea atașat un id sau un range de id-uri. Înainte cu 15 minute de plecarea trenului, oamenii ar avea posibilitatea să 
înceapă să ștampileze respectivele bilete. Pe acestea s-ar înscrie automat, de casa electronică locul  pe baza range-ului de bilete. 
Așezarea lor în tren se face pe baza unui algoritm care ține cont de câte persoane sunt în grup pentru a-i așeza în același compartiment, 
de la ce stație se urcă și la ce stație va coborî  respectivul grup pentru a putea refolosi locurile respective în cazul în care am avea
o aplicație mai mare.
O altă problemă ar putea să apărea în cazul în care am avea doar grupuri de 5 persoane. Atunci grupul trebuie despărțit deoarece nu ar
putea să stea toți 5 (Nr. Total de compartimente = 50, Nr. Maxim total de grupuri = 72). 






Descrierea algoritmului folosit

	Algoritmul va pune toți oamenii pe locurile libere astfel încât grupurile să fie în același compartiment. Se vor împărții cât mai eficient grupurile în compartimente. Lista de rezervări va fi inițial goală. Comenzile programului:
reserve stațieDePornire stațieDestinatie numărPersoaneGrup se va adăuga la listă, rezervarea respectivă și se verifică corectitudinea
input-ului. 
update reprezintă punctul în care trenul va pleca către următoarea stație. În momentul în care s-a dat această comandă lista de
rezervări se sortează în mod descrescător în funcție de numărul de persoane din grup.  Grupurile cu cele mai multe persoane vor fi puse
unde sunt cele mai multe locuri libere. 
show afișează dacă este ocupat sau a fost ocupat la o stație anterioară. 
 
Cod
Link către github: https://github.com/AndreiVatavu/ManagementCFR
 		
