package com.squarespace.interview.visitors;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class AnalyzeVisitorsSolution {

  /**
   * Given a {@link Iterable} of website hit data modeled as {@link WebsiteVisit} analyze it and return the
   * resulting page views, unique visitors, and sessions.
   *
   * @param websiteVisits Input hit data.
   * @return A 3-element array of long corresponding to 0: page views, 1: unique visitors, 2: view sessions
   */
  @SuppressWarnings("UnusedParameters")
  static long[] processPageViews(Iterable<WebsiteVisit> websiteVisits) {
    long[] countingVisitors = new long[3];
    Map<String, Long> allUsers = new HashMap<>();
    websiteVisits.forEach(websiteVisit -> {
      countingVisitors[0]++;
      if(allUsers.containsKey(websiteVisit.getVisitorId())){
        if(checkNewSession(allUsers.get(websiteVisit.getVisitorId()),websiteVisit.getTimestamp())){
          countingVisitors[2]++;
        }
      } else {
        countingVisitors[2]++;
        countingVisitors[1]++;
      }
      allUsers.put(websiteVisit.getVisitorId(), websiteVisit.getTimestamp());
    });
    return countingVisitors;
  }

  public static boolean checkNewSession(long existingSessionTime, long newTime){
    return newTime - existingSessionTime > 30*60;
  }


}
