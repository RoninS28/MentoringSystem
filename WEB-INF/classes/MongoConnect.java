
import java.io.*;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;
import org.bson.conversions.Bson;
import org.bson.*;
import org.bson.types.ObjectId;

import netscape.javascript.JSObject;

import java.util.*;
import com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.Updates.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bson.conversions.Bson;

class NoticeString {
    String noticeid;
}

public class MongoConnect {
    public static MongoClient client;
    public static MongoDatabase db;
    public static MongoCollection<Document> collectionStudent;
    public static MongoCollection<Document> collectionMentor;
    public static MongoCollection<Document> collectionNotices;
    // public static int nid = 2001;

    public MongoConnect() {

        // MongoClientURI uri = new MongoClientURI(
        // "mongodb+srv://boolclan:boolclan@cluster0.zau0n.mongodb.net/MentoringSystemDB?retryWrites=true&w=majority");
        client = MongoClients.create(
                "mongodb+srv://boolclan:boolclan@cluster0.zau0n.mongodb.net/MentoringSystemDB?retryWrites=true&w=majority");
        db = client.getDatabase("SystemDB");
        collectionStudent = db.getCollection("CollectionStudent");
        collectionMentor = db.getCollection("CollectionMentor");
        collectionNotices = db.getCollection("CollectionNotices");
    }

    public static Boolean Authenticate(String user, String pass, String role) {

        if (role.equals("MENTOR")) {
            Document doc = collectionMentor.find(Filters.eq("RegID", user)).first();
            if (doc == null) {
                return false;
            } else if (doc.get("Password").equals(pass)) {
                return true;
            }
            return false;
        }

        else if (role.equals("STUDENT")) {
            Document doc = collectionStudent.find(Filters.eq("RegID", user)).first();
            if (doc == null) {
                return false;
            } else if (doc.get("Password").equals(pass)) {
                return true;
            }
            return false;
        }

        // Document doc = collection.find(Filters.eq("Email", user)).first();
        // if (doc == null) {
        // return false;
        // } else if (doc.get("Password").equals(pass)) {
        // return true;
        // }
        return false;
    }

    public static Document getUser(String user) {
        return collectionStudent.find(Filters.eq("RegID", user)).first();
    }

    public static Document getMentor(String user) {
        return collectionMentor.find(Filters.eq("RegID", user)).first();
    }

    public static String getMyMentorID(String user) {
        Document doc = collectionStudent.find(Filters.eq("RegID", user)).first();
        return doc.get("MentorID").toString();
    }

    public static String getMentorName(String user) {
        Document doc = collectionStudent.find(Filters.eq("RegID", user)).first();
        String mentorid = doc.get("MentorID").toString();
        Document docm = collectionMentor.find(Filters.eq("RegID", mentorid)).first();
        String mentorName = (String) docm.get("Name");
        return mentorName;
    }

    public static String getStudentUserName(String user) {
        Document doc = collectionStudent.find(Filters.eq("RegID", user)).first();
        return doc.get("Name").toString();
    }

    public static String getMentorUserName(String user) {
        Document doc = collectionMentor.find(Filters.eq("RegID", user)).first();
        return doc.get("Name").toString();
    }

    public static ArrayList<String> getMentorNotices(String user) {
        Document doc = collectionMentor.find(Filters.eq("RegID", user)).first();

        ArrayList<String> docn = new ArrayList<String>();
        docn = (ArrayList<String>) doc.get("Notices");
        ArrayList<Document> myNotices = new ArrayList<Document>();

        for (String n1 : docn) {
            myNotices.add(collectionNotices.find(Filters.eq("NoticeID", n1)).first());
        }

        ArrayList<String> noticeContents = new ArrayList<String>();

        for (int i = 0; i < myNotices.size(); i++) {
            noticeContents.add(myNotices.get(i).get("content").toString());
        }

        return noticeContents;
    }

    public static ArrayList<String> getMentorNoticeTimestamps(String user) {
        Document doc = collectionMentor.find(Filters.eq("RegID", user)).first();

        ArrayList<String> docn = new ArrayList<String>();
        docn = (ArrayList<String>) doc.get("Notices");
        ArrayList<Document> myNotices = new ArrayList<Document>();

        for (String n1 : docn) {
            myNotices.add(collectionNotices.find(Filters.eq("NoticeID", n1)).first());
        }

        ArrayList<String> noticeTimestamps = new ArrayList<String>();

        for (int i = 0; i < myNotices.size(); i++) {
            noticeTimestamps.add(myNotices.get(i).get("Timestamp").toString());
        }

        return noticeTimestamps;
    }

