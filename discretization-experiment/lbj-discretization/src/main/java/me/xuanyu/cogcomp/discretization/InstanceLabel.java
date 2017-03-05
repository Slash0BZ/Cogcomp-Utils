// Modifying this comment will cause the next execution of LBJava to overwrite this file.
// F1B88000000000000000D4E81BE028040144F7562B5DD520719A1DF0031B3B424172EA8B1F2B02778D01EFD54844DA6623F299CBBA4C660E4C315FD54942F26AC04ACDAF5BFC83A6C4E5B1E39FB07037E43886B802AC61BFC1316B5AAA19AB70B64C1658E26F14291AC8C6909B1CC64BAD2C506D63DD193A8AD1F374F12A1A2CDE8CAD5E171D91705CF48A4CC0E019FF8D750F3C6E7349FEBF115C000000

package me.xuanyu.cogcomp.discretization;

import edu.illinois.cs.cogcomp.lbjava.classify.*;
import edu.illinois.cs.cogcomp.lbjava.infer.*;
import edu.illinois.cs.cogcomp.lbjava.io.IOUtilities;
import edu.illinois.cs.cogcomp.lbjava.learn.*;
import edu.illinois.cs.cogcomp.lbjava.parse.*;
import java.lang.*;
import java.util.List;


public class InstanceLabel extends Classifier
{
  public InstanceLabel()
  {
    containingPackage = "me.xuanyu.cogcomp.discretization";
    name = "InstanceLabel";
  }

  public String getInputType() { return "java.lang.String"; }
  public String getOutputType() { return "discrete"; }

  private static String[] __allowableValues = new String[]{ "positive", "negative" };
  public static String[] getAllowableValues() { return __allowableValues; }
  public String[] allowableValues() { return __allowableValues; }


  public FeatureVector classify(Object __example)
  {
    return new FeatureVector(featureValue(__example));
  }

  public Feature featureValue(Object __example)
  {
    String result = discreteValue(__example);
    return new DiscretePrimitiveStringFeature(containingPackage, name, "", result, valueIndexOf(result), (short) allowableValues().length);
  }

  public String discreteValue(Object __example)
  {
    if (!(__example instanceof String))
    {
      String type = __example == null ? "null" : __example.getClass().getName();
      System.err.println("Classifier 'InstanceLabel(String)' defined on line 7 of RealFeatures.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    String __cachedValue = _discreteValue(__example);

    if (valueIndexOf(__cachedValue) == -1)
    {
      System.err.println("Classifier 'InstanceLabel' defined on line 7 of RealFeatures.lbj produced '" + __cachedValue  + "' as a feature value, which is not allowable.");
      System.exit(1);
    }

    return __cachedValue;
  }

  private String _discreteValue(Object __example)
  {
    String line = (String) __example;

    String[] tokens = line.split(",");
    if (tokens[tokens.length - 1].equals("1.0"))
    {
      return "positive";
    }
    else
    {
      return "negative";
    }
  }

  public FeatureVector[] classify(Object[] examples)
  {
    if (!(examples instanceof String[]))
    {
      String type = examples == null ? "null" : examples.getClass().getName();
      System.err.println("Classifier 'InstanceLabel(String)' defined on line 7 of RealFeatures.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    return super.classify(examples);
  }

  public int hashCode() { return "InstanceLabel".hashCode(); }
  public boolean equals(Object o) { return o instanceof InstanceLabel; }
}

