package com.test.Locations;

import com.test.units.Unit;

class StoryItem {
    private String story;
    private String story2;
    private String storyAfter;
    private Unit unit;
    private int history;


     StoryItem (String story, String story2, Unit unit, String story3, int history) {
         this.story = story;
         this.story2 = story2;
         this.storyAfter = story3;
         this.unit = unit;
         this.history = history;
     }

}
