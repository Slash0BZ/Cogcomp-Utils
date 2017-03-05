// Modifying this comment will cause the next execution of LBJava to overwrite this file.
// F1B8800000000000000052C814A02C034144FA23414848AD2AB5357BE50ABC2D588E85F369FD29CFEA4A7773895D0CB7F897A4A744A1F08B1FE6B546F437DB541D903B82D3AB60F54123C80B5E345C5FFEAD4BEC26EAA365E30E5B4483153846B7A097AB217B33572B73A1C933DAB6F9FE21531B8E1464C50617360CE8DF706F559F7109000000

package me.xuanyu.cogcomp.discretization;

import edu.illinois.cs.cogcomp.lbjava.classify.*;
import edu.illinois.cs.cogcomp.lbjava.infer.*;
import edu.illinois.cs.cogcomp.lbjava.io.IOUtilities;
import edu.illinois.cs.cogcomp.lbjava.learn.*;
import edu.illinois.cs.cogcomp.lbjava.parse.*;
import java.lang.*;
import java.util.List;


public class FeatureSet extends Classifier
{
  public FeatureSet()
  {
    containingPackage = "me.xuanyu.cogcomp.discretization";
    name = "FeatureSet";
  }

  public String getInputType() { return "java.lang.String"; }
  public String getOutputType() { return "discrete%"; }

  public FeatureVector classify(Object __example)
  {
    if (!(__example instanceof String))
    {
      String type = __example == null ? "null" : __example.getClass().getName();
      System.err.println("Classifier 'FeatureSet(String)' defined on line 17 of RealFeatures.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    String line = (String) __example;

    FeatureVector __result;
    __result = new FeatureVector();
    String __id;
    String __value;

    String[] token = line.split(",");
    for (int i = 0; i < token.length - 1; i++)
    {
      __id = "" + (token[i]);
      __value = "true";
      __result.addFeature(new DiscretePrimitiveStringFeature(this.containingPackage, this.name, __id, __value, valueIndexOf(__value), (short) 0));
    }
    return __result;
  }

  public FeatureVector[] classify(Object[] examples)
  {
    if (!(examples instanceof String[]))
    {
      String type = examples == null ? "null" : examples.getClass().getName();
      System.err.println("Classifier 'FeatureSet(String)' defined on line 17 of RealFeatures.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    return super.classify(examples);
  }

  public int hashCode() { return "FeatureSet".hashCode(); }
  public boolean equals(Object o) { return o instanceof FeatureSet; }
}

