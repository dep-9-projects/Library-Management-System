package db;

import java.util.ArrayList;

public class MemberDB {


    private static ArrayList<Member> memberDatabase =new ArrayList();

   static  {
        memberDatabase.add(new Member("M001","Pradeep","Galle",Gender.MALE));
        memberDatabase.add(new Member("M002","Nimali","Panadura",Gender.FEMALE));
        memberDatabase.add(new Member("M003","Charith","Ratnapura",Gender.MALE));
        memberDatabase.add(new Member("M004","Sumal","Colombo",Gender.MALE));
        memberDatabase.add(new Member("M005","Nimal","Kandy",Gender.MALE));
        memberDatabase.add(new Member("M006","Tharindu","Embilipitiya",Gender.MALE));
        memberDatabase.add(new Member("M007","Sampath","Moratuwa",Gender.MALE));
    }

    public static boolean addMember(Member member){
       memberDatabase.add(member);
       return true;
    }

    public static void removeMember(Member member){
       memberDatabase.remove(member);
    }

    public static Member findMember(String id){
        for (Member member : memberDatabase) {
            if (member.getId().equalsIgnoreCase(id)){
                return member;
            }
        }
        return null;
    }
    public static ArrayList<Member> searchMembers(String query){
        ArrayList<Member> searchResults = new ArrayList<>();
        for (Member member : memberDatabase) {
            if (member.getId().toUpperCase().contains(query.toUpperCase()) || member.getName().toUpperCase().
                    contains(query.toUpperCase()) || member.getAddress().toUpperCase().contains(query.toUpperCase())){
                searchResults.add(member);
            }
        }
        return searchResults;

    }

    public static boolean isID(String id){
       if (!id.substring(0,1).equalsIgnoreCase("M")){
           return false;
       } else if (!id.substring(1,id.length()).matches("\\d+")) {
           return  false;
       }
       return true;
    }
    public static ArrayList<Member> getMemberDatabase() {
        return memberDatabase;
    }
}
