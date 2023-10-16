# TabelaHash
Implementação de uma Tabela Hash 

Entre as funções implementadas temos:

A classe LinkedList e a classe TabelaHash são definidas. Esta classe representa uma tabela de hash que utiliza encadeamento para lidar com colisões,
tamanho é a quantidade de espaços disponíveis na tabela de hash,
capacidadeMaxima representa o número máximo de elementos que a tabela pode conter antes de ser redimensionada,
tabela é um array de listas encadeadas (LinkedList) que será usado para armazenar os elementos.
![classTabelaHash](https://github.com/EdMussi/TabelaHash/assets/107222013/3d9dcf59-8b59-4f06-a2ee-0b5a66114312)

O construtor TabelaHash recebe o tamanho inicial da tabela. Ele inicializa os membros tamanho e capacidadeMaxima, e inicializa o array tabela com listas vazias.
![2](https://github.com/EdMussi/TabelaHash/assets/107222013/04477dc7-7a28-44a4-8603-c7751d4d800f)

doubleSize é um método que duplica o tamanho da tabela. Ele cria uma nova tabela com o dobro do tamanho, copia os elementos da tabela original para a nova e atualiza as variáveis de controle.
![3](https://github.com/EdMussi/TabelaHash/assets/107222013/8b7bcc9c-d318-4e97-8dfe-6866bdcf5937)

hash é um método que recebe uma chave e retorna o índice onde o elemento correspondente deve ser armazenado. No seu caso, ele faz o cálculo simples do módulo (%) do tamanho da tabela.
![4](https://github.com/EdMussi/TabelaHash/assets/107222013/0faa3c3c-1d60-4681-8f2e-260f9f8ac8b4)

inserir adiciona um elemento à tabela. Ele calcula o índice usando a função de hash, verifica se a lista encadeada naquele índice atingiu a capacidade máxima e, se sim, dobra o tamanho da tabela. Em seguida, adiciona o novo elemento à lista.
![5](https://github.com/EdMussi/TabelaHash/assets/107222013/528be800-605b-403b-a8e1-0f7725e1ba81)

buscar procura um elemento na tabela a partir da chave. Ele calcula o índice usando a função de hash e percorre a lista encadeada correspondente, verificando se a chave do elemento coincide com a chave fornecida.
![6](https://github.com/EdMussi/TabelaHash/assets/107222013/e389269c-363a-46e0-8a2b-4587071977d3)

remover busca e remove um elemento da tabela com base na chave. Ele calcula o índice usando a função de hash e percorre a lista encadeada correspondente. Quando encontra o elemento com a chave desejada, o remove e retorna o objeto associado.
![7](https://github.com/EdMussi/TabelaHash/assets/107222013/743f3417-c07f-4878-81f7-3e51f292e60e)

imprimirTabela percorre a tabela e imprime os elementos de cada slot.
![8](https://github.com/EdMussi/TabelaHash/assets/107222013/9f6703a2-3372-4a83-a3df-b00ef937a25c)

A classe Elemento representa um elemento da tabela de hash. Ela contém uma chave e um objeto associado.
![9](https://github.com/EdMussi/TabelaHash/assets/107222013/8e9c444e-c09b-43e4-af1c-6d1fbd56eec4)

Este método recebe uma chave e o número de iterações numIteracoes.
Ele calcula o tempo (em segundos) que leva para realizar numIteracoes buscas na tabela utilizando o método de encadeamento e o método de sondagem linear.
O método retorna a diferença de tempo entre o método de encadeamento e o método de sondagem linear.
![10](https://github.com/EdMussi/TabelaHash/assets/107222013/4b2d400c-d99a-44a7-ae95-ec295d1f3b99)

Este método é chamado pelo testeEficiencia para testar a eficiência do método de encadeamento.
Ele mede o tempo que leva para realizar numIteracoes buscas usando o método de encadeamento.
O tempo é medido utilizando a função System.nanoTime() que retorna o tempo em nanossegundos. O tempo é então convertido para segundos dividindo por 1e9 (equivalente a 1 bilhão).
![11](https://github.com/EdMussi/TabelaHash/assets/107222013/c605eed2-8eb4-4e53-a517-35b96707145e)

Similar ao testeEncadeamento, este método é chamado pelo testeEficiencia para testar a eficiência do método de sondagem linear.
Ele mede o tempo que leva para realizar numIteracoes buscas usando o método de sondagem linear.
![12](https://github.com/EdMussi/TabelaHash/assets/107222013/43a1e645-7cde-4019-b763-d73b9ed144ae)

Este método é usado para buscar um elemento na tabela usando o método de sondagem linear.
Ele calcula o índice inicial usando a função de hash e, em caso de colisão, itera sobre os slots seguintes até encontrar o elemento com a chave desejada.
![13](https://github.com/EdMussi/TabelaHash/assets/107222013/d5b3bc89-1e8d-46a1-9688-f9e6528af3ef)

Este método imprime a tabela usando o método de sondagem linear.
Ele percorre todos os slots da tabela e imprime os elementos de cada slot.
![14](https://github.com/EdMussi/TabelaHash/assets/107222013/9247c3c6-aeb6-45c6-b817-35ead25ea930)

Este método imprime a tabela usando tanto o método de encadeamento quanto o método de sondagem linear.
Ele chama os métodos imprimirTabela e imprimirTabelaSondagem para realizar as impressões.
![15](https://github.com/EdMussi/TabelaHash/assets/107222013/e28ba1de-1527-4c0f-b869-532fbc711bfa)



