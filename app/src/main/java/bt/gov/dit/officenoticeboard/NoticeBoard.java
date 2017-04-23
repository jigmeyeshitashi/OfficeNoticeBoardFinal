package bt.gov.dit.officenoticeboard;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jigme on 1/26/2017.
 */

public class NoticeBoard implements Serializable{

   private ArrayList<Notices> notices;

   public ArrayList<Notices> getNotices() {
      return notices;
   }
}
