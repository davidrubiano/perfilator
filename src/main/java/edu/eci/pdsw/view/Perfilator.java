/*
 * Copyright (C) 2016 David Rubiano Ruiz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import test.ClaseAProbar;

public class Perfilator {

    @SuppressWarnings("unchecked")
	public static void main(String a[]){
        try {
			@SuppressWarnings("rawtypes")
			Class test = Class.forName(a[0]);
			for(int i=0; i<test.getInterfaces().length;i++){
				if(test.getInterfaces().length != 0){
					//comprueba interface
					if(test.getInterfaces()[i].toString().contains("Perfilable")){
						System.out.println("Implementa la interface ");
					}
				}
				else System.out.println("No implementa la interface ");
			}
			//Inicializar clase a probar, obtener nombre de metodos perfilables y numero de veces a correr
			ClaseAProbar perfil = new ClaseAProbar();
			String[] nmetds;
			int[] vmetds;
			nmetds =perfil.getTesteableMethodNames();
			vmetds = perfil.getTestCount();
			long time_start, time_end;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] {};
			Method[] meths = new Method[10] ;
			for(int i=0;i<nmetds.length;i++){
				//invocar metodos y tomar tiempo de ejecucion
				try {
					meths[i]=test.getMethod(nmetds[i], types);
					System.out.println("Metodo a probar " + meths[i] );
					try {
						for(int j=0;j<vmetds[i];j++){
						time_start = System.currentTimeMillis();
						meths[i].invoke(perfil);
						time_end = System.currentTimeMillis();
						System.out.println("El metodo " + nmetds[i] + " duro en ejecucion: "+ (time_end-time_start)+ "ms durante su "+ (i+1) + " ejecución");
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
    
}
