SOLID
S- au fost create multiple clase, fiecare raspunzand de sarcina sa,
    ca: waiter, manager, restaurant, meniu, masa.
O- am utilizat protected pentru a permite utilizarea membrilor si 
    metodelor in clasele copil.
L- fiecare clasa ce implimenteaza o interfata  sau extinde o clasa 
    are implimentat metodele clasei parinte, ceea ce permite utilizarea lor fara a cunoaste insasi clasa utilizata.
I- membrii claselor sau argumentele unei functii au fost peste tot
    de tipul interfetei sau clasei abstracte, fapt ce nu ne-a
    limitat la o implementare specifica.
D- ca exemplu, la crearea aplicatiei restaurant a fost trimis ca
    argument o implementare a VIEW, fapt ce a permis sa nu depindem
    doar de o implementare, ci de o abstractizare.

MVP

MODEL
Din MODEL fac parte componentele restaurant si alte dependente,ca:
meniu, masa, angajat. In restaurant se contin toate informatiile 
necesare pentru executarea programului.

VIEW
Pentru VIEW a fost creata o interfata view de la care am implementat 
ConsoleView, adica afisarea si citirea de la linia de comanda
aceasta arhitectura ne permite sa izolam partea de comunicare cu 
utilizatorul de celelalte componente.

PRESENTER
Ca intermediar intre VIEW si MODEL  este RESTAURANT app si 
ClientSimulation, care manipuleaza cu datele din restaurant
si le afiseaza la view.


