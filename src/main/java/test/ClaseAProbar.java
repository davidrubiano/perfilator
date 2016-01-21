package test;

import java.util.Random;

import perfilation.Perfilable;


public class ClaseAProbar implements Perfilable {

	
	public void metodoUno(){
		try {
			Thread.sleep(new Random().nextInt(3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	
	public void metodoDos(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}				
		
	}

	public void metodoTres(){
			int x=0;
			for (int i=0;i<99999999;i++){
				x=x*x;
			}
	}

	public void metodoCuatro(){
		int x=0;
		for (int i=0;i<99999999;i++){
			x=x+x;
		}		
	}


	@Override
	public String[] getTesteableMethodNames() {
		String[] res= {"metodoUno", "metodoDos"};
		return res;
	}


	@Override
	public int[] getTestCount() {
		int[] res ={2,2};
		return res;
	}


	
}
