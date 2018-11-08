public class WordSearch{
    private char[][]data;

    public WordSearch(int rows,int cols){
      data = new char[rows][cols];
      for (int i = 0; i <data.length; i++){
        for (int a = 0; a <data[i].length; a++){
          data[i][a] = '_';
        }
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
      for(int i = 0; i < length; i++){
        data[row][col+i]=word.charAt(i);
      }
      return true;
    }
    public boolean addWordVertical(String word,int row, int col){
      int length = word.length();
      if (row + length >= data[0].length || length >= data.length){
        return false;
      }
      for(int i = 0; i < length; i++){
        data[row + i][col]=word.charAt(i);
      }
      return true;
    }
}
