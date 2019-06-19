/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaexample;

/**
 *
 * @author Oswah8770
 */
public class testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Population pop = new Population();
        
        int generation = 1;
        boolean answerFound = false;
        
        // initialize values
        pop.popInitial();
        
        Chromosome[] allChromo = pop.getChromo();
            
        while(answerFound == false){
            

            // sort and attempt breeding?
            pop.sort();
            
            // check to see if the answer is in the population
            for(Chromosome chr : pop.getChromo()){
                if(chr.returnFitness() ==  chr.getTargetFit()){
                    System.out.println("");
                    System.out.println("Answer found! Generation: " + generation);
                    answerFound = true;
                }
            }
            
            // print out the generation
            System.out.println("");
            System.out.println("Generation " + generation + ":");
            for (Chromosome chromo : pop.getChromo()) {
                chromo.printGenes();
            }

            // breeding through tournament
            pop.tournament();
            
            
            generation++;
        }
        
        
        
        
        
        
        
    }
    
}
