# Analisador de Hierarquia de Palavras

Esta é uma aplicação de linha de comando que carrega uma árvore hierárquica de palavras, onde cada nível da árvore representa uma profundidade específica.

## Objetivo 🔍

Analisar uma frase fornecida pelo usuário, identificar a profundidade associada a uma
palavra mencionada na frase, e então exibir os itens mais próximos dessa profundidade.

## Tecnologias 🛠️

 - **Java 17**
 - **Spring Boot**
 - **Picocli**
 - **Jackson**

## Download 📩

Com o `Java` instalado em sua máquina clone este repositório, conforme o código abaixo:

```
git clone wa-chanllege-backend
```

## Descrição 📒

- É realizada uma busca a partir das entradas fornecidas pelo usuário na linha comando, conforme o exemplo: `java -jar build/libs/cli.jar --depth 3 <phrase> --verbose`. 
- **Parâmetros**
  - **`--depth`**: indica a profundidade em que o nó deve ser encontrado.
  - **`<phrase>`**: frase que contém valores pertercentes a hierarquia de busca.
  - **`--verbose`**: valor opcional, se presente, exibe uma tabela com os tempos de carregamento dos parâmetros e o tempo de verificação da frase.
>[!important]
>A profundidade de um nó (`--depth`) é dada tomando o nó raiz da hierarquia com profundidade igual a 0.
```java
{
  Automóveis: {                //depth = 0
    Carros: {                  //depth = 1
      Esportivos:{             //depth = 2
        ...
      }
    }
  }
}
```
- Com os dados fornecidos pelo usuário a aplicação realizará uma busca em profundidade a partir dos valores de `depth`, `<phrase>` e do arquivo `.json` especificado.

> [!Important]
> Os arquivos `.json` que representam a hierarquia na qual será realizada a busca estão na pasta `chanlleges\wachanllege\src\main\resources`. Caso deseje inserir um arquivo copio-o nessa página e altere o caminho do arquivo do construtor da classe **`HierarchyService`** no pacote `src\main\java\com\chanlleges\wachanllege\service`.

```java
public HierarchyService(JsonLoader jsonLoader) {
  try {
    this.hierarchy = jsonLoader.loadHierarchy("src/main/resources/dicts/teste.json");   //caminho do arquivo a ser analisado
  } catch (RuntimeException e) {
      System.err.println( e.getMessage());
      System.exit(0);
  }
}
```
## Execução ⚙️

- Com este projeto já em sua máquina abro-o pelo terminal e execute o seguinte comando para um teste:
  ```
  java -jar build/libs/cli.jar --depth 4 "eu tenho medo de leões" --verbose
  ```
>[!NOTE]
>Os valores de `depth` e `<phrase>` ficam a critério do usuário. É importante levar em conta o contexto do arquivo `.json` em análise
  
- **Output**: A saída irá apresentar o valor do nó mais proximo em que foi encotrado o resultado da busca exibindo a tabela de tempo caso o parâmetro `--verbose` esteja presente na linha de comando. No exemplo acima a saída seria:

```
Felinos: 1; 
--------------------------------------------------------------------
Tempo de verificação da frase                           0 ms
--------------------------------------------------------------------
Tempo de carregamento dos parametros                    2 ms
--------------------------------------------------------------------
  
```

