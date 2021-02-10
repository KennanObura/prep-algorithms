package ANDELA;

import java.util.*;

/**
 *
 */
public class Clem {
    public static void main(String[] args) {

        ArrayList<Set<String>> list = new ArrayList<>();
        list.add(new HashSet<>(Collections.singletonList("gym")));
        list.add(new HashSet<>(Collections.singletonList("store")));
        list.add(new HashSet<>(Collections.singletonList("gym")));
        list.add(new HashSet<>(Collections.singletonList("school")));


    }


//    int minimumDistance(ArrayList<Set<String>> blocks, Set<String> requirements) {
//        minimumDistance(blocks, requirements, 0, new ArrayList<>());
//        return
//    }
//
//    private boolean minimumDistance(ArrayList<Set<String>> blocks, Set<String> requirements, int row, ArrayList<String> internal) {
//        if (row < 0 || row >= blocks.size())
//            return false;
//
//        if(internal.size() == requirements.size())
//            return true;
//
//        int upwords = minimumDistance(blocks, requirements, row - 1, internal) + 1;
//        int downwords = minimumDistance(blocks, requirements, row + 1, internal) + 1;
//        return upwords + downwords;
//
//    }
}
