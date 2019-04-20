# L'algoritmo euclideo

In matematica, l'algoritmo euclideo è un metodo efficiente per calcolare il massimo comun divisore (MCD) di due numeri.

E' basato sul principio per il quale _il MCD di due numeri non cambia se il maggiore dei due è sostituito dalla sua differenza con il minore dei due._

Per esempio: `21` è il MCD tra `252` e `105`. Risulta infatti

`252 = 2^2 * 3^2 * 7 = 21 * 12` ,

`105 = 3 * 5 * 7`

MCD = prodotto di tutti i fattori comuni presi una sola volta col minimo esponente in cui compaiono nella scomposizione.

Il MCD continua ad essere 21 se si sostituisce `252` con `252 - 105 = 147`.

Poiché questa sostituzione riduce il maggiore dei due numeri, ripetendo il procedimento si ottengono via via coppie di numeri più piccoli, finché i due numeri diventano uguali. Quando questo accade, si è arrivati al MCD dei due numeri iniziali.

Questo è il procedimento generale, così come fu elaborato da Euclide. Tuttavia, nel caso in cui uno dei numeri sia molto maggiore dell'altro, il procedimento può essere lungo e richiedere molti passi di sottrazioni successive per arrivare al MCD. Per rendere l'algoritmo più efficiente, invece, si sostituisce il numero maggiore con il resto della divisione tra esso e il minore. In questa versione l'algoritmo termina quando si ottiene un resto pari a zero (questo garantisce un `O(5log N)`, con `N` pari al numero più grande dei due).