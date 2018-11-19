import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class WordSearch{
    private char[][]data;
    //the random seed used to produce this WordSearch
    private int seed;
    //a random Object to unify your random calls
    private Random randgen;
    //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
    private ArrayList<String>wordsToAdd = new ArrayList<String>();
    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String>wordsAdded = new ArrayList<String>();
    private int columns;
    private int rows;
    private String instructions = "\nTo use this program, you must have three arguments or more. Argument[0] is the amount of rows that will be in the WordSearch. This value can not be below 0 or equal to 0. Argument[1] is the amount of columns that will be in the WordSearch. This value can not be below 0 or equal to 0. Argument[2] is the .txt file where the WordSearch will pull words from. This file can not be empty. Argument[3] is optional and is the seed of the WordSearch. This is used to recreate an original WordSearch. Argument[4] is also optional and is the answers for the WordSearch. To get the answers, please supply argument[4] with the argument answers, key, answer, answers, or true. Thank You.";
    public WordSearch(int r, int c, String fileName, int RandomSeed, String answer){
      seed = RandomSeed;
      if (r <= 0 || c <= 0 || seed <= 0 ){
        throw new IllegalArgumentException("\nRows or Cols or Seed are less than or equal to 0 - Row: "+r + " Cols: " + c + " Seed: " + RandomSeed + "\n" + instructions);
      }
      randgen = new Random(seed);
      data = new char[r][c];
      columns = c;
      rows = r;
      clear();
      addwordsfromFile(fileName);
      addAllWords();
      if (answer.equals("key")||answer.equals("true")||answer.equals("answer")||answer.equals("answers")){
      }
      else{
        fillIn();
      }
    }
    private void clear(){
      for (int i = 0; i <data.length; i++){
        for (int a = 0; a <data[i].length; a++){
          data[i][a] = '_';
    }
  }
}
    public String toString(){
      String returnValue = "";
      for (int i = 0; i <data.length; i++){
        returnValue += '|';
        for (int a = 0; a <data[i].length; a++){
          if (a == data[i].length -1){
            returnValue += data[i][a];
        }
          else {returnValue += data[i][a] + " ";
          }
      }
        returnValue += '|';
        returnValue += "\n";
    }
    String words = wordsAdded.toString();
    returnValue += "Words: " + words + "(Seed:" + Integer.toString(seed) +")";
    return returnValue;
  }
    // public boolean addWordHorizontal(String word,int row, int col){
    //   int length = word.length();
    //   if (row >= data[0].length || col + length >= data.length){
    //     return false;
    //   }
    //   for (int i = 0; i < length; i++){
    //     if(((data[row][col+i]!=('_'))) && (data[row][col+i]!=(word.charAt(i)))) {
    //       return false;
    //   }
    // }
    //   for(int a = 0; a < length; a++){
    //     data[row][col+a]=word.charAt(a);
    //   }
    //   return true;
    // }
    // public boolean addWordVertical(String word,int row, int col){
    //   int length = word.length();
    //   if (row + length >= data[0].length || length >= data.length){
    //     return false;
    //   }
    //   for (int i = 0; i < length; i++){
    //     if(((data[row+i][col]!=('_'))) && (data[row+i][col]!=(word.charAt(i)))) {
    //       return false;
    //   }
    // }
    //   for(int a = 0; a < length; a++){
    //     data[row + a][col]=word.charAt(a);
    //   }
    //   return true;
    // }
    // public boolean addWordDiagonal(String word,int row, int col){
    //   int length = word.length();
    //   for (int i=0;i<length;i++)
    //     if (row + length >= data[i].length || col + length >= data.length){
    //       return false;
    //   }
    //   for (int i=0;i<length;i++) {
    //     if (((data[row+i][col + i]!=('_'))) && (data[row+i][col + i]!=(word.charAt(i)))) {
    //       return false;
    //       }
    //     }
    //   for (int i=0;i< length;i++) {
    //     data[row+i][col+i]=word.charAt(i);
    //     }
    //       return true;
    //}
    public boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
      int length = word.length();

      if (row + (length-1) * rowIncrement  >= data.length || col + (length-1) * colIncrement  >= data[0].length){
        return false;
          }
      if (rowIncrement ==0 && colIncrement == 0){
        return false;
      }
      if (col + (length + 1) * colIncrement < 0 || row + (length + 1) * rowIncrement < 0) {
        return false;
      }
      for (int i=0;i<length;i++) {
          if (((data[row+(i*rowIncrement)][col+(i*colIncrement)]!=('_'))) && (data[row+(i*rowIncrement)][col+(i*colIncrement)]!=(word.charAt(i)))) {
            return false;
            }
          }
      for (int i=0; i<length; i++) {
        data[row+(i*rowIncrement)][col+(i*colIncrement)]=word.charAt(i);
      }
      return true;
        }
      public static void main(String[]args){
        String instruction = "\nTo use this program, you must have three arguments or more. Argument[0] is the amount of rows that will be in the WordSearch. This value can not be below 0 or equal to 0. Argument[1] is the amount of columns that will be in the WordSearch. This value can not be below 0 or equal to 0. Argument[2] is the .txt file where the WordSearch will pull words from. This file can not be empty. Argument[3] is optional and is the seed of the WordSearch. This is used to recreate an original WordSearch. Argument[4] is also optional and is the answers for the WordSearch. To get the answers, please supply argument[4] with the argument answers, key, answer, answers, or true. Thank You.";
          Random randomSeed = new Random();
          if(args.length > 2){
            String fileName = args[2];
          }
          else{
            throw new IllegalArgumentException("\nDid not recieve enough arguments" + instruction);
          }
          if (args.length == 3){
            WordSearch Words = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Math.abs(randomSeed.nextInt()) , "false");
            System.out.println(Words);
          }
          else if (args.length == 4){
            WordSearch Words = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), "false");
            System.out.println(Words);
          }
          else if (args.length == 5){
            WordSearch Words = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), (args[4]));
            System.out.println(Words);
          }

}




      private void addAllWords(){
        int counter = 0;
        String temp = "";
        int a = 0;
        while (!wordsToAdd.isEmpty() && counter < 100){
          for (int i = 0; i < wordsToAdd.size(); i++){
            temp = wordsToAdd.get(Math.abs(randgen.nextInt() % wordsToAdd.size()));
            if(addWord(temp,Math.abs(randgen.nextInt()%rows), Math.abs(randgen.nextInt()%columns), Math.abs(randgen.nextInt()%2),  Math.abs(randgen.nextInt()%2))){
              wordsAdded.add(temp);
              wordsToAdd.remove(temp);
            }
            counter++;
          }
        }
      }
      public void addwordsfromFile(String fileName){
        try{
          File f = new File(fileName);
          Scanner in = new Scanner(f);
          while(in.hasNext()){
            wordsToAdd.add((in.nextLine()).toUpperCase());
          }
        }catch(FileNotFoundException e){
          System.out.println("\nFile not found: " + fileName + instructions);
          System.exit(1);
        }
      }

      private void fillIn(){
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < data.length; i++){
          for (int a = 0; a < data[0].length; a++){
            if (data[i][a] == '_'){
              data[i][a] = letters.charAt(Math.abs(randgen.nextInt() % 26));
            }
          }
        }
      }
    }
