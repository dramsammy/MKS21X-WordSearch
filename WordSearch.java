import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
    private char[][]data;
    //the random seed used to produce this WordSearch
    private int seed;

    //a random Object to unify your random calls
    private Random randgen;

    //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
    private ArrayList<String>wordsToAdd;

    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String>wordsAdded;

    public WordSearch(int rows,int cols){
      data = new char[rows][cols];
      clear();
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
        for (int a = 0; a <data[i].length; a++){
          returnValue += data[i][a] + " " ;
        }
        returnValue += "\n";
    }
    return returnValue;
  }
    public boolean addWordHorizontal(String word,int row, int col){
      int length = word.length();
      if (row >= data[0].length || col + length >= data.length){
        return false;
      }
      for (int i = 0; i < length; i++){
        if(((data[row][col+i]!=('_'))) && (data[row][col+i]!=(word.charAt(i)))) {
          return false;
      }
    }
      for(int a = 0; a < length; a++){
        data[row][col+a]=word.charAt(a);
      }
      return true;
    }
    public boolean addWordVertical(String word,int row, int col){
      int length = word.length();
      if (row + length >= data[0].length || length >= data.length){
        return false;
      }
      for (int i = 0; i < length; i++){
        if(((data[row+i][col]!=('_'))) && (data[row+i][col]!=(word.charAt(i)))) {
          return false;
      }
    }
      for(int a = 0; a < length; a++){
        data[row + a][col]=word.charAt(a);
      }
      return true;
    }
    public boolean addWordDiagonal(String word,int row, int col){
      int length = word.length();
      for (int i=0;i<length;i++)
        if (row + length >= data[i].length || col + length >= data.length){
          return false;
      }
      for (int i=0;i<length;i++) {
        if (((data[row+i][col + i]!=('_'))) && (data[row+i][col + i]!=(word.charAt(i)))) {
          return false;
          }
        }
      for (int i=0;i< length;i++) {
        data[row+i][col+i]=word.charAt(i);
        }
          return true;
      }
    public boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
      int length = word.length();
      for (int i=0;i<length;i++){
        if (row + rowIncrement + length >= data[i].length || col + colIncrement + length >= data.length){
          return false;
          }
        }
      for (int i=0;i<length;i++) {
        if (((data[row+i][col + i]!=('_'))) && (data[row+i][col + i]!=(word.charAt(i)))) { // need to fix this part of Add Word -- diagraming it
          return false;
        }
          }

    }
