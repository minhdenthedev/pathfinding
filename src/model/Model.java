package model;
import Dijkstra.Path;

import java.util.ArrayList;

public class Model {
    private String ketquaFF;
    private String ketquaDT;
    public Model(){
        this.ketquaDT = "";
        this.ketquaFF = "";
    }
    public String getKetquaFF ( ) {
        return ketquaFF;
    }

    public void setKetquaFF ( String ketquaFF ) {
        this.ketquaFF = ketquaFF;
    }

    public String getKetquaDT ( ) {
        return ketquaDT;
    }

    public void setKetquaDT ( String ketquaDT ) {
        this.ketquaDT = ketquaDT;
    }
    public String[] findFFs(){
        Path path = new Path("F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv");
//        return path.shortestPath(start, end);
        return null;
    }
    public void findFF (String start, String end ){
        ArrayList <String> paths = findDTs (start,end);
        String path = "";
        for(int i = 0; i< paths.size ();i++){
            path+=path.charAt ( i )+" ";
        }
        this.setKetquaFF ( path );
        this.ketquaFF = path;
        System.out.print(this.ketquaFF);
    }

    public ArrayList <String> findDTs(String start, String end){
        Path path = new Path("F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv");
        System.out.println(start+" "+end);
        return path.shortestPath(start, end);
    }

    public void findDT ( String start, String end){
        ArrayList <String> paths = findDTs (start,end);
        String path = "";
        for(int i = 0; i< paths.size ();i++){
            path+=path.charAt ( i )+" ";
        }
        this.setKetquaDT ( path );
        this.ketquaDT = path;
        System.out.print(this.ketquaDT);
    }
}

