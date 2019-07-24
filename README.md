# Velocímetro

Essa aplicação calcula a velocidade de deslocamento do usuário. Usamos dois cálculos diferentes para comparar a eficacia entre eles:

- getSpeed: o primeiro cálculo é usando o método getSpeed() que é oferecido pelo Android/GPS e automaticamente oferece a velocidade do usuário.

- Cálculo manual: o segundo método tenta calcular a velocidade usando o tempo gasto para se deslocar de um ponto A até um ponto B; para isso, salvamos as coordenadas (latitude e longitude) dos pontos, calculamos a distância entre elas e dividimos pelo tempo necessário para se deslocar entre esses pontos.

Ambos os métodos usam um location listening que gera updates da localização do usuário automaticamente a medida que o usuário se desloca. Essas atualizações são geradas com pelo menos 1 segundo de diferença entre elas e pelo menos 1 metro deslocado.

Por padrão, a velocidade é em m/s. Convertemos para km/h por ser um requisito da aplicação.
