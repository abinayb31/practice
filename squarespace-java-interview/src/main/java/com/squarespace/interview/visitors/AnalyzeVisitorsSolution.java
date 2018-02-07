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
    // @ToDo Implement this routine.
    long[] countingVisitors = new long[3];
    long visitors = 0;
    long unique_visitors = 0;
    long sessions = 0;
    Map<String, Long> allSessions = new HashMap<>();
    for(WebsiteVisit websiteVisit : websiteVisits){
      visitors++;
      if(allSessions.containsKey(websiteVisit.getVisitorId())){
        if(checkNewSession(allSessions.get(websiteVisit.getVisitorId()),websiteVisit.getTimestamp())){
          sessions++;
        }
      } else {
        sessions++;
        unique_visitors++;
      }
      allSessions.put(websiteVisit.getVisitorId(), websiteVisit.getTimestamp());
    }
    countingVisitors[0] = visitors;
    countingVisitors[1] = unique_visitors;
    countingVisitors[2] = sessions;
    return countingVisitors;
  }

  public static boolean checkNewSession(long existingSessionTime, long newTime){
    long timeDiffrence =  newTime - existingSessionTime;
    if(timeDiffrence<0){
      timeDiffrence = -1*timeDiffrence;
    }
    if(timeDiffrence > 30*60){
      return true;
    }
    return false;
  }


}
