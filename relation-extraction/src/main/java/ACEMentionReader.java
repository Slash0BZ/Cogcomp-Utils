package me.xuanyu.cogcomp.re;
import edu.illinois.cs.cogcomp.nlp.corpusreaders.ACEReader;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.*;
import edu.illinois.cs.cogcomp.core.datastructures.ViewNames;
import edu.illinois.cs.cogcomp.lbjava.parse.Parser;
import edu.illinois.cs.cogcomp.pos.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;
import java.io.*;

public class ACEMentionReader implements Parser
{
    private List<Constituent> entities;
    private int currentEntityIndex;
    public ACEMentionReader(String file) {
        entities = new ArrayList<Constituent>();
        try {
            ACEReader reader = new ACEReader(file, false);
            POSAnnotator pos_annotator = new POSAnnotator();
            for (TextAnnotation ta : reader) {
                //pos_annotator.addView(ta);
                View entityView = ta.getView(ViewNames.MENTION_ACE);
                //View posView = ta.getView(ViewNames.POS);
                System.out.println(entityView.getConstituents());
                entities.addAll(entityView.getConstituents());
            }
        }
        catch(Exception e) {}
    }

    public void close(){}
    public Object next(){
        if (currentEntityIndex == entities.size()){
            return null;
        }
        else{
            currentEntityIndex++;
            return entities.get(currentEntityIndex - 1);
        }
    }

    public void reset(){
        currentEntityIndex = 0;
    }

}
