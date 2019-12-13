package Project92.Project92;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import junit.framework.TestCase;

public class Avaliacao_FerramentasTest extends TestCase {
	
	String ferramenta = new String("");
 	boolean aux;
 	ArrayList<Boolean> list;

	public void testDci() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();
		int output1 = af.dci("iPlasma");
 		int output2 = af.dci("pmd");
 		assertNotEquals(0, output1);
 		assertNotEquals(0, output2);
	}

	public void testCustomized_dci() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();  
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		for(int i=0;i<419;i++) {
			if(i==7) {
				list.add(false);
			}
			else if(i==15) {
				list.add(false);
			}
			else {
			list.add(true);
			}
			
		}
		int output1 = af.customized_dci(list, "long");  
		int output2 = af.customized_dci(list, "envy");
		int output3 = af.customized_dci(list, "random");
		assertNotEquals(0, output1);
		assertNotEquals(0, output2);
		assertEquals(0, output3);
		
	}

	public void testCustomized_dii() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();  
		ArrayList<Boolean> list = new ArrayList<Boolean>();  
		for(int i=0;i<419;i++) {
			if(i==7) {
				list.add(false);
			}
			else if(i==15) {
				list.add(false);
			}
			else {
			list.add(true);
			}	
		}
		int output1 = af.customized_dii(list, "long");  
		int output2 = af.customized_dii(list, "envy");
		int output3 = af.customized_dii(list, "random");
		assertNotEquals(0, output1);
		assertNotEquals(0, output2);
		assertEquals(0, output3);
	}

	public void testCustomized_adci() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();  
		ArrayList<Boolean> list = new ArrayList<Boolean>();  
		for(int i=0;i<419;i++) {
			 if(i==22) {
				list.add(true);  
			}
			else {
			list.add(false);  
			}	
		}
		int output1 = af.customized_adci(list, "long");    
		int output2 = af.customized_adci(list, "envy");
		int output3 = af.customized_adci(list, "random");  
		assertNotEquals(0, output1);
		assertNotEquals(0, output2);
		assertEquals(0, output3);
	}

	public void testCustomized_adii() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();  
		ArrayList<Boolean> list = new ArrayList<Boolean>();  
		for(int i=0;i<419;i++) {
			 if(i==22) {
				list.add(true);    
			}
			else {
			list.add(false);    
			}	
		}
		int output1 = af.customized_adii(list, "long");    
		int output2 = af.customized_adii(list, "envy");  
		int output3 = af.customized_adii(list, "random");  
		assertNotEquals(0, output1);
		assertNotEquals(0, output2);
		assertEquals(0, output3);
		
	}

	public void testNormal_search() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();
		//-----------------LONG--------------------------------------------------------------------
		
		
		ArrayList<Boolean> output1 = af.normal_search("long","<" , 10,"<", 10);
		ArrayList<Boolean> output2 = af.normal_search("long",">" , 10,">", 10);
		ArrayList<Boolean> output3 = af.normal_search("long",">" , 10,"<", 10);
		ArrayList<Boolean> output4 = af.normal_search("long","<" , 10,">", 10);
		
		
		ArrayList<Boolean> output1_out_met = af.normal_search("random","<" , 10,"<", 10);
		
		
		boolean output1_1= output1.get(0);
		assertEquals(true, output1_1);
		//out do output2-----------------------------------------------------------------
		ArrayList<Boolean> output2_out = af.normal_search("long",">" , 0,">", 100);
		//------------------------------------------------------------------------------
		
		//out do output 3-------------------------------------------------------------------
		ArrayList<Boolean> output3_out = af.normal_search("long",">" , 0,"<", 100);
		
		//FIM DO PRIMEIRO CASO----------------------------------------------------------------------------------
		
		ArrayList<Boolean> output5 = af.normal_search("envy","<" , 10,"<", 10);
		ArrayList<Boolean> output6 = af.normal_search("envy",">" , 10,">", 10);
		ArrayList<Boolean> output7 = af.normal_search("envy",">" , 10,"<", 10);
		ArrayList<Boolean> output8 = af.normal_search("envy","<" , 10,">", 10);
		
		boolean output5_1= output1.get(0);  
		assertEquals(true, output5_1);
		
		//out do output 6---------------------------------------------------------------------------
		ArrayList<Boolean> output6_out = af.normal_search("envy",">" , 0,">", 0);
		//------------------------------------------------------------------------------
		
		//out do output 8------------------------------------------------------------------
		ArrayList<Boolean> output8_out = af.normal_search("envy","<" , 100,">", 0);
		//-------------------------------------------------------------------------
		
		
		//out do output 5------------------------------------------------------------
		ArrayList<Boolean> output5_out = af.normal_search("envy","<" , 10,"<", 0.9);  
		//-----------------------------------------------------------------

	   //out do output 7-----------------------------------------------------
		ArrayList<Boolean> output7_out = af.normal_search("envy",">" , 1,"<", 0.9);
		//----------------------------------------------------------------
	
	}
	
	  
	public void testAdvance_search() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();
		//AND------------------------------------------------------------------------------------
		ArrayList<Boolean> output1 = af.Advance_search("CYCLO", "<", 10, "LAA", "<", 10, "AND");
		ArrayList<Boolean> output2 = af.Advance_search("CYCLO", ">", 10, "LAA", ">", 10, "AND");  
		ArrayList<Boolean> output3 = af.Advance_search("CYCLO", "<", 10, "LAA", ">", 10, "AND");
		ArrayList<Boolean> output4 = af.Advance_search("CYCLO", ">", 10, "LAA", "<", 10, "AND");
		ArrayList<Boolean> output1_1 = af.Advance_search("LAA", "<", 10, "CYCLO", "<", 10, "AND");
		ArrayList<Boolean> output2_1 = af.Advance_search("LAA", ">", 10, "CYCLO", ">", 10, "AND");
		ArrayList<Boolean> output3_1 = af.Advance_search("LAA", "<", 10, "CYCLO", ">", 10, "AND");
		ArrayList<Boolean> output4_1 = af.Advance_search("LAA", ">", 10, "CYCLO", "<", 10, "AND");
		ArrayList<Boolean> output_ou_ope = af.Advance_search("CYCLO", "<", 10, "LOC", "<", 10, "random");  
		ArrayList<Boolean> output_out_met = af.Advance_search("random", "<", 10, "random", "<", 10, "random");
		
		//out do output2-------------------------------------------------------------------------------
		ArrayList<Boolean> output2_out = af.Advance_search("CYCLO", ">", 0, "LAA", ">", 0, "AND");
		//---------------------------------------------------------------------------------
		
		
		//out do output4---------------------------------------------------------------------
		ArrayList<Boolean> output4_out = af.Advance_search("CYCLO", ">", 0, "LAA", "<", 0, "AND");
		//--------------------------------------------------------------------------------
	
		ArrayList<Boolean> output5 = af.Advance_search("CYCLO", "<", 10, "LAA", "<", 10, "OR");  
		ArrayList<Boolean> output6 = af.Advance_search("CYCLO", ">", 10, "LAA", ">", 10, "OR");  
		ArrayList<Boolean> output7 = af.Advance_search("CYCLO", "<", 10, "LAA", ">", 10, "OR");
		ArrayList<Boolean> output8 = af.Advance_search("CYCLO", ">", 10, "LAA", "<", 10, "OR");
		ArrayList<Boolean> output5_1 = af.Advance_search("LAA", "<", 10, "CYCLO", "<", 10, "OR");
		ArrayList<Boolean> output6_1 = af.Advance_search("LAA", ">", 10, "CYCLO", ">", 10, "OR");
		ArrayList<Boolean> output7_1 = af.Advance_search("LAA", "<", 10, "CYCLO", ">", 10, "OR");
		ArrayList<Boolean> output8_1 = af.Advance_search("LAA", ">", 10, "CYCLO", "<", 10, "OR");  
		
		//out do output5--------------------------------------------------------------------------------
		ArrayList<Boolean> output5_out = af.Advance_search("CYCLO", "<", 0, "LAA", "<", 0, "OR");
		//-----------------------------------------------------------------------------------------
	    
	
		//out do output7----------------------------------------------------------------------------------
		ArrayList<Boolean> output7_out = af.Advance_search("CYCLO", "<", 0, "LAA", ">", 0, "OR");
		//------------------------------------------------------------------------------------------
	
	    
		//out do output8------------------------------------------------------------------------------
		ArrayList<Boolean> output8_out = af.Advance_search("LAA", ">", 0, "CYCLO", "<", 0, "OR");
		//---------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	}  

	public void testDii() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();
		int output1 = af.dii("iPlasma");
		int output2 = af.dii("pmd");
		assertEquals(0, output1);
		assertNotEquals(0, output2);
	}

	public void testAdci() {
		ferramenta = "iPlasma";
 		assertNotNull(Avaliacao_Ferramentas.adci(ferramenta));
 		ferramenta = "PMD";
 		assertNotNull(Avaliacao_Ferramentas.adci(ferramenta));
	}

	public void testAdii() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();
		int output1 = af.adii("iPlasma");
 		int output2 = af.adii("pmd");
 		assertEquals(0, output1);
 		assertEquals(0, output2);
	}

}
