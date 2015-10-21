package Interpolacao;

import java.util.ArrayList;

public class Interpolacao {

	private ArrayList<PontosDados> tabela = new ArrayList<>();//-->tabela din�mica de valores tabelados
	private double x;//-->o x que ser� calculado o fx
	private double fx;//-->fx resultado

	public Interpolacao() {

	}

	public Interpolacao(double x) {//-->construtor que atribui o valor ao atributo x
		x_Para_Calcular(x);
	}

	public void inserirPontosDados(double x, double fx) {
		//m�todo que insere os pontos dados na tabela
		tabela.add(new PontosDados(x, fx));
	}

	public void x_Para_Calcular(double x) {
		//m�todo que recebe o valor do x que ser� calculado o fx
		this.x = x;
	}

	public void CalculoDeLagrange() {
		/*M�TODO QUE REALIZA O SOMAT�RIO DOS POLIN�MIOS DE INTERPOLA��O COM O M�TODO DE LAGRANGE
		 * f(xj)Lj(x)
		 * ONDE j VARIA DE 0 A n.
		 * */
		int n = tabela.size();//-->quantidade de pontos dados na tabela de valores tabelados
		double produtorioNumeradorDeLagrange;//-->armazena o produt�rio numerador do polin�mio de Lagrange
		double produtorioDenominadorDeLagrange;//-->armazena o produt�rio denominador do polin�mio de Lagrange
		double polinomioInterpolador_j;//-->armazena o polin�mio interpolador calculado
		double somatorioDosPolinomiosInterpoladores = 0;//-->armazena o somat�rio dos polin�mios interpoladores
		double[] L = new double[n];//-->array que armazena os polin�mios de Lagrange calculados
		
		//calcular o polin�mio interpolador
		for (int j = 0; j < n; j++) {
			//primeiro calcular o numerador e denominador do polin�mio de Lagrange
			produtorioNumeradorDeLagrange = 1;//-->inicializando a vari�vel
			produtorioDenominadorDeLagrange = 1;//-->inicializando a vari�vel
			
			//for() para calcular o produt�rio numerador e o produt�rio denominador do polin�mio de Lagrange
			for (int i = 0; i < n; i++) {
				if (i == j) continue;//-->evita que os valores de x em que i = j participem do c�lculo
				produtorioNumeradorDeLagrange *= (this.x - tabela.get(i).x);//-->produt�rio(x - xi)
				produtorioDenominadorDeLagrange *= (tabela.get(j).x - tabela.get(i).x);//-->produt�rio(xj - xi)
			}
			
			//calculando o polin�mio de Lagrange
			L[j] = (produtorioNumeradorDeLagrange / produtorioDenominadorDeLagrange);//-->(produt�rio(x - xi)/produt�rio(xj - xi))

			//calculando o polin�mio interpolador
			polinomioInterpolador_j = (L[j] * tabela.get(j).fx);//-->(Lj * f(xj))
			
			//realizando o somat�rio dos polin�mios interpoladores
			somatorioDosPolinomiosInterpoladores += polinomioInterpolador_j;//-->somat�rio de (Lj * f(xj))
		}
		
		this.fx = somatorioDosPolinomiosInterpoladores;//-->atribuindo ao atributo fx o valor do somat�rio dos polin�mios interpoladores
	}

	public String getFx() {
		return "f(" + x + ") ~= " + fx;
	}

	private class PontosDados {
		/* Esta classe interna � para armazenar os pontos na tabela.
		 * funciona como um registro */
		double x;
		double fx;
		public PontosDados(double x, double fx) {
			this.x = x;
			this.fx = fx;
		}
	}
}
