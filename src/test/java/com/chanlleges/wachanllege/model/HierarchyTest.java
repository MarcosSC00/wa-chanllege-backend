package com.chanlleges.wachanllege.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HierarchyTest {
	
	private Hierarchy hierarchy;
	private Hierarchy child1;
	private Hierarchy child2;

	@BeforeEach
	public void setUp() {
		hierarchy = new Hierarchy();
		hierarchy.setName("root");
		
		child1 = new Hierarchy();
		child1.setName("child1");
		
		child2 = new Hierarchy();
		child2.setName("child2");
		
		List<Hierarchy> children = new ArrayList<>();
		children.add(child1);
		children.add(child2);
		
		hierarchy.setChildren(children);
	}
	
	@Test
	@DisplayName("should get father node at name")
	void testFindPath() {
		Optional<Hierarchy> result = hierarchy.findFather("child1", 1);
		assertThat(result.isPresent()).isTrue();
	}
	
	@Test
	@DisplayName("should not get father node at name")
	void testNotFindPath() {
		Optional<Hierarchy> result = hierarchy.findFather("notfound", 1);
		assertEquals(null, result);
	}
	
	@Test
	@DisplayName("should show a message")
	void testAnalyze() {
		String phrase = "child1 child2";
		int depth = 1;
		Optional<List<String>> result = hierarchy.analize(phrase, depth);
		assertTrue(result.isPresent());
		assertEquals("root: 2", result.get().get(0));
	}
	
	@Test
	void testAnalyzeLongPhrse() {
		int depth = 1;
		String longPhrase = "A vastidão do céu azul, que se estende por sobre as child1 e child2"
				+ " vales, é uma representação majestosa da natureza em toda a sua glória, uma tapeçaria "
				+ "de cores e luzes que dançam sobre as colinas, onde cada raio de sol parece beijar a terra"
				+ " com um calor gentil, enquanto as nuvens, leves e passageiras, deslizam suavemente como véus"
				+ " de seda ao vento, criando sombras que correm pelos campos verdes, onde flores silvestres"
				+ " balançam ao ritmo de uma brisa suave, perfumada com os aromas da terra fértil, impregnada"
				+ " pela chuva que caiu na noite anterior, trazendo vida e frescor à vegetação, que, em resposta,"
				+ " cresce vigorosamente, estendendo suas folhas em direção ao sol, como se buscassem tocar o céu"
				+ " acima, e, ao fazer isso, formam um vasto tapete de verde, salpicado aqui e ali por manchas de"
				+ " cores vibrantes, como o amarelo do girassol que se destaca à distância, ou o vermelho das "
				+ "papoulas que florescem em pequenos grupos, seus caules delgados oscilando levemente com o sopro"
				+ " do vento, enquanto, ao longe, um rio sereno serpenteia pela paisagem, refletindo o brilho dourado"
				+ " do sol em suas águas claras, que fluem suavemente sobre pedras polidas, criando um som suave e"
				+ " constante, quase como uma melodia que acompanha o canto dos pássaros que, nas árvores próximas,"
				+ " celebram o novo dia com suas canções alegres e vibrantes, cada nota uma expressão de vida e"
				+ " liberdade, ecoando pelos bosques e prados, onde pequenos animais despertam de seus abrigos"
				+ " noturnos, prontos para mais um dia de atividade, correndo e saltando entre as folhas e arbustos,"
				+ " em busca de alimento, enquanto o ciclo da vida continua inabalável, uma dança eterna entre"
				+ " predadores e presas, entre a luz e a escuridão, entre o nascer e o pôr do sol, que, dia após dia,"
				+ " se repete com uma precisão quase mágica, como se o próprio universo fosse uma grande sinfonia em"
				+ " movimento, onde cada elemento desempenha o seu papel, desde as minúsculas formigas que trabalham"
				+ " incansavelmente para construir seus lares subterrâneos, até as majestosas águias que planam nas alturas,"
				+ " observando o mundo abaixo com seus olhos penetrantes, prontas para mergulhar e capturar suas presas com uma"
				+ " precisão impressionante, e, em meio a tudo isso, o ser humano, com sua mente curiosa e suas mãos"
				+ " habilidosas, que ao longo dos milênios aprendeu a moldar o ambiente ao seu redor, erguendo cidades"
				+ " que se estendem até o horizonte, preenchidas com a movimentação constante de pessoas, veículos e máquinas,"
				+ " uma cacofonia de sons e cores que contrastam com a serenidade da natureza, mas que, de certa forma,"
				+ " também fazem parte desse grande todo, onde tudo está interligado, onde cada ação tem uma reação,"
				+ " onde cada ser, por menor que seja, desempenha um papel no equilíbrio do ecossistema, um equilíbrio"
				+ " que, apesar de sua complexidade, é frágil, e que, quando perturbado, pode levar a consequências imprevisíveis,"
				+ " como vimos tantas vezes ao longo da história, quando civilizações inteiras desapareceram,"
				+ " engolidas pela natureza que retomou seu curso, ou quando espécies se extinguiram, deixando"
				+ " um vazio no mundo natural, um lembrete constante de que, por mais poderosos que sejamos,"
				+ " somos apenas uma parte deste vasto e intricado sistema, e que a nossa sobrevivência depende"
				+ " da nossa capacidade de respeitar e preservar o ambiente que nos sustenta, um ambiente que nos"
				+ " fornece o ar que respiramos, a água que bebemos, o alimento que consumimos,"
				+ " e que, se não cuidarmos dele, pode se tornar inabitável, transformando o nosso planeta,"
				+ " que hoje é uma joia de vida e diversidade, em um deserto estéril, sem vida, onde nada cresce,"
				+ " onde o céu azul é substituído por uma camada de poeira e fumaça,"
				+ " onde os rios secam e os mares se tornam tóxicos, e onde a única música que resta é o som do vento"
				+ " soprando sobre as ruínas do que um dia foi uma civilização vibrante, e é por isso que, mesmo quando"
				+ " estamos cercados pelo barulho e pela confusão da vida moderna, é importante tirarmos um momento para"
				+ " nos conectarmos com a natureza, para sentir o sol em nossa pele, o vento em nosso rosto, para ouvir o"
				+ " canto dos pássaros e o sussurro das árvores, e para lembrar que somos parte deste mundo, que nossa "
				+ "existência está profundamente entrelaçada com a terra sob nossos pés e o céu acima de nossas cabeças,"
				+ " e que, se quisermos garantir um futuro para nós e para as próximas gerações, devemos aprender a viver"
				+ " em harmonia com o mundo natural, a proteger e preservar o que resta de sua beleza e majestade, para que,"
				+ " assim como os pássaros que continuam a cantar, possamos também continuar a viver e prosperar neste planeta"
				+ " que chamamos de lar, cuidando dele, respeitando seus ciclos e celebrando a vida em todas as suas formas,"
				+ " grandes e pequenas, visíveis e invisíveis, num ciclo interminável de nascimento, crescimento, morte e"
				+ " renovação, que se repete desde o início dos tempos e que, se formos sábios o suficiente para entender,"
				+ " continuará por muitos milênios vindouros.";
		
		long timeStart = System.currentTimeMillis();
		Optional<List<String>> result = hierarchy.analize(longPhrase, depth);
		long timeEnd = System.currentTimeMillis();	
		long totalTime = timeEnd - timeStart;
		
		assertTrue(result.isPresent());
		assertEquals("root: 2", result.get().get(0));
		assertTrue(totalTime < 100);
	}
	
}
