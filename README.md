# educational_applets
Educational applet that ilustrates operating systems' concepts

Discussão inicial:

Representar as ideias de região crítica e exclusão mútua usando uma analogia com estradas, motoristas, veículos e postos de serviços localizados à beira da estrada.

Lista:
Banco do motorista ("Controle geral do veículo") -> Região Crítica (Um motorista por vez);
Motorista Atual -> Processo/Thread com acesso à região crítica;
Estrada -> Execução efetiva na região crítica;
Posto -> Deixar a região crítica (Abdicar).

1. Dois processos nunca podem estar simultaneamente em suas regiões críticas;
2. Nada pode ser afirmado sobre a velocidade ou sobre o número de CPUs;
3. Nenhum processo executando fora de sua região crítica pode bloquear outro processos;
4. Nenhum processo deve esperar eternamente para entrar em sua região crítica.


Analogias:
1. Não podem existir dois motoristas ao mesmo tempo. Um motorista e X passageiros por veículo;
2. Não sei o humor do motorista. Está bravo -> Rápido / Respeita Leis -> Devagar / Tráfego Intenso;
3. Colocar a mão nos olhos do motorista atual, puxá-lo do seu banco, freio de mão, nocautear o irmão que está lendo, etc;
4. Um motorista precisa dormir/descansar alguma hora.

JavaScript vs Java Applet
utzid