    public static ArrayList<String> getMyStudentsListRegID(String user) {
        Document doc = collectionMentor.find(Filters.eq("RegID", user)).first();
        ArrayList<String> mystudents = (ArrayList<String>) doc.get("Students");

        return mystudents;
    }

    public static ArrayList<String> getMyStudentsListNames(String user) {
        Document doc = collectionMentor.find(Filters.eq("RegID", user)).first();
        ArrayList<String> mystudents = (ArrayList<String>) doc.get("Students");

        ArrayList<String> mystudentsnames = new ArrayList<>();
        for (String student : mystudents) {
            mystudentsnames.add(collectionStudent.find(Filters.eq("RegID", student)).first().get("Name").toString());
        }
        return mystudentsnames;

    }

    public static ArrayList<String> getMyStudentsListDivision(String user) {
        Document doc = collectionMentor.find(Filters.eq("RegID", user)).first();
        ArrayList<String> mystudents = (ArrayList<String>) doc.get("Students");

        ArrayList<String> mystudentsdivision = new ArrayList<>();
        for (String student : mystudents) {
            mystudentsdivision.add(collectionStudent.find(Filters.eq("RegID", student)).first().get("Div").toString());
        }
        return mystudentsdivision;

    }

    public static ArrayList<String> getMyStudentsListContact(String user) {
        Document doc = collectionMentor.find(Filters.eq("RegID", user)).first();
        ArrayList<String> mystudents = (ArrayList<String>) doc.get("Students");

        ArrayList<String> mystudentscontact = new ArrayList<>();
        for (String student : mystudents) {
            mystudentscontact
                    .add(collectionStudent.find(Filters.eq("RegID", student)).first().get("Contact").toString());
        }
        return mystudentscontact;

    }

    public static StudentProfileSchema getStudentProfile(String user) {
        Document doc = collectionStudent.find(Filters.eq("RegID", user)).first();
        StudentProfileSchema student = new StudentProfileSchema();
        student.RegID = user;
        student.Name = doc.get("Name").toString();
        student.Div = doc.get("Div").toString();
        student.MentorID = doc.get("MentorID").toString();
        student.Contact = doc.get("Contact").toString();
        student.MentorName = getMentorName(user);
        return student;
    }

    public static ArrayList<String> /* String */ getRequest(String user) {

        Document doc = collectionStudent.find(Filters.eq("RegID", user)).first();
        // if (doc == null) {
        // return new ArrayList<String>();
        // }
        // else{
        String mentorid = doc.get("MentorID").toString();
        Document docm = collectionMentor.find(Filters.eq("RegID", mentorid)).first();

        ArrayList<String> docn = new ArrayList<String>();
        docn = (ArrayList<String>) docm.get("Notices");

        ArrayList<Document> myNotices = new ArrayList<Document>();

        for (String n1 : docn) {
            myNotices.add(collectionNotices.find(Filters.eq("NoticeID", n1)).first());
        }

        ArrayList<String> noticeContents = new ArrayList<String>();
        // String data = "[";

        for (int i = 0; i < myNotices.size(); i++) {
            // String t=myNotices.get(i);
            noticeContents.add(myNotices.get(i).get("content").toString());
            // data=data+myNotices.get(i).get("content").toString()+",";
        }
        // data+="]";
        // return data;
        return noticeContents;
        // }

    }

    public static void addNotice(String Rid, String x) {

        Document document = new Document();
        Random rand = new Random();
        String id = "N" + String.format("%04d", rand.nextInt(10000));
        document.append("NoticeID", id);
        document.append("content", x);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        document.append("Timestamp", formatter.format(date));

        collectionNotices.insertOne(document);

        Document docm = collectionMentor.find(Filters.eq("RegID", Rid)).first();

        ArrayList<String> docn = new ArrayList<String>();
        docn = (ArrayList<String>) docm.get("Notices");
        docn.add(id);

        BsonArray array = new BsonArray();
        for (String noticeid : docn) {
            array.add(new BsonString(noticeid));
        }
        Bson filter = Filters.eq("RegID", Rid);
        Bson updateOperation = set("Notices", array);

        // collectionMentor.updateOne({"RegID" : Rid}, {$set : {"Notices" : array}});

        collectionMentor.updateOne(filter, updateOperation);

        // DBObject findQuery = new BasicDBObject("RegID",Rid);
        // Document find = new Document().toJson();
        // DBObject listItem = new BasicDBObject("Notices",id);
        // DBObject updateQuery = new BasicDBObject("$push",listItem);
        // collectionMentor.
        // collectionMentor.updateMany(findQuery,updateQuery);
        // Bson filter = Filters.eq("RegID", Rid);
        // Bson update = Updates.addToSet("Notices", id);
        // collectionMentor.findOneAndUpdate(filter, update);
    }

}
