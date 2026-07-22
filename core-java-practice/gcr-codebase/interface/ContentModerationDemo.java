interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("Text policy blocks abusive and restricted words");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restrictedWords = {"hate", "abuse", "violence"};
        String lowerPost = post.toLowerCase();

        for (String word : restrictedWords) {
            if (lowerPost.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam policy blocks repeated promotions and suspicious links");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restrictedWords = {"free money", "click here", "buy now"};
        String lowerPost = post.toLowerCase();

        for (String word : restrictedWords) {
            if (lowerPost.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

class ContentModerator implements TextModeration, SpamDetection {
    public boolean isOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    public boolean isSpam(String post) {
        return SpamDetection.containsRestrictedWords(post);
    }

    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public void moderatePost(String post) {
        if (isSpam(post)) {
            System.out.println("\"" + post + "\" is spam");
        } else if (isOffensive(post)) {
            System.out.println("\"" + post + "\" is offensive");
        } else {
            System.out.println("\"" + post + "\" is valid");
        }
    }
}

public class ContentModerationDemo {
    public static void main(String[] args) {
        String[] posts = {
            "Enjoying a beautiful day",
            "Click here to win free money",
            "This message spreads hate",
            "Learning Java interfaces"
        };
        ContentModerator moderator = new ContentModerator();

        moderator.displayModerationPolicy();

        for (String post : posts) {
            moderator.moderatePost(post);
        }
    }
}
