package Interpolacao;

import java.util.ArrayList;

public class Interpolacao {

	private ArrayList<PontosDados> tabela = new ArrayList<>();//-->tabela dinâmica de valores tabelados
	private double x;//-->o x que será calculado o fx
	private double fx;//-->fx resultado

	public Interpolacao() {

	}

	public Interpolacao(double x) {//-->construtor que atribui o valor ao atributo x
		x_Para_Calcular(x);
	}

	public void inserirPontosDados(double x, double fx) {
		//método que insere os pontos dados na tabela
		tabela.add(new PontosDados(x, fx));
	}

	public void x_Para_Calcular(double x) {
		//método que recebe o valor do x que será calculado o fx
		this.x = x;
	}

	public void CalculoDeLagrange() {
		/*MÉTODO QUE REALIZA O SOMATÓRIO DOS POLINÔMIOS DE INTERPOLAÇÃO COM O MÉTODO DE LAGRANGE
		 * f(xj)Lj(x)
		 * ONDE j VARIA DE 0 A n.
		 * */
		int n = tabela.size();//-->quantidade de pontos dados na tabela de valores tabelados
		double produtorioNumeradorDeLagrange;//-->armazena o produtório numerador do polinômio de Lagrange
		double produtorioDenominadorDeLagrange;//-->armazena o produtório denominador do polinômio de Lagrange
		double polinomioInterpolador_j;//-->armazena o polinômio interpolador calculado
		double somatorioDosPolinomiosInterpoladores = 0;//-->armazena o somatório dos polinômios interpoladores
		double[] L = new double[n];//-->array que armazena os polinômios de Lagrange calculados
		
		//calcular o polinômio interpolador
		for (int j = 0; j < n; j++) {
			//primeiro calcular o numerador e denominador do polinômio de Lagrange
			produtorioNumeradorDeLagrange = 1;//-->inicializando a variável
			produtorioDenominadorDeLagrange = 1;//-->inicializando a variável
			
			//for() para calcular o produtório numerador e o produtório denominador do polinômio de Lagrange
			for (int i = 0; i < n; i++) {
				if (i == j) continue;//-->evita que os valores de x em que i = j participem do cálculo
				produtorioNumeradorDeLagrange *= (this.x - tabela.get(i).x);//-->produtório(x - xi)
				produtorioDenominadorDeLagrange *= (tabela.get(j).x - tabela.get(i).x);//-->produtório(xj - xi)
			}
			
			//calculando o polinômio de Lagrange
			L[j] = (produtorioNumeradorDeLagrange / produtorioDenominadorDeLagrange);//-->(produtório(x - xi)/produtório(xj - xi))

			//calculando o polinômio interpolador
			polinomioInterpolador_j = (L[j] * tabela.get(j).fx);//-->(Lj * f(xj))
			
			//realizando o somatório dos polinômios interpoladores
			somatorioDosPolinomiosInterpoladores += polinomioInterpolador_j;//-->somatório de (Lj * f(xj))
		}
		
		this.fx = somatorioDosPolinomiosInterpoladores;//-->atribuindo ao atributo fx o valor do somatório dos polinômios interpoladores
	}

	public String getFx() {
		return "f(" + x + ") ~= " + fx;
	}

	private class PontosDados {
		/* Esta classe interna é para armazenar os pontos na tabela.
		 * funciona como um registro */
		double x;
		double fx;
		public PontosDados(double x, double fx) {
			this.x = x;
			this.fx = fx;
		}
	}
}
