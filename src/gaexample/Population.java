/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaexample;

import java.util.Arrays;

/**
 *
 * @author oswah8770
 */
public class Population {

    // the population
    private Chromosome[] pop = new Chromosome[10];

    public void popInitial() {
        for (int i = 0; i < pop.length; i++) {
            pop[i] = new Chromosome();

        }
        for (Chromosome pop1 : this.pop) {

            pop1.initial();
        }
    }

    // check the highest fitness chromosome and use it to create the next generation
    public Chromosome highestFit() {
        boolean highest = false;
        for (int i = 0; i < this.pop.length; i++) {
            for (int z = 0; z < this.pop.length; z++) {
                if (this.pop[i].fitness() > this.pop[z].fitness()) {
                    highest = true;
                } else if (this.pop[i].fitness() == this.pop[z].fitness()) {
                    highest = true;
                } else {
                    highest = false;
                    break;
                }
            }
            if (highest == true) {
                return this.pop[i];
            }
        }
        System.out.println("No highest fitness was found");
        return null;
    }

    // sort the chromosomes by their fitness
    public void sort() {
        Arrays.sort(this.pop);
    }

    // BREEDING
    // combine half of one chromosome with half of another to create children
    // two children for each pair of parents
    // top 5 fitnesses breed
    // throw away the bottom 5 of the generation
    // replace with children with two (random) parents that are the top 50%
    public Chromosome breeding(Chromosome a, Chromosome b, int index) {
        // create the first child
        Chromosome child1 = new Chromosome();
        for (int i = 0; i < index; i++) {
            child1.setGene(i, a.gene(i));

        }
        for (int i = b.arrayOfGenes().length - 1; i >= index; i--) {
            child1.setGene(i, b.gene(i));
        }

        // create the second child
        Chromosome child2 = new Chromosome();
        for (int i = 0; i < index; i++) {
            child2.setGene(i, b.gene(i));
        }
        for (int i = a.arrayOfGenes().length - 1; i >= index; i--) {
            child2.setGene(i, a.gene(i));
        }

        // return the best child
        if (child1.returnFitness() >= child2.returnFitness()) {
            if((int)(Math.random()*100) <= 25){
                // mutation (25% chance)
                child1.setGene((int)(Math.random()*10), (int)(Math.random()*10));
            }
            return child1;
        } else {
            if((int)(Math.random()*100) <= 25){
                // mutation (25% chance)
                child2.setGene((int)(Math.random()*10), (int)(Math.random()*10));
            }
            return child2;
        }

    }
    
    // tournament selection method
    public void tournament(){
        // tournament size, k
        // select k individuals, take the best one
        // repeat until you have the amount of individuals you want (k size)
        
        Chromosome[] tempPop = new Chromosome[10];
        
        for(int i = 9; i > 4; i--){
            int randomNum1 = (int)(Math.random()*10);
            int randomNum2 = (int)(Math.random()*10);
            if(this.pop[randomNum1].returnFitness() >= this.pop[randomNum2].returnFitness()){
                tempPop[i] = this.pop[randomNum1];
            } else {
                tempPop[i] = this.pop[randomNum2];
            }
            
        }
        
        //breeding time
        Chromosome newC1 = breeding(tempPop[(int)(Math.random()*5 + 5)], tempPop[(int)(Math.random()*5 + 5)], (int)(Math.random()*10));
        Chromosome newC2 = breeding(tempPop[(int)(Math.random()*5 + 5)], tempPop[(int)(Math.random()*5 + 5)], (int)(Math.random()*10));
        Chromosome newC3 = breeding(tempPop[(int)(Math.random()*5 + 5)], tempPop[(int)(Math.random()*5 + 5)], (int)(Math.random()*10));
        Chromosome newC4 = breeding(tempPop[(int)(Math.random()*5 + 5)], tempPop[(int)(Math.random()*5 + 5)], (int)(Math.random()*10));
        Chromosome newC5 = breeding(tempPop[(int)(Math.random()*5 + 5)], tempPop[(int)(Math.random()*5 + 5)], (int)(Math.random()*10));
        
        tempPop[0] = newC1;
        tempPop[1] = newC2;
        tempPop[2] = newC3;
        tempPop[3] = newC4;
        tempPop[4] = newC5;
        
        this.pop = tempPop;
    
    }

    // return all the fitnesses to make sure you have the right highest
    // HIGHEST WORKS!!!!!!!!!!!!!!!!!
    public int[] allFitness() {
        int[] allFitness = new int[this.pop.length];
        int i = 0;
        for (Chromosome chr1 : this.pop) {
            allFitness[i] = chr1.fitness();
            i++;
        }
        return allFitness;
    }

    public int[] getFitnesses() {
        return this.allFitness();
    }

    public Chromosome[] getChromo() {
        return this.pop;
    }

    // set the chromosome to new children
    public void setChromosome(Chromosome child, int position) {
        this.pop[position] = child;
    }

}
