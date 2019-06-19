/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaexample;

/**
 *
 * @author oswah8770
 */
public class Chromosome implements Comparable{
    // ten numbers, looking for answer 0123456789
    private int[] genes = new int[10];
    private int[] answers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int targetFitness = 100;
    
    
    // initialize, random genes
    public void initial(){
        for(int i = 0; i < this.genes.length; i++){
            this.genes[i] = (int)(Math.random()* 9);
        }       
    }
    

    
    // fitness
    public int fitness(){
        int fitness = 0;
        for(int i = 0; i < this.genes.length; i++){
            if(this.genes[i] == this.answers[i]){
                fitness = fitness + 10;
            } else {
                int distance = Math.abs(this.genes[i] - this.answers[i]);
                fitness = fitness - (distance);
            }
        }
        return fitness;
    }
    
    // return gene at position
    public int gene(int position){
        return this.genes[position];
    }
    
    // set the gene value (used in breeding)
    public void setGene(int position, int gene){
        this.genes[position] = gene;
    }
    
    // return the genes
    public int[] arrayOfGenes(){
        return this.genes;
    }
    
    // return the fitness variable
    public int returnFitness(){
        return this.fitness();
    }
    
    // get target fitness
    public int getTargetFit(){
        return this.targetFitness;
    }
    
    // print out the genes in one single line
    public void printGenes(){
        for(int i = 0; i < this.genes.length; i++){
            System.out.print(this.genes[i]);
        }
        System.out.print(" Fitness: " + returnFitness());
        System.out.println("");
    }

    @Override
    public int compareTo(Object t) {
        int otherFitness = ((Chromosome)t).returnFitness();
        int diff = this.returnFitness() - otherFitness;
        return diff;
        
    }
}
