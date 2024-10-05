import java.util.*;

class Memories {
    int UserCount;
    public List<UserProfile> users;

    public Memories(int numUsers) {
        this.UserCount = numUsers;
        this.users = new ArrayList<>();
        createRandomNetwork();
    }

    public void networkDisp() {
        for (UserProfile user : users) {
            System.out.println(
                    "User Id:" + user.getUserID() + " - Age: " + user.getAge() + " - Interests: " + user.getInterests()
                            + "  Friends: " + user.getFriends());
            System.out.println("Community: " + user.getCommunity());
        }
    }

    void createRandomNetwork() {
        for (int i = 0; i < UserCount; i++) {
            int userID = i + 1;
            Random rand_gen = new Random();
            int age = rand_gen.nextInt(62 - 18 + 1) + 18;
            int interests = rand_gen.nextInt(9 - 1 + 1) + 1;
            List<Integer> friends = genFriends(i);
            List<Integer> community = generateRandomCommunity();
            users.add(new UserProfile(userID, age, interests, friends, community));
        }
    }

    public List<Integer> genFriends(int currentIndex) {
        List<Integer> friends = new ArrayList<>();
        Random rand_gen = new Random();

        for (int i = 0; i < UserCount; i++) {
            if (i != currentIndex && rand_gen.nextBoolean()) {
                friends.add(i + 1);
            }
        }

        return friends;
    }

    public List<Integer> generateRandomCommunity() {
        List<Integer> community = new ArrayList<>();
        Random rand_gen = new Random();
        for (int i = 0; i < 3; i++) {
            community.add(rand_gen.nextInt(3 - 1 + 1) + 1);
        }
        return community;
    }

    static class friend_relations {
        public static void findingfrnd(Memories memories, int userID, int friendshipType) {
            System.out.println("Friends of User " + userID + " with friendship type " + friendshipType + ":");
            UserProfile user = memories.users.get(userID - 1);
            if (user != null) {
                for (int friendID : user.getFriends()) {
                    UserProfile friend = memories.users.get(friendID - 1);
                    if (friend != null) {
                        if (friend.getInterests() == friendshipType) {
                            System.out.println("Friend ID: " + friendID);
                        }
                    }
                }
            }
        }

        public static void findingfrnd(Memories memories, int userID, int friendshipType, int age) {
            System.out.println("Friends of User " + userID + " with friendship type " + friendshipType +
                    " and age " + age + ":");
            UserProfile user = memories.users.get(userID - 1);
            if (user != null) {
                for (int friendID : user.getFriends()) {
                    UserProfile friend = memories.users.get(friendID - 1);
                    if (friend != null) {
                        if (friend.getInterests() == friendshipType && friend.getAge() == age) {
                            System.out.println("Friend ID: " + friendID);
                        }
                    }
                }
            }
        }

        public static void findingfrnd(Memories memories, int userID, int friendshipType, int age, int interests) {
            System.out.println("Friends of User " + userID + " with friendship type " + friendshipType +
                    ", age " + age + ", and interests " + interests + ":");
            UserProfile user = memories.users.get(userID - 1);
            if (user != null) {
                for (int friendID : user.getFriends()) {
                    UserProfile friend = memories.users.get(friendID - 1);
                    if (friend != null) {
                        if (friend.getInterests() == friendshipType && friend.getAge() == age
                                && friend.getInterests() == interests) {
                            System.out.println("Friend ID: " + friendID);
                        }
                    }
                }
            }
        }
    }
}

class UserProfile {
    int UserID;
    int age;
    int interests;
    List<Integer> friends;
    List<Integer> community;
    Date currentDate;

    public UserProfile(int userID, int age, int interests, List<Integer> friends, List<Integer> community) {
        this.UserID = userID;
        this.age = age;
        this.interests = interests;
        this.friends = friends;
        this.community = community;
        this.currentDate = new Date();
    }

    public int getUserID() {
        return UserID;
    }

    public int getAge() {
        return age;
    }

    public int getInterests() {
        return interests;
    }

    public List<Integer> getFriends() {
        return friends;
    }

