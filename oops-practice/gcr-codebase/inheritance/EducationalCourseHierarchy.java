public class EducationalCourseHierarchy {
    static class Course {
        private String courseName;
        private int duration;

        Course(String courseName, int duration) {
            this.courseName = courseName;
            this.duration = duration;
        }

        void displayCourseDetails() {
            System.out.println("Course Name: " + courseName);
            System.out.println("Duration: " + duration + " hours");
        }
    }

    static class OnlineCourse extends Course {
        private String platform;
        private boolean recorded;

        OnlineCourse(String courseName, int duration, String platform, boolean recorded) {
            super(courseName, duration);
            this.platform = platform;
            this.recorded = recorded;
        }

        @Override
        void displayCourseDetails() {
            super.displayCourseDetails();
            System.out.println("Platform: " + platform);
            System.out.println("Recorded: " + recorded);
        }
    }

    static class PaidOnlineCourse extends OnlineCourse {
        private double fee;
        private double discount;

        PaidOnlineCourse(String courseName, int duration, String platform, boolean recorded, double fee, double discount) {
            super(courseName, duration, platform, recorded);
            this.fee = fee;
            this.discount = discount;
        }

        double calculateFinalFee() {
            return fee - (fee * discount / 100);
        }

        @Override
        void displayCourseDetails() {
            super.displayCourseDetails();
            System.out.println("Fee: " + fee);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Final Fee: " + calculateFinalFee());
        }
    }

    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java OOP", 40, "BridgeLabz LMS", true, 5000, 10);
        course.displayCourseDetails();
    }
}
