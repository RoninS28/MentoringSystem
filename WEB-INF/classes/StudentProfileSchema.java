public class StudentProfileSchema {
    String RegID;
    String Name;
    String Div;
    String MentorID;
    String Contact;
    String MentorName;

    public void StudentProfileSchema(String user) {
        RegID = user;
    }

    public void StudentProfileSchema(String RegID, String Name, String Div, String MentorID, String Contact,
            String MentorName) {
        this.RegID = RegID;
        this.Name = Name;
        this.Div = Div;
        this.MentorID = MentorID;
        this.Contact = Contact;
        this.MentorName = MentorName;
    }

}
