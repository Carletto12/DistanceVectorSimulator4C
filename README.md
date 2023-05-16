# DistanceVectorSimulator4C
A basic distance vector simulator (Bellman-ford algorithm) developed in Java.
Partecipant: 4C informatica, ITT Tito Sarrocchi, Via Carlo Pisacane 3, Siena, Tuscany, Italy

<--Main window--> 
left side contains 3 buttons which perform these tasks:
      1 --> Matrix, shows adiacence matrix of the network;
      2 --> Step, lets the user proceed further into the algorithm; 
      3 --> Check, lets the user check all distance vectors and their current state, uploaded
            as soon as the adiacence matrix updates after node comunication
<Files saved by program>
log.txt: saves a basic log containing the precise instant in which the matrix uploads.
  
The program works on Bellman-ford algorithm, which consist in all of the nodes sending their distance vecotr to all their neighbours. 
The nodes that recive the vector update their own distance vector according to the best path existing. 
