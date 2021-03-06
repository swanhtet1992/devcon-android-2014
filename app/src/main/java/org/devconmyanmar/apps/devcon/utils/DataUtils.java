package org.devconmyanmar.apps.devcon.utils;

import android.content.Context;
import io.realm.Realm;
import org.devconmyanmar.apps.devcon.R;
import org.devconmyanmar.apps.devcon.model.Speaker;
import org.devconmyanmar.apps.devcon.model.Talk;

/**
 * Created by Ye Lin Aung on 14/10/14.
 */
public class DataUtils {

  private Context mContext;

  public DataUtils(Context context) {
    this.mContext = context;
  }

  public void createFake() {

    // Empty first
    Realm.deleteRealmFile(mContext);

    String[] myFakeSpeakers = new String[] {
        "John Graham-Cumming",
        "Paul Graham",
        "Adora Cheung",
        "Peter Thiel",
        "Alex Schultz",
        "Kevin Hale",
        "Walker Williams",
        "Justin Kan",
        "Marc Andreessen",
        "Aaron Levie",
        "Brad Fitzpatrick",
        "Jeremy Saenz",
        "Andrew Gerrand",
        "Keith Rarick",
        "Blake Mizerany"
    };

    String[] myFakeSpeakersTitle = new String[] {
        "Programmer at CloudFlare, Author of The Geek Atlas",
        "Founder, Y Combinator",
        "Founder, Homejoy",
        "Founder, Paypal, Founder, Palantir, and Founder, Founders Fund",
        "VP Growth, Facebook",
        "Founder, Wufoo and Partner, Y Combinator",
        "Founder, Teespring",
        "Founder, TwitchTV and Partner, Y Combinator",
        "Founder, Andreessen Horowitz and Founder, Netscape",
        "Founder, Box",
        "Creator of memcached, OpenID & LiveJournal\n" + "Member of the Go team",
        "Creator of Martini and Negroni", "Member of the Go team",
        "Member of the Go team",
        "Creator of godep, Beanstalkd and Doozer\n" + "Former programmer at Heroku",
        "Creator of Sinatra, co-creator of Doozer"
    };

    String[] myFakeTalkTitles = new String[] {
        "The greatest machine that never was",
        "Before the Startup",
        "Building Product, Talking to Users, and Growing",
        "Business Strategy and Monopoly Theory",
        "Growth",
        "How to Build Products Users Love, Part I",
        "Doing Things That Don't Scale",
        "PR",
        "How to Raise Money",
        "Sales and Marketing",
        "Software I'm excited about",
        "Go, Martini and Gophercasts",
        "Writing Web Apps in Go",
        "Go Dependency Management",
        "Inside the Gophers Studio"
    };

    String[] talkPhotos = new String[] {
        "http://www.dotgo.eu/images/speakers/john-graham-cumming.png",
        "http://www.dotgo.eu/images/speakers/tomas-senart.png",
        "http://www.dotgo.eu/images/speakers/francesc-campoy-flores.png",
        "http://www.dotgo.eu/images/speakers/felix-geisendorfer.png",
        "http://www.dotgo.eu/images/speakers/dave-cheney.png",
        "http://www.startupschool.org/images/2014/speakers/kevin-c77a0892.jpg",
        "http://www.dotgo.eu/images/speakers/brad-fitzpatrick.png",
        "http://www.dotgo.eu/images/speakers/jeremy-saenz.png",
        "http://www.dotgo.eu/images/speakers/andrew-gerrand.png",
        "http://www.dotgo.eu/images/speakers/keith-rarick.png",
        "http://www.dotgo.eu/images/speakers/blake-mizerany.png",
        "http://www.dotgo.eu/images/speakers/blake-mizerany.png",
        "http://www.dotgo.eu/images/speakers/keith-rarick.png",
        "http://www.dotgo.eu/images/speakers/andrew-gerrand.png",
        "http://www.dotgo.eu/images/speakers/john-graham-cumming.png",
    };

    String[] talkDates = new String[] {
        "Oct 15",
        "Oct 15",
        "Oct 15",
        "Oct 15",
        "Oct 15",
        "Oct 15",
        "Oct 15",
        "Oct 15",
        "Oct 15",
        "Oct 15",
        "Oct 15",
        "Oct 15",
        "Oct 16",
        "Oct 16",
        "Oct 16"
    };

    int[] talkTypes = new int[] {
        0, 1, 1,
        1, 1, 1,
        2, 2, 2,
        1, 1, 1,
        1, 1, 1
    };

    String[] rooms = new String[] {
        "Conference Room",
        "Room 201",
        "Room 201",
        "Room 201",
        "Room 201",
        "Room 201",
        "Room 205",
        "Room 205",
        "Room 205",
        "Room 205",
        "Room 205",
        "Room 205",
        "Conference Room",
        "Room 201",
        "Room 205"
    };

    String[] fromTime = new String[] {
        "9:00 AM", "10:00 AM", "11:00 AM",
        "9:00 AM", "10:00 AM", "11:00 AM",
        "9:00 AM", "10:00 AM", "11:00 AM",
        "9:00 AM", "10:00 AM", "11:00 AM",
        "9:00 AM", "10:00 AM", "11:00 AM"
    };

    String[] toTime = new String[] {
        "9:45 AM", "10:45 AM", "11:00 AM",
        "9:45 AM", "10:45 AM", "11:00 AM",
        "9:45 AM", "10:45 AM", "11:00 AM",
        "9:45 AM", "10:45 AM", "11:00 AM",
        "9:45 AM", "10:45 AM", "11:00 AM"
    };

    Realm realm = Realm.getInstance(mContext);
    realm.beginTransaction();

    for (int i = 0; i < myFakeSpeakers.length; i++) {
      Talk t = realm.createObject(Talk.class);
      t.setId(i);
      t.setTitle(myFakeTalkTitles[i]);
      t.setDate(talkDates[i]);
      t.setPhoto(talkPhotos[i]);
      t.setTalk_type(talkTypes[i]);
      t.setRoom(rooms[i]);
      t.setFrom_time(fromTime[i]);
      t.setTo_time(toTime[i]);
      t.setDescription(mContext.getString(R.string.placeholder_talk_description));

      Speaker s = realm.createObject(Speaker.class);
      s.setId(i);
      s.setName(myFakeSpeakers[i]);
      s.setTitle(myFakeSpeakersTitle[i]);
      s.setDescription("hello " + i);
      s.setPhoto(talkPhotos[i]);

      t.getSpeakers().add(s);
    }

    realm.commitTransaction();
  }
}
