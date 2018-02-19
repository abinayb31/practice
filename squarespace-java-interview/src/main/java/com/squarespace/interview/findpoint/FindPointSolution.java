package com.squarespace.interview.findpoint;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class FindPointSolution {
  /**
   * Given a root {@link com.squarespace.interview.findpoint.Node} of a view hierarchy, provide an ordered
   * list of {@link Node#id} representing the path through the hierarchy where the given {@link java.awt.Point}
   * can be located.
   *
   * @param rootNode Top-level node of the view hierarchy.
   * @param toFind An x,y coordinate to be located.
   * @return An ordered rdered list of {@link Node#id}
   */

  @SuppressWarnings("UnusedParameters")
  static List<String> nodesList;
  static int parentX1,parentY1;
  public static List<String> findPathToNode(Node rootNode, Point toFind) {
    nodesList = new ArrayList<>();
    parentX1 = 0;
    parentY1 = 0;
    return checkNodeOfPoint(rootNode,toFind);
  }

  public static List<String> checkNodeOfPoint(Node rootNode, Point toFind){
    Node childNode;
    Node insideNode = null;
    if(isInside(rootNode,toFind)){
      nodesList.add(rootNode.getId());
      parentX1 +=  rootNode.getLeft();
      parentY1 +=  rootNode.getTop();
      if(rootNode.getChildren().size()>0){
        for(int i = 0;i<rootNode.getChildren().size();i++){
            childNode = rootNode.getChildren().get(i);
            if(isInside(childNode,toFind)){
              insideNode = childNode;
            }
          }

        if(insideNode != null){
          checkNodeOfPoint(insideNode,toFind);
        }
      }
    }
    return nodesList;
  }

  public static boolean isInside(Node currentNode, Point toFind){
    return ((parentX1+currentNode.getLeft()<=toFind.getX()&& toFind.getX()<parentX1+currentNode.getLeft()+currentNode.getWidth()) && (parentY1+currentNode.getTop()<=toFind.getY() && toFind.getY()<parentY1+currentNode.getTop()+currentNode.getHeight()));
  }
}