    public List<Integer> getCommunity() {
        return community;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void commonInterest(Memories memories) {
        System.out.println("Friends with similar interests for User " + getUserID() + ":");
        for (int friendID : friends) {
            UserProfile friend = memories.users.get(friendID - 1);
            if (friend != null) {
                printMatchingInterests(friend);
            }
        }
    }

    public void commonInterest(Memories memories, int specificInterest) {
        for (int friendID : friends) {
            UserProfile friend = memories.users.get(friendID - 1);
            if (friend != null && friend.getInterests() == specificInterest) {
                printMatchingInterests(friend);
            }
        }
        System.out.println(
                "Friends with similar interests for User " + getUserID() + " interested in " + specificInterest + ":");
    }

    void printMatchingInterests(UserProfile friend) {
        List<Integer> matchingInterests = new ArrayList<>();
        int friendInterests = friend.getInterests();
        int userInterests = getInterests();

        for (int i = 1; i <= 9; i++) {
            if ((friendInterests & (1 << i)) != 0 && (userInterests & (1 << i)) == 0) {
                matchingInterests.add(i);
            }
        }
        if (!matchingInterests.isEmpty()) {
            System.out.println("Friend " + friend.getUserID() + " has additional interests: " + matchingInterests);
        }
    }
public void communicateAnnouncement(Memories memories, int specificInterest, String eventTitle, String eventLocation, String eventDate) {
        System.out.println("Announcement from User " + getUserID() + " to friends interested in " + specificInterest + ":");
        for (int friendID : friends) {
            UserProfile friend = memories.users.get(friendID - 1);
            if (friend != null && friend.getInterests() == specificInterest) {
                friend.receiveAnnouncement(eventTitle, eventLocation, eventDate);
            }
        }
    }

    private void receiveAnnouncement(String eventTitle, String eventLocation, String eventDate) {
        System.out.println("Announcement received from User " + getUserID() + ":");
        System.out.println("Event Title: " + "Office conference ");
        System.out.println("Event Location: " +"KnowledgeCity ");
        System.out.println("Event Date: " + "Thursday, November 16");
        System.out.println("Let's join and have a great time!");
    }



    public void storeDetailsForYears(int years) {
        System.out.println("Storing details for User " + getUserID() + " for " + years + " years:");

        // Assume you have a data structure (e.g., a Map) to store community details
        Map<Integer, String> communityDetails = new HashMap<>();

        // Iterate through the communities and store details
        for (int communityID : getCommunity()) {
            String communityDetailsForUser = "Details for Community " + communityID + ": [Add your details here]";
            communityDetails.put(communityID, communityDetailsForUser);
        }

        // Print the stored details
        for (Map.Entry<Integer, String> entry : communityDetails.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("Details stored successfully for User " + getUserID() + " for " + years + " years.");
    }}

public class Assign102022207 {
    public static void main(String[] args) {

        System.out.println("-----Question ( a )------");
        Memories memories = new Memories(5);
        memories.networkDisp();
        int spInt = 8;
        System.out.println("-----Question ( b )------");
        for (UserProfile user : memories.users) {
            user.commonInterest(memories);
            user.commonInterest(memories, spInt);
        }

        System.out.println("-----Question ( d )------");
        Memories.friend_relations.findingfrnd(memories, 1, 1);
        Memories.friend_relations.findingfrnd(memories, 2, 2, 25);
        Memories.friend_relations.findingfrnd(memories, 3, 3, 30, 5);

        System.out.println("-----Question ( e )------");
        System.out.println("Announcement is subjected to the user ID");
        for (UserProfile user : memories.users) {
            if (user.getInterests() == spInt) {
                String eventTitle = "Office conference";
                String eventLocation = "KnowledgeCity";
                String eventDate = "Thursday, November 16";
                user.communicateAnnouncement(memories, spInt, eventTitle, eventLocation, eventDate);

            }
        }//

        System.out.println("-----Question ( f )------");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of year of experience of community for qn (f)");
        int expyr = sc.nextInt();
        for (UserProfile user : memories.users) {
            user.storeDetailsForYears(expyr);
        }
    }

    static String createEventAnnouncement(String eventTitle, String eventLocation, String eventDate) {
        return String.format("Everyone don't forget to attend: %s at %s on %s", eventTitle, eventLocation, eventDate);
    }
}
