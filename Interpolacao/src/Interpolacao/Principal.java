package Interpolacao;

public class Principal {

	private static Interpolacao interpolacao;

	public static void main(String[] args) {
		exemplo1();//exercício 6 da pag 54. Gabarito: resultado aproximado = 17,6765
		exemplo2();//exemplo da página 38, resultado aproximado na pag 40 = 6,046875
		exemplo3();//exercício 5 da pag 53. Gabarito: resultado = -2,5
	}

	private static void exemplo1() {//exercício 6 da pag 54. Gabarito: resultado aproximado = 17,6765 
		//neste exemplo estou passando por parâmetro do construtor o valor do x que será calculado o fx
		interpolacao = new Interpolacao(0.3);
		
		//carregando a tabela de pontos dados
		interpolacao.inserirPontosDados(-8, 4);
		interpolacao.inserirPontosDados(-4, 9);
		interpolacao.inserirPontosDados(0, 16);
		interpolacao.inserirPontosDados(4, 39);
		interpolacao.inserirPontosDados(8, 14);
		
		//chamando o calculo de Lagrange
		interpolacao.CalculoDeLagrange();
		
		//exibindo o resultado
		System.out.println("Exemplo 1: " + interpolacao.getFx());
	}

	private static void exemplo2() {//exemplo da página 38, resultado aproximado na pag 40 = 6,046875
		//Instanciando um novo objeto Interpolacao
		interpolacao = new Interpolacao();
		
		//carregando a tabela de pontos dados
		interpolacao.inserirPontosDados(-1, 2);
		interpolacao.inserirPontosDados(1, 4);
		interpolacao.inserirPontosDados(2, 6);
		interpolacao.inserirPontosDados(3, 5);
		
		//inserindo na instância interpolacao pelo método x_Para_Calcular(double x) o valor do x que será calculado o fx
		interpolacao.x_Para_Calcular(2.5);
		
		//chamando o calculo de Lagrange
		interpolacao.CalculoDeLagrange();
		
		//exibindo o resultado
		System.out.println("Exemplo 2: " + interpolacao.getFx());
	}
	private static void exemplo3() {//exercício 5 da pag 53. Gabarito: resultado = -2,5
		interpolacao = new Interpolacao(3);
		interpolacao.inserirPontosDados(2, -2);
		interpolacao.inserirPontosDados(4, -1);
		interpolacao.inserirPontosDados(5, 1);
		interpolacao.inserirPontosDados(6, 2);
		interpolacao.CalculoDeLagrange();
		System.out.println("Exemplo 3: " + interpolacao.getFx());
	}
}
