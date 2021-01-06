package de.crowraw.morph.util;

import java.util.HashMap;

public class MorphRepo {
    private  final static HashMap<String, MorphUtil> isMorphed = new HashMap<>();

public static void morph(String playerName,MorphUtil morphUtil){

    if(isMorphed.get(playerName)==null){
        isMorphed.put(playerName,morphUtil);
    }else {
        isMorphed.get(playerName).killTask();
        isMorphed.put(playerName,morphUtil);
    }

}



}
