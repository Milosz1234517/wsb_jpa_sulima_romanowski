Laboratorium III - JPQL

Uwaga! Do wykonania zadan konieczne jest zaimplementowanie architektury warstwowej i testow z Laboratorium II !

Uzupelnij plik data.sql o dane niezbedne do realizacji nastepujacych zapytan:
1. Znajdz pacjentow po nazwisku
2. Znajdz wszystkie wizyty pacjenta po jego ID
3. znajdz pacjentow ktorzy mieli wiecej niz X wizyt (X jest parametrem wejsciowym)
4. Znajdz pacjentow po dodanym przez Ciebie polu - nie wyszukuj wprost po wartosci, uzyj zapytania typu wieksze/mniejsze/pozniej/wczesniej/zawiera, w zaleznosci od wybranego typu zmiennej.

Napisz testy do zapytan w nastepujacej formie:
1. do zapytania nr 1  - test DAO
2. do zapytania nr 2 - test serwisu
3. do zapytania nr 3 - test DAO
4. do zapytania nr 4 - test DAO

W PatientEntity, nad relacja do VisitEntity dodaj adnotacje

@Fetch(FetchMode.SELECT)

a fetchType zmien na EAGER
Uruchom test w ktorym pobierany jest Patient z wieloma wizytami. W logach zaobserwuj, jak wyglada pobieranie dodatkowych encji (ile i jakie sqle).
Nastepnie zmien adnotacje na

@Fetch(FetchMode.JOIN)

i powtorz test i obserwacje. Wnioski zapisz na dole tego pliku i skomituj.

Gdy ustawione zostanie @Fetch(FetchMode.SELECT), wówczas wykonywany jest osobny select do tabeli z wizytami

Np. dla pacjenta z id = 4:

Hibernate: select pe1_0.id,pe1_0.address_id,ae1_0.id,ae1_0.address_line1,ae1_0.address_line2,ae1_0.city,ae1_0.postal_code,pe1_0.date_of_birth,pe1_0.email,pe1_0.first_name,pe1_0.last_name,pe1_0.patient_number,pe1_0.pesel,pe1_0.telephone_number from patient pe1_0 join address ae1_0 on ae1_0.id=pe1_0.address_id where pe1_0.id=?

Hibernate: select ve1_0.patient_id,ve1_0.id,ve1_0.description,ve1_0.doctor_id,de1_0.id,de1_0.address_id,ae1_0.id,ae1_0.address_line1,ae1_0.address_line2,ae1_0.city,ae1_0.postal_code,de1_0.doctor_number,de1_0.email,de1_0.first_name,de1_0.last_name,de1_0.specialization,de1_0.telephone_number,ve1_0.time from visit ve1_0 left join doctor de1_0 on de1_0.id=ve1_0.doctor_id left join address ae1_0 on ae1_0.id=de1_0.address_id where ve1_0.patient_id=?

Natomiast w momencie ustawienia @Fetch(FetchMode.JOIN) tworzone jest jedno zapytanie z użyciem klauzuli join:

Hibernate: select pe1_0.id,pe1_0.address_id,ae1_0.id,ae1_0.address_line1,ae1_0.address_line2,ae1_0.city,ae1_0.postal_code,pe1_0.date_of_birth,pe1_0.email,pe1_0.first_name,pe1_0.last_name,pe1_0.patient_number,pe1_0.pesel,pe1_0.telephone_number,ve1_0.patient_id,ve1_0.id,ve1_0.description,ve1_0.doctor_id,de1_0.id,de1_0.address_id,ae2_0.id,ae2_0.address_line1,ae2_0.address_line2,ae2_0.city,ae2_0.postal_code,de1_0.doctor_number,de1_0.email,de1_0.first_name,de1_0.last_name,de1_0.specialization,de1_0.telephone_number,ve1_0.time from patient pe1_0 join address ae1_0 on ae1_0.id=pe1_0.address_id left join visit ve1_0 on pe1_0.id=ve1_0.patient_id left join doctor de1_0 on de1_0.id=ve1_0.doctor_id left join address ae2_0 on ae2_0.id=de1_0.address_id where pe1_0.id=?

Do wybranej encji dodaj wersjonowanie, oraz napisz test (w DAO) sprawdzajacy rownolegla modyfikacje (OptimisticLock)